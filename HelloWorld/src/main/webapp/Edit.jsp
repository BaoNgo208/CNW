<%@page import="model.bean.PhongTro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="./Style/DangTin.css">
</head>
<body>
		<% PhongTro phongTro = (PhongTro) request.getAttribute("phongTro");
		
		%>
		
		<div class="main-container">
	  <form class="add-form" action="EditServlet" method="post" >
			  <div class="mb-3">
			    <label for="Img" class="form-label">Link hình ảnh</label>
			    <input type="text" class="form-control" name="Img" aria-describedby="emailHelp" value="<%= phongTro.getImg()%>">
			  
			  </div>
			  
			  <div class="mb-3">
			    <label for="TieuDe" class="form-label">Tiêu đề</label>
			    <input type="text" class="form-control" name="TieuDe" value="<%= phongTro.getTieuDe()%>">
			  </div>
			  
			  <div class="mb-3">
			    <label for="DienTich" class="form-label">Diện tích</label>
			    <input type="text" class="form-control" name="DienTich" value="<%= phongTro.getDienTich()%>">
			  </div>
			  
			    <div class="mb-3">
			    <label for="Gia" class="form-label">Gía</label>
			    <input type="text" class="form-control" name="Gia" value="<%= phongTro.getGia()%>">
			  </div>
			  
			    <div class="mb-3">
			    <label for="DiaChi" class="form-label">Địa Chỉ</label>
			    <input type="text" class="form-control" name="DiaChi" value="<%= phongTro.getDiaChi()%>">
			  </div>
			  
			   <div class="mb-3">
			    <label for="Quan class="form-label">Quận</label>
			    <input type="text" class="form-control" name="Quan" value="<%= phongTro.getQuan()%>">
			  </div>
			  
			   <div class="mb-3">
			    <label for="Quan class="form-label">Mô Tả</label>
			    <input type="text" class="form-control" name="MoTa" value="<%= phongTro.getMoTa()%>">
			  </div>
        	       
        	       
		  <%-- 	  <input type="hidden" class="form-control" name="IdUser" value="<%= userId %>"> --%>
		 		<input type="hidden" name="UserId" value="<%= request.getParameter("UserId") %>">
		 		<input type="hidden" name="phongTroId" value="<%= request.getParameter("phongTroId") %>">
			  <button type="submit" class="btn btn-primary">Cập nhật</button>
		</form>
		 
</body>
</html>