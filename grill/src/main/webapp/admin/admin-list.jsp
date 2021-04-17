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
              <a><cite>管理员管理</cite></a>
              <a><cite>管理员列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace('${pageContext.request.contextPath}/admin/adminList?pageNum=1');" title="刷新"><i
            class="layui-icon"
            style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" method="get" action="${pageContext.request.contextPath}/admin/adminList"
          style="width:80%">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <input type="hidden" name="pageNum" value="1">
                <label class="layui-form-label">日期范围</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="start_time" placeholder="开始日" value="${start_time}"
                           id="LAY_demorange_s">
                </div>
                <div class="layui-input-inline">
                    <input class="layui-input" name="end_time" placeholder="截止日" value="${end_time}"
                           id="LAY_demorange_e">
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="username" value="${username}" placeholder="请输入登录名" autocomplete="off"
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
                onclick="admin_add('添加用户','${pageContext.request.contextPath}/admin/add','500','500')"><i
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
                登录名
            </th>
            <th>
                手机
            </th>
            <th>
                邮箱
            </th>
            <th>
                加入时间
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="admin">
            <tr>
                <td>
                    <input type="checkbox" value="${admin.id}" name="check">
                </td>
                <td>
                        ${admin.id}
                </td>
                <td>
                        ${admin.username}
                </td>
                <td>
                        ${admin.phone}
                </td>
                <td>
                        ${admin.email}
                </td>
                <td>
                        ${admin.create_time}
                </td>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;"
                       onclick="admin_edit('编辑','${pageContext.request.contextPath}/admin/edit/${admin.id}','500','500')"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="admin_del(this,'${admin.id}')"
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
    layui.use(['laydate', 'element', 'laypage', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
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
                    location.href = "${pageContext.request.contextPath}/admin/adminList?pageNum=" + e.curr + "&username=${username}&start_time=${start_time}&end_time=${end_time}";
                }
            }
        });

        var start = {
            format: 'YYYY-MM-DD',
            max: laydate.now()+1,
            istime: false,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            format: 'YYYY-MM-DD',
            max: laydate.now()+1,
            istime: false, //是否开启时间选择
            istoday: false,
            isclear: true, //是否显示清空
            issure: true, //是否显示确认
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function () {
            start.elem = this;
            laydate(start);
        }
        document.getElementById('LAY_demorange_e').onclick = function () {
            end.elem = this
            laydate(end);
        }

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
                url: "${pageContext.request.contextPath}/admin/delAll",
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
    function admin_add(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    //编辑
    function admin_edit(title, url, w, h) {
        x_admin_show(title, url, w, h);
    }

    /*删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/del",
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
</script>
<script>
</script>
</body>
</html>
