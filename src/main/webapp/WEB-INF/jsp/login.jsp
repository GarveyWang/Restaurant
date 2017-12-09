<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div>
        ${msg}
    </div>
    <form role="form" method="post" action="/restaurant/login">
        <div class="form-group">
            <label for="r_id">餐馆ID</label>
            <input type="text" class="form-control" id="r_id" name="rId" placeholder="请输入餐馆ID" value="${rId}">
            <label for="password">餐馆密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入餐馆密码">
        </div>
        <button type="submit" class="btn btn-default">登录</button>
    </form>
    <form role="form" method="get" action="/restaurant/register">
        <button type="submit" class="btn btn-default">注册</button>
    </form>
</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>