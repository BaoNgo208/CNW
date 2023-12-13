package controller;

import model.bean.User;
import model.bo.CheckLoginBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public SearchUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search_name");
        CheckLoginBO checkLoginBO = new CheckLoginBO();
        ArrayList<User> list = checkLoginBO.GetAllUser();
        ArrayList<User> users = new ArrayList<>();
        for(User user : list)
        {
            if(user.getName().contains(name)){
                users.add(user);
            }
        }
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
