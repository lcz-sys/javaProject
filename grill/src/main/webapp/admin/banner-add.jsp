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
            <label for="good" class="layui-form-label">
                <span class="x-red">*</span>商品
            </label>
            <div class="layui-input-block">
                <select id="good" name="goodId">
                    <option value="0">--请选择商品--</option>
                    <c:forEach items="${goodList}" var="good">
                        <option value="${good.id}">${good.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="good" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="add" lay-submit="">
                推荐
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
        form.on('submit(add)', function (data) {
            $.ajax({
                url:"${pageContext.request.contextPath}/top/save",
                type:"post",
                data:data.field,
                success:function(res){
                    if(res == "true"){
                        layer.alert("推荐成功", {icon: 6},function () {
                            //重新刷新父界面
                            parent.location.reload();
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        });
                    }else{
                        layer.alert("推荐失败", {icon: 6});
                    }
                }
            });
            return false;
        });


    });
</script>
</body>

</html>
