package com.icss.Snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Address;
import com.icss.Snack.entity.User;
import com.icss.Snack.service.AddressService;
import com.icss.Snack.service.OrdersService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		User user=(User) request.getSession().getAttribute("user");
	
		AddressService addressService=new AddressService();
		int uid=user.getUid();
		int address_id=Integer.parseInt(request.getParameter("address_Id"));
		String remark=request.getParameter("remark");
		double totalprice=Double.parseDouble(request.getParameter("totalPrice"));
 		String cartIds=request.getParameter("cartIds");
 		List<Address> list=null;
		OrdersService os=new OrdersService();
		try {
			list=addressService.findAddressByaddressid(uid,address_id);
			os.addOrder(address_id, remark, totalprice, uid, cartIds);
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		request.setAttribute("addresslist", list);
		request.setAttribute("totalPrice", totalprice);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
