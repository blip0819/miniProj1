<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link href="css/menu.css" rel="stylesheet">
	<link href="css/font.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>게시물 목록</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #fffec4;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container button {
            padding: 10px 20px;
            font-size: 16px; 
            background-color: #f5f5f5;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
	<nav>
        <ul>
            <li><a href="corpInfo.html">회사 소개</a></li>
            <li><a href="member?action=memberList">회원가입</a></li>
            <li><a href="member?action=logout">로그인</a></li>
            <li><a href="board?action=boardList">게시판</a></li>
        </ul>
    </nav>
    	
    <h1>게시판</h1>
    <form id="searchForm" action="board" method="get" style="margin-left: 200px;">
    	<label style="font-size: 16pt;">제목</label>
    	<input type="text" id="searchKey" name="searchKey" value="${param.searchKey}">
    	<input type="hidden" name="action" value="boardList">
    	<input type="submit" value="검색">
    </form>
    
    <form id="listForm" action="board" method="post">
    	<input type="hidden" id="action" name="action" value="boardView">
    	<input type="hidden" id="bno" name="bno" >
    </form>
   
    <table border="1">
        <tr>
            <th>게시물번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="board" items="${list}">
        <tr>
            <td onclick="jsView('${board.bno}')"style="cursor:pointer;">
            <a href="board?action=boardView&bno=${board.bno}">${board.bno}</a>
            </td>
            <td>${board.btitle}</td>
            <td>${board.bwriter}</td>
            <td>${board.bdate}</td>
        </tr>
        </c:forEach>
    </table>
    
    <form id="login-menu" action="board" method="get" style="margin-left: 180px;">
    	<input type="hidden" name="action" value="boardInsertForm">
    	<input type="submit" value="게시글 작성">
    	
    	<input type="button" value="전체 삭제" onclick="jsClear()">
    </form>
    
    <script>
	function jsView(bno) {
		bno.value = bno;
		boardInsertForm.submit();
	}
	
	function jsClear() {
	    if (confirm("정말로 삭제하시겠습니까?")) {
	        action.value = "boardClear";
	        
	        listForm.submit();
	        alert("게시물이 전체 삭제되었습니다.");
	    }
	}
	</script>  
</body>
</html>
