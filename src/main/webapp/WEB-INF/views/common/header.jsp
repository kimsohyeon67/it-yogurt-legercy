<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">
    <div id="title">
        IT Yogurt
    </div>
    <div class="nav">
        <ul class="nav-menu">
            <li id="nav-menu-knowledge">
                <a href="<%=request.getContextPath()%>/list?page=1" style="text-decoration-line: none; color:white;                      ">매일지식</a>
            </li>
            <li id="nav-menu-quiz">
                퀴즈
            </li>
            <li id="nav-menu-mypage" hidden="hidden">
                마이 페이지
            </li>
        </ul>
    </div>
</div>