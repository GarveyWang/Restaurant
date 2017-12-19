<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职员账号管理</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">

    <div>${msg}</div>

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
            <button type="submit" class="btn btn-default">更新</button>
            <button type="button" id="cashier_update_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

    <table class="table">
        <caption>收银台</caption>
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
                <button wid="${cashier.cId}" wpwd="${cashier.password}" class="btn btn-default" id="cashier_update_btn">修改</button>
            </td>
        </tr>
        </tbody>
    </table>

    <form id="waiter_reg_form" role="form" method="post" action="/account/waiter/add">
        <div class="form-group form-inline">
            <label>服务员姓名
                <input type="text" class="form-control" name="name" placeholder="请输入服务员姓名" >
            </label>
            <label>服务员密码
                <input type="password" class="form-control" name="password" placeholder="请输入服务员密码">
            </label>
            <button type="submit" class="btn btn-default">新建</button>
            <button type="button" id="waiter_reg_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

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
            <button type="submit" class="btn btn-default">更新</button>
            <button type="button" id="waiter_update_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

    <table class="table">
        <caption>服务员列表
            <button class="btn btn-default" id="waiter_reg_form_open_btn">添加服务员账号</button>
        </caption>
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
                    <a href="/account/waiter/${waiter.wId}/delete" class="btn btn-default">删除</a>
                    <button wid="${waiter.wId}" wname="${waiter.name}" wpwd="${waiter.password}" wactive="${waiter.active}" class="btn btn-default waiter_update_btn">修改</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form id="kitchen_reg_form" role="form" method="post" action="/account/kitchen/add">
        <div class="form-group form-inline">
            <label>厨房名称
                <input type="text" class="form-control" name="name" placeholder="请输入厨房名称" >
            </label>
            <label>厨房密码
                <input type="password" class="form-control" name="password" placeholder="请输入厨房密码">
            </label>
            <button type="submit" class="btn btn-default">新建</button>
            <button type="button" id="kitchen_reg_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

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
            <button type="submit" class="btn btn-default">更新</button>
            <button type="button" id="kitchen_update_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

    <table class="table">
        <caption>厨房列表
            <button class="btn btn-default" id="kitchen_reg_form_open_btn">添加厨房账号</button>
        </caption>
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
                    <a href="/account/kitchen/${kitchen.kId}/delete" class="btn btn-default">删除</a>
                    <button kid="${kitchen.kId}" kname="${kitchen.name}" kpwd="${kitchen.password}" kactive="${kitchen.active}" class="btn btn-default kitchen_update_btn">修改</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>

<script type="text/javascript">
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
