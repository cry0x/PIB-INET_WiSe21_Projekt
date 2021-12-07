function myFunction() {
    if (document.getElementById('userFormFieldSet').hasAttribute('disabled')) {
        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
    } else {
        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'

        putData()
    }
}

function putData() {
    fetch("http://localhost:8080/api/v1/users/1", {
        method: 'PUT',
        headers: { 'Content-Type':'application/json' },
        body: JSON.stringify({
            loginName : document.querySelector('#loginName').value,
            firstName : document.querySelector('#firstName').value,
            lastName : document.querySelector('#lastName').value,
            email : document.querySelector('#email').value,
            birthdate : document.querySelector('#birthdate').value
        })
    }).then(res => {
        return res.json()
    }).then(data => {
        console.log(data)
    });
}

function fetchData() {
    fetch("http://localhost:8080/api/v1/users/1")
        .then(res => {
        if (!res.ok)
            throw Error('ERROR')

        return res.json();
    }).then(user => {
        console.log(user)
        document.querySelector('#loginName').value = `${user.loginName}`;
        document.querySelector('#firstName').value = `${user.firstName}`;
        document.querySelector('#lastName').value = `${user.lastName}`;
        document.querySelector('#email').value = `${user.email}`;
        document.querySelector('#birthdate').value = `${user.birthdate}`;
    }).catch(err => {
        console.log(err)
    });
}

fetchData();