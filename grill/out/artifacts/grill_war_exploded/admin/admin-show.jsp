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
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>

<body>
<div class="x-body">
    <blockquote class="layui-elem-quote">
        <img src="${pageContext.request.contextPath}/admin/images/logo.png" class="layui-circle"
             style="width:50px;float:left">
        <dl style="margin-left:80px; color:#019688">
            <dt><span>${admin.username}</span></dt>
            <dd style="margin-left:0">
                这家伙很懒，这一块功能没有做
            </dd>
        </dl>
    </blockquote>
    <div class="pd-20">
        <table class="layui-table" lay-skin="line">
            <tbody>
            <tr>
                <th>手机：</th>
                <td>${admin.phone}</td>
            </tr>
            <tr>
                <th>邮箱：</th>
                <td>${admin.email}</td>
            </tr>
            <tr>
                <th>注册时间：</th>
                <td>${admin.create_time}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
</body>

</html>
