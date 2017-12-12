<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银台</title>
    <%@include file="common/head.jsp"%>
</head>
<body>

<div class="container">
    <div>
        ${msg}
    </div>
    收银台
    <div>
        <table class="table">
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
                        <button class="btn btn-default end_btn" oid="${item.oId}">
                            结束
                        </button>
                    </td>
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

<script type="text/javascript">
    $(function () {
        $('.end_btn').click(function () {
            var oid=$(this).attr('oid');
            var action='/cashier/'+ oid +'/end';
            var form = $('<form></form>');

            form.attr('action', action);
            form.attr('method', 'post');
            form.attr('target', '_self');

            var oIdInput = $('<input type="text" name="oId" />');
            oIdInput.attr('value',oid);

            form.append(oIdInput);

            form.appendTo("body").submit();
            form.remove();
            return false;
        })
    })
</script>

</html>
