<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐馆控制台</title>
    <%@include file="common/head.jsp"%>
</head>
<body>

<div class="btn-group">
    <a href="/restaurant/${rId}/employee" type="button" class="btn btn-default">员工账号管理</a>
    <a href="/restaurant/${rId}/tablegroup" type="button" class="btn btn-default">餐桌信息管理</a>
    <a href="/restaurant/${rId}/dishgroup" type="button" class="btn btn-default">菜单管理</a>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>
