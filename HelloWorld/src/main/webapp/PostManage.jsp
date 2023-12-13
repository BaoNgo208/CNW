<%--
  Created by IntelliJ IDEA.
  User: thain
  Date: 12/13/2023
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page language="java" import="javax.servlet.RequestDispatcher.*" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.*" %>
<%@ page language="java" import="model.bo.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<form action="SearchPostServlet" method="POST">
    <h3>${error}</h3>


    Nhập vào tên người đăng:<input type="text" name="search" style="width: 200px;" >
    <button type="submit" value="submit" style="margin-bottom: 30px; height: 50px; width: 120px;">Gỡ Bài & Search</button>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Ảnh </th>
            <th>Tiêu đề</th>
            <th>Diện tích</th>
            <th>giá</th>
            <th>Địa chỉ</th>
            <th>Quận</th>
            <th>ID người đăng</th>
            <th>Chọn</th>
        </tr>
        </thead>
        <tbody>
        <%
            CheckLoginBO checkLoginBO = new CheckLoginBO();
            ArrayList<PhongTro> phongTros = (ArrayList<PhongTro>)request.getAttribute("phongTros");
            for (PhongTro phongTro : phongTros) {
        %>
        <tr>
            <td><%= phongTro.getId() %></td>
            <td>
                <img src="./image/setdanh.jpg" style="width: 60px;height: 40px;"/>
            </td>
            <td><%= phongTro.getTieuDe() %></td>
            <td><%= phongTro.getDienTich()%></td>
            <td><%= phongTro.getGia()%></td>
            <td><%= phongTro.getDiaChi()%></td>
            <td><%= phongTro.getQuan()%></td>
            <td><%= checkLoginBO.GetUsernameByID(phongTro.getIdUser())%></td>
            <td><input type="checkbox" name="optionIds" value="<%= phongTro.getId() %>"></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</form>
</body>
</html>
