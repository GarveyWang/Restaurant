<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>t</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <c:forEach var="tableGroup" items="${tableGroupList}">
        <table class="table">
            <caption>Group ID:${tableGroup.tgId} Group Name:${tableGroup.name}</caption>
            <thead>
                <tr>
                    <th>餐桌ID</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>容量</th>
                    <th>顾客数</th>
                    <th>服务码</th>
                    <th>状态</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="diningTable" items="${tableGroup.diningTables}">
                    <tr>
                        <th>${diningTable.tId}</th>
                        <th>${diningTable.name}</th>
                        <th>${diningTable.description}</th>
                        <th>${diningTable.capacity}</th>
                        <th>${diningTable.guestNumber}</th>
                        <th>${diningTable.serviceCode}</th>
                        <th>${diningTable.status}</th>
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
