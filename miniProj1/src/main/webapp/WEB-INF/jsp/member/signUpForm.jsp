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
    <title>회원가입 화면</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="corpInfo.html">회사 소개</a></li>
        <li><a href="member?action=signUpForm">회원가입</a></li>
        <li><a href="member?action=loginForm">로그인</a></li>
        <li><a href="board?action=boardlistDefault">게시판</a></li>
    </ul>
</nav>

<div id="container">
    <img src="img/귀여움자격증.jpeg" width=360px>
    <div id="signup-form">
        <h1>회원가입 양식</h1>
        <form id="rForm" action="member" method="post">
            <input type="hidden" name="action" value="memberInsert">
            
            <div class="form-group">
                <label for="memberID">아이디 :</label>
                <input type="text" id="memberID" name="memberID" required="required">
                <button type="button" id="duplicatedID">중복확인</button>
            </div>
            
            <div class="form-group">
                <label for="memberPW">비밀번호 :</label>
                <input type="password" id="memberPW" name="memberPW" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberPW2">비밀번호확인 :</label>
                <input type="password" id="memberPW2" name="memberPW2" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberName">이름 :</label>
                <input type="text" id="memberName" name="memberName" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberADDR">주소 :</label>
                <input type="text" id="memberADDR" name="memberADDR" required="required">
            </div>
            
            <div class="form-group">
                <label for="memberPhone">전화번호 :</label>
                <input type="text" id="memberPhone" name="memberPhone" required="required">
            </div>

            <label>성별:</label>
            <div class="gender-container">
                <input type="radio" id="male" name="memberGen" value="남">
                <label for="male" class="radio-label">남</label>
                <input type="radio" id="female" name="memberGen" value="여">
                <label for="female" class="radio-label">여</label>
            </div>
            <br>
        <input type="submit" value="등록" >
        <a href="mainDefault.html">취소</a>
        </form>
    </div>
    <img src="img/귀염둥이.jpeg" width=360px>
    </div>
    
    <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>

	<script type="text/javascript">
	const rForm = document.getElementById("rForm");
    const memberID = document.getElementById("memberID");
    const memberPW = document.getElementById("memberPW");
    const memberPW2 = document.getElementById("memberPW2");
    const memberName = document.getElementById("memberName");
    const memberADDR = document.getElementById("memberADDR");
    const memberPhone = document.getElementById("memberPhone");
    const maleRadio = document.getElementById("male");
    const femaleRadio = document.getElementById("female");

    let validMemberID = "";
    let selectedGen = "";
	
    rForm.addEventListener("submit", e => {
        // 서버에 form data를 전송하지 않는다
        e.preventDefault();

	    // 아이디 사용 여부 확인
        if (validMemberID == "" || memberID.value !== validMemberID) {
            alert("아이디 중복확인 해주세요");
            return false;
        }
       

        if (maleRadio.checked) {
            selectedGen = "남";
        } else if (femaleRadio.checked) {
        	selectedGen = "여";
        } else {
            alert("성별을 선택해주세요.");
            return false;
        }

        if (memberPW.value !== memberPW2.value) {
            alert("비밀번호가 일치하지 않습니다.");
            memberPW2.value = "";
            memberPW2.focus();
            return false;
        }
        
        const param = {
	            action: 'memberInsert',
	            memberID: memberID.value,
	            memberPW: memberPW.value,
	            memberName: memberName.value,
	            memberADDR: memberADDR.value,
	            memberPhone: memberPhone.value,
	            memberGen: selectedGen
	        }
	    
	    fetch("member", {
            method: "POST",
            body: JSON.stringify(param),
            headers: { "Content-type": "application/json; charset=utf-8" }
        }).then(res => res.json()).then(json => {
            // 서버로부터 받은 결과를 사용해서 처리 루틴 구현
            console.log("json ", json);
            if (json.status == 0) {
                // 성공
                alert("회원 가입이 완료되었습니다.");
                location = "member?action=memberView&memberID=" + memberID.value;
            } else {
                alert(json.statusMessage);
            }
        });
    });
    
 	// 아이디 중복 여부 확인
    const duplicatedID = document.getElementById("duplicatedID");
    duplicatedID.addEventListener("click", () => {
        if (memberID.value === "") {
            alert("아이디를 입력해주세요");
            memberID.focus();
            return;
        }
        const param = {
            action: "existedMemberID",
            memberID: memberID.value
        }
        fetch("member", {
            method: "POST",
            body: JSON.stringify(param),
            headers: { "Content-type": "application/json; charset=utf-8" }
        }).then(res => res.json()).then(json => {
            // 서버로부터 받은 결과를 사용해서 처리 루틴 구현
            if (json.existMember == true) {
                alert("해당 아이디는 사용 중 입니다.");
                validMemberID = "";
            } else {
                alert("사용가능한 아이디 입니다.");
                validMemberID = memberID.value;
            }
        });
    });
</script>



</body>
</html>
