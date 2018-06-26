package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class updateNews
 */
@WebServlet("/updateNews")
public class updateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Page<News> page=new Page(request,response);
		NewServices newServices = new NewsServiceImol();
		News news = new News();
		//int id = Integer.parseInt(request.getParameter("nid"));
		String nid = request.getParameter("nid");
		String[] ntids = request.getParameterValues("ntid");
		String ntitle = request.getParameter("ntitle");
		String ntname = request.getParameter("ntname");
		String nauthor = request.getParameter("nauthor");
		//String npicpath = request.getParameter("file");
		//String nsummary = request.getParameter("nsummary");nmodifyDate
		String ncontent = request.getParameter("ncontent");
	
		
		if (ntids != null) {
			for (String ntid : ntids) {
				news.setNtid(ntid);
			}
		}
		//PrintWriter out = response.getWriter();
		news.setNid(nid);
		
		news.setNtitle(ntitle);
		news.setNtname(ntname);
		news.setNauthor(nauthor);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setNmodifydate(format.format(new Date()));
		//news.setNsummary(nsummary);
		news.setNcontent(ncontent);
		
		//news.setNpicpath(npicpath);
		boolean data = true;
		int i = newServices.upadte(news);
		if (i > 0) {
			data = true;
		} else {
			data = false;
		}
		System.out.println("updateNews");
		try {
			page = newServices.pageQuery(page);
			System.out.println("更新分页");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("/NewsList.jsp").forward(request, response);
		/*n = cSer.toget(id);//调用方法
		request.setAttribute("id", String.valueOf(n.getId()));
		request.setAttribute("title", n.getTitle());
		request.setAttribute("content", n.getContent());
		request.setAttribute("admin", n.getAdmin());
		request.setAttribute("type", n.getType());
		request.setAttribute("date", n.getDate());
		request.getRequestDispatcher("/updatenews.jsp").forward(request, response);//跳转到更新页面 */
	}

}
