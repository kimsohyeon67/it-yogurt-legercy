<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
.dropdown{
  position : relative;
  display : inline-block;
}

.dropdown-content{
   display : none;
  position : absolute;
  z-index : 1; /*다른 요소들보다 앞에 배치*/
  font-weight: 400;
  background-color: #f9f9f9;
  min-width : 200px;
}

.dropdown-content a{
 display : block;
  text-decoration : none;
  color : rgb(37, 37, 37);
  padding : 12px 20px;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
<div class="header">
    <div id="title">
        <a href="<%=request.getContextPath()%>/" style="text-decoration-line: none; color:black;">IT Yogurt</a>
    </div>

    <div class="nav">
        <ul class="nav-menu">
            <li id="nav-menu-knowledge">
            		<div class="dropdown">
            		<span class="dropbtn">매일지식</span>
<%--                 <a href="<%=request.getContextPath()%>/knowledge/list" style="text-decoration-line: none; color:white;">매일지식</a> --%>
                	<div class="dropdown-content">
				        <a href="<%=request.getContextPath()%>/knowledge/list/category">프로그래밍언어</a>
			        </div>
			        </div>
            </li>
            <li id="nav-menu-quiz">
                <a href="<%=request.getContextPath()%>/board/list" style="text-decoration-line: none; color:white;">게시판</a>
            </li>
            <li id="nav-menu-mypage" hidden="hidden">
                마이 페이지
            </li>
        </ul>
    </div>
</div>