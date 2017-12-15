<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐桌情况</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <div>${msg}</div>
    <c:if test="${role=='admin'}">
        <div class="btn-group">
            <button class="btn btn-default" id="table_group_reg_form_open_btn">添加餐桌组</button>
            <c:if test="${tableGroupList.size()!=0}">
                <button class="btn btn-default" id="table_reg_form_open_btn">添加餐桌</button>
            </c:if>
        </div>

        <form id="table_group_reg_form" role="form" method="post" action="/table/group/add">
            <div class="form-group form-inline">
                <label>餐桌组名称
                    <input type="text" class="form-control" name="name" placeholder="请输入餐桌组名称" value="餐桌组${tableGroupList.size()+1}" >
                </label>
                <button type="submit" class="btn btn-default">新建</button>
                <button type="button" id="table_group_reg_form_close_btn" class="btn btn-default">关闭</button>
            </div>
        </form>

        <form id="table_group_update_form" role="form" method="post">
            <div class="form-group form-inline">
                <label>餐桌组ID
                    <input type="text" id="tg_id" class="form-control" name="tgId" disabled="disabled">
                </label>
                <label>餐桌组名称
                    <input type="text" id="tg_name" class="form-control" name="name" placeholder="请输入餐桌组名称" >
                </label>
                <button type="submit" class="btn btn-default">更新</button>
                <button type="button" id="table_group_update_form_close_btn" class="btn btn-default">关闭</button>
            </div>
        </form>

        <form id="table_reg_form" role="form" method="post" action="/table/add">
            <div class="form-group form-inline">
                <label>餐桌组ID
                    <select name="tgId" class="form-control">
                        <c:forEach var="tableGroup" items="${tableGroupList}">
                            <option value="${tableGroup.tgId}">${tableGroup.name}(${tableGroup.tgId})</option>
                        </c:forEach>
                    </select>
                </label>
                <label>餐桌名称
                    <input type="text" class="form-control" name="name" placeholder="请输入餐桌名称" value="餐桌${tableCount+1}" >
                </label>
                <label>描述
                    <input type="text" class="form-control" name="description" placeholder="请输入餐桌描述"  >
                </label>
                <label>容量
                    <select name="capacity" class="form-control">
                        <c:forEach var="i" begin="1" end="20">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </label>
                <button type="submit" class="btn btn-default">新建</button>
                <button type="button" id="table_reg_form_close_btn" class="btn btn-default">关闭</button>
            </div>
        </form>

        <form id="table_update_form" role="form" method="post">
            <div class="form-group form-inline">
                <label>餐桌ID
                    <input type="text" id="table_update_t_id" class="form-control" name="tId" disabled="disabled">
                </label>
                <label>餐桌组ID
                    <select name="tgId" id="table_update_tg_id" class="form-control">
                        <c:forEach var="tableGroup" items="${tableGroupList}">
                            <option value="${tableGroup.tgId}">${tableGroup.name}(${tableGroup.tgId})</option>
                        </c:forEach>
                    </select>
                </label>
                <label>餐桌名称
                    <input type="text" id="table_update_name" class="form-control" name="name" placeholder="请输入餐桌名称"  >
                </label>
                <label>描述
                    <input type="text" id="table_update_desc" class="form-control" name="description" placeholder="请输入餐桌描述"  >
                </label>
                <label>容量
                    <select name="capacity" id="table_update_capacity" class="form-control">
                        <c:forEach var="i" begin="1" end="20">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </label>
                <label>顾客数
                    <select name="guestNumber" id="table_update_guest_number" class="form-control">
                        <c:forEach var="i" begin="0" end="20">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </label>
                <label>服务码
                    <input type="text" id="table_update_service_code" class="form-control" name="serviceCode" placeholder="请输入服务码"  >
                </label>
                <label>状态
                    <select name="status" id="table_update_status" class="form-control">
                        <option value="有客">有客</option>
                        <option value="空闲">空闲</option>
                    </select>
                </label>
                <button type="submit" class="btn btn-default">更新</button>
                <button type="button" id="table_update_form_close_btn" class="btn btn-default">关闭</button>
            </div>
        </form>

    </c:if>

    <form id="guest_update_form" role="form" method="post">
        <div class="form-group form-inline">
            <label>餐桌ID
                <input type="text" id="guest_update_t_id" class="form-control" name="tId" disabled="disabled">
            </label>
            <label>餐桌组ID
                <input type="text" id="guest_update_tg_id" class="form-control" name="tgId" disabled="disabled">
            </label>
            <label>餐桌名称
                <input type="text" id="guest_update_name" class="form-control" name="name" disabled="disabled" >
            </label>
            <label>容量
                <input type="text" id="guest_update_capacity" class="form-control" name="capacity" disabled="disabled" >
            </label>
            <label>顾客数
                <select name="guestNumber" id="guest_update_guest_number" class="form-control">
                    <c:forEach var="i" begin="0" end="20">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </label>
            <label>服务码
                <input type="text" id="guest_update_service_code" class="form-control" name="serviceCode" placeholder="请输入服务码"  >
            </label>
            <button type="submit" class="btn btn-default">更新</button>
            <button type="button" id="guest_update_form_close_btn" class="btn btn-default">关闭</button>
        </div>
    </form>

    <c:forEach var="tableGroup" items="${tableGroupList}">

        <table class="table">
            <caption>餐桌组ID:${tableGroup.tgId} &nbsp;&nbsp; 餐桌组名:${tableGroup.name}&nbsp;&nbsp;
                <c:if test="${role=='admin'}">
                    <a class="btn btn-default" href="/table/group/${tableGroup.tgId}/delete">删除</a>
                    <button class="btn btn-default table_group_update_form_open_btn" tgId="${tableGroup.tgId}" tgName="${tableGroup.name}">更新</button>
                </c:if>
                </caption>
            <thead>
                <tr>
                    <th>餐桌ID</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>容量</th>
                    <th>顾客数</th>
                    <th>服务码</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="table" items="${tableGroup.diningTables}">
                    <tr>
                        <td>${table.tId}</td>
                        <td>${table.name}</td>
                        <td>${table.description}</td>
                        <td>${table.capacity}</td>
                        <td>${table.guestNumber}</td>
                        <td>${table.serviceCode}</td>
                        <td>${table.status}</td>
                        <td>
                            <c:if test="${role=='admin'}">
                                <a class="btn btn-default" href="/table/${table.tId}/delete">删除</a>
                                <button class="btn btn-default table_update_form_open_btn" tId="${table.tId}" tgId="${table.tgId}"
                                        name="${table.name}" desc="${table.description}" capacity="${table.capacity}"
                                        guestnumber="${table.guestNumber}" servicecode="${table.serviceCode}" status="${table.status}">更新</button>
                            </c:if>
                            <button class="btn btn-default guest_update_form_open_btn" tId="${table.tId}" tgId="${table.tgId}"
                                    name="${table.name}" capacity="${table.capacity}"
                                    guestnumber="${table.guestNumber}" servicecode="${table.serviceCode}" status="${table.status}">更新顾客</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</div>

