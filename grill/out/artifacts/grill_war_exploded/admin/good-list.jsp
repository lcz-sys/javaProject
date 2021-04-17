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
              <a><cite>产品管理</cite></a>
              <a><cite>产品列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace('${pageContext.request.contextPath}/good/goodList?pageNum=1');" title="刷新"><i
            class="layui-icon"
            style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" method="get" action="${pageContext.request.contextPath}/good/goodList"
          style="width:80%">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <input type="hidden" name="pageNum" value="1">
                <div class="layui-input-inline">
                    <input type="text" name="name" value="${name}" placeholder="请输入商品名" autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:80px">
                    <button class="layui-btn" lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i>
                    </button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
        <button class="layui-btn"
                onclick="good_add('添加用户','${pageContext.request.contextPath}/good/add','','')"><i
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
                封面
            </th>
            <th>
                名称
            </th>
            <th>
                介绍
            </th>
            <th>
                规格
            </th>
            <th>
                价格
            </th>
            <th>
                库存
            </th>
            <th>
                销量
            </th>
            <th>
                产品类型
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="good">
            <tr>
                <td>
                    <input type="checkbox" value="${good.id}" name="check">
                </td>
                <td>
                        ${good.id}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/index/detail?id=${good.id}">
                        <img src="${good.cover}" width="200" alt="">
                    </a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/index/detail?id=${good.id}"><p>${good.name}</p></a>
                </td>
                <td>
                        ${good.intro}
                </td>
                <td>
                        ${good.spec}
                </td>
                <td>
                        ${good.price}
                </td>
                <td>
                        ${good.stock}
                </td>
                <td>
                        ${good.sales}
                </td>
                <td>
                        ${good.type.name}
                </td>
                <td class="td-manage">
                    <c:if test="${empty good.top}">
                        <a title="推送" href="javascript:;" onclick="good_up(this,'${good.id}')"
                           style="text-decoration:none">
                            <i class="layui-icon">&#xe604;</i>
                        </a>
                    </c:if>
                    <c:if test="${!empty good.top}">
                        <a title="下调" href="javascript:;" onclick="good_down(this,'${good.id}')"
                           style="text-decoration:none">
                            <i class="layui-icon">&#x1006;</i>
                        </a>
                    </c:if>
                    <a title="编辑" href="javascript:;"
                       onclick="good_edit('编辑产品详情','${pageContext.request.contextPath}/good/edit/${good.id}','','')"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="good_del(this,'${good.id}')"
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
<script src="${pageContext.request.contextPath}/admin/js/jquery-3.3.1.js" charset="utf-8"></script>
<script>
    layui.use(['element', 'laypage', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        form = layui.form();//表单
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
                    location.href = "${pageContext.request.contextPath}/good/goodList?pageNum=" + e.curr + "&name=${name}";
                }
            }
        });

        form.on('submit(search)', function (data) {
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
                url: "${pageContext.request.contextPath}/good/delAll",
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
    function good_add(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    //编辑
    function good_edit(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*删除*/
    function good_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                url: "${pageContext.request.contextPath}/good/del",
                type: "get",
                data: {
                    id: id
                },
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

    /*推送*/
    function good_up(obj, id) {
        layer.confirm('确认要推送吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: "${pageContext.request.contextPath}/good/up",
                type: "get",
                data: {
                    id: id
                },
                success: function (res) {
                    if (res == "true") {
                        //重新刷新界面
                        location.reload();
                        layer.msg('推送成功!', {icon: 1, time: 1000});
                    } else {
                        layer.msg('推送失败！', {icon: 1, time: 1000});
                    }
                }
            });
        });
    }

    /*下调*/
    function good_down(obj, id) {
        layer.confirm('确认要下调吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: "${pageContext.request.contextPath}/good/down",
                type: "get",
                data: {
                    id: id
                },
                success: function (res) {
                    if (res == "true") {
                        //重新刷新界面
                        location.reload();
                        layer.msg('下调成功!', {icon: 1, time: 1000});
                    } else {
                        layer.msg('下调失败！', {icon: 1, time: 1000});
                    }
                }
            });
        });
    }
</script>
<script>
</script>
</body>
</html>
