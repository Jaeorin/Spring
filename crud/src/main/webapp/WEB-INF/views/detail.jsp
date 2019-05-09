<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body onload="pageLoad()">
    <form action="/board/create" method="POST">
        <input name="num" type="hidden" value="${board.num}" />
        제 목 : <input name="title" class="board" type="text" value="${board.title}" readonly /><br />
        내 용 : <input name="content" class="board" type="text" value="${board.content}" readonly /><br />
        작 성 자 : <input name="userID" type="text" value="${board.userID}" readonly /><br />
        작성일자 : <input name="createDate" type="text" value="${board.createDate}" readonly /><br />
        <input class="update" type="button" onclick="update()" value="수정" />
        <input class="updateComplete" type="submit" value="수정완료" />
        <input type="button" value="삭제" onclick="del()" />
    </form>
    <script>
        function pageLoad() {
            let updateComplete_dom = document.querySelector(".updateComplete");
            updateComplete_dom.style.display = "none"
        }

        function update() {
            let updateComplete_dom = document.querySelector(".updateComplete");
            let update_dom = document.querySelector(".update");
            let board_dom = document.querySelectorAll(".board");
            updateComplete_dom.style.display = "inline-block";
            update_dom.style.display = "none"
            for (i = 0; i < board_dom.length; i++) {
                board_dom[i].removeAttribute("readonly");
            }
        }

        function del() {
            fetch("/board/delete/${board.num}", {
                method: "POST"
            }).then(function(res) {
                return res.text();

            }).then(function(res) {
                if (res == 1) {
                    location.href = "/board/list";
                } else {
                    alert("서버오류");
                    location.href = "/board/list";
                }

            });
        }

    </script>
</body>

</html>
