'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var UserManagement = function (_React$Component) {
    _inherits(UserManagement, _React$Component);

    function UserManagement(props) {
        _classCallCheck(this, UserManagement);

        var _this = _possibleConstructorReturn(this, (UserManagement.__proto__ || Object.getPrototypeOf(UserManagement)).call(this, props));

        _this.state = {
            users: [],
            DataisLoaded: false
        };
        return _this;
    }

    _createClass(UserManagement, [{
        key: "componentDidMount",
        value: function componentDidMount() {
            var _this2 = this;

            fetch("http://localhost:8080/api/users").then(function (res) {
                return res.json();
            }).then(function (json) {
                _this2.setState({
                    users: json,
                    DataisLoaded: true
                });
            });
        }
    }, {
        key: "renderTableData",
        value: function renderTableData() {
            return this.state.users.map(function (user, index) {
                return React.createElement(
                    "tr",
                    { key: user.id },
                    React.createElement(
                        "td",
                        null,
                        user.id
                    ),
                    React.createElement(
                        "td",
                        null,
                        user.loginname
                    ),
                    React.createElement(
                        "td",
                        null,
                        user.firstname
                    ),
                    React.createElement(
                        "td",
                        null,
                        user.lastname
                    ),
                    React.createElement(
                        "td",
                        null,
                        user.email
                    ),
                    React.createElement(
                        "td",
                        { id: "editUser" },
                        React.createElement(
                            "p",
                            null,
                            "EDIT"
                        )
                    ),
                    React.createElement(
                        "td",
                        { id: "deleteUser" },
                        React.createElement(
                            "p",
                            null,
                            "DELETE"
                        )
                    )
                );
            });
        }
    }, {
        key: "render",
        value: function render() {
            return React.createElement(
                "table",
                { id: "students" },
                React.createElement(
                    "thead",
                    null,
                    React.createElement(
                        "tr",
                        null,
                        React.createElement(
                            "th",
                            null,
                            "ID"
                        ),
                        React.createElement(
                            "th",
                            null,
                            "Loginname"
                        ),
                        React.createElement(
                            "th",
                            null,
                            "Vorname"
                        ),
                        React.createElement(
                            "th",
                            null,
                            "Nachname"
                        ),
                        React.createElement(
                            "th",
                            null,
                            "EMail"
                        )
                    )
                ),
                React.createElement(
                    "tbody",
                    null,
                    this.renderTableData()
                )
            );
        }
    }]);

    return UserManagement;
}(React.Component);

ReactDOM.render(React.createElement(UserManagement, null), document.getElementById('user-management'));