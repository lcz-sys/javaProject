<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/search.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/font.css"/>
</head>
<body onload="init()">

<div id="searchss">
    <div class="search">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/index/main"><img
                    src="${pageContext.request.contextPath}/index/img/logo.jpg"/></a>
        </div>
        <div class="sear_input">
            <form id="SForm" method="get"
                  action="${pageContext.request.contextPath}/index/good">
                <input type="hidden" name="pageNum" value="1">
                <input type="text" name="goodName" value="${goodName}">
                <button id="search"><i class="iconfont icon-icon--"></i></button>
            </form>
        </div>
        <div class="sear_cart">
            <a href="${pageContext.request.contextPath}/customer/cart"><p><i class="iconfont icon-gouwuche5"></i>我的购物车
            </p></a>
            <c:if test="${sessionScope.cartCount!=null && sessionScope.cartCount>0}">
                <span class="cartnum">${sessionScope.cartCount}</span>
            </c:if>
            <%--<c:if test="${sessionScope.cartCount!=null && sessionScope.cartCount>0}">
               <c:choose>
                   <c:when test="${sessionScope.cartCount>999}">
                       <span class="cartnum">999</span>
                   </c:when>
                   <c:otherwise>
                       <span class="cartnum">${sessionScope.cartCount}</span>
                   </c:otherwise>
               </c:choose>
            </c:if>--%>
        </div>
        <div class="sear_fir">
            <c:if test="${sessionScope.user==null}">
                <div class="sinup">
                    <a href="${pageContext.request.contextPath}/customer/login">登录</a>
                    <a>/</a>
                    <a href="${pageContext.request.contextPath}/customer/register">注册</a>
                </div>
                <div class="sinup">
                    <a target="_blank" href="${pageContext.request.contextPath}/admin/index.jsp">后台管理</a>
                </div>
            </c:if>

            <c:if test="${sessionScope.user!=null}">
                <div class="sigin">
                    <span class="wel" id="wel">Hi,${sessionScope.user.username}</span>
                </div>
                <div class="my">
                    <a>个人中心</a>
                    <i class="iconfont icon-zheng-triangle1"></i>
                    <ul class="uls">
                        <li><a href="${pageContext.request.contextPath}/customer/order?pageNum=1">我的订单</a></li>
                        <li><a href="${pageContext.request.contextPath}/customer/personal/address">收货地址</a></li>
                        <li><a href="${pageContext.request.contextPath}/customer/personal/password">修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/customer/logout">退出</a></li>
                    </ul>
                </div>
            </c:if>

        </div>
    </div>
</div>

<!--导航nav-->
<div id="navall">
    <div id="nav">
        <!--产品分类-->
        <div class="proclass">
            <p>产品分类</p>
            <div class="prolist" style="display:none;">

                <c:forEach items="${typeList}" var="type">
                    <div class="list">
                        <dl>
                            <a href="${pageContext.request.contextPath}/index/type?id=${type.id}&pageNum=1">
                                <dt>${type.name}</dt>
                            </a>
                        </dl>
                    </div>
                </c:forEach>

            </div>
        </div>

        <!--导航-->
        <ul id="inav">
            <li <c:if test="${flag==1}">class="active"</c:if>><a href="${pageContext.request.contextPath}/index/main">商城首页</a>
            </li>
            <li <c:if test="${flag==2}">class="active"</c:if>><a
                    href="${pageContext.request.contextPath}/index/good?flag=2&pageNum=1">今日推荐</a>
            </li>
            <li <c:if test="${flag==3}">class="active"</c:if>><a
                    href="${pageContext.request.contextPath}/index/good?flag=3&pageNum=1">热销排行</a>
            </li>
            <li <c:if test="${flag==4}">class="active"</c:if>><a
                    href="${pageContext.request.contextPath}/index/good?flag=4&pageNum=1">新品上市</a>
            </li>
        </ul>

    </div>
</div>


<script src="${pageContext.request.contextPath}/index/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/index/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">

    function init() {
        $.ajax({
            url: '${pageContext.request.contextPath}/index/typeN',
            type: 'get',
            async: true
        });
    }

    $(function () {
        $("#search").on("click",function () {
            $("#SForm").submit();
        });
    });

    //显示隐藏分类
    $(".proclass").on("mouseenter", function () {
        $(".prolist").css("display", "block");
    });
    $(".proclass").on("mouseleave", function () {
        $(".prolist").css("display", "none");
    });
    // 显示隐藏个人中心
    $(".my").on("mouseenter", function () {
        $(".uls").show();
    });
    $(".my").on("mouseleave", function () {
        $(".uls").hide();
    });
    $(".uls li a").on("mouseenter", function () {
        $(this).css('color', '#ff712b');
    });
    $(".uls li a").on("mouseleave", function () {
        $(this).css('color', '#919191');
    });

    // 加入购物车
    $(document).on("click", ".addcart", function () {
        var goodId = $(this).attr("data-id");
        var count = $("#sum").val();
        var index = layer.load();
        $.post("${pageContext.request.contextPath}/customer/cartBuy", {goodId: goodId, count: count}, function (data) {
            layer.close(index);
            if (data == true) {
                updateCartnum();
                layer.msg("加入成功", {
                    icon: 1,   // 成功图标
                    time: 1200 //1.2秒关闭（如果不配置，默认是3秒）
                });
            } else if (data == false) {
                layer.msg("操作失败", {
                    icon: 2,   // 失败图标
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                });
            } else { // 重新渲染页面
                document.write(data);
            }
        });
    });

    // 更新购物车显示数量
    function updateCartnum() {
        $.ajax({
            url: "${pageContext.request.contextPath}/customer/updateCartCount",
            type: "get",
            async: true,
            success: function (data) {
                $(".cartnum").text(data);
            }
        });
    }
</script>
</body>
</html>