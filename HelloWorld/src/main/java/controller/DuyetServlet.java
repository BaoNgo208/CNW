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

@WebServlet("/DuyetServlet")
public class DuyetServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckLoginBO checkLoginBO = new CheckLoginBO();
        String[] optionIds = request.getParameterValues("optionIds");
        if (optionIds != null) {
            for (String optionId : optionIds) {
                try {
                    checkLoginBO.Duyet(checkLoginBO.GetPhongTroByID(Integer.parseInt(optionId)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        ArrayList<PhongTro> phongTros = new ArrayList<>();
        try {
            ArrayList<PhongTro> list = null;
            try {
                list = checkLoginBO.getPhongTroList();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            for (PhongTro phongTro : list) {
                if (phongTro.getState() == 0)   // cac bai chua dc duyet
                {
                    phongTros.add(phongTro);
                }
            }
            request.setAttribute("phongTros", phongTros);
            RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachKiemDuyet.jsp");
            dispatcher.forward(request, response);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
