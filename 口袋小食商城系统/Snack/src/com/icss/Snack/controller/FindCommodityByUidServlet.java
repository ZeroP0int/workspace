package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.service.CommodityService;

/**
 * Servlet implementation class FindCommodityByUidServlet
 */
@WebServlet("/FindCommodityByUidServlet")
public class FindCommodityByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCommodityByUidServlet() {
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
		// TODO Auto-generated method stub
		String commodity_id = request.getParameter("commodity_id");
		int id = 0;
		if(commodity_id != null && !"".equals(commodity_id)){
			id = Integer.parseInt(commodity_id);
		}
		CommodityService commodityService = new CommodityService();
		Commodity commodity = null;
		try{
			commodity = commodityService.findCommodityById(id);
		}catch(Exception e){
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
