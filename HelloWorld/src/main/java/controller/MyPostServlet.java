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
import model.bo.CheckLoginBO;

@WebServlet("/MyPostServlet")
public class MyPostServlet extends HttpServlet {

	public MyPostServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 CheckLoginBO checkLoginBO = new CheckLoginBO();
	
		  try {
			  String destination = "/MyPost.jsp";
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			  String userId = request.getParameter("UserId");
			  User user = checkLoginBO.getUserByPhongTroIdUser(Integer.parseInt(userId) );
			  ArrayList<PhongTro> phongTros = checkLoginBO.getPhongTrosByIdUse(Integer.parseInt(userId));
			  request.setAttribute("phongtrolist", phongTros);
			  request.setAttribute("UserId", userId);
			  request.setAttribute("User", user);
			  rd.forward(request, response);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
