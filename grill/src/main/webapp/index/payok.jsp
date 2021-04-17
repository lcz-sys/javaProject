<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>支付</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/reclassify.css">
</head>
<body style="background: #fff;">

<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>

<div id="main">
    <div>
        <img src="${pageContext.request.contextPath}/index/img/payok.jpg" width="200px">
        <span style="font-size: 40px;">支付成功</span>
        <a href="${pageContext.request.contextPath}/customer/order?pageNum=1">
            <p style="width: 130px;background: #FF712B;border-radius: 6px;color: #fff;font-size: 18px;text-align: center;line-height: 48px;margin-left: 210px;">查看我的订单</p>
        </a>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>

</body>
<script src="${pageContext.request.contextPath}/index/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    // 选择支付方式
    $("#payway .payway-cont .way").on("click", function () {
        $(this).addClass("active").siblings().removeClass("active")
    });
    // 提交支付
    $("#tijiao").on("click", function (data) {
        var paytype = $(".payway-cont .active").attr("data");
        $("input[name=paytype]").val(paytype);
        $("#form").submit();
    });
</script>
</html>