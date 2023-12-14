package controller;

import model.bean.PhongTro;
import model.bo.CheckLoginBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/SearchPostServlet")
public class SearchPostServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public SearchPostServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        CheckLoginBO checkLoginBO = new CheckLoginBO();
        String[] optionIds = request.getParameterValues("optionIds");
        if(optionIds!=null)
        {
            for (String option : optionIds) {
                checkLoginBO.RemovePost(Integer.parseInt(option));
            }
        }

        ArrayList<PhongTro> phongTros = new ArrayList<>();
        try {
            ArrayList<PhongTro> list = checkLoginBO.GetAllPost();
            for(PhongTro phongTro : list)
            {
                if(checkLoginBO.GetUsernameByID(phongTro.getIdUser()).contains(name))
                {
                    phongTros.add(phongTro);
                }
            }
            request.setAttribute("phongTros", phongTros);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PostManage.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
