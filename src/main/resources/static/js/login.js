const loginForm = document.getElementById('loginForm')
const loginButton = document.getElementById('submitButton')
const loginErrorMsg = document.getElementById('loginErrorMessage')

loginButton.addEventListener('click', (e) => {
    e.preventDefault()
    const username = loginForm.username.value
    const password = loginForm.password.value

    // Doesn't send anything to the server since
    // I'll have to figure out how this actually works first.
    if (username === 'user' && password === 'test') {
        alert('You have successfully logged in.')
        // Redirecting to main page.
        window.location = '/index.html'
    } else {
        loginErrorMsg.style.opacity = 1
    }
})
