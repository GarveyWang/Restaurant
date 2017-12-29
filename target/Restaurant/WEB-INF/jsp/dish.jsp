<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
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
                <a href="#"><i class="fa fa-cutlery"></i>菜品管理</a>
            </li>
            <li>
                <a href="#" id="dish_group_reg_form_open_btn" data-toggle="modal" data-target="#addDishGroup">添加菜品组</a>
            </li>
            <li>
                <c:if test="${dishGroupList.size()!=0}">
                    <a href="#" id="dish_reg_form_open_btn" data-toggle="modal" data-target="#addDish">添加菜品</a>
                </c:if>
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
            <h3 style="text-align: center;color: white">湘粤阁菜品管理</h3>
            <c:forEach var="dishGroup" items="${dishGroupList}">
                <table class="table" style="color: white">
                    <caption style="color: #f7e1b5">菜品组ID:${dishGroup.dgId} &nbsp;&nbsp; 菜品组名:${dishGroup.name}
                        <button class="btn btn-primary dish_group_update_form_open_btn" dgId="${dishGroup.dgId}" name="${dishGroup.name}"
                        data-toggle="modal" data-target="#updateDishGroup">
                            修改
                        </button>
                        <a href="/dish/group/${dishGroup.dgId}/delete" class="btn btn-warning">删除</a>
                    </caption>
                    <thead>
                    <tr>
                        <th>菜品ID</th>
                        <th>名称</th>
                        <th>描述</th>
                        <th>价格</th>
                        <th>成本</th>
                        <th>菜单状态</th>
                        <th>售卖状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dish" items="${dishGroup.dishes}">
                        <tr>
                            <td>${dish.dId}</td>
                            <td>${dish.name}</td>
                            <td>${dish.description}</td>
                            <td>${dish.price}</td>
                            <td>${dish.cost}</td>
                            <td>${dish.active}</td>
                            <td>${dish.status}</td>
                            <td>
                                <button class="btn btn-primary"id="dish_update_form_open_btn" did="${dish.dId}" dgid="${dish.dgId}"
                                        name="${dish.name}" desc="${dish.description}" price="${dish.price}" cost="${dish.cost}"
                                        active="${dish.active}" status="${dish.status}" data-toggle="modal" data-target="#updateDish">
                                    修改
                                </button>
                                <a href="/dish/${dish.dId}/delete" class="btn btn-warning">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </div>
</div>
<div class="modal fade" id="updateDishGroup" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="dish_group_update_form" role="form" method="post">
                    <div class="form-group form-inline">
                        <label>菜品组ID
                            <input type="text" id="dg_id" class="form-control" name="dgId" disabled="disabled">
                        </label>
                        <label>菜品组名称
                            <input type="text" id="dg_name" class="form-control" name="name" placeholder="请输入菜品组名称" >
                        </label>
                        <button type="submit" class="btn btn-primary">更新</button>
                        <button type="button" id="dish_group_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addDishGroup" tabindex="-1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="dish_group_reg_form" role="form" method="post" action="/dish/group/add">
                    <div class="form-group form-inline">
                        <label>菜品组名称
                            <input type="text" class="form-control" name="name" placeholder="请输入菜品组名称" value="菜品组${dishGroupList.size()+1}" >
                        </label>
                        <button type="submit" class="btn btn-info">新建</button>
                        <button type="button" id="dish_group_reg_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateDish" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form id="dish_update_form" role="form" method="post">
                    <div class="form-group form-inline">
                        <label>菜品ID
                            <input type="text" id="dish_update_d_id" class="form-control" name="dId" placeholder="请输入菜品ID" disabled="disabled" >
                        </label>
                        <label>菜品组ID
                            <select name="dgId" id="dish_update_dg_id" class="form-control">
                                <c:forEach var="dishGroup" items="${dishGroupList}">
                                    <option value="${dishGroup.dgId}">${dishGroup.name}(${dishGroup.dgId})</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label>菜品名称
                            <input type="text" id="dish_update_name" class="form-control" name="name" placeholder="请输入菜品名称" value="菜品${dishCount+1}" >
                        </label>
                        <label>描述
                            <input type="text" id="dish_update_desc" class="form-control" name="description" placeholder="请输入菜品描述"  >
                        </label>
                        <label>价格
                            <input type="text" id="dish_update_price" class="form-control" name="price" placeholder="请输入菜品价格"  >
                        </label>
                        <label>成本
                            <input type="text" id="dish_update_cost" class="form-control" name="cost" placeholder="请输入菜品成本"  >
                        </label>
                        <label>菜单状态
                            <select id="dish_update_active" name="active" class="form-control">
                                <option value="0">0</option>
                                <option value="1">1</option>
                            </select>
                        </label>
                        <label>销售状态
                            <select id="dish_update_status" name="status" class="form-control">
                                <option value="正常销售">正常销售</option>
                                <option value="售罄">售罄</option>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-primary">更新</button>
                        <button type="button" id="dish_update_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addDish" tabindex="-1" role="dialog" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <form id="dish_reg_form" role="form" method="post" action="/dish/add">
                    <div class="form-group form-inline">
                        <label>菜品组ID
                            <select name="dgId" class="form-control">
                                <c:forEach var="dishGroup" items="${dishGroupList}">
                                    <option value="${dishGroup.dgId}">${dishGroup.name}(${dishGroup.dgId})</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label>菜品名称
                            <input type="text" class="form-control" name="name" placeholder="请输入菜品名称" value="菜品${dishCount+1}" >
                        </label>
                        <label>描述
                            <input type="text" class="form-control" name="description" placeholder="请输入菜品描述"  >
                        </label>
                        <label>价格
                            <input type="text" class="form-control" name="price" placeholder="请输入菜品价格"  >
                        </label>
                        <label>成本
                            <input type="text" class="form-control" name="cost" placeholder="请输入菜品成本"  >
                        </label>
                        <label>菜单状态
                            <select name="active" class="form-control">
                                <option value="0">0</option>
                                <option value="1">1</option>
                            </select>
                        </label>
                        <label>销售状态
                            <select name="status" class="form-control">
                                <option value="正常销售">正常销售</option>
                                <option value="售罄">售罄</option>
                            </select>
                        </label>
                        <button type="submit" class="btn btn-info">新建</button>
                        <button type="button" id="dish_reg_form_close_btn" class="btn btn-warning" data-dismiss="modal">关闭</button>
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
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/3.jpg)";
    $(function () {

        $('.dish_group_update_form_open_btn').click(function () {
            $('#dg_id').val($(this).attr('dgid'));
            $('#dg_name').val($(this).attr('name'));

            var action="/dish/group/"+$(this).attr('dgid')+"/update";
            $('#dish_group_update_form').attr("action",action);
        })

        $('.dish_update_form_open_btn').click(function () {
            $('#dish_update_d_id').val($(this).attr('did'));
            $('#dish_update_dg_id').val($(this).attr('dgid'));
            $('#dish_update_desc').val($(this).attr('desc'));
            $('#dish_update_name').val($(this).attr('name'));
            $('#dish_update_price').val($(this).attr('price'));
            $('#dish_update_cost').val($(this).attr('cost'));
            $('#dish_update_status').val($(this).attr('status'));
            $('#dish_update_active').val($(this).attr('active'));

            var action="/dish/"+$(this).attr('did')+"/update";
            $('#dish_update_form').attr("action",action);
        })

    })
</script>
</html>
