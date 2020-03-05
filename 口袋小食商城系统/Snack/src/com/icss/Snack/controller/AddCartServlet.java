package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.User;
import com.icss.Snack.service.CartService;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
	 * @param qua 
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
		
		User user=(User) request.getSession().getAttribute("user");
		CartService cartService=new CartService();
		Cart cart=new Cart();
		cart.setCommodity_id(commodity_id);
		cart.setFid(flavor_id);
		cart.setQuantity(quantity);
		cart.setUid(user.getUid());
		try {
			cartService.addCart(cart);
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("FindCartByUidServlet").forward(request, response);
	}

}
