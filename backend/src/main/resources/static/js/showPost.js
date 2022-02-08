//  GET request using fetch()
fetch("http://localhost:8080/api/v1/posts")
   
    // Converting received data to JSON
    .then(response => response.json())
    .then(json => {
  
        // Create a variable to store HTML
        let li = `<tr><th>ID</th><th>Titel</th><th>Inhalt</th></tr>`;
       
        // Loop through each data and add a table row
        json.forEach(p => {
            li += `<div>
                <p>${p.id}</p>
                <p>${p.title}</p>
                <p>${p.post}</p>        
            </div>`;
        });
  
        // Display result
        document.getElementById("posts").innerHTML = li;
    });