<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
    <div>
        ${msg}
    </div>
    <form role="form" method="post" action="/account/waiterlogin">
        <div class="form-group">
            <label>服务员ID
                <input type="text" class="form-control" name="wId" placeholder="请输入服务员ID" value="${wId}">
            </label>
            <label>服务员密码
                <input type="password" class="form-control" name="password" placeholder="请输入服务员密码">
            </label>
        </div>
        <button type="submit" class="btn btn-default">服务员登录</button>
    </form>

    <form role="form" method="post" action="/account/kitchenlogin">
        <div class="form-group">
            <label>厨房ID
                <input type="text" class="form-control" name="kId" placeholder="请输入厨房ID" value="${kId}">
            </label>
            <label>厨房密码
                <input type="password" class="form-control" name="password" placeholder="请输入厨房密码">
            </label>
        </div>
        <button type="submit" class="btn btn-default">厨房登录</button>
    </form>

    <form role="form" method="post" action="/account/cashierlogin">
        <div class="form-group">
            <label>收银台ID
                <input type="text" class="form-control" name="cId" placeholder="请输入收银台ID" value="${cId}">
            </label>
            <label>收银台密码
                <input type="password" class="form-control" name="password" placeholder="请输入收银台密码">
            </label>
        </div>
        <button type="submit" class="btn btn-default">收银台登录</button>
    </form>

    <form role="form" method="post" action="/account/adminlogin">
        <div class="form-group">
            <label>餐馆ID
                <input type="text" class="form-control"  name="rId" placeholder="请输入餐馆ID" value="${rId}">
            </label>
            <label>餐馆密码
                <input type="password" class="form-control" name="password" placeholder="请输入餐馆密码">
            </label>
        </div>
        <button type="submit" class="btn btn-default">管理员登录</button>
    </form>
    <form role="form" method="get" action="/account/restreg">
        <button type="submit" class="btn btn-default">注册</button>
    </form>
</div>
</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>

</html>