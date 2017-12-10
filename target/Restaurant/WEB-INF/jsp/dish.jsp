<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <c:forEach var="dishGroup" items="${dishGroupList}">
        <table class="table">
            <caption>Group ID:${dishGroup.dgId} Group Name:${dishGroup.name}</caption>
            <thead>
                <tr>
                    <th>菜品ID</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>价格</th>
                    <th>成本</th>
                    <th>菜单状态</th>
                    <th>售卖状态</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dish" items="${dishGroup.dishes}">
                    <tr>
                        <th>${dish.dId}</th>
                        <th>${dish.name}</th>
                        <th>${dish.description}</th>
                        <th>${dish.price}</th>
                        <th>${dish.cost}</th>
                        <th>${dish.active}</th>
                        <th>${dish.status}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/resources/js/.js" type="text/javascript"></script>
</html>
