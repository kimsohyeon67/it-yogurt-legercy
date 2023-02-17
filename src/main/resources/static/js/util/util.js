window.util = {
  emptyAlert: (target, isSNS = false) => {
    let value = target.val();
    if (!value || value == "") {
      var label_txt = $("label[for='" + target.attr('id') + "']").text();
      return `${label_txt}을(를) 입력해주세요`;
    }
    return "";
  }
}