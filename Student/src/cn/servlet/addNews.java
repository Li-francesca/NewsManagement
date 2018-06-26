package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Grade;
import cn.entity.News;
import cn.entity.Page;
import cn.entity.Student;
import cn.service.GradeService;
import cn.service.NewServices;
import cn.service.StudentService;
import cn.service.impl.GradeServiceimp;
import cn.service.impl.NewsServiceImol;
import cn.service.impl.StudentServiceimp;

/**
 * Servlet implementation class addNews
 */
@WebServlet("/addNews")
public class addNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
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
		String ntid = request.getParameter("ntid");
		String ntitle = request.getParameter("ntitle");
		String ntname = request.getParameter("ntname");
		String nauthor = request.getParameter("nauthor");
		//int age = Integer.parseInt(request.getParameter("stuAge"));
		String ncreatedate = request.getParameter("ncreatedate");
		/*String nsummary = request.getParameter("nsummary");
		String npicPath = request.getParameter("npicPath");*/
		String ncontent = request.getParameter("ncontent");
		
		
		news.setNtid(ntid);
		news.setNtitle(ntitle);
		news.setNtname(ntname);
		news.setNauthor(nauthor);
		news.setNcontent(ncontent);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setNcreatedate(format.format(new Date()));
		//news.setNcreatedate(ncreatedate);
		/*news.setNpicpath(npicPath);
		news.setNsummary(nsummary);*/
		newServices.addNews(news);
		System.out.println("addNews");
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		try {
			page = newServices.pageQuery(page);
			System.out.println("增加新闻分页");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("/NewsList.jsp").forward(request, response);
		//request.getRequestDispatcher("/servlet/NewsServlet").forward(request, response);
		
		/*request.getRequestDispatcher("/pages/getNews.jsp").forward(request, response);//跳转到更新页面
		StudentService studentService = new StudentServiceimp();
		*/
		/*if(studentService.findStudent(stu)){//如果学生已经存在，就不添加
			response.sendRedirect("/Student/pages/stuList.jsp");
			
		}else{//如果学生不存在，就添加
			
			String opr = request.getParameter("opr");//根据传的opr参数决定是添加学生还是修改学生信息
			int n = 0;
			if(opr.equals("addStu")){
				n = studentService.addStudent(stu);
			}else if(opr.equals("modifyStu")){
				int id = Integer.parseInt(request.getParameter("stuId"));
				stu.setId(id);
				n = studentService.modifyStudent(stu);
			}
			
			
			if(n>0){
				response.sendRedirect("/Student/pages/stuList.jsp");
			}else{
				response.sendRedirect("/Student/pages/addStu.jsp");
			}
			
		}*/
		
		
	}

}
