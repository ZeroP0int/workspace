package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.User;
import com.icss.Snack.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收页面提交的参数
		String name = request.getParameter("username");
	    String pwd = request.getParameter("password");
	    //调用业务层方法进行处理
	    UserService userService = new UserService();
	    User user=null;
	    try {
	    	user=userService.login(name, pwd);
	    	
	    }catch(Exception e) {
	    	//登录方法出现异常
	    	request.getRequestDispatcher("error.jsp").forward(request, response);
	    	return;
	    }
	    //根据处理结果进行相应的跳转
	    if(user == null) {
	    	request.setAttribute("msg", "用户名或密码输入有误......");//存储属性-页面通过key（msg）获取该属性
	    	request.getRequestDispatcher("login.jsp").forward(request, response);//请求转发
	    }else {
	    	request.getSession().setAttribute("user", user);
	    	request.getRequestDispatcher("FindNewCommodityServlet").forward(request, response);//请求转发
	    }
	    
	}

}
