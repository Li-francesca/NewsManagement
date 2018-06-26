<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改密码</title>
</head>
<body>
<h3>修改密码</h3>
<a href ="${pageContext.request.contextPath}/servlet/ContentServlet?status=doPost &nid=${news.nid} ">
	<a href="login.jsp">登录</a> 
    <a href="regist.jsp">注册</a> 
	<p><span id="registHit" > <%=session.getAttribute("msg")==null?"":session.getAttribute("msg") %><% session.removeAttribute("msg"); %></span></p> 

	<form action="${pageContext.request.contextPath }/servlet/doRegist?opr=modifyUser" onSubmit="return isValid(this);" method="post">

   	 <table class="loginTable">

        <tr>
       		<td id="name">用户名：</td>
       		<td id="nmtd"><input type="text" name="username" id="username"></td>
      	</tr> 
      
       	<tr>
       		<td id="pwd">新密码：</td>
       		<td id="pwdtd"><input type="password" name="password" id="password"></td>
      	</tr>
      	<tr>
      		<td>确认密码:</td>
      		<td><input type="password"name="password2" ></td>
      	<tr>
      	<tr>
       		<td colspan="2"><input type="submit" value="提交"></td>
      	</tr>
      	
    </table>

</body>
</html>