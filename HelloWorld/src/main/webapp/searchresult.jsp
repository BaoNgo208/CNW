<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page language="java" import="model.bean.PhongTro" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	  <link rel="stylesheet" type="text/css" href="./Style/Home.css">
</head>
<body>

		 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
       <a class="navbar-brand" href="#">Ngô Gia Bảo,Nguyễn Tấn Phát</a>>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
           <a class="nav-link active" aria-current="page" href="home?IdUser=<%= (String) request.getAttribute("UserId")%>">Home</a>
        </li>     
      
      </ul>
     
      <form class="d-flex me-2" method="get" action="RedirectFoundResultServlet">
      	
	        <input class="ms-2 form-control me-2" style="max-width:500px;width:500px;" name="searchResult" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      
  
      
        <form class="d-flex" action="MyPostServlet" method="get" > 
          <button class="btn btn-outline-success custom">My Post</button>
       
          <input type="hidden" name="UserId" value="<%= (String) request.getAttribute("UserId") %>"/>
      
      </form>
      
    </div>
  </div>
</nav>


	 <div class="main-content" style="display:flex;padding-top:0px;margin-top:50px;"  >
	 
	 	<div class="home-body" style="padding-bottom:0px;padding-top:0px; padding-right:0px;overflow-y: scroll; height:600px;width:78%;">
	   <%
			ArrayList<PhongTro> phongTroList = (ArrayList<PhongTro>) request.getAttribute("phongTroList");
			for(int i  = 0 ;i< phongTroList.size();i++) {
		%>
	
			
						<div class="card mb-3" style="width:100%;"> 
						
						 	<a  class="detail" href="detail?Id=<%=phongTroList.get(i).getId() %>" style="text-decoration:none" > 
				             	   <div class="row g-0"> 
				            
				                <div class="col-md-6 img-container"> 
				                    <img src="./Image/<%=phongTroList.get(i).getImg()%>" 
											  
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
				                        <p class="card-text mb-1 price"> 
				                            <small class="text-muted"> 
				                                 <%=phongTroList.get(i).getDienTich() %> mét vuông
				                            </small> 
				                        </p> 
				                        
				                     
				                        
				                   
				                    </div> 
				             </div>
				              
				            </div> 
				             	
	             	
	             	</a>
	         
	        </div>
	        
		
	
		
		<%} %>
		
	  </div>
	  
	  
	   <div class ="add-section">
	  
	  		  <div class="home-body-ad-section" style="width:100%;padding-left:0px;padding-top:0px;">
	        
	        		<div class="ad-item" style="margin-bottom:5px;">
	        			<img src="https://tpc.googlesyndication.com/simgad/1654040997672814320">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://tpc.googlesyndication.com/simgad/16095383902754767523">
	        		</div>
	        		
	        		
	        </div>
	        
	        
	          <div class="home-body-ad-section" style="width:100%;padding-left:0px;">
	         		<h3>Liên kết</h3>
	        		<div class="ad-item" style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_HTTTSV.jpg">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_tacnghiep.jpg">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_elearning.jpg">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_quanlykhoahoc.jpg">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_thuvienPrimo.jpg">
	        		</div>
	        		
	        		<div class="ad-item"  style="margin-bottom:5px;">
	        			<img src="https://dut.udn.vn/Images/UserfulLinks/home_PURSEA.jpg">
	        		</div>
	        		
	        		
	        </div>
	   </div>
	  
	  
	 
	  </div>
	  
	  
	  
	  <div class="container my-5" style="margin:0px;padding:0px;max-width:100%;margin-bottom:0px !important;">

  <footer class="bg-dark text-center text-lg-start text-white">
    <!-- Grid container -->
    <div class="container p-4">
      <!--Grid row-->
      <div class="row mt-4">
        <!--Grid column-->
        <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase">See other books</h5>

          <ul class="list-unstyled mb-0">
            <li>
              <a href="#!" class="text-white"><i class="fas fa-book fa-fw fa-sm me-2"></i>Bestsellers</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-book fa-fw fa-sm me-2"></i>All books</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-user-edit fa-fw fa-sm me-2"></i>Our authors</a>
            </li>
          </ul>
        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase">Execution of the contract</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white"><i class="fas fa-shipping-fast fa-fw fa-sm me-2"></i>Supply</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-backspace fa-fw fa-sm me-2"></i>Returns</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="far fa-file-alt fa-fw fa-sm me-2"></i>Regulations</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="far fa-file-alt fa-fw fa-sm me-2"></i>Privacy policy</a>
            </li>
          </ul>
        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase">Publishing house</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white">The BookStore</a>
            </li>
            <li>
              <a href="#!" class="text-white">123 Street</a>
            </li>
            <li>
              <a href="#!" class="text-white">05765 NY</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-briefcase fa-fw fa-sm me-2"></i>Send us a book</a>
            </li>
          </ul>
        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase">Write to us</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white"><i class="fas fa-at fa-fw fa-sm me-2"></i>Help in purchasing</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-shipping-fast fa-fw fa-sm me-2"></i>Check the order status</a>
            </li>
            <li>
              <a href="#!" class="text-white"><i class="fas fa-envelope fa-fw fa-sm me-2"></i>Join the newsletter</a>
            </li>
          </ul>
        </div>
        <!--Grid column-->
      </div>
      <!--Grid row-->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
      © 2021 Copyright:
      <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
  </footer>

</div>
	

     
    
</body>
</html>