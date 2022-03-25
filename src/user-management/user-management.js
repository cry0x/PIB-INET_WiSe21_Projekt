'use strict';

class UserManagement extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [],
            DataisLoaded: false
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/users")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    users: json,
                    DataisLoaded: true
                });
            })
    }

    renderTableData() {
        return this.state.users.map((user, index) => {
                return (
                    <tr key={ user.id }>
                        <td>{ user.id }</td>
                        <td>{ user.loginname }</td>
                        <td>{ user.firstname }</td>
                        <td>{ user.lastname }</td>
                        <td>{ user.email }</td>
                        <td id="editUser">
                            <p>EDIT</p>
                        </td>
                        <td id="deleteUser">
                            <p>DELETE</p>
                        </td>
                    </tr>
                )
            }
        )
    }

    render() {
        return (
            <table id='students'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Loginname</th>
                        <th>Vorname</th>
                        <th>Nachname</th>
                        <th>EMail</th>
                    </tr>
                </thead>
                <tbody>
                    { this.renderTableData() }
                </tbody>
            </table>
        );
    }
}

ReactDOM.render(<UserManagement />, document.getElementById('user-management'));