<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h1>标题：</h1><p>${ntitle}</p>
			<h1>作者：</h1><p>${nauthor}</p>
			<h1>创建时间：</h1>${ncreatedate}
			<%-- <h1>概要：</h1>${nsummary}
			<h1>图片：</h1>${npicPath} --%>
			<h1>内容：</h1>${ncontent}
		<div class="newsnav">
			<a href="javascript:history.go(-1)">返回</a>
		</div>
		 
	
</body>
</html>