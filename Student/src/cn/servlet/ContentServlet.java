package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.entity.Page;
import cn.service.NewServices;
import cn.service.impl.NewsServiceImol;


public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ContentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Page<News> page=new Page(request,response);
		NewServices newServices = new NewsServiceImol();
		News news = new News();
		int id = Integer.parseInt(request.getParameter("nid"));
		try {
			news = newServices.findNewsByNid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//调用方法
		request.setAttribute("nid", String.valueOf(news.getNid()));
		request.setAttribute("ntid", String.valueOf(news.getNtid()));
		request.setAttribute("ntname", String.valueOf(news.getNtname()));
		request.setAttribute("ntitle", news.getNtitle());
		//request.setAttribute("ncontent", news.getNcontent());
		request.setAttribute("nauthor", news.getNauthor());
		request.setAttribute("ncreatedate", news.getNcreatedate());
		//request.setAttribute("npicPath", news.getNpicpath());
		request.setAttribute("ncontent", news.getNcontent());
		request.getRequestDispatcher("/pages/updatenews.jsp").forward(request, response);//跳转到更新页面 
	}

}
