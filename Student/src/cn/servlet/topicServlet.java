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

import cn.entity.Topic;
import cn.service.TopicsService;
import cn.service.impl.TopicsServiceImpl;

/**
 * Servlet implementation class topicServlet
 */
@WebServlet("/topicServlet")
public class topicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topicServlet() {
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
		try {
			topics = topicsService.findAllTopics();
			request.setAttribute("topics", topics);
			//System.out.println(topic.getTname());
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String opr = request.getParameter("readnews");
		
		if(opr!=null && !opr.equals("")){
			try {
				System.out.println("获取新闻分类");
				topics = topicsService.findAllTopics();
				System.out.println(topics);
				request.setAttribute("topics", topics);
				//System.out.println(topic.getTname());
				request.getRequestDispatcher("/pages/news.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*try {
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
			*/
		
		}
	}

}
