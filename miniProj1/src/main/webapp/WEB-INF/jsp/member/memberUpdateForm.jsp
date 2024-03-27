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
    <title>마이페이지</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="corpInfo.html">회사 소개</a></li>
        <li><a href="member?action=memberList">회원목록</a></li>
        <li><a href="member?action=logout">로그아웃</a></li>
        <li><a href="board?action=boardlistDefault">게시판</a></li>
    </ul>
</nav>

<div id="container">
    <img src="img/건강챙겨.png" width=360px>
    <div id="update-form">
        <h1>마이페이지</h1>
        <form id="rForm" action="member.do" method="post">
            <input type="hidden" name="action" value="insert">
            
            <div class="form-group">
                <label for="memberid">아이디 :</label>
                    <input type="text" id="memberid" name="memberid" required="required" readonly>
            </div>
            
            <div class="form-group">
                <label for="memberPW">비밀번호 :</label>
                <input type="PW" id="memberPW" name="memberPW" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberPW2">비밀번호확인 :</label>
                <input type="PW" id="memberPW2" name="memberPW2" required="required">
            </div>
            
            <div class="form-group">
                <label for="membername">이름 :</label>
                <input type="text" id="membername" name="membername" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberADDR">주소 :</label>
                <input type="text" id="memberADDR" name="memberADDR" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberphone">전화번호 :</label>
                <input type="text" id="memberphone" name="memberphone" required="required">
            </div>

            <label>성별:</label>
            <div class="gender-container">
                <input type="radio" id="male" name="gender" value="male">
                <label for="male" class="radio-label">남</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female" class="radio-label">여</label>
            </div>
            <br>
            <label>취미:</label><br>
            <div>
                <input type="checkbox" id="hobby1" name="hobby" value="Exercising">
                <label for="hobby">운동</label>
            </div>
            <div>
                <input type="checkbox" id="hobby2" name="hobby" value="Cooking">
                <label for="hobby">요리</label>
            </div>
		<div>
		    <input type="checkbox" id="hobby3" name="hobby" value="Movies">
		    <label for="hobby">영화 감상</label>
		</div>
		<div>
		    <input type="checkbox" id="hobby4" name="hobby" value="Fishing">
		    <label for="hobby">낚시</label>
		</div>
		<br>
        <input type="submit" value="수정" >
        <a href="member.do?action=memberView">취소</a>
        </form>
    </div>
    <img src="img/아프지마.jpeg" width=360px>
    </div>

</body>
</html>