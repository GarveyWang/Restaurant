<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐馆控制台</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/leafDemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/managerStyle.css">

</head>
<body>
<div id="wrapper">
    <div class="overlay"></div>

    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper">
        <ul class="nav sidebar-nav">
            <li class="sidebar-brand">
                <a href="#"><i class="fa fa-user-circle"></i>餐厅管理员</a>
            </li>
            <li>
                <a href="/restaurant/${rId}/admin/employee" ><i class="fa fa-user"></i> 员工账号管理</a>
            </li>
            <li>
                <a href="/restaurant/${rId}/admin/tablegroup"><i class="fa fa-table"></i> 餐桌信息管理</a>
            </li>
            <li>
                <a href="/kitchen/${rId}/dishgroup" type="button"><i class="fa fa-shopping-cart"></i> 菜单管理</a>
            </li>
        </ul>
    </nav>
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>

        <div class="container">
            <img  style="max-width: 1000px;max-height:800px" src="${pageContext.request.contextPath}/resources/images/map.png">
            <div class="row">
                <h3 style="color: white">风雨数十载，湘粤阁从零开始，只为您的满意</h3>
                <h3 style="color: white">遍布全国数十个省份，湘粤阁提供餐厅电子化的最佳解决方案</h3>
            </div>
        </div>
    </div>
</div>
</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"><\/script>')</script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script type="text/javascript">
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/3.jpg)";
    $(document).ready(function () {
        var trigger = $('.hamburger'),
            overlay = $('.overlay'),
            isClosed = false;

        trigger.click(function () {
            hamburger_cross();
        });

        function hamburger_cross() {

            if (isClosed == true) {
                overlay.hide();
                trigger.removeClass('is-open');
                trigger.addClass('is-closed');
                isClosed = false;
            } else {
                overlay.show();
                trigger.removeClass('is-closed');
                trigger.addClass('is-open');
                isClosed = true;
            }
        }

        $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');
        });
    });
</script>

</html>
