<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">
    <div id="title">
        <a href="<%=request.getContextPath()%>/" style="text-decoration-line: none; color:black;">IT Yogurt</a>
    </div>
    <div class="nav">
        <ul class="nav-menu">
            <li id="nav-menu-knowledge">
                <a href="<%=request.getContextPath()%>/list2/1" style="text-decoration-line: none; color:white;">매일지식</a>
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