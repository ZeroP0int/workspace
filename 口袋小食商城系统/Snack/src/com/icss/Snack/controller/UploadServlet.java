package com.icss.Snack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
	request.setCharacterEncoding("GBK");
		try {
	SmartUpload smartUpload = new SmartUpload();
	smartUpload.initialize(getServletConfig(), request, response);
	smartUpload.upload();
	smartUpload.getFiles();
	Files files=smartUpload.getFiles();
	File file=files.getFile(0);
	file.saveAs("d:/img/"+file.getFileName());
	
	String name = smartUpload.getRequest().getParameter("name");
	System.out.println(name);
	
	String brandid = smartUpload.getRequest().getParameter("brand_id");
	System.out.println(brandid);
	
	
	}catch(SmartUploadException e) {
		e.printStackTrace();
	}
	}

}
