let currentUserData;

function myFunction() {
    if (document.getElementById('userFormFieldSet').hasAttribute('disabled')) {
        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
        document.getElementById('userFormSubmitCancel').style.visibility = 'visible';
    } else {
        putData()

        document.getElementById('userFormSubmitCancel').style.visibility = 'hidden';
        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'
    }
}

function cancelChangeData() {
    if (document.getElementById('userFormFieldSet').hasAttribute('disabled')) {
        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
    } else {
        loadCurrentUserData()

        document.getElementById('userFormSubmitCancel').style.visibility = 'hidden';
        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'
    }
}

function putData() {
    fetch("http://localhost:8080/api/v1/users/1", {
        method: 'PUT',
        headers: { 'Content-Type':'application/json' },
        body: JSON.stringify(updateCurrentUserData())
    }).then(res => {
        return res.json()
    }).then(userData => {
        updateForm(userData)
    });
}

function fetchData() {
    fetch("http://localhost:8080/logintest").then(res => {
        if (!res.ok)
            throw Error('Userdata couldn\'t be fetched!')

        return res.json();
    }).then(userData => {
        updateForm(userData)
    }).catch(err => {
        alert(err)
    });
}

function updateCurrentUserData() {
    currentUserData.loginName = document.querySelector('#loginName').value
    currentUserData.firstName = document.querySelector('#firstName').value
    currentUserData.lastName = document.querySelector('#lastName').value
    currentUserData.email = document.querySelector('#email').value
    currentUserData.birthdate = document.querySelector('#birthdate').value

    return currentUserData;
}

function loadCurrentUserData() {
    document.querySelector('#loginName').value = `${currentUserData.loginName}`;
    document.querySelector('#firstName').value = `${currentUserData.firstName}`;
    document.querySelector('#lastName').value = `${currentUserData.lastName}`;
    document.querySelector('#email').value = `${currentUserData.email}`;
    document.querySelector('#birthdate').value = `${currentUserData.birthdate}`;
}

function updateForm(userData) {
    currentUserData = userData;

    loadCurrentUserData()
}

fetchData();