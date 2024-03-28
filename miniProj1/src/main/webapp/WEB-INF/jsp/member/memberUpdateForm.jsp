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
        
            <div id = update-form>
            <h1>마이페이지</h1>
   			<form id="rForm" action="member" method="post">
            <input type="hidden" name="action" value="memberUpdate">
            <div class="form-group">
        	<label>아이디 : </label>
        	<input type="text" id="memberID" name="memberID" value="${member.memberID}" readonly="readonly"> <br/>
            </div>
            
            <div class="form-group">
             <label>비밀번호 : </label>
             <input type="password" id="memberPW" name="memberPW" value="${member.memberPW}" required="required"> <br/>
            </div>
            
            <div class="form-group">
                <label>비밀번호확인 : </label>
                <input type="password" id="memberPW2" name="memberPW2" required="required">
            </div>
            
            <div class="form-group">
                <label>이름 : </label>
                <input type="text" id="memberName" name="memberName" value="${member.memberName}">
            </div>
            
            <div class="form-group">
                <label>주소 : </label>
                <input type="text" id="memberADDR" name="memberADDR" value="${member.memberADDR}">
            </div>
            
            <div class="form-group">
                <label>전화번호 : </label>
                <input type="text" id="memberPhone" name="memberPhone" value="${member.memberPhone}">
            </div>

            <label>성별:</label>
			<div class="gender-container">
			    <input type="radio" id="memberGen" name="memberGen" value="남" ${member.memberGen == '남' ? 'checked' : ''}>
			    <label for="남" class="radio-label">남</label>
			    <input type="radio" id="memberGen" name="memberGen" value="여" ${member.memberGen == '여' ? 'checked' : ''}>
			    <label for="여" class="radio-label">여</label>
			</div>

            <br>
           <!-- <label>취미:</label><br>
            <div class="hobby-container">
                <input type="checkbox" id="exercising" name="hobby" value="exercising">
                <label for="hobby" class="checkbox-label">운동</label>
            </div>
            <div>
                <input type="checkbox" id="cooking" name="hobby" value="cooking">
                <label for="hobby" class="checkbox-label">요리</label>
            </div>
			<div>
		    <input type="checkbox" id="movies" name="hobby" value="movies">
		    <label for="hobby" class="checkbox-label">영화 감상</label>
			</div>
			<div>
		    <input type="checkbox" id="fishing" name="hobby" value="fishing">
		    <label for="hobby" class="checkbox-label">낚시</label>
			</div> --> 
		<br> 
				<input type="submit" value="수정">
       			<a href="member?action=memberView&memberID=${member.memberID}">취소</a>
       	</form>
    
		<script type="text/javascript">
		const rForm = document.getElementById("rForm");
		const memberID = document.getElementById("memberID");
		const memberPW = document.getElementById("memberPW");
		const memberPW2 = document.getElementById("memberPW2");
		const memberName = document.getElementById("memberName");
		const memberADDR = document.getElementById("memberADDR");
		const memberPhone = document.getElementById("memberPhone");
		const memberGen = document.getElementById("memberGen");
		
		rForm.addEventListener("submit", e => {
			//서버에 form data를 전송하지 않는다 
			e.preventDefault();
			
			if (memberPW.value != memberPW2.value) {
		    	
				alert("비밀번호가 잘못되었습니다.")
				memberPW2.value = "";
				memberPW2.focus();
				return false;
			}
			//fetch를 사용하여 회원 정보 수정을 함
			//전송자료 구성 
			const param = {
				 action : 'memberUpdate'
				,memberID : memberID.value
		    	,memberPW : memberPW.value
		        ,memberName : memberName.value
		        ,memberADDR : memberADDR.value
		        ,memberPhone : memberPhone.value
		        ,memberGen : memberGen.value
			} 
			
			fetch("member", {
				method:"POST",
				body:JSON.stringify(param),
				headers : {"Content-type" : "application/json; charset=utf-8"}
			}).then(res => res.json()).then(json => {
				//서버로 부터 받은 결과를 사용해서 처리 루틴 구현  
				console.log("json ", json );
				if(json.status == 0) {
					//성공
					alert("회원 정보 수정을 성공 하였습니다");
					location = "member?action=memberView&memberID=" + memberID.value;
				} else {
					alert(json.statusMessage);
				}
			});
		});
		
		</script>    


    </div>
    <img src="img/아프지마.jpeg" width=360px>
    </div>

</body>
</html>