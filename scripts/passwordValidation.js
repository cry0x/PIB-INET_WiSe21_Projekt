var pwd = document.getElementById('pwd'),
    pwd_confirm = document.getElementById('pwd_confirm');

function validatePassword() {
    if (pwd.value != pwd_confirm.value) {
        pwd_confirm.setCustomValidity("Passwords Don't Match");
    } else {
        pwd_confirm.setCustomValidity('');
    }
}

pwd.onchange = validatePassword;
pwd_confirm.onkeyup = validatePassword;
