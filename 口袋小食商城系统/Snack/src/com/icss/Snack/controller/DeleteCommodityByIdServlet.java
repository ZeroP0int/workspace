package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.service.CommodityService;

/**
 * Servlet implementation class deleteCommodityByIdServlet
 */
@WebServlet("/DeleteCommodityByIdServlet")
public class DeleteCommodityByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommodityByIdServlet() {
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
		String commodity_id=request.getParameter("commodity_id");
		int id=0;
		if(commodity_id!=null) {
			id=Integer.parseInt(commodity_id);
		}
		//����ҵ���ķ������д���
		CommodityService commodityService=new CommodityService();
		try {
			commodityService.deleteCommodityById(id);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		//���ݴ�����������ת
		request.getRequestDispatcher("FindCommodityByPageServlet").forward(request, response);
	}

}
