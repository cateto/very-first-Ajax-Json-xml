<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, java.sql.*, com.md.domain.Board"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Board with MVC</title>

</head>
<body>
		<script language='javascript'>

			if(${flag}){
				alert('입력 성공 (with Spring)');
			}else{
				alert('입력 실패 (with Spring)');
			}
		
			location.href='list.do?cp=1&ps=3';
		</script>
</body>
</html>