</body>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%@include file="common/foot.jsp"%>

<script type="text/javascript">
    $(function () {
        $('#table_group_reg_form').hide();
        $('#table_reg_form').hide();
        $('#table_group_update_form').hide();
        $('#table_update_form').hide();
        $('#guest_update_form').hide();


        $('#table_group_reg_form_open_btn').click(function () {
            $('#table_group_reg_form').show();
        })

        $('#table_group_reg_form_close_btn').click(function () {
            $('#table_group_reg_form').hide();
        })

        $('#table_reg_form_open_btn').click(function () {
            $("#table_reg_form").show();
        })

        $('#table_reg_form_close_btn').click(function () {
            $('#table_reg_form').hide();
        })

        $('.table_group_update_form_open_btn').click(function () {
            $('#table_group_update_form').show();
            $('#tg_id').val($(this).attr('tgid'));
            $('#tg_name').val($(this).attr('tgname'));

            var action="/table/group/"+$(this).attr('tgid')+"/update";
            $('#table_group_update_form').attr("action",action);
        })

        $('#table_group_update_form_close_btn').click(function () {
            $('#table_group_update_form').hide();
        })

        $('.table_update_form_open_btn').click(function () {
            $('#table_update_form').show();
            $('#table_update_t_id').val($(this).attr('tid'));
            $('#table_update_tg_id').val($(this).attr('tgid'));
            $('#table_update_desc').val($(this).attr('desc'));
            $('#table_update_name').val($(this).attr('name'));
            $('#table_update_capacity').val($(this).attr('capacity'));
            $('#table_update_guest_number').val($(this).attr('guestnumber'));
            $('#table_update_status').val($(this).attr('status'));
            $('#table_update_service_code').val($(this).attr('servicecode'));

            var action="/table/"+$(this).attr('tid')+"/update";
            $('#table_update_form').attr("action",action);
        })

        $('#table_update_form_close_btn').click(function () {
            $('#table_update_form').hide();
        })

        $('#guest_update_form_close_btn').click(function () {
            $('#guest_update_form').hide();
        })

        $('.guest_update_form_open_btn').click(function () {
            $('#guest_update_form').show();
            $('#guest_update_t_id').val($(this).attr('tid'));
            $('#guest_update_tg_id').val($(this).attr('tgid'));
            $('#guest_update_name').val($(this).attr('name'));
            $('#guest_update_capacity').val($(this).attr('capacity'));
            $('#guest_update_guest_number').val($(this).attr('guestnumber'));
            $('#guest_update_status').val($(this).attr('status'));
            $('#guest_update_service_code').val($(this).attr('servicecode'));

            var action="/table/"+$(this).attr('tid')+"/guest/update";
            $('#guest_update_form').attr("action",action);
        })
    })
</script>
</html>
