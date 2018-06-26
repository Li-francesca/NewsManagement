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
import cn.entity.Page;
import cn.entity.Topic;
import cn.entity.User;
import cn.service.NewServices;
import cn.service.TopicsService;
import cn.service.UserService;
import cn.service.impl.NewsServiceImol;
import cn.service.impl.TopicsServiceImpl;
import cn.service.impl.UserServiceimp;

/**
 * Servlet implementation class addTopic
 */
@WebServlet("/addTopic")
public class addTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addTopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		TopicsService topicsService = new TopicsServiceImpl();
		List<Topic> topics = new ArrayList<Topic>();
		Topic topic = new Topic();
		String tname = request.getParameter("tname");
		
		if(tname!=null && !tname.equals("")){
			
			try {
				if(topicsService.findTopicByName(tname)){//不存在这个主题，可以插入新主题
				
					topic.setTname(tname);
					topicsService.addTopic(topic);
					System.out.println("增加新闻分类");
					topics = topicsService.findAllTopics();
					System.out.println(topics);
					request.setAttribute("topics", topics);
					//System.out.println(topic.getTname());
					request.getRequestDispatcher("/topicPage.jsp").forward(request, response);
					
				}
				
				else {
				
					//存在这个用户，给出提示，转回添加页面
					String message = "此分类已存在，请更改！";
					request.getSession().setAttribute("msg", message);
					//request.getRequestDispatcher("/Student/pages/addTopic.jsp").forward(request, response);
					response.sendRedirect("/Student/pages/addTopic.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
}
