<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>厨房</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/leafDemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/managerStyle.css">
</head>
<body>
<div id="wrapper">
    <div class="overlay"></div>
    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper">
        <ul class="nav sidebar-nav">
            <li class="sidebar-brand">
                <a href="#"><i class="fa fa-home"></i>厨房</a>
            </li>
            <li>
                <a href="/kitchen/${rId}/dishgroup"><i class="fa fa-shopping-cart"></i> 菜单管理</a>
            </li>
        </ul>
    </nav>
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container" style="color: white">
            <div>${msg}</div>
            <div>
                <table class="table" style="color: white">
                    <caption>任务队列</caption>
                    <thead>
                    <tr>
                        <th>菜品ID</th>
                        <th>菜名</th>
                        <th>备注</th>
                        <th>点单数量</th>
                        <th>已上数量</th>
                        <th>餐桌组</th>
                        <th>餐桌名</th>
                        <th>请求时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${kitchenTaskItemList}">
                        <tr>
                            <td>${item.dId}</td>
                            <td>${item.dishName}</td>
                            <td>${item.remark}</td>
                            <td>${item.orderNumber}</td>
                            <td>${item.serveNumber}</td>
                            <td>${item.tableGroupName}</td>
                            <td>${item.tableName}</td>
                            <td>${item.orderTime}</td>
                            <td>${item.state}</td>
                            <td>
                                <c:if test="${item.state=='排队中'}">
                                    <button class="btn btn-default cook_btn" oid="${item.oId}" did="${item.dId}" >
                                        烹饪
                                    </button>
                                </c:if>
                                <c:if test="${item.state=='正在烹饪'}">
                                    <button class="btn btn-default serve_btn" oid="${item.oId}" did="${item.dId}">
                                        上菜
                                    </button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/3.jpg)";
   $(function () {
        $('.cook_btn').click(function () {
            alert(2);
            var oid=$(this).attr('oid');
            var did=$(this).attr('did');
            var action='/kitchen/'+ oid + '/' + did + '/cook';
            var form = $('<form></form>');
            form.attr('action', action);
            form.attr('method', 'post');
            form.attr('target', '_self');
            var oIdInput = $('<input type="text" name="oId" />');
            oIdInput.attr('value',oid);
            var dIdInput = $('<input type="text" name="dId" />');
            dIdInput.attr('value',did);
            form.append(oIdInput);
            form.append(dIdInput);
            form.appendTo("body").submit();
            form.remove();
            return false;
        })
        $('.serve_btn').click(function () {
            var oid=$(this).attr('oid');
            var did=$(this).attr('did');
            var action='/kitchen/'+ oid + '/' + did + '/serve';
            var form = $('<form></form>');
            form.attr('action', action);
            form.attr('method', 'post');
            form.attr('target', '_self');
            var oIdInput = $('<input type="text" name="oId" />');
            oIdInput.attr('value',oid);
            var dIdInput = $('<input type="text" name="dId" />');
            dIdInput.attr('value',did);
            form.append(oIdInput);
            form.append(dIdInput);
            form.appendTo("body").submit();
            form.remove();
            return false;
        })
    })
</script>
<%@include file="common/foot.jsp"%>
</html>
