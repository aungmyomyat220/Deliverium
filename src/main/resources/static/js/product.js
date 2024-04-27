$(document).ready(function() {
    $('#product_create').submit(function(e) {
      e.preventDefault(); // prevent the form from submitting normally
  
      $.ajax({
          url: '/create_data',
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify({
              productName: $('input[name="productName"]').val(),
              price: $('input[name="price"]').val(),
              productType: $('input[name="productType"]').val()
          }),
          success: function(response) {
              alert(response);
              $('input[type="text"]').val('')
          }
      });
  });
});