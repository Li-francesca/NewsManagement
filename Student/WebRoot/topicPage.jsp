<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<table>
				<tr >             
					<td>新闻栏目</td>
					<!-- <td>栏目编辑</td>
					<td>栏目删除</td> -->
				</tr>
				
		<c:forEach var="topic" items="${topics}">
			<tr>
				 
			    <td>${topic.tid}</td> 
				 <td><a href="CTopicServlet?tid=${topic.getTid()}">${topic.tname}</a></td>
				 <%-- <td><a href ="${pageContext.request.contextPath}/servlet/ContentServlet?status=doPost &nid=${topic.tid} ">编辑</a></td> 
                 <td><a href ="${pageContext.request.contextPath}/servlet/deleteTopic?status=doPost &nid=${topic.tid} ">删除</a></td>--%>
                
       	 	</tr>
				
	  </c:forEach>
	   <%-- <tr>

                <th>新闻标题</th>
                <th>新闻作者</th>
                <th>创建时间</th>
                <th>新闻摘要</th>
                
            </tr>
	  <c:forEach var="news"  items="${list}">
                <tr>
                	
	                <td><a href="TextServlet?nid=${news.getNid()}">${news.ntitle}</a></td>
	                <td>${news.nauthor}</td>
                   <td>${news.ncreatedate}</td>
                   <td>${news.nsummary}</td>

            	</tr>
            </c:forEach>  --%>    
	</table>
	<a href="javascript:history.go(-1)">返回</a>
</body>
</html>