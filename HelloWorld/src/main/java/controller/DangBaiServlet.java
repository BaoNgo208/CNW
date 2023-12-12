package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongTro;
import model.bean.User;
import model.bean.Wife;
import model.bo.CheckLoginBO;

@WebServlet("/DangBaiServlet")

public class DangBaiServlet extends HttpServlet{

	public DangBaiServlet() {
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
			PhongTro phongTro = new PhongTro(
					request.getParameter("Img"),
					request.getParameter("TieuDe"),
					Integer.parseInt(request.getParameter("DienTich")) ,
					Integer.parseInt(request.getParameter("Gia")) ,
					request.getParameter("DiaChi"),
					request.getParameter("Quan"),
					request.getParameter("MoTa"),
					Integer.parseInt(request.getParameter("IdUser")) 
			);
			
			try {
				PhongTro createNewPhongTro = checkLoginBO.addPhongTro(phongTro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
