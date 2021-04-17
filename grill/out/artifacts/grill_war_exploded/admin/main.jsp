<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>
        烧烤店后台管理系统
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>

<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <a class="logo" href="${pageContext.request.contextPath}/admin/main.jsp">
                烧烤店后台管理系统
            </a>
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item"><img src="${pageContext.request.contextPath}/admin/images/logo.png"
                                                class="layui-circle"
                                                style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">${admin.username}</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd><a style="cursor:pointer;text-align: center;text-decoration: none;color: #000000"
                               onclick="admin_show('<h3>个人信息栏</h3>','${pageContext.request.contextPath}/admin/show/${admin.id}','360','400')">
                            个人信息
                        </a>
                        </dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/logout">切换帐号||退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item x-index"><a href="${pageContext.request.contextPath}/admin/main.jsp">前台首页</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-side layui-bg-black x-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>产品管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/good/goodList?pageNum=1">
                                <cite>产品列表</cite>
                            </a>
                        </dd>
                        </dd>
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/type/typeList?pageNum=1">
                                <cite>产品分类</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe634;</i><cite>轮播管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/top/topList?pageNum=1">
                                <cite>轮播列表</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe642;</i><cite>订单管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/order/orderList?pageNum=1">
                                <cite>订单列表</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>会员管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/user/userList?pageNum=1">
                                <cite>会员列表</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>管理员管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                            <a href="javascript:;" _href="${pageContext.request.contextPath}/admin/adminList?pageNum=1">
                                <cite>管理员列表</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>

    </div>
    <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
        <div class="x-slide_left"></div>
        <ul class="layui-tab-title">
            <li class="layui-this">
                我的桌面
                <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
            </li>
        </ul>
        <div class="layui-tab-content site-demo site-demo-body">
            <div class="layui-tab-item layui-show">
                <iframe frameborder="0" src="${pageContext.request.contextPath}/admin/welcome.jsp" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="site-mobile-shade">
    </div>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-admin.js"></script>
<script>
    layui.use(['layer'], function () {
        $ = layui.jquery;//jquery
        layer = layui.layer;//弹出层
    });

    /*个人信息-查看*/
    function admin_show(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }
</script>
</body>

</html>
