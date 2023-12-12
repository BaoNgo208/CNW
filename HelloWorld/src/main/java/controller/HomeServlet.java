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

@WebServlet("/home")
public class HomeServlet   extends HttpServlet{

	public HomeServlet() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
	
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		
		ArrayList<PhongTro> phongTroList = null;
		ArrayList<User> users = null;
		User user = null;
		try {

				  destination = "/welcome.jsp";
				  
				  phongTroList = checkLoginBO.getPhongTroList();
				  users=checkLoginBO.getUserList();
				  
				  user = checkLoginBO.getUserByPhongTroIdUser(Integer.parseInt(request.getParameter("IdUser")));
				  
				  request.setAttribute("User", user);
				  
				  request.setAttribute("phongtrolist", phongTroList);
				  request.setAttribute("UserList", users);
				  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				  rd.forward(request, response);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
