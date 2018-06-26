package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.service.CommonService;

/**
 * Servlet implementation class CTopicServlet
 */
@WebServlet("/CTopicServlet")
public class CTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("查看新闻1");
		int id = Integer.parseInt(request.getParameter("tid"));
		System.out.println("查看新闻2");
		News n  = new News();
		List<News> list = new ArrayList<News>();
		CommonService cSer = new CommonService();
		try {
			list = cSer.togets(id);
			request.setAttribute("list", list);
			/*request.setAttribute("ntid", n.getNtid());
			request.setAttribute("ntitle", n.getNtitle());
			request.setAttribute("tname", n.getNtname());
			request.setAttribute("ncontent", n.getNcontent());
			request.setAttribute("nauthor", n.getNauthor());
			//System.out.println("nauthor:"+n.getNauthor());
			request.setAttribute("ncreatedate",n.getNcreatedate());
			request.setAttribute("npicPath", n.getNpicpath());
			request.setAttribute("nmodifydate",n.getNmodifydate());
			request.setAttribute("nid", String.valueOf(n.getNid()));
			request.setAttribute("nsummary",n.getNsummary());*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nauthor:");
		//response.sendRedirect("/pages/topicPage.jsp");
		request.getRequestDispatcher("/pages/news.jsp").forward(request, response);//跳转到更新页面
		
	}


}
