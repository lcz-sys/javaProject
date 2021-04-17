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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/address.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/pay.css">
</head>
<body style="background: #fff;">
	
	<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
	
	<div id="main">
		
		<div id="goodslist">
		    <div class="tit" style="height: 50px;padding-bottom: 10px;">商品清单</div>
		    <div class="list-tit">
		        <ul>
		            <li class="li1">商城发货订单</li>
		            <li class="li3">单价</li>
		            <li class="li4">数量</li>
		            <li class="li5">小计</li>
		        </ul>
		    </div>
    		<div class="list-cont">
				<c:forEach items="${order.itemList}" var="item">
					<ul>
	                    <li class="li1">
	                        <dl>
	                            <a href="${pageContext.request.contextPath}/index/detail?id=${item.good.id}">
	                            	<dt><img src="${item.good.cover}"></dt>
	                                <dd class="goodsname" style="padding-top: 36px;">${item.good.name}</dd>
	                                <dd class="goods-des">${item.good.intro}</dd>
	                            </a>
	                        </dl>
	                    </li>
	                    <li class="li3">￥<span>${item.price}</span></li>
	                    <li class="li4">x<span>${item.amount}</span></li>
	                    <li class="li5">￥<span>${item.price * item.amount}</span></li>
	                </ul>
				</c:forEach>
			</div>
	        <p class="zprice" style="text-align: right;">应付总金额：
	        	<span>￥<span id="shifu" style="font-size: 32px;font-weight: bold;color: #FF712B;">${order.total}</span></span>
	        </p>
		</div>
	
		<div id="collect">
		    <div class="collect-tit"><span class="tit">收货信息</span></div>
		    <div class="collect-cont new-address" style="padding: 0px 0px;">
				<form action="${pageContext.request.contextPath}/customer/orderPay" method="post" id="form">
					<input type="hidden" name="id" value="${order.id}">
					<input type="hidden" name="paytype">
			        <div class="box clearfix">
						<div class="left">
							<span>姓名&nbsp;：&nbsp;</span>
						</div>
						<div class="right">
							<input type="text" name="name" value="${sessionScope.user.name}" placeholder="请输入收货人姓名">
						<span class="Validform_checktip"></span></div>
					</div>
					<div class="box clearfix">
						<div class="left">
							<span>电话&nbsp;：&nbsp;</span>
						</div>
						<div class="right">
							<input type="text" name="phone" value="${sessionScope.user.phone}" placeholder="请输入收货人电话">
						<span class="Validform_checktip"></span></div>
					</div>
					<div class="box clearfix">
						<div class="left">
							<span>地址&nbsp;：&nbsp;</span>
						</div>
						<div class="right">
							<input type="text" name="address" value="${sessionScope.user.address}" placeholder="请输入收货地址">
						</div>
					</div>
				</form>
		    </div>
		</div>
	
		<div class="close-foot clearfix">
	        <div id="payway">
	            <div class="payway-tit">支付方式</div>
	            <div class="payway-cont">
	                <div class="way active" data="1">
	                    <i class="iconfont icon-weixin"></i>微信
	                    <span class="iconfont icon-xuanzhong3"></span>
	                </div>
	                <div class="way" data="2">
	                    <i class="iconfont icon-zhifubao"></i>支付宝
	                    <span class="iconfont icon-xuanzhong3"></span>
	                </div>
	            </div>
	        </div>
	        <p class="submit" id="tijiao">立即支付</p>
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
$("#tijiao").on("click", function(){
	var paytype = $(".payway-cont .active").attr("data");
	$("input[name=paytype]").val(paytype);
	if($("input[name=name]").val()==""){
		layer.msg("请正确填写收货人姓名");
		return false;
	}
	if($("input[name=phone]").val()==""){
		layer.msg("请正确填写收货人电话");
		return false;
	}
	if($("input[name=address]").val()==""){
		layer.msg("请正确填写收货人地址");
		return false;
	}
	$("#form").submit();
});
</script>
</html>