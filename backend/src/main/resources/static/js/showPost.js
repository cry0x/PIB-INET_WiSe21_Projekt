//  GET request using fetch()
fetch("http://localhost:8080/api/v1/posts")
   
    // Converting received data to JSON
    .then(response => response.json())
    .then(json => {
  
        // Create a variable to store HTML
        let li = ``;
      
        // Loop through each data and add a table row
        json.forEach(p => {
            li +=   `<div class="title_box" id="post">
                        <div id="title">${p.title}</div>
                        <div id="content">${p.post}</div>  
                    </div>`;
        });
  
        // Display result
        document.getElementById("posts").innerHTML = li;
    });