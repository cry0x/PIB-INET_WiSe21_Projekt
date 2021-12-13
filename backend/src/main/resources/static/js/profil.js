let currentUserData;

const userFormFieldSet = document.getElementById('userFormFieldSet');
const userFormSubmitButton = document.getElementById('userFormSubmitButton')
const userFormSubmitCancel = document.getElementById('userFormSubmitCancel')
const userFormPasswordChange = document.getElementById('userFormPasswordChange')
const userFormPasswordCancel = document.getElementById('userFormPasswordCancel')
const passwordForm = document.getElementById('passwordForm')

function handleUserProfileChange() {
    if (userFormFieldSet.hasAttribute('disabled')) {
        userFormFieldSet.removeAttribute('disabled')
        userFormSubmitButton.innerHTML = 'save'
        userFormSubmitCancel.style.visibility = 'visible';
    } else {
        putUserProfileData()

        userFormFieldSet.setAttribute('disabled','disabled')
        userFormSubmitButton.innerHTML = 'change data'
        userFormSubmitCancel.style.visibility = 'hidden';
    }
}

function cancelUserProfileChange() {
    if (userFormFieldSet.hasAttribute('disabled')) {
        userFormFieldSet.removeAttribute('disabled')
        userFormSubmitButton.innerHTML = 'save'
    } else {
        loadCurrentUserData()

        userFormFieldSet.setAttribute('disabled','disabled')
        userFormSubmitButton.innerHTML = 'change data'
        userFormSubmitCancel.style.visibility = 'hidden';
    }
}

function handleUserPasswordChange() {
    if (userFormPasswordCancel.style.visibility === 'visible') {
        userFormPasswordCancel.style.visibility = 'hidden';
        userFormPasswordChange.innerHTML = 'change password';
        passwordForm.style.visibility = 'hidden';
    } else {
        userFormPasswordCancel.style.visibility = 'visible';
        userFormPasswordChange.innerHTML = 'save password';
        passwordForm.style.visibility = 'visible';
    }
}

function cancelUserPasswordChange() {
    userFormPasswordCancel.style.visibility = 'hidden';
    userFormPasswordChange.innerHTML = 'change password';
    passwordForm.style.visibility = 'hidden';
}

function putUserProfileData() {
    fetch("http://localhost:8080/api/profile/current", {
        method: 'PUT',
        headers: { 'Content-Type':'application/json' },
        body: JSON.stringify(updateCurrentUserData())
    }).then(res => {
        return res.json()
    }).then(userData => {
        updateForm(userData)
    });
}

function fetchCurrentUserProfile() {
    fetch("http://localhost:8080/api/profile/current").then(res => {
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

    loadCurrentUserData();
}

fetchCurrentUserProfile();