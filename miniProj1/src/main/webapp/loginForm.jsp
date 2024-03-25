<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인화면</title>
    <style>
        label {
            display: inline-block;
            width: 120px;
        }
        input {
            margin-bottom: 10px; 
        }
    </style>
</head>
<c:if test="${not empty param.err}">
<script>
	alert("아이디 또는 비밀번호가 잘못되었습니다");
</script>	
</c:if>
<body>
    <h1>
        로그인 화면 
    </h1>
    <form id="rForm" action="member.do" method="post" >
    	<input type="hidden" name="action" value="login">
        <label>아이디 : </label> <input type="text" id="memberid" name="memberid" required="required" value="${parqa.memberid}"><br/>
        <label>비밀번호 : </label>   <input type="password" id="memberpassword" name="memberpassword" required="required"><br/>
        <label for="autologin">자동로그인</label> <input type="checkbox" id="autologin" name="autologin" value="Y">    
    <div>
        <input type="submit" value="로그인" >
        <a href="member.do?action=list">취소</a>
    </div>
    
    </form>
    
<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
    
<script type="text/javascript">
    </script>
    
</body>
</html>







