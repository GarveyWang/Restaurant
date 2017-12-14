<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <div>${msg}</div>

    <form id="order_dish_update_form" role="form" method="post">
        <div class="form-group form-inline">
            <label>菜名
                <input type="text" id="d_name" class="form-control" disabled="disabled">
            </label>
            <label>菜品ID
                <input type="text" id="d_id" class="form-control" name="dId" disabled="disabled">
            </label>
            <label>备注
                <input type="text" id="remark" class="form-control" name="remark" placeholder="请输入菜品组名称" >
            </label>
            <label>已点数量
                <select id="order_number" class="form-control" name="orderNumber">
                    <c:forEach var="i" begin="1" end="20">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </label>
            <button type="submit" class="btn btn-default">更新</button>
            <button type="button" id="order_dish_update_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

    <div>
        <table class="table">
            <caption>订单号：${oId} &nbsp; &nbsp; 总价： ${totalPrice}</caption>
            <thead>
            <tr>
                <th>菜品ID</th>
                <th>名称</th>
                <th>备注</th>
                <th>价格</th>
                <th>已点数量</th>
                <th>已上数量</th>
                <th>状态</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${orderFormItemList}">
                <tr>
                    <td>${item.dId}</td>
                    <td>${item.name}</td>
                    <td>${item.remark}</td>
                    <td>${item.price}</td>
                    <td>${item.orderNumber}</td>
                    <td>${item.serveNumber}</td>
                    <td>${item.state}</td>
                    <td>${item.orderTime}</td>
                    <td>
                        <a href="/customer/orderdish/${item.dId}/delete" class="btn btn-default">删除</a>
                        <button class="btn btn-default order_dish_update_form_open_btn"
                                did="${item.dId}" remark="${item.remark}" ordernumber="${item.orderNumber}"
                                servenumber="${item.serveNumber}" dname="${item.name}">
                            修改
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



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
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dish" items="${dishGroup.dishes}">
                    <c:if test="${dish.active>0}">
                        <tr>
                            <td>${dish.dId}</td>
                            <td>${dish.name}</td>
                            <td>${dish.description}</td>
                            <td>${dish.price}</td>
                            <td>${dish.status}</td>
                            <td>
                                <div class="form-group form-inline">
                                    <label>备注
                                        <input type="text" id="remark_${dish.dId}" class="form-control" placeholder="备注">
                                    </label>
                                    <label>数量
                                        <select name="dgId" id="order_number_${dish.dId}" class="form-control">
                                            <c:forEach var="i" begin="1" end="20">
                                                <option value="${i}">${i}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                    <button class="btn btn-default add_dish_btn" did="${dish.dId}" >
                                        添加
                                    </button>
                                </div>
                            </td>
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

<script type="text/javascript">
    $(function () {
        $('#order_dish_update_form').hide();

        $('.order_dish_update_form_open_btn').click(function () {
            $('#order_dish_update_form').show();

            $('#order_number').val($(this).attr("ordernumber"));
            $('#serve_number').val($(this).attr("servenumber"));
            $('#remark').val($(this).attr("remark"));
            $('#d_id').val($(this).attr("did"));
            $('#d_name').val($(this).attr("dname"));

            var action = "/customer/orderdish/"+$(this).attr("did")+"/update";
            $('#order_dish_update_form').attr("action",action);
        })

        $('#order_dish_update_form_close_btn').click(function () {
            $('#order_dish_update_form').hide();
        })

        $('.add_dish_btn').click(function () {
            var did=$(this).attr('did');
            var orderNumber=$('#order_number_'+did).val();
            var remark=$('#remark_'+did).val();
            var action='/customer/orderdish/'+did+'/add';
            var form = $('<form></form>');

            form.attr('action', action);
            form.attr('method', 'post');
            form.attr('target', '_self');

            var orderNumberInput = $('<input type="text" name="orderNumber" />');
            orderNumberInput.attr('value',orderNumber);
            var remarkInput = $('<input type="text" name="remark" />');
            remarkInput.attr('value',remark);

            form.append(orderNumberInput);
            form.append(remarkInput);

            form.appendTo("body").submit();
            form.remove();
            // 注意return false取消链接的默认动作
            return false;
        })
    })
</script>
</html>
