package com.icss.Snack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.User;
import com.icss.Snack.service.UserService;

/**
 * Servlet implementation class CheckNameServlet
 */
@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNameServlet() {
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
		//��Ӧת��
		response.setContentType("text/html;charset=utf-8");
		//����ҳ�洫�ݹ������˻�����
		String name=request.getParameter("username");
		//����ҵ��㷽�����д���
		UserService userService=new UserService();
		User user=null;
		try {
			user=userService.checkName(name);
		}catch(Exception e) {
			
		}
		String str = "";
		if(user!=null) {
			str="���˻��Ѵ���";
			
		}
		//�ַ�����Ӧ���ͻ���
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

}
