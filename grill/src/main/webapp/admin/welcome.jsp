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
        欢迎使用烧烤店后台管理系统！<span class="f-14">v1.0</span>
    </blockquote>
    <fieldset class="layui-elem-field layui-field-title site-title">
        <legend><a name="default">小组组员信息统计</a></legend>
    </fieldset>
    <table class="layui-table">
        <thead>
        <tr>
            <th>姓名</th>
            <th>班级</th>
            <th>学号</th>
            <th>角色</th>
            <th>任务分工</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>刘楚泽</td>
            <td>18软件2班</td>
            <td>1813157244</td>
            <td>组长</td>
            <td>后台+设计文档</td>
        </tr>
        <tr>
            <td>蔡镇柯</td>
            <td>18软件2班</td>
            <td>1813157236</td>
            <td>组员</td>
            <td>客户端页面+设计文档</td>
        </tr>
        <tr>
            <td>杨鑫</td>
            <td>18软件2班</td>
            <td>1813157241</td>
            <td>组员</td>
            <td>服务端页面+设计文档</td>
        </tr>
        <tr>
            <td>谭荣业</td>
            <td>18软件2班</td>
            <td>1813157235</td>
            <td>组员</td>
            <td>客户端页面+软件测试（黑盒测试）+设计文档</td>
        </tr>
        </tbody>
    </table>
    <div class="layui-footer footer footer-demo">
        <div class="layui-main">
            <p>
                <a href="#" target="_blank">
                    烧烤店后台管理系统
                </a>
            </p>
            <p>采用了spring，mybatis，spring-mvc，maven，layui，html，js，jquery等技术完成</p>
            <p>
                <a href="#">
                    开始时间：2020年11月9日，结束时间：2020年11月25日
                </a>
            </p>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-admin.js"></script>
</body>
</html>
