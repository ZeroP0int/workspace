package com.icss.Snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Address;
import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.CartVo;
import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.User;
import com.icss.Snack.service.AddressService;
import com.icss.Snack.service.CartService;
import com.icss.Snack.service.CommodityService;

/**
 * Servlet implementation class DirectPayServlet
 */
@WebServlet("/DirectPayServlet")
public class DirectPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectPayServlet() {
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
	 * @param  
	 * @param id 
	 * @param cartIds 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cid=request.getParameter("cid");
		String fid=request.getParameter("fid");
		String qua=request.getParameter("quantity");
		
		int commodity_id=0;
		int flavor_id=0;
		int quantity=0;
		if(cid!=null && !"".equals(cid)) {
			commodity_id=Integer.parseInt(cid);
		}
		if(fid!=null && !"".equals(fid)) {
			flavor_id=Integer.parseInt(fid);
		}

		if(qua!=null && !"".equals(qua)) {
			quantity=Integer.parseInt((String) qua);
		}
		
		Commodity commodity=new Commodity();
		commodity.setCommodity_id(commodity_id);
		commodity.setFid(flavor_id);
		commodity.setQuantity(quantity);
		
		
		User user=(User) request.getSession().getAttribute("user");

		CommodityService commodityService = new CommodityService();
		AddressService addressService=new AddressService();
		List<Address> list=null;
		try{
			list=addressService.findAddressByUid(user.getUid());
			commodity = commodityService.findCommoditytoPay(commodity_id);
		}catch(Exception e){
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("addresslist", list);

		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("directpay.jsp").forward(request, response);
	}


	}


