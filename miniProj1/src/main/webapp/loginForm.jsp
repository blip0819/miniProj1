<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="css/menu.css" rel="stylesheet">
	<link href="css/font.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>로그인화면</title>
    <style>
        #login-container {
            display: flex;
            justify-content: space-around;
        }

        #login-container img {
            width: 30%;
            height: auto;
        }

        #login-form {
            padding: 25px 50px 50px;
            background-color: #faf6d9;
            text-align: left;
            width: 360px;
        }

        .form-group {
            margin-bottom: 15px;
            margin-left: 55px;
            text-align: left;
        }

        .form-group label {
            width: 120px;
            display: inline-block;
            vertical-align: top;
        }

        .form-group input[type="text"],
        .form-group input[type="password"],
        .form-group input[type="number"],
        .form-group input[type="radio"],
        .form-group input[type="checkbox"] {
            width: 25%;
        }

        .form-group.checkbox-group {
            display: flex;
            align-items: left;
            justify-content: flex-start;
        	margin-top: 10px;
        }

        .form-group.checkbox-group label {
            width: auto;
            margin-right: 25px;
        }
        .form-group.checkbox-group input[type="checkbox"] {
		    margin-left: 30px;
		}
        h1 {
            text-align: center;
        }
    </style>
</head>
<c:if test="${not empty param.err}">
<script>
    alert("아이디 또는 비밀번호가 잘못되었습니다");
</script>    
</c:if>
<body>
<nav>
    <ul>
        <li><a href="corpInfo.html">회사 소개</a></li>
        <li><a href="signUpForm.jsp">회원가입</a></li>
        <li><a href="loginForm.jsp">로그인</a></li>
        <li><a href="boardlistDefault.jsp">게시판</a></li>
    </ul>
</nav>

<div id="login-container">
    <img src="img/누워있기.jpeg">
    <div id="login-form">
        <h1>로그인 화면 </h1>
        <form id="rForm" action="member.do" method="post">
            <input type="hidden" name="action" value="login">
            <div class="form-group">
                <label for="memberid">아이디 : </label>
                <input type="text" id="memberid" name="memberid" required="required" value="${parqa.memberid}">
            </div>

            <div class="form-group">
                <label for="memberPW">비밀번호 : </label>
                <input type="password" id="memberpassword" name="memberpassword" required="required">
            </div>
            <div class="form-group checkbox-group">
                <input type="checkbox" id="autologin" name="autologin" value="Y">
                <label for="autologin">자동로그인</label>
            </div>
            <input type="submit" value="로그인" style="margin-left: 110px;">
			<a href="member.do?action=list" style="margin-left: 30px;">취소</a>
        </form>
    </div>
    <img src="img/도파민중독자.jpg">
</div>
</body>
</html>