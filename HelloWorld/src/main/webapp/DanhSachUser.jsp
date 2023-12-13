<%--
  Created by IntelliJ IDEA.
  User: thain
  Date: 12/13/2023
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="javax.servlet.RequestDispatcher.*" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<form action="SearchUserServlet" method="POST">
    <h3>${error}</h3>
    <input type="text" name="search_name" style="width: 200px;">
    <button type="submit" value="submit" style="margin-bottom: 30px; height: 30px; width: 70px;">Duyệt</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>User name </th>

        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getName()%></td>

        </tr>
        <% } %>
        </tbody>
    </table>
</form>
</body>
</html>
