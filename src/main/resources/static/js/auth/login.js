$(document).ready(function(){
    $('#loginForm').submit(function(event){
        event.preventDefault(); // Prevent default form submission
        let username = $('#username').val(); // Get username input value
        let password = $('#password').val(); // Get password input value
        
        // Construct the request body
        let requestBody = {
            username: username,
            password: password
        };
        
        // Send POST request using fetch
        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            location.href = 'home'
        })
        .then(data => {
            // Handle successful response
            console.log('Login successful:', data);
            // Redirect or perform further actions based on the response
        })
        .catch(error => {
            // Handle error
            console.error('Login error:', error);
            // Display an error message or perform appropriate action
        });
    });
});
