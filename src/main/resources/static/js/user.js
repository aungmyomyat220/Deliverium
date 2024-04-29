$(document).ready(function () {
    $("#user_table").DataTable({
      ajax: {
        url: "/userlist",
        dataSrc: "",
      },
      columns: [
        { data: "id" },
        { data: "username" },
        { data: "email" },
        {
          data: "role",
          render: function (data, type, row) {
            return data == 0 ? "admin" : "user";
          },
        },
        {
          data: "status",
          render: function (data, type, row) {
            return data == 0 ? '<i class="bi bi-slash-circle-fill text-danger"></i>' : '<i class="bi bi-check-circle-fill text-success"></i>';
          },
        },
        {
          data: "status",
          render: function (data, type, row) {
            return (
              '<button type="button" class="btn btn-danger ban-button" data-id="' +
              row.id +
              '">' +
              (data == 1 ? "Ban" : "Activate") +
              "</button>"
            );
          },
        },
      ],
    });
    // Handle click events on edit icons
    $("#user_table").on("click", ".ban-button", function () {
      var id = $(this).data("id");
      Swal.fire({
        title: 'Are you sure?',
        text: 'Do you want to Ban?',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Ban'
      }).then((result) => {
          if (result.isConfirmed) {
            $.ajax({
              url: "/ban_user",
              type: "POST",
              contentType: "application/json",
              data: JSON.stringify({
                id: id,
              }),
              success: function (response) {
                alert(response);
                $('#user_table').DataTable().ajax.reload();
              },
            });
          }
      });
    });

   
  });