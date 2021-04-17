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
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>会员管理</cite></a>
              <a><cite>轮播列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace('${pageContext.request.contextPath}/top/topList?pageNum=1');" title="刷新"><i
            class="layui-icon"
            style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
        <button class="layui-btn"
                onclick="banner_add('添加用户','${pageContext.request.contextPath}/top/add','','')"><i
                class="layui-icon">&#xe608;</i>添加
        </button>
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
                缩略图
            </th>
            <th>
                商品名
            </th>
            <th>
                链接
            </th>
            <th>
                描述
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody id="x-img">
        <c:forEach items="${pageInfo.list}" var="top">
            <tr>
                <td>
                    <input type="checkbox" value="${top.id}" name="check">
                </td>
                <td>
                        ${top.id}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/index/detail?id=${top.goodId}">
                        <img src="${top.good.cover}" width="200" alt="">
                    </a>
                </td>
                <td>
                        ${top.good.name}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/index/detail?id=${top.goodId}">商品链接</a>
                </td>
                <td>
                        ${top.good.intro}
                </td>
                <td class="td-manage">
                    <a title="删除" href="javascript:;" onclick="banner_del(this,'${top.id}')"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div id="page"></div>
</div>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['element', 'laypage', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        //以上模块根据需要引入
        <%--console.log("${pageInfo}");--%>
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
                    location.href = "${pageContext.request.contextPath}/top/topList?pageNum=" + e.curr;
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
        $.each($("[name=check]"), function () {
            if (this.checked) {
                // console.log(this.value);
                ids.push(this.value);
            }
        });
        // console.log(ids);

        layer.confirm('确认要删除吗？', function (index) {
            //捉到所有被选中的，发异步进行删除
            $.ajax({
                url: "${pageContext.request.contextPath}/top/delAll",
                type: "post",
                data: {ids: ids},
                success: function (res) {
                    if (res == "true") {
                        //重新刷新界面
                        location.reload();
                        layer.msg('删除成功!', {icon: 1, time: 1000});
                    } else {
                        layer.msg('删除失败！', {icon: 1, time: 1000});
                    }
                }
            });
        });

    }

    /*添加*/
    function banner_add(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*删除*/
    function banner_del(obj, id) {

        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: "${pageContext.request.contextPath}/top/del",
                type: "get",
                data: {
                    id: id
                },
                success: function (res) {
                    if (res == "true") {
                        //重新刷新界面
                        location.reload();
                        layer.msg('已删除!', {icon: 1, time: 1000});
                    } else {
                        layer.msg('删除失败！', {icon: 1, time: 1000});
                    }
                }
            });

        });

    }
</script>
</body>
</html>
