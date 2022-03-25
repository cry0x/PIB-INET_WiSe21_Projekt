function fetchIsCurrentUserAdmin() {
    const url = "http://localhost:8080/api/profile/admin";

    return fetch(url)
        .then(response => response.json())
        .catch(err => console.error(err));
}

async function exchangeProfile() {
    if (await fetchIsCurrentUserAdmin()) {
        document.querySelector('#profileButton').innerHTML = 'USER-MANAGEMENT'
    }
}

exchangeProfile()