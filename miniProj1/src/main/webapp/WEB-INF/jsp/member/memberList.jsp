<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link href="css/menu.css" rel="stylesheet">
	<link href="css/font.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>회원 목록</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse 2px;
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
            <li><a href="member?action=memberList">회원목록</a></li>
            <li><a href="member?action=logout">로그아웃</a></li>
            <li><a href="board?action=boardList">게시판</a></li>
        </ul>
    </nav>
    	
    <h1>회원 목록</h1>
    <form id="searchForm" action="member" method="get" style="margin-left: 200px;">
    	<label style="font-size: 16pt;">아이디</label>
    	<input type="text" id="searchKey" name="searchKey" value="${param.searchKey}">
    	<input type="hidden" name="action" value="memberList">
    	<input type="submit" value="검색">
    </form>
    
    <form id="listForm" action="member" method="post">
    	<input type="hidden" id="action" name="action" value="memberView">
    	<input type="hidden" id="memberID" name="memberID" >
    </form>
   
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
            <th>전화번호</th>
            <th>성별</th>
        </tr>
        <c:forEach var="member" items="${list}">
        <tr>
            <td onclick="jsView('${member.memberID}')"style="cursor:pointer;">
            <a href="member?action=memberView&memberID=${member.memberID}">${member.memberID}</a>
            </td>
            <td>${member.memberName}</td>
            <td>${member.memberADDR}</td>
            <td>${member.memberPhone}</td>
            <td>${member.memberGen}</td>
        </tr>
        </c:forEach>
    </table>
    
    <script>
	function jsView(mid) {
		memberID.value = mid;
		memberView.submit();
	}
	</script>    
    
</body>
</html>
