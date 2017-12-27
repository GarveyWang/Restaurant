<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<html>
<head>
    <title>顾客登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body background="${pageContext.request.contextPath}/resources/images/2.jpg">
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>欢迎来到湘粤阁</h1>
                    <div class="description">
                        <p>湘粤阁，中国餐饮业领导者</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-8 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>登录</h3>
                            <p>请输入您的餐桌ID和服务员给您的服务码</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" method="post" action="/customer/login">
                            <div class="form-group">
                                <label>餐桌ID</label>
                                <input type="text" class="form-control" name="tId" placeholder="请输入餐桌ID" value="${tId}">
                            </div>
                            <div class="form-group">
                                <label>餐桌服务码</label>
                                <input type="password" class="form-control" name="serviceCode" placeholder="请输入餐桌服务码" value="${serviceCode}">
                            </div>
                            <button type="submit" class="btn btn-success">进入点单</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>

</html>