<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>    
<%@ page language="java" import="model.bean.Wife" %>  
  <%@ page language="java" import="model.bean.PhongTro" %>  
   <%@ page language="java" import="model.bean.User" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html">
<title>Welcome page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="./Style/MyPost.css">
</head>
<body>
	 
	 
	 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <%User user = (User) request.getAttribute("User");
          
          %>
          <a class="nav-link active" aria-current="page" href="home?IdUser=<%=user.getId()%>">Home</a>
        </li>     
      
      </ul>
     
       <form class="d-flex me-2" method="get" action="RedirectFoundResultServlet">
      	
	        <input class="ms-2 form-control me-2" style="max-width:500px;width:500px;" name="searchResult" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
       <form class="d-flex me-2" action="PostContentServlet" method="get" > 
          <button class="btn btn-outline-success custom">Đăng Tin</button>
        
          <input type="hidden" name="UserId" value="<%= user.getId() %>"/>
      
      </form>
      
        <form class="d-flex" action="MyPostServlet" method="get" > 
          <button class="btn btn-outline-success custom">My Post</button>
          <input type="hidden" name="UserId" value="<%= user.getId() %>"/>
      
      </form>
      
    </div>
  </div>
</nav>
	 

	 
	 <div class="home-body">
	 		<h1>Tin đã đăng <span style="color:red;font-size:20px;">* Nháy đúp để xóa </span> </h1>
	   <%
			ArrayList<PhongTro> phongTroList = (ArrayList<PhongTro>) request.getAttribute("phongtrolist");
	
			for(int i  = 0 ;i< phongTroList.size();i++) {
		%>
	

						<div class="card mb-3" style="height:155px;"> 
						
						<a  class="detail" href="detail?Id=<%=phongTroList.get(i).getId() %>" style="text-decoration:none" > 
				             	   <div class="row g-0"> 
				            
				                <div class="col-md-6 img-container"> 
				                    <img src="./Image/<%=phongTroList.get(i).getImg()%>" 
										style="height:155px !important;"	  
				                        class="img" alt=""> 
				             </div> 
				             <div class="col-md-6 content-container"> 
				                    <div class="card-body "> 
				                        <h5 class="card-title"> 
				                             <%=phongTroList.get(i).getTieuDe() %>
				                        </h5> 
				                        <p class="card-text mb-2" style="color:red"> 
				                            <%=phongTroList.get(i).getGia() %>/tháng
				                        </p> 
				                        <p class="card-text mb-1 price" style="margin-bottom:0px;"> 
				                            <small class="text-muted"> 
				                                 <%=phongTroList.get(i).getDienTich() %> mét vuông
				                            </small> 
				                        </p> 
				                        	    
				                        	    <form method="post" action="DeletePostServlet">
				                        	    		<!-- <button type="button" class="btn btn-danger" style="float:right;margin-left:5px;">Xóa</button> -->
				                        	    		  <button  class="btn btn-outline-success custom" style="float:right;margin-left:5px;">Xóa</button>
				                        	    		 <input type="hidden" name="phongTroId" value="<%= phongTroList.get(i).getId() %>"/>
				                        	    		 	  <input type="hidden" name="UserId" value="<%= user.getId() %>"/>
				                        	    </form>
				                        	    
				                        	    <form method="get" action="RedirectEditFormServlet">
				                        	     		 <button  class="btn btn-outline-success custom" style="float:right;margin-left:5px;">Edit</button>
				                        	     			 <input type="hidden" name="phongTroId" value="<%= phongTroList.get(i).getId() %>"/>
				                        	    		 	 <input type="hidden" name="UserId" value="<%= user.getId() %>"/>
				                        	    </form>
				                     
				                        	
											
				                 
									
				                    </div> 
				             </div>
				              
				            </div> 
				             	
	             	</a>
	         
	         
	        </div>
	        
		
	
		
		<%} %>
		
	  </div>
	  
	 
		
<%-- 
	<table>
		<%
			ArrayList<PhongTro> phongTroList = (ArrayList<PhongTro>) request.getAttribute("phongtrolist");
			for(int i  = 0 ;i< phongTroList.size();i++) {
		%>
			<tr>
				<td><img src=<%= phongTroList.get(i).getImg() %>> </td>
		
				 <td><%= phongTroList.get(i).getTieuDe() %> </td> 
				  <td><%= phongTroList.get(i).getDiaChi() %> </td> 
			
				 <td><%=phongTroList.get(i).getGia() %> </td> 
			</tr>
		<%} %>
	</table> --%>
	
	
</body>
</html>