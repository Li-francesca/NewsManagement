<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="opt_area">
		<h1 id="opt_type">编辑新闻：</h1>

		<form action="../servlet/updateNews" name="updateNews" method="post">
			
			<c:forEach var="news">
				 <p>
					<label> id </label> <input name="nid" type="text"
						value='${nid}' class="opt_input" />
				</p> 
				<p>
					<label> 标题 </label> <input name="ntitle" type="text"
						value='${ntitle}' class="opt_input" />
				</p>
				<%-- <p>
					<label> 主题 </label> <input name="ntname" type="text"
						value='${ntname}' class="opt_input" />
				</p> --%>
				<label> 主题 </label>
					<select name="ntname" value="${ntname}">
		                <option value="${ntid}">${ntname}</option>
		                <option value="${ntid}">${ntname}</option>
		                <option value="${ntid}" selected>${ntname}</option>
	                </select>	
				
				<p>
					<label> 来源 </label> <input name="nauthor" type="text"
						value='${nauthor}' class=" opt_input" />
				</p>
				<p>
					<label> 时间</label> <input name="ncreatedate" type="text"
						value='${ncreatedate}' class=" opt_input" />
				</p>
				<p>
					<label> 更改时间</label> <input name="nmodifydate" type="date"
						value='${nmodifydate}' class=" opt_input" />
				</p>
				<textarea id="container" name="ncontent" style="width: 800px; height: 400px;">${ncontent}</textarea>

				<!-- 加载编辑器的容器 -->
   				 <script id="container" name="ncontent" type="text/plain">
       				 这里写你的初始化内容
   				 </script>
			    <!-- 配置文件 -->
			    <script type="text/javascript" src="/Student/utf8-jsp/ueditor.config.js"></script>
			    <!-- 编辑器源码文件 -->
			    <script type="text/javascript" src="/Student/utf8-jsp/ueditor.all.js"></script>
			    <!-- 实例化编辑器 -->
			    <script type="text/javascript">
			        var ue = UE.getEditor('container');
			    </script>
				

				<%-- <input name="action" type="hidden" value="addnews" />
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach> --%>
 
		
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach>
		</form>
	</div>
</body>
</html>