const submitButton = document.getElementById('submitButton');

submitButton.addEventListener("click", handleSubmit);

handleSubmit = () => {
    const userData = {
        salutation: 'Mr.',
        fName: 'Max',
        lName: 'Mustermann',
        email: 'max.mustermann@mail.de',
        login: 'max',
        birth: '01.01.2000',
        pwd: 'max123'
    }

    fetch('https://jsonplaceholder.typicode.com/todos/1')
        .then(response => response.json())
        .then(json => console.log(json))

    window.location.replace("http://localhost:8080/")
}