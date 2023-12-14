<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <style>
        span{
            position: absolute;
            margin-top: 5px;
            font-size: 23px;
            color: rgb(10, 103, 175);
            margin-left: 200px;
        }
    </style>
</head>
<body>
    <form action="" >
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="">
                    <img src="./image/LogoCNTT.png" width="350" height="70"/>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href=""> Trang chủ </a>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Các chức năng
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="KiemDuyetServlet" target="Frame3">Duyệt Bài Viết</a></li>
                                <li><a class="dropdown-item" href="DanhSachUserServlet" target="Frame3">Xem Tất Cả Tài Khoản</a></li>
                                <li><a class="dropdown-item" href="AllPostServlet" target="Frame3">Thống Kê Bài viết</a></li>
                            </ul>
                        </li>
<%--                            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-right: 10px;">--%>
<%--                                <li class="nav-item dropdown">--%>
<%--                                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                                        &lt;%&ndash;         đây là để tên user              &ndash;%&gt;  User--%>
<%--                                    </a>--%>
<%--                                    <ul class="dropdown-menu" >--%>
<%--                                        <li><a class="dropdown-item" href="#">Trang cá nhân</a></li>--%>
<%--                                        <li><a class="dropdown-item" href="">Thoát</a></li>--%>
<%--                                    </ul>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
                        </li>
                    </ul>

                </div>

            </div>

        </nav>
        <table style="width: 100%; height: 100%;">
            <tr style="height:100%; margin-right: 5px;" >
                <td style="width:100%; height: 500px; margin-right: 0px;margin-left: 0px;">
                    <iframe name="Frame3" src="KiemDuyetServlet" height="100%" width="100%" frameborder="0" Scrolling="auto"></iframe>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
