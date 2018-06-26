<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/Student/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="/Student/utf8-jsp/ueditor.all.js"></script>
</head>
<body>
<h1>添加新闻：</h1>
<form action="../servlet/addNews" name="addNews" method="post">
			<!-- items="${SHOW_NID_NEWS}" -->
			<c:forEach var="news" >
			
				
					<label> 标题 </label> <input name="ntitle" type="text"
						value='${news.getNtitle()}' class="opt_input" />
				
				
					<label> 主题 </label> <input name="ntname" type="text"
						value='${news.getNtname()}' class="opt_input" />
				<label> 主题 id</label> <input name="ntid" type="text"
						value='${news.getNtid()}' class="opt_input" />
				
			
					<label> 来源 </label> <input name="nauthor" type="text"
						value='${news.getNauthor()}' class=" opt_input" />
				
				
					<label> 时间</label> <input name="ncreatedate" type="date"
						value='${news.getNcreatedate()}' class=" opt_input" />
				
				 <textarea id="container" name="ncontent" style="width: 800px; height: 400px;">${news.getNcontent()}</textarea>

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
				<%-- <p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3">${news.getNsummary()}</textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10">${news.getNcontent()}</textarea>
				</p> --%>
				<!-- <p>
					<label> 上传图片 </label> <input name="file" type="file" value=''
						class="opt_input" />
				</p> -->

				<input name="action" type="hidden" value="addnews" />
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach>
		</form>
 	
<%-- 
<div id="opt_area">
		<h1 id="opt_type">添加新闻：</h1>

		<form action="../servlet/addNews" name="addNews" method="post">
			<!-- items="${SHOW_NID_NEWS}" -->
			<c:forEach var="news" >
			
				<p>
					<label> 标题 </label> <input name="ntitle" type="text"
						value='${news.getNtitle()}' class="opt_input" />
				</p>
				<p>
					<label> 主题 </label> <input name="ntid" type="text"
						value='${news.getNtid()}' class="opt_input" />
				</p> 
				
				<p>
					<label> 作者 </label> <input name="nauthor" type="text"
						value='${news.getNauthor()}' class=" opt_input" />
				</p>
				<p>
					<label> 时间</label> <input name="ncreatedate" type="text"
						value='${news.getNcreatedate()}' class=" opt_input" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3">${news.getNsummary()}</textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10">${news.getNcontent()}</textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="file" type="file" value=''
						class="opt_input" />
				</p>

				<input name="action" type="hidden" value="addnews" />
				<input type="submit" value="提交" class="opt_sub" />
				<input type="reset" value="重置" class="opt_sub" />
			</c:forEach>
		</form>
	</div> --%>
</body>
</html>