function fetchData() {
    fetch("http://127.0.0.1:8080/api/v1/users").then(res => {
        if (!res === 302)
            throw Error('ERROR')

        return res.json();
    }).then(data => {
        console.log(data)
        /*
        const html = data.data.map(user => {
            return `<div class="user">
                        <p>Login Name: ${user.login_name}</p>
                        <p>Vorname: ${user.firstname}</p>
                        <p>Nachname: ${user.lastname}</p>
                        <p>EMail: ${user.email}</p>
                    </div>`;
        }).join("")

        document.querySelector('#app').innerHTML = html;
        */
    }).catch(err => {
        console.log(err)
    });
}

fetchData();