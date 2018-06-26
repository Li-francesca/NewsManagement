package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.News;
import cn.service.CommonService;


public class ContentQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ContentQServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("修改新闻1");
		int id = Integer.parseInt(request.getParameter("nid"));
		System.out.println("修改新闻2");
		News n  = new News();
		CommonService cSer = new CommonService();
						
		try {
			n = cSer.toget(id);
			
			request.setAttribute("ntid", n.getNtid());
			request.setAttribute("ntitle", n.getNtitle());
			request.setAttribute("ntname", n.getNtname());
			request.setAttribute("ncontent", n.getNcontent());
			request.setAttribute("nauthor", n.getNauthor());
			//System.out.println("nauthor:"+n.getNauthor());
			request.setAttribute("ncreatedate",n.getNcreatedate());
			//request.setAttribute("npicPath", n.getNpicpath());
			request.setAttribute("nmodifydate",n.getNmodifydate());
			request.setAttribute("nid", String.valueOf(n.getNid()));
			//request.setAttribute("nsummary",n.getNsummary());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nauthor:");
		
		/*String opr = request.getParameter("opr");//根据传的opr参数决定
		
		if(opr.equals("readNews")){
			request.getRequestDispatcher("/pages/getNews.jsp").forward(request, response);//普通用户跳转到详情页面
			
		}else if(opr.equals("TreadNews")) {
			request.getRequestDispatcher("/pages/getTNews.jsp").forward(request, response);//管理员用户跳转到详情页面
		}*/
		
		request.getRequestDispatcher("/pages/getNews.jsp").forward(request, response);//跳转到页面
		
	}

}
