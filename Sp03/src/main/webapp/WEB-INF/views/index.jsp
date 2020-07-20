<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Model with Spring5 Index</title> <!--  쓰는 이유 : 웹 상에서 페이지 노출 -->
	</head>
<body style = "text-align:center">
	<h1>
		Model with Spring5
	</h1>
	
	
	<a href="paging/list.do">페이징</a>[페이징모듈사용]<br/><br/>
	<a href="board/list.do">게시판</a>[파일업로드/페이징]<br/><br/>
	<br/><br/><br/>
	
	<h1>
		Spring REST & AJAX
	</h1>
	<h3>
		Rest Test
	</h3>
	<a href="rest/getText">getText</a><br/>
	<a href="rest/getAddress.json">getAddress(json)</a><br/>
	<a href="rest/getAddress.xml">getAddress(xml)</a><br/>
	<a href="rest/getList.xml">getList(xml)</a><br/>
	<a href="rest/getList.json">getList(json)</a><br/>
	<MARQUEE>default는 xml입니다.</MARQUEE>
	<a href="rest/getMap.xml">getMap(xml)</a><br/>
	<a href="rest/getMap.json">getMap(json)</a><br/>
	<MARQUEE>객체가 map은 key값이 같이 넘어와서 key값으로 구분되고, list는 item으로 구분됩니다.</MARQUEE>
    
    <a href="rest/check?height=175.2&weight=75.3">check(xml)</a></br>
    <a href="rest/check.json?height=175.2&weight=75.3">check(json)</a></br>
    
    <a href="rest/product/bag/001">product/bag/001</a>(xml)</br>
    <a href="rest/product/bag/002.json">product/bag/002</a>(json)</br>
    
    	<br/><br/><br/>
	
	<h3>
		AJAX
	</h3>
	   <a href="ajax/test01.do">Ajax01</a><br/>
	   <a href="ajax/test02.do">Ajax02</a><br/>
	   <a href="ajax/test03.do">Ajax03</a><br/>
	   <a href="ajax/test04.do">Ajax04</a><br/>
    
</body>
</html>