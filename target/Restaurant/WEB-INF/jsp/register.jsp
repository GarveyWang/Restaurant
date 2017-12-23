<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐馆注册页面</title>
    <%@include file="common/head.jsp"%>
</head>
<body background="${pageContext.request.contextPath}/resources/images/3.jpg">
    <div class="container">
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class=" col-sm-8 col-sm-offset-2 text">
                            <h1>湘粤阁餐厅管理系统</h1>
                            <div class="description">
                                <p>餐厅注册</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>register</h3>
                                    <p>请输入将注册的餐厅信息</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" method="post" action="/account/restaurant/add">
                                    <div class="form-group">
                                        <label for="r_id" class="sr-only">餐馆ID</label>
                                        <input type="text" class="form-control" id="r_id" name="rId" placeholder="请输入餐馆ID" value="${restaurant.rId}">
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="sr-only">餐馆名称</label>
                                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入餐馆名称" value="${restaurant.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="sr-only">餐馆密码</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入餐馆密码" value="${restaurant.password}">
                                    </div>
                                    <button type="submit" class="btn btn-success">提交</button>
                                </form>
                                <p style="color: red">
                                    ${msg}
                                </p>
                            </div>
                        </div>
                    </div>
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

</html>
