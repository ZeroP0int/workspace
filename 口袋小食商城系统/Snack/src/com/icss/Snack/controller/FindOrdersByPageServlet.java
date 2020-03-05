package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.Orders;
import com.icss.Snack.service.CommodityService;
import com.icss.Snack.service.OrdersService;
import com.icss.Snack.util.PageUtil;

/**
 * Servlet implementation class FindOrdersByPageServlet
 */
@WebServlet("/FindOrdersByPageServlet")
public class FindOrdersByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrdersByPageServlet() {
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
		int pageSize=6;
		String currentPage=request.getParameter("currentPage");
		int page=0;
		if(currentPage==null) {
			page=1;
		}else {
			page=Integer.parseInt(currentPage);
		}
		OrdersService ordersService=new OrdersService();
		PageUtil<Orders> pageUtil=null;
		try {
			pageUtil=ordersService.findAllOrdersByPage(page,pageSize);
			
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("pageUtil", pageUtil);
		request.getRequestDispatcher("back/orderlist.jsp").forward(request, response);
	}

}
