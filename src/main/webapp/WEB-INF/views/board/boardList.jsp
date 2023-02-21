<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/container.css" rel="stylesheet">
     <link href="/css/admin.css" rel="stylesheet">
<title> 커뮤니티 | 게시판 </title>
<style>
.tableList:hover {
	background-color: #91ACCC;
	color: white;
	cursor: pointer;
}
.page-link {
  color: #fff; 
  background-color: #91ACCC;
  border: 1px solid #ccc; 
}

.page-item.active .page-link {
 z-index: 1;
 color: #555;
 font-weight:bold;
 background-color: #f1f1f1;
 border-color: #ccc;
 
}

.page-link:focus, .page-link:hover {
  color: #000;
  background-color: #fafafa; 
  border-color: #ccc;
}

</style>
</head>
<body>

<div class="container">
<%@include file="../common/header.jsp" %>
     <div class="form">
		<h3 id="main" > 게시판 </h3> <br>
		<table class="form" border=3>
			<tr>
				<th> 번호 </th>
				<th> 카테고리 </th>
				<th> 제목 </th>
				<th> 작성자 </th>
				<th> 조회수 </th>
			</tr>
			<tbody class="listData">
			<c:forEach items="${boardList }" var="list">
			<tr class="tableList" onClick="location.href='/board/${list.boardSeq}'">
				<td id ="boardSeq">${list.boardSeq }</td>
				<td>${list.category }</td>
				<td style="display : flex;">${list.title }</td>
				<td>${list.nickname }</td>
				<td>${list.viewcount }</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			
	<div class="paging">
	<nav aria-label="Page navigation example" style="margin: 10px;">
			<ul class="pagination justify-content-center">
	        <li class="page-item"><a href='javascript:void(0);' onclick="go_page(1); return false;" class="page-link">처음</a></li>
	    <%-- <c:if test="${paging.prev}"> --%>
	        <li class="page-item"><a href='javascript:void(0);' onclick="go_page(${paging.startPage-1});" class="page-link">이전</a></li>
	   <%--  </c:if> --%>
	    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
	    	<c:choose>
	    		<c:when test= "${num==1 }">
	        		<li class="page-item active" style="pagination-bg: #91ACCC"><span><a href='javascript:void(0);' onclick="go_page(${num}); return false;" class="page-link">${num}</a></span></li>
				</c:when>
				<c:otherwise>
	        		<li class="page-item" style="pagination-bg: #91ACCC"><span><a href='javascript:void(0);' onclick="go_page(${num}); return false;" class="page-link">${num}</a></span></li>
				</c:otherwise>
			</c:choose>	        
	    </c:forEach>
	    <%-- <c:if test="${paging.next && paging.endPage>0}"> --%>
	        <li class="page-item"><a href='javascript:void(0);' onclick="go_page(${paging.endPage+1});return false;" class="page-link">다음</a></li>
		 <%--</c:if> --%>
	        <li class="page-item"><a href='javascript:void(0);' onclick="go_page(${maxpage});return false;" class="page-link">끝</a></li>
			</ul>
	</nav>
	</div>
	
<div class="d-grid gap-2 d-sm-flex justify-content-sm-end">
  <button class="btn btn-primary" style="background-color: #91ACCC; font-size: 15px; width: 80px;" type="button" onClick="location.href='/board/form'">글쓰기</button>
</div>
	</div>
<%@include file="../common/footer.jsp" %>
</div>
</body>

<script>

function go_page(pageNum){
	
	
	
	$.ajax({
		url: "${pageContext.request.contextPath}/board/list/a?page="+pageNum,
		type: "GET",
		dataType: "json",
		success: function(result){
			let list = result.boardList;
			let content = '';
			for(let i=0;i<list.length;i++){
				content += '<tr class="tableList" onClick="window.location=\'/board/'+list[i].boardSeq+'\'">';
				content += '<td id ="boardSeq">' + list[i].boardSeq +'</td>';
				content +=	'<td>'+ list[i].category +'</td>';
				content +=	'<td style="display : flex;">'+ list[i].title+ '</td>';
				content +=	'<td>'+ list[i].nickname + '</td>';
				content += '<td>' + list[i].viewcount + '</td>';
				content += '</tr>';
			}
			$('.listData').html(content);	
			
			let paging = result.paging;
			let content2 = '';
			
				
				content2 += '<nav aria-label="Page navigation example" style="margin: 10px;">';
				content2 += '<ul class="pagination justify-content-center">';
				content2 += '<li class="page-item"><a href=\'javascript:void(0);\' onclick="go_page(1); return false;" class="page-link">처음</a></li>';
				
				
				/* if(paging.prev){ */
					content2 += '<li class="page-item"><a href=\'javascript:void(0);\' onclick="go_page('+(Number(paging.startPage)-1)+');return false;" class="page-link">이전</a></li>';
				/* } */
				for (let num = Number(paging.startPage) ; num <=Number(paging.endPage); num++){
					if (num == Number(paging.cri.page)){
						content2 += '<li class="page-item active" style="pagination-bg: #91ACCC"><span><a href=\'javascript:void(0);\' onclick="go_page('+num+'); return false;" class="page-link">'+ num +'</a></span></li>';
						
					}
					else{
						content2 += '<li class="page-item" style="pagination-bg: #91ACCC"><span><a href=\'javascript:void(0);\' onclick="go_page('+num+'); return false;" class="page-link">'+ num +'</a></span></li>';
					}
				}
				if (paging.next && paging.endPage>0){
					content2 += '<li class="page-item"><a href=\'javascript:void(0);\' onclick="go_page('+ (Number(paging.endPage)+1)+');return false;" class="page-link">다음</a></li>';
				}
				content2 += '<li class="page-item"><a href=\'javascript:void(0);\' onclick="go_page('+ Number(result.maxPage) +');return false;" class="page-link">끝</a></li>';
				content2 += '</ul>';
				content2 += '</nav>';
			
			
				$('.paging').html(content2);	
		},
		error: function(){
			console.log('error');
		}
	})
}

</script>

<%-- 						"<tr id="+ajaxTr+">"+
						"<td>"+\${list[i].knowSeq}+"</td>"+
						<td><a href="<%=request.getContextPath()%>/detail/\${list[i].knowSeq}">${list.title}</a></td>
						<td>\${list[i].insertDate }</td>
						<td>\${list[i].viewcount }</td>
						<td>관리자</td>	
						<td><input type="button" id="quizBtn" value="퀴즈 풀러가기" onClick="location.href='${pageContext.request.contextPath}/quiz/\${list.knowSeq}'"></td>
					</tr> --%>



<!-- <script>
function go_page(pageNum){
	
	var pageNum = pageNum;
	var boardList = boardList.serialiaze();
	
$.ajax({
    url :'board/list'+ pageNum,
    type: 'GET',
    data: {},
    success: result => {
      success(result);

      var content = '';
      var content2 = '';
      
     $.each(result, function(key, value) {
    	 
     content += '<tr class="tableList" onClick="location.href=\'/board/'+${list.boardSeq}+''">';
	 content += '<td id ="boardSeq">' + ${list.boardSeq } +'</td>';
	 content +=	'<td>'+ ${list.category } +'</td>'
	 content +=	'<td style="display : flex;">'+ ${list.title }+ '</td>'
	 content +=	'<td>'+ ${list.nickname } + '</td>'
	 content += '<td>' + ${list.viewcount } + '</td>'
	 content += '</tr>'
     });
     
     $(".listData").html(content); 
     
    },
    error: (request) => {
      error(request);
    },
  });
},
}

</script> -->

</html>