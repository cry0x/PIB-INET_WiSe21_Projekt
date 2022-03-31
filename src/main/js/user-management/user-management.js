'use strict';

// Diese Klasse stellt die UI zur Verwaltung der Bentuzer im Forum dar
// Wenn ein Benutzer gelöscht wird, dann werden auch alle Posts und Kommentare des Benutzers gelöscht
class UserManagement extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [],
            dataIsLoaded: false
        };
    }
    // Wenn die UI im HTML angezeigt bzw hinzugefügt wird, dann wird diese Methode ausgeführt die die Benutzerdaten lädt
    componentDidMount() {
        const url = `${window.location.origin}/api/users`;

        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    users: json,
                    DataisLoaded: true
                });
            })
    }

    // Rendert die Elemente der Tabelle nachdem die Informationen geladen wurden
    renderTableData() {
        function deleteUser(id) {
            const url = `${window.location.origin}/api/users/${id}`;
            const fetchInit = {
                method: 'DELETE',
            };

            fetch(url, fetchInit)
                .then(res => res.json())
                .then(() => window.location.reload(true));
        }
        // Erzeugt für jeden User einen Tabelleneintrag
        return this.state.users.map((user, index) => {
                return (
                    <tr key={ user.id }>
                        <td>{ user.id }</td>
                        <td>{ user.loginname }</td>
                        <td>{ user.firstname }</td>
                        <td>{ user.lastname }</td>
                        <td>{ user.email }</td>
                        <td id="deleteUser">
                            <button id="btnDeleteUser" onClick={() => deleteUser(user.id)}>DELETE</button>
                        </td>
                    </tr>
                )
            }
        )
    }

    // Rendert die Grundlage der Tabelle und abhängig vom Zustand des Objekts auch die Daten bzw. Rows
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
// Rendert die UI an der definierten Stelle
ReactDOM.render(<UserManagement />, document.getElementById('user-management'));