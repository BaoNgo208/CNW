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

@WebServlet("/KiemDuyetServlet")
public class KiemDuyetServlet extends  HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckLoginBO checkLoginBO = new CheckLoginBO();
        ArrayList<PhongTro> phongTros = new ArrayList<>();
        try {
            ArrayList<PhongTro> list = checkLoginBO.getPhongTroList();
            for(PhongTro phongTro : list)
            {
                if(phongTro.getState() == 0)   // cac bai chua dc duyet
                {
                    phongTros.add(phongTro);
                }
            }
            request.setAttribute("phongTros", phongTros);
            RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachKiemDuyet.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
