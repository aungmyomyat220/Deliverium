$(document).ready(function () {
    $.ajax({
        url: "/productlist",
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            console.log("Response",response);
            // Loop through each product in the response
            response.forEach(function(product, index) {
                // If it's the first product or a multiple of 3, start a new row
                if (index % 3 === 0) {
                    $('.product_container').append('<div class="row"></div>');
                }

                // Create HTML elements for each product
                var productHTML = '<div class="col-4">' +
                                      '<img src="https://i.ibb.co/KsMVr26/product-3.jpg" alt="' + product.productName + '" />' +
                                      '<h4>' + product.productName + '</h4>' +
                                      '<div class="rating">';
                
                // Add stars based on product rating
                for (var i = 0; i < product.rating; i++) {
                    productHTML += '<i class="fas fa-star"></i>';
                }
                for (var i = product.rating; i < 5; i++) {
                    productHTML += '<i class="far fa-star"></i>';
                }
                
                productHTML += '</div>' +
                               '<p>' + product.price + ' Kyats</p>' +
                               '</div>';

                // Append the product HTML to the last row
                $('.row:last-child').append(productHTML);
            });
        },
        error: function(xhr, status, error) {
            // Function to handle errors
            console.error('Error fetching product list:', error);
        }
    });
});
