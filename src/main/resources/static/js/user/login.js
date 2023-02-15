$(document).ready(function () {

  $(".sign_up").on("click", function () {
    window.document.location.href = "/user/1"
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
  })

});
