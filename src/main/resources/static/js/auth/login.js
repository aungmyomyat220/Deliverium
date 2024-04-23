$(document).ready(function(){
    $('#loginForm').submit(function(event){
        event.preventDefault();
        let username = $('#username').val();
        let password = $('#password').val();
        
        let requestBody = {
            username: username,
            password: password
        };
        
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
            return response.json();
        })
        .then(data => {
            if(data === true) {
                location.href = 'home';
            } else {
                console.error('Login failed:', data);
            }
        })
        .catch(error => {
            console.error('Login error:', error);
        });
    });
});
