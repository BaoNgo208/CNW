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
	  <link rel="stylesheet" type="text/css" href="./Style/Detail.css">
</head>
<body>
	 
	 
	 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
       <a class="navbar-brand" href="#">Ngô Gia Bảo,Nguyễn Tấn Phát</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
         <%
	 	User user  = (User) request.getAttribute("User");
	 %>
          <a class="nav-link active" aria-current="page" href="home?IdUser=<%=user.getId()%>">Home</a>
        </li>     
      
      </ul>
     
      
       <form class="d-flex me-2" method="get" action="RedirectFoundResultServlet">
      	
	        <input class="ms-2 form-control me-2" style="max-width:500px;width:500px;" name="searchResult" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      
     
    </div>
  </div>
</nav>
	 <%
		PhongTro phongTro = (PhongTro) request.getAttribute("phongTro");

	 %>
	<div class="add-body" style="padding:0px 170px"> 
		<img src="https://tpc.googlesyndication.com/simgad/12385207578083577613">
	</div>
	
	
	<div class="home-body" style="padding:20px 200px; display:flex;">
	        
	        
	        <div class="home-body-content" style="width:60%;">
		        <div class="img" style="width:100%;">
						<img src="./Image/<%= phongTro.getImg() %>" style="width:100%;" ">
				</div>
				
				<div class="item-detail tiem" style="padding:10px;width:100%;">
					 <h5 class="header" style="">Phòng Trọ</h5>
					 <p  style="color:red;" ><%= phongTro.getGia() %>/tháng <span style="color:grey"> - <%=phongTro.getDienTich()%> mét vuông </</span></p>
					 
					 <p style="color: #777;font-weight: 400;" >
					 <img src= "https://static.chotot.com/storage/icons/logos/ad-param/location.svg">
					 <%=phongTro.getDiaChi() %>
					 
					 </p>
					 
					 <p>
					 	<img src="https://static.chotot.com/storage/default_images/default-avatar.webp">
					 	
					 	<%=user.getName() %>
					 </p>
		 
				</div>
				
				
					<div class="item-detail item"  style="padding:10px;width:100%;">
						 <h5 class="header" style="">Mô tả chi tiết</h5>
				
						 
						 <p style="color: #777;font-weight: 400;" >
						
						 <%=phongTro.getMoTa() %>
						 
						 </p>
					 
				
		 
				</div>
	        
	        </div>
	        
	        <div class="home-body-ad-section" style="width:40%;padding-left:20px;">
	         		<h3>Quảng cáo</h3>
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
	
	
	<div class="recommend-section" style="width:100%;padding:0px 150px;">
	
	     <div class="recommend-body" style="padding:0px 15px;background:white">
	    	<h3 align-center> Tin đăng tương tự</h3>
	     		  <div class="card-group card-group-scroll" style="padding:20px;" >
	     		     <%
						ArrayList<PhongTro> phongTroList = (ArrayList<PhongTro>) request.getAttribute("phongtrolist");
					
						for(int i  = 0 ;i< phongTroList.size();i++) {
					%>
				
				    <div class="card" style="width:200px !important;">
				    	<a href="detail?Id=<%=phongTroList.get(i).getId() %>" style="text-decoration:none;">
					
									   <img src="./Image/<%=phongTroList.get(i).getImg()%>" class="card-img-top" alt="Hollywood Sign on The Hill" style="height:200px;"/>
				        <div class="card-body">
				            <h5 class="card-title"><%= phongTroList.get(i).getTieuDe() %></h5>
				            <p class="card-text">
				                <%= phongTroList.get(i).getDienTich() %> mét vuông
				            </p>
				            
				            <p class="card-text" style="color:red;">
				                <%= phongTroList.get(i).getGia() %>/tháng
				            </p>
				        </div>
					
						</a>
				     
				   
				    </div>
				    
				  <%} %>
				    
				    
				    
				    
				 
				  
				  
				  
				</div>
	     </div>
	   
	</div>
	
	
	<!-- Remove the container if you want to extend the Footer to full width. -->
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
<!-- End of .container -->
	
	
	 

	
	
</body>
</html>