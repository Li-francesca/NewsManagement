<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="opt_area">
		<h1 id="opt_type">添加新闻分类：</h1>
		<p><span id="addTopic" > <%=session.getAttribute("msg")==null?"":session.getAttribute("msg") %><% session.removeAttribute("msg"); %></span></p> 
		<form action="../servlet/addTopic" name="addTopic" method="post">
			<!-- items="${SHOW_NID_NEWS}" -->
			<c:forEach var="topic" >
				
				
				<p>
					<label> 主题 </label> <input name="tname" type="text"
						value='${topic.getTname()}' class="opt_input" />
				</p> 
				

				<!-- <input name="action" type="hidden" value="addnews" /> -->
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach>
		</form>
	</div>
	<a href="javascript:history.go(-1)">返回</a>
</body>
</html>