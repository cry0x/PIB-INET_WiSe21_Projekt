let currentUserData;

let isProfileFormDisabled = true;

function handleUserProfileChange() {
    if (isProfileFormDisabled) {
        isProfileFormDisabled = false

        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
        document.getElementById('userFormSubmitCancel').style.visibility = 'visible';
    } else {
        isProfileFormDisabled = true

        putUserProfileData()

        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'
        document.getElementById('userFormSubmitCancel').style.visibility = 'hidden';
    }
}

function cancelUserProfileChange() {
    if (isProfileFormDisabled) {
        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
    } else {
        loadCurrentUserData()

        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'
        document.getElementById('userFormSubmitCancel').style.visibility = 'hidden';
    }
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
    currentUserData.pictureUrl = document.querySelector('#pictureUrl').value

    return currentUserData;
}

function loadCurrentUserData() {
    document.querySelector('#loginName').value = `${currentUserData.loginName}`;
    document.querySelector('#firstName').value = `${currentUserData.firstName}`;
    document.querySelector('#lastName').value = `${currentUserData.lastName}`;
    document.querySelector('#email').value = `${currentUserData.email}`;
    document.querySelector('#birthdate').value = `${currentUserData.birthdate}`;
    document.querySelector('#pictureUrl').value = `${currentUserData.pictureUrl}`;
    if (currentUserData.pictureUrl === "") {
        document.querySelector('#profilepicture').src = '/resources/images/default-profile-picture.png';
    } else {
        document.querySelector('#profilepicture').src = `${currentUserData.pictureUrl}`;
    }
}

function updateForm(userData) {
    currentUserData = userData;

    loadCurrentUserData();
}

fetchCurrentUserProfile();