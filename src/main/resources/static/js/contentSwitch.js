function contentSwitch(element) {
    // hides all child elements of the parent element
    $('#content').children().hide()
    // shows the child inside the function argument
    // added the optional speed parameter 'slow' for an animation
    $(element).show('slow')
}

document.getElementById('aboutButton').addEventListener('click', () => {
    // Stop duplicating the content
    if ($('#about').is(':parent') === false) {
        // eslint-disable-next-line no-alert
        // Add content to the page
        $('#about').append(
            '<div><em>"This is a minimal Web Forum template with basic functions"</em></div>'
        )
        $('#about').append(
            '<div><em>"This is a placeholder and could hold an image"</em></div>'
        )
        $('#about').append('<div><em>"This is another placeholder"</em></div>')
    }
})

document.getElementById('contactButton').addEventListener('click', () => {
    // Stop duplicating the content
    if ($('#contact').is(':parent') === false) {
        // eslint-disable-next-line no-alert
        // Add content to the page
        $('#contact').append(
            '<div><b>Hochschule für Technik und Wirtschaft des Saarlandes</b> (Placeholder)</div>'
        )
        $('#contact').append(
            '<div>Goebenstraße 40 <br> 66117 Saarbrücken</div>'
        )
        $('#contact').append(
            '<div>Telefon: (0681) 58 67 - 0 <br> Telefax: (0681) 58 67 - 122 <br> E-Mail: <a href="mailto:info@htwsaar.de">info@htwsaar.de</a></div>'
        )
    }
})
