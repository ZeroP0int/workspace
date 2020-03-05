package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.service.CommodityService;
import com.icss.Snack.util.PageUtil;

/**
 * Servlet implementation class FindCommodityByPageServlet
 */
@WebServlet("/FindCommodityByPageServlet")
public class FindCommodityByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCommodityByPageServlet() {
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
		CommodityService commodityService=new CommodityService();
		PageUtil<Commodity> pageUtil=null;
		try {
			pageUtil=commodityService.findAllCommodityByPage(page,pageSize);
			
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("pageUtil", pageUtil);
		request.getRequestDispatcher("back/foodlist.jsp").forward(request, response);
		
	}
	

}
