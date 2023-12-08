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

@WebServlet("/PostContentServlet")
public class PostContentServlet extends HttpServlet {
	
	
	
	public PostContentServlet() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String destination = "/PostContent.jsp";
		  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		  String userId = request.getParameter("UserId");
		  request.setAttribute("UserId", userId);
	
		  rd.forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}


}
