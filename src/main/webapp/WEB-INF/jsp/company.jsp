<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐厅介绍</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
</head>
<body>
<header>
    <div class="header-carousel container">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">

                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner.jpg" style="width:100%;" alt="First slide">
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner2.jpg" style="width:100%;" alt="Second slide">
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/resources/images/companyImages/banner3.jpg" style="width:100%;" alt="Third slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev"></a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next"></a>
        </div>

    </div>
</header>
<main class="main-first-bgcolor">
    <div>
        <div class="main-head">
            <p>
                <span>我们提供</span>
            </p>
        </div>
        <div class="main-we-provide">
            <ul>
                <li><span><img src="${pageContext.request.contextPath}/resources/images/companyImages/lunch.png" alt=""></span>
                    <h2>中餐</h2>
                    <p>舌尖上的湘粤阁，为您提供极致的美味和充足的营养，让您领略中华美食的魅力</p></li>
                <li><span><img src="${pageContext.request.contextPath}/resources/images/companyImages/dinner.png" alt=""></span>
                    <h2>晚餐</h2>
                    <p>走遍大江南北，看尽人情世故，一顿丰盛的晚宴，拂去您旅途的劳顿，为您接风洗尘</p></li>
                <li><span><img src="${pageContext.request.contextPath}/resources/images/companyImages/coffee.png" alt=""></span>
                    <h2>小食</h2>
                    <p>餐后餐后，需要小食的加入，才能够完美无瑕</p></li>
            </ul>
        </div>
    </div>

    <div>
        <div class="main-head">
            <p>
                <span>菜式欣赏</span>
            </p>
        </div>
    </div>
</main>

<main>
    <img class="mdbanner" src="${pageContext.request.contextPath}/resources/images/companyImages/mdbanner.jpg">
</main>
<main>
    <div class="main-body">
        <p style="background-color: darkgrey"><span>每一种食物来源都经过我们的精挑细选，关于食材我们只选最天然、健康、优质的，只为一份对极致美味的追求，用心做好每一份菜，是我们不变的宗旨。</span></p>
        <ul class="main-body-img">
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist1.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist2.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist3.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist4.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist5.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist6.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist7.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist8.jpg"></li>
            <li><img src="${pageContext.request.contextPath}/resources/images/companyImages/mdlist9.jpg"></li>
        </ul>
    </div>
</main>
<main>
    <ul class="main-submenu">
        <li><p>美味</p></li>
        <li><p>传统</p></li>
        <li><p>创新</p></li>
        <li><p>领先</p></li>
    </ul>
    <ul class="main-submenu-info main-submenu-first">
        <li><a href="#">
            <div class="food-name">
                <p>玫瑰香酥西兰花</p>
                <p>Rose fried broccoli</p>
            </div>
            <div class="food-price">
                <p>￥<span>25</span></p>
            </div>
            <div class="img-bg"></div>
            <img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist1.jpg"></a></li>
        <li><a href="#">
            <div class="food-name">
                <p>大闸蟹</p>
                <p>hairy crab</p>
            </div>
            <div class="food-price">
                <p>￥<span>25</span></p>
            </div>
            <div class="img-bg"></div>
            <img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist2.jpg"></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist3.jpg"></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist4.jpg"></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist5.jpg"></a></li>
        <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/companyImages/foodlist6.jpg"></a></li>
    </ul>
    <a class="more" href="#">MORE</a>
</main>
</body>
<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</html>