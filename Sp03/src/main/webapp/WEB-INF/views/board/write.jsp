<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <title>MY Board</title>
    <style>
		table, th, td {
		   border: 1px solid black;
		   border-collapse: collapse;
		   font-family:Comic Sans MS
		}
		th, td {
		   padding: 5px;
		   font-family:Comic Sans MS
		}
		a { text-decoration:none;
		font-family:Comic Sans MS}

		input { text-decoration:none;
		font-family:Comic Sans MS}
	</style>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
  </head>
  <body onload="input.writer.focus()">
	<font color="black" size='4' face="Comic Sans MS">
    <center>
	   <hr width="750" size='2' color="gray" noshade>
	      <h3> MY Board </h3>
		  	<font color="gray" size="3" face="Comic Sans MS">
			<a href='list.do?cp=1&ps=3'><button class="btn btn-default">리스트</button></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='../'><button class="btn btn-default">인덱스</button></a>
			</font>
	   <hr width="750" size="2" color="gray" noshade>
	</center>

	<form name="input" method="post" action="write.do" enctype="multipart/form-data">
	   <table border="0" width="630" align="center"  cellpadding="3" cellspacing="1" bordercolor="gray">
	      <tr>
		     <td width="30%" align="center">WRITER</td>
			 <td><input type="text" name="writer" size="80"></td>
		  </tr>
		  <tr>
		     <td align="center">EMAIL</td>
			 <td><input type="text" name="email" size="80"></td>
		  </tr>
          <tr>
		     <td align="center">SUBJECT</td>
			 <td><input type="text" name="subject" size="80"></td>
		  </tr>
		  <tr>
		     <td align="center">CONTENT</td>
			 <td><textarea name="content" rows="15" cols="60"></textarea></td>
		  </tr>
		  <tr>
		     <td align="center">FILE</td>
			 <td><input type='file' name='files' multiple></td>
		  </tr>

		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="전송" onclick="check()">
				<input type="reset" value="다시입력" onclick="input.writer.focus()">
			 </td>
		  </tr>
	   </table>
	   <hr width="750" size="2" color="gray" noshade>
	</form>
	</font>
  </body>
</html>