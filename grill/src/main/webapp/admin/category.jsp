<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>产品管理</cite></a>
              <a><cite>产品分类</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace('${pageContext.request.contextPath}/type/typeList?pageNum=1');" title="刷新"><i class="layui-icon"
                                                                        style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" action="${pageContext.request.contextPath}/type/save" method="post" style="width:50%">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <label class="layui-form-label" style="width:60px">分类名</label>
                <div class="layui-input-inline" style="width:120px">
                    <input type="text" name="name" placeholder="分类名" value="" autocomplete="off" class="layui-input">
                </div>
                <label class="layui-form-label" style="width:60px">排序</label>
                <div class="layui-input-inline" style="width:120px">
                    <input type="text" name="num" placeholder="排序" value="" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:80px">
                    <button class="layui-btn" lay-submit="" lay-filter="add"><i class="layui-icon">&#xe608;</i>增加
                    </button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span></xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <input type="checkbox" onclick="checkAll()" id="checkAll" name="checkAll" value="">
            </th>
            <th>
                ID
            </th>
            <th>
                排序
            </th>
            <th>
                分类名
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody id="x-link">
        <C:forEach items="${pageInfo.list}" var="type">
        <tr>
            <td>
                <input type="checkbox" value="${type.id}" name="check">
            </td>
            <td>
                ${type.id}
            </td>
            <td>
                ${type.num}
            </td>
            <td>
                ${type.name}
            </td>
            <td class="td-manage">
                <a title="编辑" href="javascript:;" onclick="cate_edit('编辑','${pageContext.request.contextPath}/type/edit/${type.id}','425','300')"
                   class="ml-5" style="text-decoration:none">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" href="javascript:;" onclick="cate_del(this,'${type.id}')"
                   style="text-decoration:none">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </C:forEach>
        </tbody>
    </table>
    <div id="page"></div>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['element', 'laypage', 'layer'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        //以上模块根据需要引入

        laypage({
            cont: 'page'
            , pages: ${pageInfo.pages}
            , first: "首页"
            , last: "尾页"
            , prev: '<em><</em>'
            , next: '<em>></em>'
            , skip: true
            , curr: ${pageInfo.pageNum}
            , jump: function (e, first) { //触发分页后的回调
                if (!first) { //一定要加此判断，否则初始时会无限刷新
                    location.href = "${pageContext.request.contextPath}/type/typeList?pageNum=" + e.curr;
                }
            }
        });

    });

    //复选框全选或全不选
    function checkAll() {
        var check = $("#checkAll").prop("checked");
        // console.log(check);
        $.each($("input[name=check]"), function () {
            this.checked = check;
        });
    }

    //批量删除提交
    function delAll() {
        var ids = new Array();
        // console.log($("input:checkbox"));
        $.each($("input[name=check]"), function () {
            if (this.checked) {
                // console.log(this.value);
                ids.push(this.value);
            }
        });
        // console.log(ids);

        $.ajax({
            url: "${pageContext.request.contextPath}/type/delAll",
            type: "post",
            data: {ids: ids},
            success: function (res) {
                if (res) {
                    layer.confirm('确认要删除吗？', function (index) {
                        //捉到所有被选中的，发异步进行删除
                        location.reload();
                        layer.msg('删除成功', {icon: 1});
                    });
                }
            }
        });

    }

    //-编辑
    function cate_edit(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*-删除*/
    function cate_del(obj, id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/type/del",
            type: "get",
            data: {
                id: id
            },
            success: function (res) {
                if (res) {
                    layer.confirm('确认要删除吗？', function (index) {
                        //发异步删除数据
                        //重新刷新界面
                        location.reload();
                        layer.msg('已删除!', {icon: 1, time: 1000});
                    });
                }
            }
        });
    }
</script>

</body>
</html>
