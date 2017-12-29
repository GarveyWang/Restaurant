<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职员账号管理</title>
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
                <a href="#"><i class="fa fa-user"></i>职员账号管理</a>
            </li>

            <li>
                <a href="#" id="waiter_reg_form_open_btn" data-toggle="modal" data-target="#addWaiter">添加服务员账号</a>
            </li>
            <li>
                <a href="#" id="kitchen_reg_form_open_btn" data-toggle="modal" data-target="#addKitchen">添加厨房账号</a>
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

            <table class="table" style="color: white">
                <caption style="color: #f7e1b5">收银台</caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>密码</th>
                    <th>账号状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${cashier.cId}</td>
                    <td>${cashier.password}</td>
                    <td>${cashier.active}</td>
                    <td>
                        <button wid="${cashier.cId}" wpwd="${cashier.password}" class="btn btn-primary" id="cashier_update_btn" data-toggle="modal"
                        data-target="#updateCashier">修改</button>
                    </td>
                </tr>
                </tbody>
            </table>

            <table class="table" style="color:white;">
                <caption style="color: #f7e1b5">服务员列表</caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>账号状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="waiter" items="${waiterList}">
                    <tr>
                        <td>${waiter.wId}</td>
                        <td>${waiter.name}</td>
                        <td>${waiter.password}</td>
                        <td>${waiter.active}</td>
                        <td>
                            <button wid="${waiter.wId}" wname="${waiter.name}" wpwd="${waiter.password}" wactive="${waiter.active}" class="btn btn-primary waiter_update_btn"
                            data-toggle="modal" data-target="#updateWaiter">修改</button>
                            <a href="/account/waiter/${waiter.wId}/delete" class="btn btn-warning">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <table class="table" style="color:white;">
                <caption style="color: #f7e1b5">厨房列表</caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>密码</th>
                    <th>账号状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="kitchen" items="${kitchenList}">
                    <tr>
                        <td>${kitchen.kId}</td>
                        <td>${kitchen.name}</td>
                        <td>${kitchen.password}</td>
                        <td>${kitchen.active}</td>
                        <td>
                            <button kid="${kitchen.kId}" kname="${kitchen.name}" kpwd="${kitchen.password}" kactive="${kitchen.active}" class="btn btn-primary kitchen_update_btn"
                            data-toggle="modal" data-target="#updateKitchen">修改</button>
                            <a href="/account/kitchen/${kitchen.kId}/delete" class="btn btn-warning">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<div class="modal fade" id="updateKitchen">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="kitchen_update_form" role="form" method="post">
                    <div class="form-group form-inline">
                        <label>厨房ID
                            <input id="kitchen_id" type="text" class="form-control" name="wId" disabled="disabled">
                        </label>
                        <label>厨房名称
                            <input id="kitchen_name" type="text" class="form-control" name="name" placeholder="请输入厨房名称" >
                        </label>
                        <label>厨房密码
                            <input id="kitchen_pwd" type="text" class="form-control" name="password" placeholder="请输入厨房密码">
                        </label>
                        <label>账号状态
                            <select id="kitchen_active" name="active" class="form-control">
                                <option>1</option>
                                <option>0</option>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-primary">更新</button>
                        <button type="button" id="kitchen_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateWaiter">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="waiter_update_form" role="form" method="post">
                    <div class="form-group form-inline">
                        <label>服务员ID
                            <input id="waiter_id" type="text" class="form-control" name="wId" disabled="disabled">
                        </label>
                        <label>服务员姓名
                            <input id="waiter_name" type="text" class="form-control" name="name" placeholder="请输入服务员姓名" >
                        </label>
                        <label>服务员密码
                            <input id="waiter_pwd" type="text" class="form-control" name="password" placeholder="请输入服务员密码">
                        </label>
                        <label>账号状态
                            <select id="waiter_active" name="active" class="form-control">
                                <option>1</option>
                                <option>0</option>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-primary">更新</button>
                        <button type="button" id="waiter_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateCashier">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="cashier_update_form" role="form" method="post" action="/account/cashier/${cashier.cId}/update">
                    <div class="form-group form-inline">
                        <label>收银台ID
                            <input id="cashier_id" type="text" class="form-control" name="kId" disabled="disabled" value="${cashier.cId}">
                        </label>
                        <label>收银台密码
                            <input id="cashier_pwd" type="text" class="form-control" name="password" placeholder="请输入收银台密码" value="${cashier.password}">
                        </label>
                        <label>账号状态
                            <select id="cashier_active" name="active" class="form-control">
                                <option>1</option>
                                <option>0</option>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-primary">更新</button>
                        <button type="button" id="cashier_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addKitchen">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="kitchen_reg_form" role="form" method="post" action="/account/kitchen/add">
                    <div class="form-group form-inline">
                        <label>厨房的名称
                            <input type="text" class="form-control" name="name" placeholder="请输入厨房名称" >
                        </label>
                        <label>厨房的密码
                            <input type="password" class="form-control" name="password" placeholder="请输入厨房的密码">
                        </label>
                        <button type="submit" class="btn btn-info">新建</button>
                        <button type="button" id="kitchen_reg_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addWaiter">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="waiter_reg_form" role="form" method="post" action="/account/waiter/add">
                    <div class="form-group form-inline">
                        <label>服务员姓名
                            <input type="text" class="form-control" name="name" placeholder="请输入服务员姓名" >
                        </label>
                        <label>服务员密码
                            <input type="password" class="form-control" name="password" placeholder="请输入服务员密码">
                        </label>
                        <button type="submit" class="btn btn-info">新建</button>
                        <button type="button" id="waiter_reg_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
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
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/1.jpg)";
    $(function(){
        $('#kitchen_reg_form').hide();
        $('#waiter_reg_form').hide();

        $('#kitchen_update_form').hide();
        $('#waiter_update_form').hide();
        $('#cashier_update_form').hide();


        $('#cashier_update_btn').click(function () {
            $('#cashier_update_form').show();
        })

        $('#cashier_update_form_close_btn').click(function () {
            $('#cashier_update_form').hide();
        })


        $('#waiter_reg_form_open_btn').click(function(){
            $('#waiter_reg_form').show();
            $(this).hide();
        })

        $('#waiter_reg_form_close_btn').click(function () {
            $('#waiter_reg_form_open_btn').show();
            $('#waiter_reg_form').hide();
        })

        $('.waiter_update_btn').click(function () {
            if($('#waiter_update_form').is(':hidden')){
                $('#waiter_update_form').show();
            }
            $('#waiter_id').val($(this).attr('wid'));
            $('#waiter_name').val($(this).attr('wname'));
            $('#waiter_pwd').val($(this).attr('wpwd'));
            var action="/account/waiter/"+$(this).attr('wid')+"/update";
            $('#waiter_update_form').attr('action',action)
        })

        $('#waiter_update_form_close_btn').click(function () {
            $('#waiter_update_form').hide();
        })


        $('#kitchen_reg_form_open_btn').click(function(){
            $('#kitchen_reg_form').show();
            $(this).hide();
        })

        $('#kitchen_reg_form_close_btn').click(function () {
            $('#kitchen_reg_form_open_btn').show();
            $('#kitchen_reg_form').hide();
        })

        $('.kitchen_update_btn').click(function () {
            if($('#kitchen_update_form').is(':hidden')){
                $('#kitchen_update_form').show();
            }
            $('#kitchen_id').val($(this).attr('kid'));
            $('#kitchen_name').val($(this).attr('kname'));
            $('#kitchen_pwd').val($(this).attr('kpwd'));
            var action="/account/kitchen/"+$(this).attr('kid')+"/update";
            $('#kitchen_update_form').attr('action',action)
        })

        $('#kitchen_update_form_close_btn').click(function () {
            $('#kitchen_update_form').hide();
        })

    })
</script>

</html>
