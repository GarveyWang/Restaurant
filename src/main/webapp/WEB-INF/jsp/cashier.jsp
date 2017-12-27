<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银台</title>
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
                <a href="#"><i class="fa fa-money"></i>收银台</a>
            </li>
        </ul>
    </nav>
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container">
            <table class="table" style="color: white">
                <caption>未结束订单</caption>
                <thead>
                <tr>
                    <th>订单ID</th>
                    <th>餐桌号</th>
                    <th>总价</th>
                    <th>折扣</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${currentOrderFormList}">
                    <tr>
                        <td>${item.oId}</td>
                        <td>${item.tId}</td>
                        <td>${item.totalPrice}</td>
                        <td>${item.discount}</td>
                        <td>
                            <button class="btn btn-success end_btn" oid="${item.oId}" tid="${item.tId}">
                                结束
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    $(function () {
        $('.end_btn').click(function () {
            var oid=$(this).attr('oid');
            var tid=$(this).attr('tid');
            var action='/cashier/'+ oid +'/end';
            var form = $('<form></form>');


            form.attr('action', action);
            form.attr('method', 'post');
            form.attr('target', '_self');

            var oIdInput = $('<input type="text" name="oId" />');
            var tIdInput = $('<input type="text" name="tId" />')
            oIdInput.attr('value',oid);
            tIdInput.attr('value',tid);
            form.append(oIdInput);
            form.append(tIdInput);

            form.appendTo("body").submit();
            form.remove();
            return false;
        })
    })
</script>
<script>
    $(function () {
        <c:if test="${msg!=null}">
        alert("${msg}");
        </c:if>
    })
</script>
</html>
