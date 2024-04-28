$(document).ready(function() {
    $('.productForm').submit(function(e) {
      e.preventDefault(); // prevent the form from submitting normally
      var formId = $(this).attr('id');
      var url = (formId === "product_create") ? "/create_data" : (formId === "product_edit") ? "/edit_data" : "/delete_data";

      $.ajax({
          url: url,
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify({
              id: $('input[name="id"]').val(),
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