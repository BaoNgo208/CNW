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

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {

	public DetailServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  CheckLoginBO checkLoginBO = new CheckLoginBO();
		
		  
		  try {
			  Integer id = Integer.parseInt(request.getParameter("Id")) ;
			  String destination = "/Detail.jsp"; 
			  PhongTro phongTro = checkLoginBO.getPhongTroById(id);
			  User user = checkLoginBO.getUserByPhongTroIdUser(phongTro.getIdUser());
			  ArrayList<PhongTro> phongTros = checkLoginBO.getPhongTroList();
			  
			  request.setAttribute("phongtrolist", phongTros);
			  request.setAttribute("phongTro", phongTro);
			  request.setAttribute("User", user);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			  rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
