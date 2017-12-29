<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/leafDemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/managerStyle.css">
</head>
<body>
<div id="wrapper">
    <div class="overlay"></div>
    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper">
        <ul class="nav sidebar-nav">
            <li class="sidebar-brand">
                <a href="#"><i class="fa fa-cutlery"></i>菜品展示</a>
            </li>
            <li>
                <a href="#">湘菜</a>
            </li>
            <li>
                <a href="#">粤菜</a>
            </li>
            <li>
                <a href="#">闽菜</a>
            </li>
            <li>
                <a href="#">鲁菜</a>
            </li>
        </ul>
    </nav>
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container"  >
            <h3 style="text-align: center">每日推荐菜品</h3>
            <div class="row">
                <div id="myCarousel" class="carousel slide col-md-8" style="max-height: 600px">
                    <ol class="carousel-indicators" >
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner.jpg" alt="first slide" >
                            <div class="carousel-caption">烤羊排</div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner2.jpg" alt="second slide">
                            <div class="carousel-caption">凉拌西红柿</div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner3.jpg" alt="third slide">
                            <div class="carousel-caption">烘焙小蛋糕</div>
                        </div>
                    </div>
                    <a class="carousel-control left" href="#myCarousel"
                       data-slide="prev">&lsaquo;
                    </a>
                    <a class="carousel-control right" href="#myCarousel"
                       data-slide="next">&rsaquo;
                    </a>
                </div>
                <div class="col-md-4 alert alert-warning" style=" min-height:400px">
                    <div >
                        <p><span>菜品一:烤羊排</span></p>
                        <p><span>菜品二:凉拌西红柿</span></p>
                        <p><span>菜品三:烘焙小蛋糕</span></p>
                    </div>
                </div>
            </div>
            <div id="yue" >
                <ul>
                    <li>
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue1.jpg" alt="图片丢失" class="image-rounded" style="max-height: 500px;max-width: 500px">
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue2.jpg" alt="图片丢失" class="image-rounded" style="max-height: 500px;max-width: 500px">
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue3.jpg" alt="图片丢失" class="image-rounded" style="max-height: 500px;max-width: 500px">
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/userInterface.jpg)";
</script>
</html>
