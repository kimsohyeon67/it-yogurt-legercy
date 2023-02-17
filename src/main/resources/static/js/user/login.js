$(document).ready(function () {

  $(".sign_up").on("click", function () {
    window.document.location.href = "/user/1"
  })

  $(".sns_login_btn").on("click", function () {
    let ouathType = $(this).attr("id");
    window.document.location.href = `/auth/${ouathType}`
  })

  $("#login_form").on("submit", function (event) {
    event.preventDefault();

    let result;
    let isNotEmpty = false;

    $('#login_form input:not([type=image],[type=button],[type=submit], [type=checkbox])')
    .each(
        function (index) {
          result = window.util.emptyAlert($(this))
          if (result != "") {
            alert(result)
            return false;
          } else {
            isNotEmpty = true;
          }
        });

    // 로그인 요청
    $.ajax({
      url: "/user",
      enctype: 'multipart/form-data',
      type: 'POST',
      cache: false,
      processData: false,
      contentType: false,
      data: new FormData($('#login_form')[0]),
      success: result => {
        if (result == "") {
          window.location.href = "/";
        }
        else
        {
          alert(result)
        }

      },
      error: (request, status, error) => {
        alert(error);
      }
    });
    //window.ajax.sendForm("/user", new FormData($('#login_form')[0]))

  })

});
