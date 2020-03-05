package com.icss.Snack.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

import com.icss.Snack.entity.User;
import com.icss.Snack.service.UserService;
/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳ���ύ�Ĳ���
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		//����ҵ��㷽�����д���
		UserService userService=new UserService();
		int row;
		User user = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		((com.icss.Snack.entity.User) user).setRegtime(new Timestamp(System.currentTimeMillis()));
		try {
			row=userService.register((com.icss.Snack.entity.User) user);
			
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		if(row==0) {
			request.setAttribute("msg", "ע��ʧ��");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//���ݴ�����������Ӧ��ת
	}

}
