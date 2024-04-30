$(document).ready(function(){
    $('#loginForm').submit(function(event){
        event.preventDefault();
        let username = $('#username').val();
        let password = $('#password').val();

        if(username.trim() === '' || password.trim() === '') {
            if (username.trim() === '' && password.trim() === '') {
                $('#username').addClass('error-border');
                $('#password').addClass('error-border');
                $('#username-error-message').text('Please enter username');
                $('#password-error-message').text('Please enter password');
                return false;
            }else if (username.trim() === '') {
                $('#username').addClass('error-border');
                $('#username-error-message').text('Please enter username');
                return false;
            }else if (password.trim() === '') {
                $('#password').addClass('error-border');
                $('#password-error-message').text('Please enter password');
                return false;
            }
        }
        
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
            if(data) {
                Swal.fire({
                    title: 'Login Success',
                    icon: 'success',
                    showConfirmButton: false,
                    timer: 2000,
                });           
                setTimeout(function() {
                    location.href = 'dashboard';
                }, 2000);
            }else if(!data) {
                Swal.fire({
                    title: 'Login Failed',
                    text: 'Incorrect Username or Password',
                    icon: 'error',
                    confirmButtonText: 'Try again'
                  })
            }
        })
        .catch(error => {
            console.error('Login error:', error);
        });
    });

    function hideErrorMessage(inputElement, errorMessageElement) {
        inputElement.removeClass('error-border');
        errorMessageElement.text('');
        errorMessageElement.hide();
    }
    $('#username').on('input', function() {
        hideErrorMessage($('#username'), $('#username-error-message'));
    });

    $('#password').on('input', function() {
        hideErrorMessage($('#password'), $('#password-error-message'));
    });
});
