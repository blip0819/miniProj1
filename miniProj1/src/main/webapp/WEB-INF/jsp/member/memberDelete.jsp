<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/menu.css" rel="stylesheet">
<link href="css/layout.css" rel="stylesheet">
<link href="css/font.css" rel="stylesheet">
<meta charset="UTF-8">
<title>회원탈퇴</title>
<style>
#deleted{
    padding: 25px 50px 50px;
    background-color: #faf6d9;
    text-align: center;
    width: 360px;
    margin: 0 auto;
}
</style>
</head>
<body>
    
    <nav>
	    <ul>
	        <li><a href="corpInfo.html">회사 소개</a></li>
            <li><a href="member?action=memberList">회원목록</a></li>
            <li><a href="member?action=logout">로그아웃</a></li>
            <li><a href="board?action=boardList">게시판</a></li>
	    </ul>
	</nav>
	
	<div id="container" style="text-align: center;">
	    <img src="img/비가아니라눈물.jpeg">
	    <div id="deleted">
	    <h3>잘가...(가지마) 행복해...(떠나지마)</h3>
	        <c:if test="${updated != 0}">
	            탈퇴가 완료되었습니다.
	        </c:if>
	    
	    <form action="member" method="post">
	        <input type="hidden" name="action" value="memberList">
	        <input type="submit" value="돌아가기">
	    </form>
	    </div>
	    
	    <img src="img/가오살려.jpeg"> 
	</div>
	
</body>
</html>

