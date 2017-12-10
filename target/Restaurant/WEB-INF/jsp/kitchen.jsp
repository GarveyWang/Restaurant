<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>厨房</title>
    <%@include file="common/head.jsp"%>
</head>
<body>

<div class="container">
    <div class="btn-group">
        <a href="/restaurant/${rId}/dishgroup" type="button" class="btn btn-default">菜单管理</a>
    </div>
    <div>
        <table class="table">
            <caption>任务队列</caption>
            <thead>
            <tr>
                <th>菜品ID</th>
                <th>菜名</th>
                <th>备注</th>
                <th>数量</th>
                <th>餐桌组</th>
                <th>餐桌名</th>
                <th>请求时间</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${kitchenTaskItemList}">
                <tr>
                    <th>${item.dId}</th>
                    <th>${item.dishName}</th>
                    <th>${item.remark}</th>
                    <th>${item.number}</th>
                    <th>${item.tableGroupName}</th>
                    <th>${item.tableName}</th>
                    <th>${item.orderTime}</th>
                    <th>${item.state}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>
