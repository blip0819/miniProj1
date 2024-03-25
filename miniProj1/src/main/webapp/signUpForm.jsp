<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입 화면</title>
    <style>
        /* 기존 CSS 스타일 */
        /* 네비게이션 바 스타일 */
       nav {
	    font-size: 12pt;
	    font-family: 'PT Sans', Arial, Sans-serif;
	    position: relative;
	    background-color: #333; /* 배경색 설정 */
	    color: white; /* 텍스트 색상 설정 */
		}
		
		nav ul {
		    padding: 0;
		    margin: 0 auto;
		    width: auto;
		    text-align: center; /* 가운데 정렬 */
		}
		
		nav li {
		    display: inline-block;
		}
		
		nav a {
		    line-height: 50px;
		    height: 50px;
		    padding: 0 20px; /* 각 링크의 좌우 여백 추가 */
		    text-decoration: none;
		    color: white; /* 링크 텍스트 색상 설정 */
		}
		
		nav a:hover,
		nav a:active {
		    color: #FFD400; /* 호버 시 텍스트 색상 변경 */
		    font-weight: normal;
		}
		
		.menu {
		    width: 100%; /* 가로 폭 100%로 설정 */
		    height: 50px;
		    text-align: center;
		    background-color: #333333;
		    color: white;
		    position: relative; /* 기존에는 fixed로 설정했던 것을 relative로 변경 */
		    z-index: 1;
		}
		
		#rForm {
		    margin: 20px auto; /* 가운데 정렬 */
		    width: 400px; /* 폼 너비 설정 */
		    text-align: left; /* 텍스트 왼쪽 정렬 */
		}
		
		.form-group {
		    margin-bottom: 15px; /* 각 항목 사이의 간격 설정 */
		    display: flex; /* 입력 필드와 라벨을 한 줄에 정렬 */
		    align-items: center; /* 수직 가운데 정렬 */
		}
		
		.form-group label {
		    flex-basis: 120px; /* 라벨의 고정 너비 설정 */
		    margin-right: 10px; /* 라벨과 입력 필드 사이의 간격 설정 */
		}
		
		.form-group input[type="text"],
		.form-group input[type="password"],
		.form-group input[type="number"] {
		    flex: 1; /* 입력 필드가 남은 공간을 모두 차지하도록 설정 */
		}
		
		.form-group button {
		    margin-left: 10px; /* 중복 확인 버튼과 입력 필드 사이의 간격 설정 */
		}
		
		label, input[type="checkbox"] {
		    display: inline-block; /* 레이블과 체크박스를 인라인으로 표시 */
		    vertical-align: middle; /* 수직 중앙 정렬 */
		}
		
		input[type="submit"], a {
		    display: inline-block; /* 버튼을 인라인으로 표시 */
		    vertical-align: middle; /* 수직 중앙 정렬 */
		    margin-left: 10px; /* 왼쪽 여백 추가 */
		}
		#memberPW,
		#memberPW2,
		#membername,
		#memberADDR,
		#memberphone {
		    width: calc(100% - 120px); /* 아이디 입력란의 너비에 맞게 계산 */
		}

        
    </style>
</head>
<body>
    <h1>회원가입 양식</h1>
    <div class="menu">
        <nav>
            <ul>
                <li><a href="corpInfo.html">회사 소개</a></li>
                <li><a href="SignUpForm.jsp">회원가입</a></li>
                <li><a href="loginForm.jsp">로그인</a></li>
                <li><a href="boardlist.jsp">게시판</a></li>
            </ul>
        </nav>
    </div>
    <div style="text-align:center;">

          <form id="rForm" action="member.do" method="post">
   		 <input type="hidden" name="action" value="insert">
    
    <div class="form-group">
        <label for="memberid">아이디 :</label>
        <div class="input-group">
            <input type="text" id="memberid" name="memberid" required="required">
            <button type="button" id="duplicateId">중복확인</button>
        </div>
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
                <input type="checkbox" id="hobby1" name="hobby1" value="Exercising">
                <label for="hobby1">운동</label>
            </div>
            <div>
                <input type="checkbox" id="hobby2" name="hobby2" value="Cooking">
                <label for="hobby2">요리</label>
            </div>
		<div>
		    <input type="checkbox" id="hobby3" name="hobby3" value="Movies">
		    <label for="hobby3">영화 감상</label>
		</div>
		<div>
		    <input type="checkbox" id="hobby4" name="hobby4" value="Fishing">
		    <label for="hobby4">낚시</label>
		</div>
        <input type="submit" value="등록" >
        <a href="user.do?action=list">취소</a>
    </div>
    
    </form>
    
<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
    
    <script type="text/javascript">
    
    const rForm = document.getElementById("rForm");
    const userid = document.getElementById("userid");
    const userpassword = document.getElementById("userpassword");
    const userpassword2 = document.getElementById("userpassword2");
    const username = document.getElementById("username");
    const userage = document.getElementById("userage");
    const useremail = document.getElementById("useremail");
    //아이디 사용 여부 확인 
    let validUserId = "";
    
    rForm.addEventListener("submit", e => {
    	//서버에 form data를 전송하지 않는다 
    	e.preventDefault();
    	
    	if (validUserId == "" || userid.value != validUserId) {
    		alert("아이디 중복확인 해주세요");
    		return false;
    	}
    	
    	if (userpassword.value != userpassword2.value) {
        	
    		alert("비밀번호가 잘못되었습니다.")
    		userpassword2.value = "";
    		userpassword2.focus();
    		return false;
    	}
    	
		myFetch("user.do", "rForm", json => {
			if(json.status == 0) {
				//성공
				alert("회원가입을 성공 하였습니다");
				location = "user.do?action=list";
			} else {
				alert(json.statusMessage);
			}
		});
    });
    
    //id의 객체를 얻는다
	const duplicateId = document.getElementById("duplicateId");
    //click 이벤트 핸들러 등록
	duplicateId.addEventListener("click", () => {
		const userid = document.getElementById("userid");
		if (userid.value == "") {
			alert("아이디를 입력해주세요");
			userid.focus();
			return;
		}
		const param = {
			action : "existUserId",
			userid : userid.value
		}
		fetch("user.do", {
			method:"POST",
			body:JSON.stringify(param),
			headers : {"Content-type" : "application/json; charset=utf-8"}
		}).then(res => res.json()).then(json => {
			//서버로 부터 받은 결과를 사용해서 처리 루틴 구현  
			console.log("json ", json );
			if (json.existUser == true) {
				alert("해당 아이디는 사용 중 입니다.");
				validUserId = "";
			} else {
				alert("사용가능한 아이디 입니다.");
				validUserId = userid.value;
			}
		});
	});
    </script>
    
</body>
</html>