<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">

    <c:choose>
        <c:when test="${hasOrdered}">
            <div>
                <table class="table">
                    <caption>订单号：${oId}</caption>
                    <thead>
                    <tr>
                        <th>菜品ID</th>
                        <th>名称</th>
                        <th>备注</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>状态</th>
                        <th>时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="orderFormItem" items="${orderFormItemList}">
                        <tr>
                            <th>${orderFormItem.dId}</th>
                            <th>${orderFormItem.name}</th>
                            <th>${orderFormItem.remark}</th>
                            <th>${orderFormItem.price}</th>
                            <th>${orderFormItem.number}</th>
                            <th>${orderFormItem.state}</th>
                            <th>${orderFormItem.orderTime}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <button class="btn btn-default">创建订单</button>
        </c:otherwise>
    </c:choose>



    <div>
        <h3>菜单</h3>
        <c:forEach var="dishGroup" items="${dishGroupList}">
            <table class="table">
                <caption>Group ID:${dishGroup.dgId} Group Name:${dishGroup.name}</caption>
                <thead>
                <tr>
                    <th>菜品ID</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>价格</th>
                    <th>售卖状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dish" items="${dishGroup.dishes}">
                    <c:if test="${dish.active>0}">
                        <tr>
                            <th>${dish.dId}</th>
                            <th>${dish.name}</th>
                            <th>${dish.description}</th>
                            <th>${dish.price}</th>
                            <th>${dish.status}</th>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>

</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/resources/js/.js" type="text/javascript"></script>
</html>
