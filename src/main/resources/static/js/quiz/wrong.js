$(document).ready(function() {
  //해설  n
  $("input:submit").click(function(e) {
    let list = '\${list}';
    var length = $('input[name=length]').val(); //문제 길이
    var chk1 = $('input[name=radio1]:checked').val(); //체크된 보기 번호
    var chk2 = $('input[name=radio2]:checked').val(); //체크된 보기 번호
    var chk3 = $('input[name=radio3]:checked').val(); //체크된 보기 번호
    var chk4 = $('input[name=radio4]:checked').val(); //체크된 보기 번호
    var answer = 0;

    if(chk1 != undefined){
      answer+=1;
    }
    if(chk2 != undefined){
      answer+=1;
    }
    if(chk3 != undefined){
      answer+=1;
    }
    if(chk4 != undefined){
      answer+=1;
    }

    if(length != answer){
      alert('답을 체크하세요.');
      e.preventDefault();
    }else{
      $("form").attr("action","/answer");
    }
  });

});