let isProfileFormDisabled = true

function handleUserProfileChange() {
    if (isProfileFormDisabled) {
        isProfileFormDisabled = false

        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
        document.getElementById('userFormSubmitCancel').style.visibility =
            'visible'
        document
            .querySelector('#loginName')
            .setAttribute('disabled', 'disabled')
    } else {
        isProfileFormDisabled = true

        updateUserDataFromForm()

        document
            .getElementById('userFormFieldSet')
            .setAttribute('disabled', 'disabled')
        document.getElementById('userFormSubmitButton').innerHTML =
            'change data'
        document.getElementById('userFormSubmitCancel').style.visibility =
            'hidden'
    }
}

function cancelUserProfileChange() {
    if (isProfileFormDisabled) {
        document.getElementById('userFormFieldSet').removeAttribute('disabled')
        document.getElementById('userFormSubmitButton').innerHTML = 'save'
    } else {
        loadCurrentUserData()

        document
            .getElementById('userFormFieldSet')
            .setAttribute('disabled', 'disabled')
        document.getElementById('userFormSubmitButton').innerHTML =
            'change data'
        document.getElementById('userFormSubmitCancel').style.visibility =
            'hidden'
    }
}

function putUserProfileData(newUserData) {
    const url = 'http://localhost:8080/api/profile/current'
    const body = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newUserData),
    }

    return fetch(url, body)
        .then((response) => response.json())
        .catch((error) => console.error(error))
}

async function updateUserDataFromForm() {
    let currentUserData = {}

    currentUserData.loginname = document.querySelector('#loginName').value
    currentUserData.firstname = document.querySelector('#firstName').value
    currentUserData.lastname = document.querySelector('#lastName').value
    currentUserData.email = document.querySelector('#email').value
    currentUserData.birthdate = document.querySelector('#birthdate').value
    currentUserData.pictureUrl = document.querySelector('#pictureUrl').value

    await putUserProfileData(currentUserData)

    loadCurrentUserData()
}

function fetchCurrentUserProfile() {
    const url = 'http://localhost:8080/api/profile/current'

    return fetch(url)
        .then((response) => response.json())
        .catch((err) => console.error(err))
}

async function loadCurrentUserData() {
    const currentUserData = await fetchCurrentUserProfile()

    console.log(currentUserData)

    document.querySelector('#loginName').value = `${currentUserData.loginname}`
    document.querySelector('#firstName').value = `${currentUserData.firstname}`
    document.querySelector('#lastName').value = `${currentUserData.lastname}`
    document.querySelector('#email').value = `${currentUserData.email}`
    document.querySelector('#birthdate').value = `${currentUserData.birthdate}`
    document.querySelector(
        '#pictureUrl'
    ).value = `${currentUserData.pictureUrl}`
    document.querySelector(
        '#memberSince'
    ).innerHTML = `Mitglied seit: ${currentUserData.registrationdate}`

    if (currentUserData.pictureUrl === '') {
        document.querySelector('#profilepicture').src = ''
    } else {
        document.querySelector(
            '#profilepicture'
        ).src = `${currentUserData.pictureUrl}`
    }
}

loadCurrentUserData()
