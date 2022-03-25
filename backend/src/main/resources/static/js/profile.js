let isProfileFormDisabled = true;

function handleUserProfileChange() {
    if (isProfileFormDisabled) {
        isProfileFormDisabled = false

        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
        document.getElementById('userFormSubmitCancel').style.visibility = 'visible';
        document.getElementById('userFormSubmitButton').addEventListener("click", putUserProfileData)
    } else {
        isProfileFormDisabled = true

        document.getElementById('userFormFieldSet').setAttribute('disabled','disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'change data'
        document.getElementById('userFormSubmitCancel').style.visibility = 'hidden';
        document.getElementById('userFormSubmitButton').removeEventListener("click", putUserProfileData)
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
    const url = "http://localhost:8080/api/profile/current";
    const body = {
        method: 'PUT',
        headers: { 'Content-Type':'application/json' },
        body: JSON.stringify(getUpdateUserDataFromForm())
    };

    fetch(url, body)
        .then(res => res.json())
        .catch(err => console.log(err));
}

function fetchCurrentUserProfile() {
    const url = "http://localhost:8080/api/profile/current";

    fetch(url)
        .then(res => res.json())
        .catch(err => console.log(err));
}

function getUpdateUserDataFromForm() {
    let currentUserData = {};

    currentUserData.loginname = document.querySelector('#loginName').value
    currentUserData.firstname = document.querySelector('#firstName').value
    currentUserData.lastname = document.querySelector('#lastName').value
    currentUserData.email = document.querySelector('#email').value
    currentUserData.birthdate = document.querySelector('#birthdate').value
    currentUserData.pictureUrl = document.querySelector('#pictureUrl').value

    return currentUserData;
}

function loadCurrentUserData() {
    const currentUserData = fetchCurrentUserProfile()

    console.log(currentUserData)

    document.querySelector('#loginName').value = `${currentUserData.loginname}`;
    document.querySelector('#firstName').value = `${currentUserData.firstname}`;
    document.querySelector('#lastName').value = `${currentUserData.lastname}`;
    document.querySelector('#email').value = `${currentUserData.email}`;
    document.querySelector('#birthdate').value = `${currentUserData.birthdate}`;
    document.querySelector('#pictureUrl').value = `${currentUserData.pictureUrl}`;
    document.querySelector('#memberSince').innerHTML = `Mitglied seit: ${currentUserData.registrationdate}`;

    if (currentUserData.pictureUrl === "") {
        document.querySelector('#profilepicture').src = '/resources/images/default-profile-picture.png';
    } else {
        document.querySelector('#profilepicture').src = `${currentUserData.pictureUrl}`;
    }
}

loadCurrentUserData();