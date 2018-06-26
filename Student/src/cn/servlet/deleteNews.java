package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.entity.Page;
import cn.service.NewServices;
import cn.service.impl.NewsServiceImol;


/**
 * Servlet implementation class deleteNews
 */
@WebServlet("/deleteNews")
public class deleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public deleteNews() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String status;
		boolean delSF = true;
		String nid = request.getParameter("nid");
		news.setNid(nid);
		
		boolean data = true;
		int i = newServices.del(news);
		if (i > 0) {
			data = true;
		} else {
			data = false;
		}
		System.out.println("deleteNews");
		try {
			page = newServices.pageQuery(page);
			System.out.println("删除新闻分页");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("/NewsList.jsp").forward(request, response);
		//NewsDao newsbiz = new NewsDaoImpl();
		
		/*if (a > 0) {
			delSF = true;
			//NewsDao newsDao = new NewsDaoImpl();
			ServletContext application = this.getServletContext();
			List<News> listNews;
			try {
				listNews = newsDao.getAllnews();
				application.setAttribute("SHOW_ALL_NEWS", listNews);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			delSF = false;
		}
	}
*/
}
}