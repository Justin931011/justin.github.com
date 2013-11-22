<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  
  	<script type="text/javascript">
  		function clickSubmit(){
  			var userName = document.getElementById("userName").value;
  			var passWord = document.getElementById("passWord").value;
  			if(userName.length<=0){
  				alert("Username can not be empty!");
  				return false;
  			}
  			if(passWord.length<=0){
  				
  				alert("Password can not be empty!");
  				return false;
  			}
  			return true;
  		}
  	</script>
  </head>
  <body>
  <form action="Login.do" method="post">
  	<table>
  		<tr>
  			<td colspan="2" style="text-align: center"><h2>Sign in</h2></td>
  			<td ><img src="image/successImg.jpg"/></td>
  		</tr>
  		<tr>
  			<td>USERNAME</td>
  			<td><input type = "text" name = "userName" id = "userName"/></td>
  		</tr>
  		
  		<tr>
  			<td>PASSWORD</td>
  			<td><input type = "password" name = "passWord" id = "passWord"/></td>
  		</tr>
  
  		<tr>
  			<td><input type="submit" value="Sign in" onclick="return clickSubmit();"/></td>
  			<td><input type="button" value="Registration" onclick="window.location.href='../SelectCountry.action'"/></td>
  		</tr>
  	</table>
  	
  	
  	
  </form>
  </body>
  </html>