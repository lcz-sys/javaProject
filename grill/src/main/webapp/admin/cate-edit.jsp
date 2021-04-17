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
            <label for="cid" class="layui-form-label">
                ID
            </label>
            <div class="layui-input-inline">
                <input type="text" id="cid" name="id" value="${type.id}" required="" lay-verify="required"
                       autocomplete="off" disabled="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="cname" class="layui-form-label">
                <span class="x-red">*</span>分类名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="cname" name="name" value="${type.name}" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="num" class="layui-form-label">
                <span class="x-red">*</span>排序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="num" name="num" value="${type.num}" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="num" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="save" lay-submit="">
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
                url:"${pageContext.request.contextPath}/type/update",
                type:"post",
                data:data.field,
                success:function(res){
                    if(res == "true"){
                        layer.alert("修改成功", {icon: 6},function () {
                            //重新刷新父界面
                            parent.location.reload();
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        });
                    }else {
                        layer.alert("修改失败", {icon:6});
                    }
                }
            });
            return false;
        });

    });
</script>
</body>

</html>
