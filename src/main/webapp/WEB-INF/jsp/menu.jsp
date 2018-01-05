<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
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
                <a href="#"><i class="fa fa-user"></i>顾客</a>
            </li>
            <li>
                <a href="#" data-toggle="modal" data-target="#showOrder">显示订单</a>
            </li>
            <li>
                <a href="/customer/displayDish">菜品展示</a>
            </li>
            <li>
                <a href="/customer/company">公司概况</a>
            </li>
        </ul>
    </nav>
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container" >
            <div>
                <h3 align="center" style="color: #f7e1b5">菜单</h3>
                <c:forEach var="dishGroup" items="${dishGroupList}">
                    <table class="table" style="color: white">
                        <caption style="color: #f7e1b5">Group ID:${dishGroup.dgId} Group Name:${dishGroup.name}</caption>
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
                                    <td>
                                        <c:if test="${dish.status==1}">正常销售</c:if>
                                        <c:if test="${dish.status==0}">售罄</c:if>
                                    </td>
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
                                            <button class="btn btn-primary add_dish_btn" did="${dish.dId}" >
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
    </div>
</div>
<div class="modal fade " id="showOrder">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body">
                <div>
                    <table class="table">
                        <caption style="color: white">订单号：${oId} &nbsp; &nbsp; 总价： ${totalPrice}</caption>
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
                                    <button class="btn btn-primary order_dish_update_form_open_btn"
                                            did="${item.dId}" remark="${item.remark}" ordernumber="${item.orderNumber}"
                                            servenumber="${item.serveNumber}" dname="${item.name}" score="${item.score}"
                                            data-toggle="modal" data-target="#updateOrder">
                                        修改
                                    </button>
                                    <a href="/customer/orderdish/${item.dId}/delete" class="btn btn-warning" data-dismiss="modal">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="center">
                    <button class="btn btn-info" data-dismiss="modal" >退出</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateOrder">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="order_dish_update_form" role="form" method="post">
                    <div class="form-group form-inline">
                        <label>菜名
                            <input type="text" id="d_name" class="form-control" disabled="disabled">
                        </label>
                        <label>菜品ID
                            <input type="text" id="d_id" class="form-control" name="dId" disabled="disabled">
                        </label>
                        <label>备注
                            <input type="text" id="remark" class="form-control" name="remark" placeholder="请输入备注" >
                        </label>
                        <label>已点数量
                            <select id="order_number" class="form-control" name="orderNumber">
                                <c:forEach var="i" begin="1" end="20">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label>评分
                            <select id="score" class="form-control" name="score">
                                <c:forEach var="i" begin="1" end="5">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-success">更新</button>
                        <button type="button" id="order_dish_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
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
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/userInterface.jpg)";
    $(function () {
        $('#order_dish_update_form').hide();
        $('.order_dish_update_form_open_btn').click(function () {
            $('#order_dish_update_form').show();
            $('#order_number').val($(this).attr("ordernumber"));
            $('#serve_number').val($(this).attr("servenumber"));
            $('#remark').val($(this).attr("remark"));
            $('#d_id').val($(this).attr("did"));
            $('#d_name').val($(this).attr("dname"));
            $('#score').val($(this).attr("score"));
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
