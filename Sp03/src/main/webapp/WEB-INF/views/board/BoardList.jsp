<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, java.sql.*, com.md.domain.Board, com.md.vo.ListResult"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>My Board</title>

		<style>
		table, th, td {
						border: 1px solid black;
						border-collapse: collapse;
		}
		th, td {
			padding: 5px;
		}
		a {text-decoration:none; font-family:Comic Sans MS}
		</style>

</head>
<body>
		<center>
		<font color='black' size='4' face='Comic Sans MS'>
		<hr width='600' size='2' color='gray' noshade>
			<h3> MY Board with Spring</h3>
		<font color='gray' size='4' face='Comic Sans MS'>
			<a href='../'><button class="btn btn-default">인덱스</button></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='write.do'><button class="btn btn-default">글쓰기</button></a><br/>
		</font>
		<hr width='600' size='2' color='gray' noshade>
	
			<TABLE border='2' width='600' align='center' noshade>
			<TR size='2' align='center' noshade bgcolor='AliceBlue'>
				<th bgcolor='AliceBlue'>no</th>
				<th color='gray'>writer</th>
				<th color='gray'>e-mail</th>
				<th color='gray'>subject</th>
				<th color='gray'>date</th>
			</TR>
		
	<c:forEach items="${listResult.list}" var="board">
		<TR align='center' noshade>
			<TD>${board.seq}</TD>
			<TD>${board.writer}</TD>
			<TD>${board.email}</TD>
		    <TD>
		      <a href="content.do?seq=${board.seq}">
			    ${board.subject}
			  </a>
			</TD>
			<TD>${board.rdate}</TD>
		   </TR> 
	</c:forEach>      
	<c:if test="${empty listResult}">
		<tr align="center" noshade>
		   <td colspan="5">데이터가 하나도 없음</td>
		</tr>
	</c:if>

		</table>
		
		<hr width='600' size='2' color='gray' noshade>
			<font color='gray' size='3' face='Comic Sans MS'>
				(Total Page : ${listResult.totalPageCount})	&nbsp;&nbsp;&nbsp;
				
		    <c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
		        <a href="list.do?cp=${i}&ps=${listResult.pageSize}">
		   			<c:choose>
		   			    <c:when test="${i==listResult.currentPage}">
		                	<strong>${i}</strong>
		                </c:when>
		                <c:otherwise>
		                    ${i}
		                </c:otherwise>
					</c:choose>
		    	</a>&nbsp;
    	</c:forEach>
		
    			 ( TOTAL : ${listResult.totalCount} )
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			Page Size :
    			<select id="psId" name="ps" onchange="f(this)">
					<option id="3" value="3" >3</option>
					<option id="5" value="5">5</option>
					<option id="10" value="10">10</option>
				</select>
			<br/><br/>	
			
		<form action="list.do" method="post">	
			<div>
			<span>글쓴이</span>
				<input type="text" name="writer" placeholder="ex) 홍길동">
				<input type="submit" value="검색" >
			</div>
		</form>	
		<br/>
		<form action="list.do" method="post">	
			<div>
			<span>제목</span>
				<input type="text" name="subject" placeholder="ex) 안녕하세요">
				<input type="submit" value="검색" >
			</div>
		</form>
			 
				<script language="javascript">
       				window.onload = function(){
       				
       					
       				<%--var ps = getCookie("ps");
       					
       					if(ps == <%=ps%>){
       						var psId = document.getElementById("psId");
       						for(var i=0; i<psId.length; i++){
    					        if(psId[i].value==ps){
    					        	console.log("sel[i].value is "+psId[i].value);
    					            psId[i].selected = true;
    					        }
    					    }
       					} --%>
       					
						var sel = document.getElementById("psId");
						for(var i=0; i<sel.length; i++){
					        if(sel[i].value==${listResult.pageSize}){
					        	console.log("sel[i].value is "+sel[i].value);
					            sel[i].selected = true;
					        }
					    }
       						
       							
       				}
       				
       				var getCookie = function(name) {
       					var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
       					return value? value[2] : null;
       				};


					function f(select){
           				var ps = select.value;
						console.log("ps :"+ps); <%-- 기능 : 웹페이지 콘솔창에 찍힘 (크롬 개발자 도구 : f12 )--%>

						location.href="list.do?cp=1&ps="+ps;
       				}
    			</script>
    			
		
	</center>