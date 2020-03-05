package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.User;
import com.icss.Snack.service.AccountService;
import com.icss.Snack.util.PageUtil;

/**
 * Servlet implementation class FindAccountByPageServlet
 */
@WebServlet("/FindAccountByPageServlet")
public class FindAccountByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAccountByPageServlet() {
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
		//接收页面提交的参数
				int pageSize=6;
				String currentPage=request.getParameter("currentPage");
				int page=0;
				if(currentPage==null) {
					page=1;
				}else {
					page=Integer.parseInt(currentPage);
				}
				AccountService accountService=new AccountService();
				PageUtil<User> pageUtil=null;
				try {
					pageUtil=accountService.findAllUserByPage(page,pageSize);
					
				}catch(Exception e) {
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
				request.setAttribute("pageUtil", pageUtil);
				request.getRequestDispatcher("back/accountlist.jsp").forward(request, response);
				
			}
	}


