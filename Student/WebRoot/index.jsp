<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
	   a{text-decoration: none;}
	   a:VISITED{color:blue}
       a:hover{text-decoration: underline;color:orange;}
	</style>
  </head>
  
  <body style="text-align:center">
    <h1>欢迎使用新闻管理系统</h1>
    <h2><a href="login.jsp" >管理员点击进入</a></h2>
    <%-- <a href="servlet/topicServlet?nid=${news.getNid()}">${news.ntitle}</a> --%>
    <h1><a href="servlet/topicServlet?opr=readnews" >用户点击进入</a></h1>
  </body>
</html>
