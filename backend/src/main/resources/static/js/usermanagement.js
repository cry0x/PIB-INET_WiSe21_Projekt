console.log(await fetchCurrentUserProfile())

function fetchCurrentUserProfile() {
    const url = "http://localhost:8080/api/profile/current";

    return fetch(url)
        .then(response => response.json())
        .catch(err => console.error(err));
}