$(document).ready(function () {
  $.ajax({
    url: "/productlist",
    type: "GET",
    dataType: "json",
    success: function (response) {
      console.log("Response", response);
      // Loop through each product in the response
      response.forEach(function (product, index) {
        // If it's the first product or a multiple of 3, start a new row
        if (index % 3 === 0) {
          $(".product_container").append('<div class="row"></div>');
        }

        var productHTML = `
                <div class="col-4">
                    <img src="https://i.ibb.co/KsMVr26/product-3.jpg" alt="${
                    product.productName
                    }" />
                    <h3>${product.productName}</h3>
                    <p>${product.productType}</p>
                    <p>${product.price} Kyats</p>
                    <div class="rating">
                    ${Array(5).fill('<i class="fas fa-star"></i>').join("")}
                    ${Array(5 - 5)
                        .fill('<i class="far fa-star"></i>')
                        .join("")}
                    </div>
                    
                </div>`;
        $(".row:last-child").append(productHTML);
      });
    },
    error: function (xhr, status, error) {
      // Function to handle errors
      console.error("Error fetching product list:", error);
    },
  });
});
