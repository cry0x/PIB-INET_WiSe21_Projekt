const home = $('#main')
const about = $('#about')
const contact = $('#contact')

// Switch between main content pages
function contentSwitch(element) {
    // hides all child elements of the parent element
    // added the optional speed parameter 'slow' for an animation
    $('#content').children().hide('slow')
    // shows the child inside the function argument
    element.show('slow')
}