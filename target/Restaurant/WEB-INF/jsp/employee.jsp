<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>t</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    
    <table class="table">
        <caption>收银台</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>密码</th>
            <th>账号状态</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${cashier.cId}</td>
            <td>${cashier.password}</td>
            <td>${cashier.active}</td>
        </tr>
        </tbody>
    </table>

    <table class="table">
        <caption>服务员列表</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>账号状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="waiter" items="${waiterList}">
            <tr>
                <td>${waiter.wId}</td>
                <td>${waiter.name}</td>
                <td>${waiter.password}</td>
                <td>${waiter.active}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table class="table">
        <caption>厨房列表</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>密码</th>
            <th>账号状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="kitchen" items="${kitchenList}">
            <tr>
                <td>${kitchen.kId}</td>
                <td>${kitchen.name}</td>
                <td>${kitchen.password}</td>
                <td>${kitchen.active}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/resources/js/.js" type="text/javascript"></script>
</html>
