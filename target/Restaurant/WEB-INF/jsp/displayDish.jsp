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
                <a href="#xiang">湘菜</a>
            </li>
            <li>
                <a href="#yue">粤菜</a>
            </li>
            <li>
                <a href="#min">闽菜</a>
            </li>
            <li>
                <a href="#lu">鲁菜</a>
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
                        <c:forEach varStatus="i" var="dish" items="${top5SoldDishList}">
                            <p><span>Top${i.index+1}: ${dish.dishName}</span></p>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <h3 align="center" style="color: #f7e1b5">湘菜</h3>
            <div class="row" id="xiang">
                <div class="col-md-4 ">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/xiang1.jpg" alt="图片丢失"  >
                        <div class="caption">
                            <p>红辣椒炒牛肉</p>
                            <p>滋补养元的居家旅行必备之物</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 ">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/xiang2.jpg" alt="图片丢失" >
                        <div class="caption">
                            <p>香辣鸡爪</p>
                            <p>大补之物</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/xiang3.jpg" alt="图片丢失">
                        <div class="caption">
                            <p>香辣羊排</p>
                            <p>维吾尔族的秘密</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/xiang4.jpg" alt="图片丢失">
                        <div class="caption">
                            <p>铁板什菌</p>
                            <p>菌类</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/xiang5.jpg" alt="图片丢失">
                        <div class="caption">
                            <p>湘西小炒肉</p>
                            <p>家常菜</p>
                        </div>
                    </div>
                </div>
            </div>
            <h3 align="center" style="color: #f7e1b5">粤菜</h3>
            <div class="row" id="yue">
                <div class="col-md-4 ">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue1.jpg" alt="图片丢失"  >
                        <div class="caption">
                            <p>葱油鸡</p>
                            <p>滋补养元的居家旅行必备之物</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 ">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue2.jpg" alt="图片丢失" >
                        <div class="caption">
                            <p>冰镇鲍鱼</p>
                            <p>大补之物</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/yue3.jpg" alt="图片丢失">
                        <div class="caption">
                            <p>沙拉银鳕鱼</p>
                            <p>海鲜</p>
                        </div>
                    </div>
                </div>
            </div>
            <h3 align="center" style="color: #f7e1b5">闽菜</h3>
            <div class="row" id="min">
                <div class="col-md-4 ">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min1.jpg" alt="图片丢失"  >
                        <div class="caption">
                            <p>山茶油炖栗子</p>
                            <p>滋补养元的居家旅行必备之物</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min2.jpg " alt="">
                        <div class="caption">
                            <p>蛤蜊蒸蛋</p>
                            <p>海鲜和鸡蛋的完美交融</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min3.jpg " alt="">
                        <div class="caption">
                            <p>佛跳墙</p>
                            <p>视觉与味觉的盛宴</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min4.jpg " alt="">
                        <div class="caption">
                            <p>黄椒炒肉片</p>
                            <p>家常小炒</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min5.jpg " alt="">
                        <div class="caption">
                            <p>椒盐凤尾虾</p>
                            <p>海鲜</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/min6.jpg " alt="">
                        <div class="caption">
                            <p>荔枝肉</p>
                            <p>饭后甜点</p>
                        </div>
                    </div>
                </div>
            </div>
            <h3 align="center" style="color: #f7e1b5">鲁菜</h3>
            <div class="row" id="lu">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu1.jpg " alt="">
                        <div class="caption">
                            <p>把子肉</p>
                            <p>经典菜肴</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu2.jpg " alt="">
                        <div class="caption">
                            <p>葱烧海参</p>
                            <p>海鲜</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu3.jpg " alt="">
                        <div class="caption">
                            <p>芙蓉鸡片</p>
                            <p>家常小炒</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu4.jpg " alt="">
                        <div class="caption">
                            <p>极品海蜇头</p>
                            <p>海鲜</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu5.jpg " alt="">
                        <div class="caption">
                            <p>九转大肠</p>
                            <p>家常菜肴</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"><div class="thumbnail">
                    <img src="${pageContext.request.contextPath}/resources/images/companyImages/lu6.jpg " alt="">
                    <div class="caption">
                        <p>砂锅牛尾</p>
                        <p>精美小炒</p>
                    </div>
                </div>
                </div>
            </div>
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
