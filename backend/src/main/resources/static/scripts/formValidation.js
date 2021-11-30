const pwd = document.getElementById('pwd');
const pwdConfirm = document.getElementById('pwd_confirm');

function validatePassword() {
    if (pwd.value !== pwdConfirm.value) {
        pwdConfirm.setCustomValidity("Passwords Don't Match");
    } else {
        pwdConfirm.setCustomValidity('');
    }
}

pwd.onchange = validatePassword;
pwdConfirm.onkeyup = validatePassword;
