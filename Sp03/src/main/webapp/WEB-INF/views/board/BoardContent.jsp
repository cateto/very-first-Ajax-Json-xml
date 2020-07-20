<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, java.sql.*, com.md.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px; font-family:Comic Sans MS
	}
	a { text-decoration:none }
</style>
<meta charset="utf-8">
<title>My Board with Spring</title>
</head>
<body>
	<center>
	<font color=black size='4' face='Comic Sans MS'>
	<hr width='600' size='2' color='gray' noshade>
	<h3>MY Board with Spring</h3>
	<font color='gray' size='4' face='Comic Sans MS'>
	<a href='write.do'>글쓰기</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
	</font>

		<table border='2' width='600' align='center' noshade>
		<tr>
			<td width='20%' align='center' bgcolor='AliceBlue'>No</td>
			<td>${board.seq}</td>
		</tr>
		<tr>
			<td width='20%' align='center' bgcolor='AliceBlue'>Writer</td>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<td align='center' bgcolor='AliceBlue'>E-mail</td>
			<td>${board.email}</td>
		</tr>
		<tr>
			<td align='center' bgcolor='AliceBlue'>Subject</td>
			<td>${board.subject}</td>
		</tr>
		<tr>
			<td align='center' bgcolor='AliceBlue'>Contents</td>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td align='center' bgcolor='AliceBlue'>Date</td>
			<td>${board.rdate}</td>
		</tr>
		<tr>
			<td align='center' colspan="2" bgcolor='AliceBlue'>FILE</td>
		</tr>
		<c:if test="${empty fList}">
		<tr>
		   	<td align="center" colspan="2">파일이 하나도 없음</td>
		</tr>
	   	</c:if>
	   	
        <c:forEach items="${fList}" var="file">
		<tr>
          <td align="center">
            <a href="file_download?fname=${file.fname}">${file.fname}</a>
          </td>
          <td align="center">
           <a href="file_del?fname=${file.fname}&f_num=${file.f_num}&seq=${board.seq}">삭제</a>
          </td>
		</tr>
        </c:forEach>

		</table>

		<hr width='600' size='2' color='gray' noshade>
		<font color='gray' size='4' face='Comic Sans MS'>
		<a href='update.do?seq=${board.seq}'>수정</a>
		&nbsp;&nbsp;|
		<a href='del.do?seq=${board.seq}'>삭제</a>
		&nbsp;&nbsp;|
		<a href='list.do?cp=1&ps=3'>목록</a>
		</font>
		<hr width='600' size='2' color='gray' noshade>
		</center>
</body>	
</html>
