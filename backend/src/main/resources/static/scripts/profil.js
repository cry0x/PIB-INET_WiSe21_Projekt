function fetchData() {
    fetch("http://127.0.0.1:8080/api/v1/users/1").then(res => {
        if (!res === 302)
            throw Error('ERROR')

        return res.json();
    }).then(user => {
        console.log(user)
        document.querySelector('#loginName').innerHTML = `Login Name: ${user.login_name}`;
        document.querySelector('#firstName').innerHTML = `Vorname: ${user.firstname}`;
        document.querySelector('#lastName').innerHTML = `Nachname: ${user.lastname}`;
        document.querySelector('#email').innerHTML = `EMail: ${user.email}`;
        document.querySelector('#birthdate').innerHTML = `Geburtsdatum: ${user.birthdate}`;
    }).catch(err => {
        console.log(err)
    });
}

fetchData();