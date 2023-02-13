<%@ include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row mt-5 md" id="box-detail">
        <div id="box-boardbtn" class="btn-right col-10">
            <button type="button" class="btn btn-primary btn-sm" id="btn-modify-board" onclick="location.href='updateboard/${board.boardSeq}'">수정하기</button>
            <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal" >삭제하기</button>
        </div>
    </div>

    <br><br><hr><br><br>

    <div id="box-comment-list">
        <div class="col-10 btn-right">
            <button type="button" class="btn btn-primary btn-sm" id="btn-modify-${comment.commentSeq}" onclick="location.href='/comment/update/${comment.commentSeq}'">수정하기</button>
            <button type="button" class="btn btn-danger btn-sm" id="btn-delete-${comment.commentSeq}" onclick="location.href='/comment/delete/${comment.commentSeq}'">삭제하기</button>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
                </div>
                <div class="modal-body" style="text-align: center">
                    <h4><strong>정말 삭제하시겠습니까?</strong><h4>
                        <p class="fs-5 mb-5">삭제 후 복구는 불가합니다.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-primary" id="btn-delete-board">확인</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
