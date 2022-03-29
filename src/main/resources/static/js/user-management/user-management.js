'use strict';

class UserManagement extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
      dataIsLoaded: false
    };
  }

  componentDidMount() {
    const url = `http://localhost:8080/api/users`;
    fetch(url).then(res => res.json()).then(json => {
      this.setState({
        users: json,
        DataisLoaded: true
      });
    });
  }

  deleteUser(id) {
    const url = 'http://localhost:8080/api/users/' + id;
    const fetchInit = {
      method: 'DELETE'
    };
    fetch(url, fetchInit).then(res => res.json()).then(res => console.log(res));
  }

  renderTableData() {
    return this.state.users.map((user, index) => {
      return /*#__PURE__*/React.createElement("tr", {
        key: user.id
      }, /*#__PURE__*/React.createElement("td", null, user.id), /*#__PURE__*/React.createElement("td", null, user.loginname), /*#__PURE__*/React.createElement("td", null, user.firstname), /*#__PURE__*/React.createElement("td", null, user.lastname), /*#__PURE__*/React.createElement("td", null, user.email), /*#__PURE__*/React.createElement("td", {
        id: "deleteUser"
      }, /*#__PURE__*/React.createElement("button", {
        id: "btnDeleteUser",
        onClick: () => this.deleteUser(user.id)
      }, "DELETE")));
    });
  }

  render() {
    return /*#__PURE__*/React.createElement("table", {
      id: "students"
    }, /*#__PURE__*/React.createElement("thead", null, /*#__PURE__*/React.createElement("tr", null, /*#__PURE__*/React.createElement("th", null, "ID"), /*#__PURE__*/React.createElement("th", null, "Loginname"), /*#__PURE__*/React.createElement("th", null, "Vorname"), /*#__PURE__*/React.createElement("th", null, "Nachname"), /*#__PURE__*/React.createElement("th", null, "EMail"))), /*#__PURE__*/React.createElement("tbody", null, this.renderTableData()));
  }

}

ReactDOM.render( /*#__PURE__*/React.createElement(UserManagement, null), document.getElementById('user-management'));