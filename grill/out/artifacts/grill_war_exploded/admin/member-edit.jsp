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
    <form class="layui-form">
        <div class="layui-form-item">
            <input type="text" name="id" value="${user.id}" style="display: none">
            <label for="L_phone" class="layui-form-label">
                手机
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_phone" name="phone" required lay-verify="phone"
                       autocomplete="off" value="${user.phone}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                收货人
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" required lay-verify="required"
                       autocomplete="off" value="${user.name}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_city" class="layui-form-label">
                地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_city" name="address" autocomplete="off" value="${user.address}"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label for="L_sign" class="layui-form-label">
                签名
            </label>
            <div class="layui-input-block">
                        <textarea placeholder="随便写些什么刷下存在感" id="L_sign" name="message" autocomplete="off"
                                  class="layui-textarea" style="height: 80px;">${user.message}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_sign" class="layui-form-label">
            </label>
            <button class="layui-btn" key="set-mine" lay-filter="save" lay-submit>
                保存
            </button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8">
</script>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form()
            , layer = layui.layer;

        //监听提交
        form.on('submit(save)', function (data) {
            $.ajax({
                url: "${pageContext.request.contextPath}/user/update",
                type: "post",
                data: data.field,
                success: function (res) {
                    if (res == "true") {
                        layer.alert("修改成功", {icon: 6}, function () {
                            //重新刷新父界面
                            parent.location.reload();
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        });
                    }else {
                        layer.alert("修改失败", {icon: 6});
                    }
                }
            });
            return false;
        });


    });
</script>
</body>

</html>
