<%@ page language="java" contentType="text/html;charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/header.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/container.css" rel="stylesheet">
<link href="/css/knowledge.css" rel="stylesheet">

<title>매일지식 컨텐츠</title>
</head>
<body>
	<div class="container">
		<%@include file="../common/header.jsp"%>
		<div class="content">
			<div id="tblDiv">
			
			<h1 style="text-align: center;">매일지식 목록</h1>
			<form action="<%=request.getContextPath()%>/searchResult">
			<input type="text" placeholder="검색어 입력" name="keyword" id="keyword">
                <button type="submit" id="search">검색</button>
			<table id="listTbl">
				
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
					<th>작성자</th>
					<th>퀴즈풀러가기</th>
				</tr>

				<%-- <c:forEach items="${knowledgeList }" var="list">
					<tr id="id"> --%>

				<tbody>
					
					<c:forEach items="${knowledgeList }" var="list">
					<tr id="ajaxTr">
						<td>${list.knowSeq}</td>
						<td><a href="<%=request.getContextPath()%>/detail/${list.knowSeq}">${list.title}</a></td>
						<td>${list.insertDate }</td>
						<td>${list.viewcount }</td>
						<td>관리자</td>	
						<td><input type="button" id="quizBtn" value="퀴즈 풀러가기" onClick="location.href='<%=request.getContextPath()%>/quiz/${list.knowSeq}'"></td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
			<div id="page">
				<%
				int totalCnt = (int) request.getAttribute("totalCnt");
				int totalPage = 0;
				if (totalCnt % 9 == 0) {
					totalPage = totalCnt / 9;
				} else {
					totalPage = totalCnt / 9 + 1;
				}
				for (int i = 1; i <= totalPage; i++) {
					System.out.println(i);
				%>
				<input type="hidden" id="hide" value="<%=i%>"><%=i %>
				<a href=" <%=request.getContextPath()%>/list/<%=i%>" class="page-link" id="page" <%-- value=<%=i %> --%>><%=i%>페</a>
				<%
				}
				%>
				<c:set var="i" value="$('#a').val()" />
			</div>
			</form>
		</div>
		<%@include file="../common/footer.jsp"%>
		</div>
	</div>
<script type="text/javascript">

// var total = 0;
// var nowPage = 0;
// var endPage=0;
// var pageIndex=0;
// var cntPerPage=0;

//html /값이 1만 넘어옴
$("#page").on("click",function(){
// 	$("#page").attr("id")
	let a = $("#hide").val();
	let i = '<c:out value="${i}"/>';
	let page = $("#page").html();
	alert(i);
	$.ajax({
		url: "${pageContext.request.contextPath}/list/"+page,
		type: "get",
		dataType: "json",
		success: function(result){
			let list = result.knowledgeList;
			for(let i=0;i<list.length;i++){
				$('#ajaxTr').html(
						"<tr id="+ajaxTr+">"+
						"<td>"+\${list[i].knowSeq}+"</td>"+
						<td><a href="<%=request.getContextPath()%>/detail/\${list[i].knowSeq}">${list.title}</a></td>
						<td>\${list[i].insertDate }</td>
						<td>\${list[i].viewcount }</td>
						<td>관리자</td>	
						<td><input type="button" id="quizBtn" value="퀴즈 풀러가기" onClick="location.href='${pageContext.request.contextPath}/quiz/\${list.knowSeq}'"></td>
					</tr>
						);				
			}
		},
		error: function(){
			console.log('error');
		}
	})
})
	




// var pageNum = 1;
// console.log('전역변수 페이지 넘버:'+pageNum);

// function getReply(){
// 	console.log("getReply들어옴:${dto.placeName}")
// 	$.ajax({
// 		url:"${pageContext.request.contextPath}/list?pageNum="+pageNum,
// 		type : "get",		
// 		dataType: "json",
// 		success:function(list){
// 			let html="";
// 			list.foreach(function(data){
// 				html+=data.knowSeq+"/"+data.title+"/"+data.insertDate+"/"+data.viewcount
// 			});
// 			if(pageNum ==1){
// 				html +="<button disabled>&lt;</button>"
// 			}else{
// 				html +="<button onclick='getPageMinus()'>&lt;</button>"
// 			}
// 			if(list == ""){
// 				html +="<button disabled>&lt;</button>"
// 			}else{
// 				html +="<button onclick='getPagePlus()'>&lt;</button>"
// 			}
// 			$("#reply").html(html)
// 		}//success
				
// 	});
// }


// $(document).ready(function() {
// 	$("#page").click(function(){
// // 		var a = $('#page').val();
// // 		console.log(a);
		
// 		$.ajax({
// 			url : "${pageContext.request.contextPath}/list",
// 			type : 'get',
// 			data : {
// 				page : "1"
// 			},
// 			success : function(data) {
// 				alert(data.knowSeq);
//             	alert(data.title); 
//                 alert(data.insertDate);
//                 alert(data.viewcount);		
// 		     },
// 			error : function() {
// 				alert("error");
// 			}
// 		});
		
// // 		alert('페이징');
// 	});

// });	
</script>
</body>
</html>