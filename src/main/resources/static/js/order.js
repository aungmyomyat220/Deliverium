$(document).ready(function () {
    $("#order_table").DataTable({
      ajax: {
        url: "/getAllOrders",
        dataSrc: "",
      },
      columns: [
        {
          data: "id",
          render: function(data, type, row, meta) {
            return meta.row + 1;
          }
        },
        { data: "productName"},
        { data: "username" },
        { data: "email" },
        { data: "quantity"},
        {
          data: "status",
          render: function(data, type, row) {
              return data == "0" ? '<i class="bi bi-hourglass-split"></i>' : '<i class="bi bi-patch-check-fill text-success"></i>';
          },
      },
      
        {
          data: "status",
          render: function (data, type, row) {
            return (
              data === "0" ?
              '<div><i class="bi bi-check-circle big-icon text-success mr-3"></i><i class="bi bi-x-circle-fill big-icon text-danger"></i></div>'
              :
              '<button type="button" class="btn btn-secondary" disabled>Approved</button>'
            );
          },
        },
      ],
    });
    // Handle click events on ban button
    $("#user_table").on("click", ".ban-button", function () {
      var id = $(this).data("id");
      showDialogBox(id, "ban");
    });
  
    // Handle click events on activate button
    $("#user_table").on("click", ".active-button", function () {
      var id = $(this).data("id");
      showDialogBox(id, "active");
    });
  
    function showDialogBox(id, status) {
      if (status == "ban") {
        var text = "Do you want to Ban?"
        var buttonName = "Ban"
        var status = 0
      } else {
        var text = "Do you want to Activate?"
        var buttonName = "Activate"
        var status = 1
      }
      Swal.fire({
        title: 'Are you sure?',
        text: text,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: buttonName
      }).then((result) => {
          if (result.isConfirmed) {
            $.ajax({
              url: "/change_status",
              type: "POST",
              contentType: "application/json",
              data: JSON.stringify({
                id: id,
                status : status,
              }),
              success: function (response) {
                Swal.fire({
                  title: 'Process Success',
                  icon: 'success',
                  showConfirmButton: false,
                  timer: 2000,
              }); 
                $('#user_table').DataTable().ajax.reload();
              },
            });
          }
      });
    }
  });