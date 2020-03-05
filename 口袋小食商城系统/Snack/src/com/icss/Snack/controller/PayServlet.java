package com.icss.Snack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.Snack.entity.Address;
import com.icss.Snack.entity.CartVo;
import com.icss.Snack.entity.User;
import com.icss.Snack.service.AddressService;
import com.icss.Snack.service.CartService;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
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
		//接受页面传递的参数
		User user=(User) request.getSession().getAttribute("user");
		request.getParameter("totalMoney");
		double totalMoney=Double.parseDouble(request.getParameter("totalMoney"));
		String cartIds=request.getParameter("cartId");
		//调用业务层方法进行处理
		AddressService addressService=new AddressService();
		CartService cartService=new CartService(); 
		List<Address> list=null;
		List<CartVo> cartVoList=null;
		try {
		list=addressService.findAddressByUid(user.getUid());
		cartVoList=cartService.findCartListByUidAndCartId(user.getUid(), cartIds);
		//根据处理结果在页面显示
		}catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
			
		}
		request.setAttribute("addresslist", list);
		request.setAttribute("cartVoList",cartVoList);
		request.setAttribute("totalMoney",totalMoney);
		request.setAttribute("cartIds", cartIds);
		request.getRequestDispatcher("pay.jsp").forward(request,response);
	}
	
}
