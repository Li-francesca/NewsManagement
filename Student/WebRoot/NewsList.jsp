<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<!-- <a href="modifyUserPass.jsp">修改密码</a><br> -->
		<a href="pages/logout.jsp">退出</a></div><br>
		<a href ="pages/addNews.jsp">增加新闻</a><br>
		<a href ="pages/addTopic.jsp">增加新闻分类</a>
        <table>
            <tr>

                <!-- <th>新闻id</th>-->
                <th>新闻分类</th> 
                <th>新闻标题</th>
                <th>新闻作者</th>
                <th>创建时间</th>
                
                <th>编辑新闻</th>
                <th>删除新闻</th>
            </tr>
            <c:forEach var="news"  items="${page.list}">
                <tr>
                	<%-- <td>${news.nid}</td>--%>
	                <td>${news.ntname}</td> 
	                <td><a href="servlet/ContentQServlet?nid=${news.getNid()}">${news.ntitle}</a></td>
	                <td>${news.nauthor}</td>
                   <td>${news.ncreatedate}</td>
                  
                   <td><a href ="${pageContext.request.contextPath}/servlet/ContentServlet?status=doPost &nid=${news.nid} ">编辑</a></td>
                   <td><a href ="${pageContext.request.contextPath}/servlet/deleteNews?status=doPost &nid=${news.nid} ">删除</a></td>
            	</tr>
            </c:forEach>        
        </table>
        <br>
   
    共 ${page.count}    条记录，
    每页<input type="text" id="pagesize" value="${page.pageSize }" onchange="gotopage(1)" style="width: 30px" maxlength="3">条，
    共<fmt:formatNumber type="number" value="${(page.count-page.count%page.pageSize)/page.pageSize+1}"/>页，
    当前第${page.pageNo}页  &nbsp;&nbsp;
   <a href="javascript:void(0)" onclick="gotopage(${page.pageNo-1})" >上一页</a> &nbsp;
           
   <a href="javascript:void(0)" onclick="gotopage(${page.pageNo+1})" >下一页</a> &nbsp;
   
   跳转<input type="text" id="forwardPage" value="${page.pageNo}" style="width: 30px;" onchange="gotopage(this.value)">页
    
  </body>
  
  <script type="text/javascript">
      function gotopage(wantedPage) {
          var pagesize = document.getElementById("pagesize").value;
          window.location.href = "${pageContext.request.contextPath}/list?pageNo="+wantedPage+"&pageSize="+pagesize;
          
      }

  </script>