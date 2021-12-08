/* Set the width of the sidebar to 250px and the left margin of the page content to 250px */
function openNav() {
    document.getElementById('sideNav').style.display = 'block'
    document.getElementById('sideNav').style.width = '250px'
    document.getElementById('sideNavButton').style.marginRight = '250px'
}

/* Set the width of the sidebar to 0 and the left margin of the page content to 0 */
function closeNav() {
    document.getElementById('sideNav').style.display = 'none'
    document.getElementById('sideNav').style.width = '0'
    document.getElementById('sideNavButton').style.marginRight = '0'
}
