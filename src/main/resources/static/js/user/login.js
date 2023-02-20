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

    $('#login_form input:not([type=image],[type=button],[type=submit], [type=checkbox])')
    .each(
        function (index) {
          let target = $(this);
          result = window.util.emptyAlert(target);
          if (result != "") {
            return false;
          }
        });

    if (result != "") {
      alert(result);
      return;
    }

    // 로그인 요청
    window.ajax.sendForm("/user", new FormData($('#login_form')[0]),
        loginSuceess, loginError)
  })
});

loginSuceess = (result) => {
  alert(result);
  window.location.href="/";
}
loginError = (request) => {
  alert(request.responseJSON.errorMessage);
}