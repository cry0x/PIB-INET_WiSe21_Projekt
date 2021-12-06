const home = $('#main')
const about = $('#about')
const contact = $('#contact')

// Switch between main content pages
function contentSwitch(element) {
    // hides all child elements of the parent element
    $('#content').children().hide()
    // shows the child inside the function argument
    // added the optional speed parameter 'slow' for an animation
    element.show('slow')
}
