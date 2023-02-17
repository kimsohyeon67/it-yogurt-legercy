let isSNSUser =false;

$(document).ready(function () {

  if (isSNSUser) {
    $(".form-input-email").hide();
    $(".form-input-password").hide();
    $(".form-input-password-check").hide();
  }

  $("#signup_form").on("submit", function (event) {
    event.preventDefault();

    let isNotEmpty = false;

    $('#signup_form input:not([type=image],[type=button],[type=submit], [type=checkbox])')
    .each(
        function (index) {
          let result;
          if (isSNSUser && ($(this).attr("id")== ("password") || $(this).attr("id")
              == ("password_check"))) {
            return true;
          }

          result = window.util.emptyAlert($(this));

          if (result != "") {
            alert(result)
            return false;
          } else {
            isNotEmpty = true;
          }
        })

    if (isNotEmpty) {
      if (($("#password").val() != $("#password_check").val()) && !isSNSUser) {
        console.log($("#password").val() );
        console.log($("#password_check").val());
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
    $.ajax({
      url: "/user/1",
      enctype: 'multipart/form-data',
      type: 'POST',
      cache: false,
      processData: false,
      contentType: false,
      data: fd,
      success: result => {
        alert("회원가입이 완료 되었습니다.")
        window.location.href = "/user";
      },
      error: (request, status, error) => {
        return error;
      }
    });
    // let data = window.ajax.sendForm("/user/1", fd);

  })

});