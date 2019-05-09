<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
            <td>번호</td>
            <td>제목</td>
            <td>작성자명</td>
            <td>등록일</td>
        </tr>
        <c:forEach var="item" items="${board}">
            <tr>
                <td>${item.num}</td>
                <td><a href="/board/${item.num}">${item.title}</a></td>
                <td>${item.userID}</td>
                <td>${item.createDate}</td>
            </tr>
        </c:forEach>
	</table>
	<a href="/board/write">글쓰기</a>
</body>
</html>