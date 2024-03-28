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
	    <img src="img/스불행.jpeg" width=360px>
	    <div id="member-view">
	    <h1>회원 정보</h1>
	      <label>아이디 : ${member.memberID}</label> <br>
	      <label>이름 : ${member.memberName}</label><br>
	      <label>주소: ${member.memberADDR}</label><br>
	      <label>전화번호: ${member.memberPhone}</label><br>
	      <label>성별: ${member.memberGen}</label><br><br>
	      
	
	<script>
	function jsDelete(memberID) {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			action.value= "memberDelete";
			viewForm.submit();
			
			 const memberID = document.getElementById("memberID"); 
		    	const param = {
					 action : 'memberDelete'
					,memberID : memberID.value
		    	} 
			    	
				fetch("member.do", {
					method:"POST",
					body:JSON.stringify(param),
					headers : {"Content-type" : "application/json; charset=utf-8"}
				}).then(res => res.json()).then(json => {
					console.log("json ", json );
					if(json.status == 0) {
						//성공
						alert("탈퇴가 완료되었습니다");
						location = "member.do?action=memberList";
					} else {
						alert(json.statusMessage);
					}
				});
		}
	}
	
	function jsUpdateForm(memberID) {
			action.value= "memberUpdateForm";
			viewForm.submit();
	}
	
	function jsList(){
			action.value= "memberList";
			viewForm.submit();
	}
	</script>
		<div>
		<form id="viewForm" method="get" action="member">
			<input type="hidden" id="action" name="action" value="">
			<input type="hidden" name="memberID" value="${member.memberID}">
			<input type="button" value="탈퇴" onclick="jsDelete()">
			<input type="button" value="수정" onclick="jsUpdateForm()">
			<input type="button" value="목록" onclick="jsList()">
		</form>  
		</div>

	</div>
		    <img src="img/사랑평화행복.jpeg" width=360px>
</body>
</html>