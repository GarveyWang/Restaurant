<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐馆注册页面</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
    <div class="container">
        <div>
            ${msg}
        </div>
        <form role="form" method="post" action="/account/restaurant/add">
            <div class="form-group">
                <label for="r_id">餐馆ID</label>
                <input type="text" class="form-control" id="r_id" name="rId" placeholder="请输入餐馆ID" value="${restaurant.rId}">
                <label for="name">餐馆名称</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入餐馆名称" value="${restaurant.name}">
                <label for="password">餐馆密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入餐馆密码" value="${restaurant.password}">
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>


</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>

</html>
