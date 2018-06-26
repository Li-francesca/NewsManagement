<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" />
<script language="javascript">
        function isValid(form)
        {
            if (form.username.value=="")
            {
                alert("用户名不能为空");
                return false;
            }
            if (form.pwd.value!=form.pwd2.value)
            {
                alert("两次输入的密码不同！");
                return false;
            }
            else  if (form.pwd.value=="")
            {
                alert("用户密码不能为空！");
                return false;
            }
            else return true;
        }
    </script>
   <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
</head>
<body>
	<h3>管理员注册</h3>
	<a href="login.jsp">登录</a> 
    <a href="regist.jsp">注册</a> 
	<p><span id="registHit" > <%=session.getAttribute("msg")==null?"":session.getAttribute("msg") %><% session.removeAttribute("msg"); %></span></p> 

	<form action="${pageContext.request.contextPath }/servlet/doRegist?opr=addUser" onSubmit="return isValid(this);" method="post">

   	 <table class="loginTable">

      	<tr>
       		<td id="name">用户名：</td>
       		<td id="nmtd"><input type="text" name="username" id="username"></td>
      	</tr>
      
       	<tr>
       		<td id="pwd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
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


</form>
</body>
</html>