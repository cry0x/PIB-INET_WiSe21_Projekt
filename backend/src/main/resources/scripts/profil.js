function fetchData() {
    fetch("https://reqres.in/api/users").then(res => {
        if (!res.ok)
            throw Error('ERROR')

        return res.json();
    }).then(data => {
        console.log(data.data)
        const html = data.data.map(user => {
            return `<div class="user">
                        <img src="${user.avatar}">
                        <p>Vorname: ${user.first_name}</p>
                        <p>Nachname: ${user.last_name}</p>
                        <p>EMail: ${user.email}</p>
                    </div>`;
        }).join("")

        document.querySelector('#app').innerHTML = html;
    }).catch(err => {
        console.log(err)
    });
}

fetchData();