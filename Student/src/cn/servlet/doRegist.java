package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.User;
import cn.service.UserService;
import cn.service.impl.UserServiceimp;

/**
 * Servlet implementation class doRegist
 */
@WebServlet("/doRegist")
public class doRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public doRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(userName!=null && !userName.equals("")){
			UserService uerService = new UserServiceimp();
			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			if(uerService.findUser(user)){//存在这个用户
				String message = "用户名已存在";
				request.getSession().setAttribute("msg", message);
				response.sendRedirect("/Student/regist.jsp");
				
			/*	request.getSession().setAttribute("user", user);
			
				response.sendRedirect("../NewsServlet");*/
				
			}else{
				
				//如果用户不存在，就添加
				
				String opr = request.getParameter("opr");//根据传的opr参数决定是添加学生还是修改学生信息
				boolean n = true;
				if(opr.equals("addUser")){
					uerService.addUser(user);
					n = true;
				}else if(opr.equals("modifyUser")){
					int id = Integer.parseInt(request.getParameter("id"));
					
					user.setId(id);
					uerService.updateUser(user);
					n = false;
				}
				
				
				if(n){
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					//response.sendRedirect("/Student/index.jsp");
				}else{
					String message = "密码修改成功";
					request.getSession().setAttribute("msg", message);
					request.getRequestDispatcher("/Student/login.jsp").forward(request, response);
					//response.sendRedirect("/Student/login.jsp");
				}
				
				
				
			}
		}
		
	}

}
