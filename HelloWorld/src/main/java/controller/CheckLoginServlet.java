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
import model.bo.*;
import model.bean.*;
import model.dao.*;
/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
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
		String destination = null;
		String username= request.getParameter("userName");
		String password= request.getParameter("password");
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		ArrayList<Wife> wifeArray = null;
		ArrayList<PhongTro> phongTroList = null;
		ArrayList<User> users = null;
		User user = null;
		try {
			if(checkLoginBO.isValidUser(username,password) ) {
//				  wifeArray = checkLoginBO.getWifeList(username);
//				  request.setAttribute("wifeArray", wifeArray);
				  destination = "/welcome.jsp";
				  
				  phongTroList = checkLoginBO.getPhongTroList();
				  users=checkLoginBO.getUserList();
				  
				  user = checkLoginBO.getUser(username, password);
				  
				  request.setAttribute("User", user);
				  
				  request.setAttribute("phongtrolist", phongTroList);
				  request.setAttribute("UserList", users);
				  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				  rd.forward(request, response);
			}
			else {
				  destination = "/login.jsp";
				  RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				  rd.forward(request, response);
			}
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

}
