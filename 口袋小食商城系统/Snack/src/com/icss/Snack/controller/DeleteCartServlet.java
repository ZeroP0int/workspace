package com.icss.Snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.CartVo;
import com.icss.Snack.entity.User;
import com.icss.Snack.service.CartService;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
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
		String cartId=request.getParameter("cartId");
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		int cart_id=0;
		if(cartId!=null) {
			cart_id=Integer.parseInt(cartId);
		}
		CartService cs=new CartService();
		List<CartVo> list=null;
		try {
			cs.delCart(cart_id);
			list=cs.findCartListByUid(user.getUid());
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("cartVolist", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}

}
