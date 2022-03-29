'use strict';

class UserManagement extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [],
            dataIsLoaded: false
        };
    }

    componentDidMount() {
        const url = 'http://localhost:8080/api/users';

        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    users: json,
                    DataisLoaded: true
                });
            })
    }

    deleteUser(id) {
        const url = 'http://localhost:8080/api/users/' + id;
        const fetchInit = {
            method: 'DELETE',
        };

        fetch(url, fetchInit)
            .then(res => res.json())
            .then(res => console.log(res))
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
                        <td id="deleteUser">
                            <button id="btnDeleteUser" onClick={() => this.deleteUser(user.id)}>DELETE</button>
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