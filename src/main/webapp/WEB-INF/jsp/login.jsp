<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<html>
<head>
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="top-content">
    <div class="inner-bg">
        <div class="container ">

            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>湘粤阁餐厅管理系统</h1>
                    <div class="description">
                        员工登录
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to your identity</h3>
                            <p>身份认证登录</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>

                    <div class="form-bottom">
                        <div>
                            <ul id="myTab" class="nav nav-tabs">
                                <li class="active"><a href="#waiter" data-toggle="tab" style="color: black">服务员</a> </li>
                                <li><a href="#cook" data-toggle="tab" style="color: black">厨师</a> </li>
                                <li><a href="#cashier" data-toggle="tab" style="color: black">收银台</a> </li>
                                <li><a href="#restaurant" data-toggle="tab" style="color: black">管理员</a> </li>
                                <li><a href="#register" data-toggle="tab" style="color: black">餐厅注册</a> </li>
                            </ul>
                            <div id="myTabContent" class="tab-content">

                                <div class="tab-pane fade in active" id="waiter">
                                    <form role="form" method="post" action="/account/waiterlogin">
                                        <div class="form-group">
                                            <label class="sr-only">服务员ID</label>
                                            <input type="text" class="form-control" name="wId" placeholder="请输入服务员ID" value="${wId}">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only">服务员密码</label>
                                            <input type="password" class="form-control" name="password" placeholder="请输入服务员密码">
                                        </div>
                                        <button type="submit" class="btn btn-success ">服务员登录</button>
                                    </form>
                                </div>

                                <div class="tab-pane fade" id="cook">
                                    <form role="form" method="post" action="/account/kitchenlogin">
                                        <div class="form-group">
                                            <label class="sr-only">厨房ID</label>
                                            <input type="text" class="form-control" name="kId" placeholder="请输入厨房ID" value="${kId}">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only">厨房密码</label>
                                            <input type="password" class="form-control" name="password" placeholder="请输入厨房密码">
                                        </div>
                                        <button type="submit" class="btn btn-success">厨房登录</button>
                                    </form>
                                </div>

                                <div class="tab-pane fade" id="cashier">
                                    <form role="form" method="post" action="/account/cashierlogin">
                                        <div class="form-group">
                                            <label class="sr-only">收银台ID</label>
                                            <input type="text" class="form-control" name="cId" placeholder="请输入收银台ID" value="${cId}">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only">收银台密码</label>
                                            <input type="password" class="form-control" name="password" placeholder="请输入收银台密码">
                                        </div>
                                        <button type="submit" class="btn btn-success">收银台登录</button>
                                    </form>
                                </div>

                                <div class="tab-pane fade" id="restaurant">
                                    <form role="form" method="post" action="/account/adminlogin">
                                        <div class="form-group">
                                            <label class="sr-only">餐馆ID</label>
                                            <input type="text" class="form-control"  name="rId" placeholder="请输入餐馆ID" value="${rId}">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only">餐馆密码</label>
                                            <input type="password" class="form-control" name="password" placeholder="请输入餐馆密码">
                                        </div>
                                        <button type="submit" class="btn btn-success">管理员登录</button>
                                    </form>
                                </div>

                                <div class="tab-pane fade" id="register">
                                    <form role="form" method="get" action="/account/restreg">
                                        <button type="submit" class="btn btn-success">注册</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                ${msg}
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
<script>
    document.body.style.backgroundImage="URL(${pageContext.request.contextPath}/resources/images/1.jpg)";
    $(function () {
        <c:if test="${msg!=null}">
        alert("${msg}");
        </c:if>
    })
</script>
</html>