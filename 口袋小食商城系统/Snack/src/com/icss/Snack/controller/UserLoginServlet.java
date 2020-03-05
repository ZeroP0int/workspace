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
		//����ҳ���ύ�Ĳ���
		String name = request.getParameter("username");
	    String pwd = request.getParameter("password");
	    //����ҵ��㷽�����д���
	    UserService userService = new UserService();
	    User user=null;
	    try {
	    	user=userService.login(name, pwd);
	    	
	    }catch(Exception e) {
	    	//��¼���������쳣
	    	request.getRequestDispatcher("error.jsp").forward(request, response);
	    	return;
	    }
	    //���ݴ�����������Ӧ����ת
	    if(user == null) {
	    	request.setAttribute("msg", "�û�����������������......");//�洢����-ҳ��ͨ��key��msg����ȡ������
	    	request.getRequestDispatcher("login.jsp").forward(request, response);//����ת��
	    }else {
	    	request.getSession().setAttribute("user", user);
	    	request.getRequestDispatcher("FindNewCommodityServlet").forward(request, response);//����ת��
	    }
	    
	}

}
