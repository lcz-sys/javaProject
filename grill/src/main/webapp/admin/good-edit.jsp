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
    <form class="layui-form" enctype="multipart/form-data">
        <div class="layui-form-item">
            <label for="cover" class="layui-form-label">
                <span class="x-red">*</span>上传封面
            </label>
            <div class="layui-input-block">
                <input type="hidden" name="id" value="${good.id}">
                <input type="file" id="upload" name="file" lay-type="images" class="layui-upload-file">
                <input id="cover" name="cover" type="hidden" value="${good.cover}" autocomplete="off"
                       class="layui-input">
                <img id="img" src="${good.cover}" width="200" alt="">
                <p id="fileName" class="x-red">${good.cover}</p>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>商品名
            </label>
            <div class="layui-input-block">
                <input type="text" id="name" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${good.name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="intro" class="layui-form-label">
                <span class="x-red">*</span>介绍
            </label>
            <div class="layui-input-block">
                <textarea id="intro" name="intro" autocomplete="off"
                          class="layui-textarea">${good.intro}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="spec" class="layui-form-label">
                <span class="x-red">*</span>规格
            </label>
            <div class="layui-input-block">
                <input type="text" id="spec" name="spec" required="" lay-verify=""
                       autocomplete="off" class="layui-input" value="${good.spec}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-block">
                <input type="text" id="price" name="price" required="" lay-verify=""
                       autocomplete="off" class="layui-input" value="${good.price}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="stock" class="layui-form-label">
                <span class="x-red">*</span>库存
            </label>
            <div class="layui-input-block">
                <input type="text" id="stock" name="stock" required="" lay-verify=""
                       autocomplete="off" class="layui-input" value="${good.stock}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="type" class="layui-form-label">
                <span class="x-red">*</span>商品类型
            </label>
            <div class="layui-input-block">
                <select id="type" name="typeId">
                    <c:forEach items="${typeList}" var="type">
                        <c:choose>
                            <c:when test="${good.type.id == type.id}">
                                <option value="${type.id}" selected>${type.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type.id}">${type.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="container" class="layui-form-label">
                <span class="x-red">*</span>商品详情
            </label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" id="container" name="content" style="display: none">
                    ${good.content}
                </textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="container" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="save" lay-submit="">
                保存
            </button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layer', 'upload', 'layedit'], function () {
        $ = layui.jquery;
        var form = layui.form()
            , layer = layui.layer
            , upload = layui.upload
            , layedit = layui.layedit;

        //富文本编辑器图片上传
        layedit.set({
            uploadImage: {
                url: '${pageContext.request.contextPath}/good/uploadPhotos'//接口url
                , type: 'post' //默认post
            }
        });


        //富文本编辑器
        var index = layedit.build('container');

        //图片上传
        upload({
            elem: '#upload'
            , url: '${pageContext.request.contextPath}/good/upload'
            , success: function (res) {
                // console.log(res);
                if (res.code == 'success') {
                    $('#fileName').html(res.oldName);
                    $('#cover').val(res.fileName);
                    $('#img').prop('src',res.fileName);
                }
                // console.log(res.message);
                layer.msg(res.message);
            }
        });

        //监听提交
        form.on('submit(save)', function (data) {
            data.field.content = layedit.getContent(index);
            $.ajax({
                url: "${pageContext.request.contextPath}/good/update",
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