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
    <title>게시글 자세히보기</title>
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
    
    <div id="container">
        <img src="img/스불행.jpeg" width="360px">
        <div id="member-view">
            <h1>게시글 자세히보기</h1>
            <label>게시글 번호 : ${board.bno}</label> <br>
            <label>제목 : ${board.btitle}</label> <br>
            <label>내용 : ${board.bcontent}</label><br>
            <label>작성자: ${board.bwriter}</label><br>
            <label>작성일: ${board.bdate}</label><br>
            
            <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
            <script>
            function jsDelete() {
                if (confirm("정말로 삭제하시겠습니까?")) {
                    document.getElementById("action").value = "boardDelete";
                    document.getElementById("viewForm").submit();
                }
            }
            
            function jsUpdateForm() {
            	if (confirm("정말로 수정하시겠습니까?")) {
            		action.value = "boardUpdateForm";
            	
            		viewForm.submit();
            	}	
            }
            
            function jsList(){
                document.getElementById("action").value= "boardList";
                document.getElementById("viewForm").submit();
            }
            </script>
            
            <form id="viewForm" method="post" action="board">
                <input type="hidden" id="action" name="action" value="">
                <input type="hidden" name="bno" value="${board.bno}">
                <input type="button" value="삭제" onclick="jsDelete()">
                <input type="button" value="수정" onclick="jsUpdateForm()">
                <input type="button" value="목록" onclick="jsList()">
            </form>  
        </div>

        <img src="img/사랑평화행복.jpeg" width="360px">
        
    </div>
</body>
</html>
