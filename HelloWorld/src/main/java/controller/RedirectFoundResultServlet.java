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

/**
 * Servlet implementation class RedirectFoundResultServlet
 */
@WebServlet("/RedirectFoundResultServlet")
public class RedirectFoundResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectFoundResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			String destination = "/searchresult.jsp";
			
			String searchResult = request.getParameter("searchResult");
			
			try {
				ArrayList<PhongTro> phongTros = checkLoginBO.getPhongTroBySearchBar(searchResult);
				request.setAttribute("phongTroList", phongTros);
		
				request.setAttribute("UserId",request.getParameter("UserId"));
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
