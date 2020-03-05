package com.icss.Snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.service.CommodityService;

/**
 * Servlet implementation class FindNewCommodityServlet
 */
@WebServlet("/FindNewCommodityServlet")
public class FindNewCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNewCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//调用业务层的方法进行处理
		CommodityService commodityService = new CommodityService();
		List<Commodity> list=null;
		try {
			list=commodityService.findLatestCommodityList();
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		request.setAttribute("commodityList", list);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
