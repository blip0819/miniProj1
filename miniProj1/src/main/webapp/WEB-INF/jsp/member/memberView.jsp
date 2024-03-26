<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/menu.css" rel="stylesheet">
<link href="css/font.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <style>
        #member-view {
            padding: 25px 50px 50px;
            background-color: #faf6d9;
            text-align: left;
            width: 360px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }

        .form-group label {
            width: 120px;
            display: inline-block;
            vertical-align: top;
        }

        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group input[type="radio"],
        .form-group input[type="checkbox"] {
            width: 25%;
        }

        .form-group button {
            margin-left: 10px;
        }

        h1 {
            text-align: center;
        }

        #container {
            display: flex;
            justify-content: space-around;
            align-items: flex-start;
        }

        #container img {
            width: 30%;
            height: auto;
            margin: 0 auto;
        }
    </style>
</head>
<body>
	<nav>
	    <ul>
	        <li><a href="corpInfo.html">회사 소개</a></li>
	        <li><a href="signUpForm.jsp">회원가입</a></li>
	        <li><a href="loginForm.jsp">로그인</a></li>
	        <li><a href="boardlistDefault.jsp">게시판</a></li>
	    </ul>
	</nav>
	
	<div id="container">
	    <img src="img/건강챙겨.png" width=360px>
	    <div id="member-view">
	      <label>아이디 : ${member.memberID}</label> <br/>
	      <label>이름 : ${member.memberName}</label><br/>
	      <label>주소: ${member.memberADDR}</label><br/>
	      <label>전화번호: ${member.memberPhone}</label><br/>
	      <label>성별: ${member.memberGen}</label><br/>
	
	<script>
	function jsDelete() {
		if (confirm("정말로 삭제하시겠습니까?")) {

			viewForm.action = "memberDelete.jsp";
			viewForm.submit();
		}
	}
	
	function jsUpdateForm() {
		if (confirm("정말로 수정하시겠습니까?")) {
			viewForm.action = "memberUpdateForm.jsp";
			viewForm.submit();
		}	
	}
	</script>
		<form id="viewForm" method="post">
			<input type="hidden" name="userid" value="${member.memberID}">
			<input type="button" value="삭제" onclick="jsDelete()">
			<input type="button" value="수정" onclick="jsUpdateForm()">
		</form>     
	 
		<form action="delete.jsp" method="post">
			<input type="hidden" name="userid" value="${member.memberID}">
			<input type="submit" value="삭제">
		</form>     
		
		<form action="updateForm.jsp" method="post">
			<input type="hidden" name="userid" value="${member.memberID}">
			<input type="submit" value="수정">
		</form>     
		
	    <div>
	        <a href="list.jsp">목록</a>
	        <a href="updateForm.jsp?userid=${member.memberID}">수정</a>
	        <a href="delete.jsp?userid=${member.memberID}">삭제</a>
	    </div>
	    <img src="img/아프지마.jpeg" width=360px>
	    </div>
	</div>

</body>
</html>