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

<body style="background-color: #393D49">
<div class="x-box">
    <div class="x-top">
        <i class="layui-icon x-login-close">
            &#x1007;
        </i>
        <ul class="x-login-right">
            <li style="background-color: #F1C85F;" color="#F1C85F">
            </li>
            <li style="background-color: #EA569A;" color="#EA569A">
            </li>
            <li style="background-color: #393D49;" color="#393D49">
            </li>
        </ul>
    </div>
    <div class="x-mid">
        <div class="x-avtar">
            <img src="${pageContext.request.contextPath}/admin/images/logo.png" alt="">
        </div>
        <div class="input">
            <form class="layui-form" method="post" action="${pageContext.request.contextPath}/admin/login">
                <div class="layui-form-item x-login-box">
                    <label for="username" class="layui-form-label">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="username" name="username" required="" lay-verify="username"
                               autocomplete="off" placeholder="username" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item x-login-box">
                    <label for="password" class="layui-form-label">
                        <i class="layui-icon">&#xe628;</i>
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="password" name="password" required="" lay-verify="password"
                               autocomplete="off" placeholder="******" class="layui-input">
                    </div>
                </div>
                <div id="errorMsg" style="color: red;margin: auto">${msg}</div>
                <div class="layui-form-item" id="loginbtn">
                    <button class="layui-btn" lay-filter="save" lay-submit="">
                        登 录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<p style="color:#fff;text-align: center;">Copyright © 2020.Company name All rights lcz</p>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'],
        function () {
            $ = layui.jquery;
            var form = layui.form(),
                layer = layui.layer;

            $('.x-login-right li').click(function (event) {
                color = $(this).attr('color');
                $('body').css('background-color', color);
            });

            //监听提交
            form.on('submit(save)',function(data){});

        });

    if (window != top) {
        top.location.href = location.href;
    }
</script>
</body>

</html>
