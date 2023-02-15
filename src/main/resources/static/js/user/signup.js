$(document).ready(function () {
  let urlSearch = new URLSearchParams(location.search);
  let isSNSUser = urlSearch.get('isSNSUser');

  if (isSNSUser) {
    $("#email").hide();
    $("#pw").hide();
    $("#pw_check").hide();
  }

  $("#signup_form").on("submit", function (event) {
    event.preventDefault();
    let result;
    let isNotEmpty = false;

    $('#signup_form input:not([type=image],[type=button],[type=submit], [type=checkbox])')
    .each(
        function (index) {
          result = emptyAlert($(this))
          if (result != "") {
            alert(result)
            return false;
          } else {
            isNotEmpty = true;
          }
        });

    if (isNotEmpty) {
      if ($("#password").val() != $("#password_check").val()) {
        alert('비밀번호가 다릅니다. 다시 입력해주세요');
        return;
      } else if (!($("#subscribe").prop("checked"))) {
        alert('구독에 동의하셔야 서비스 가입이 가능합니다');
        return;
      }

    }

    let fd = new FormData($('#signup_form')[0]);
    let category = {
      "main": fd.get("category_main"),
      "middle": fd.get("category_middle"),
      "sub": fd.get("category_sub"),
    }
    fd.append("category", category);
    window.ajax.sendForm("/user/1", fd)
  })

});