<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/reclassify.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/order.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>
<body>
	
	<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
	
	<div id="main">
	
		<div class="east" style="width: 1200px;margin: 0 auto;">
			<div style="">
				<table border="0" cellspacing="" cellpadding="" class="list">
					<thead>
						<tr>
							<th class="li1"></th>
							<th class="li2"><span>商品</span></th>
							<th class="li3"><span>单价</span></th>
							<th class="li4"><span>数量</span></th>
							<th class="li5"><span></span></th>
							<th class="li6"><span>实付款</span></th>
							<th class="li7"><span>交易状态</span></th>
							<th class="li8"><span>交易操作</span></th>
						</tr>
					</thead>
				</table>
			</div>
				
			<div style="width:100%;height:auto !important;height:468px;background: #f6f6f6;">
				<div id="itemContainer" style="background: #f6f6f6;">
							
					<c:forEach items="${pageInfo.list}" var="order">
						<table border="0" cellspacing="" cellpadding="" class="list animated wobble">
							<tbody>
								<tr class="order-info">
							 		<td colspan="8">
										<span style="margin-left: 20px;">订单编号&nbsp;:&nbsp;</span><i class="order-num">${order.id}</i>
										<span style="margin-left: 40px;">下单时间&nbsp;:&nbsp;</span><i class="order-num"><fmt:formatDate value="${order.systime}" pattern="yyyy-MM-dd HH:mm:ss"/></i>
									</td>
								</tr>
								<tr class="order" style="margin-bottom: 10px;">
								
									<c:forEach items="${order.itemList}" var="item" end="0">
										<td class="li1" style="text-align: left;" colspan="4">
											<a href="${pageContext.request.contextPath}/index/detail?id=${item.goodId}"><img src="${item.good.cover}"></a>
											<div class="m-good-descript">
												<a href="${pageContext.request.contextPath}/index/detail?id=${item.goodId}"><p class="goods-descript">${item.good.name}</p></a>
											</div>
											<div class="li3"><span>￥${item.price}</span></div>
											<div class="li4"><span>${item.amount}</span></div>
											<div class="li5"></div>
										</td>
									</c:forEach>
									
									<td class="li6" rowspan="${fn:length(itemList)}">
										<div>
											<p class="total-money">￥${order.total}</p>
										</div>
									</td>
									<td class="li7" rowspan="${fn:length(itemList)}">
										<div>
											<c:if test="${order.status==1}"><span>待付款</span></c:if>
											<c:if test="${order.status==2}">
												<c:if test="${order.paytype==1}"><span>已付款 (微信)</span></c:if>
												<c:if test="${order.paytype==2}"><span>已付款 (支付宝)</span></c:if>
											</c:if>
											<c:if test="${order.status==3}"><span>已发货</span></c:if>
											<c:if test="${order.status==4}"><span>已完成</span></c:if>
										</div>
									</td>
									<td class="li8" rowspan="${fn:length(itemList)}">
										<div>
											<p>
												<c:if test="${order.status==1}">
													<a href="${pageContext.request.contextPath}/customer/orderPay?id=${order.id}"><span class="sta1 pay noSelect">确认付款</span></a>
												</c:if>
											</p>
										</div>
									</td>
								</tr> 
								
								<c:forEach items="${order.itemList}" var="item" begin="1">
									<tr class="order" style="margin-bottom: 10px;">
										<td class="li1" style="text-align: left;" colspan="4">
											<a href="${pageContext.request.contextPath}/index/detail?id=${item.goodId}"><img src="${item.good.cover}" width="200" alt=""></a>
											<div class="m-good-descript">
												<a href="${pageContext.request.contextPath}/index/detail?id=${item.goodId}"><p class="goods-descript">${item.good.name}</p></a>
											</div>
											<div class="li3"><span>￥${item.price}</span></div>
											<div class="li4"><span>${item.amount}</span></div>
											<div class="li5"></div>
										</td>
									</tr>	
								</c:forEach>
							</tbody>
						</table>					
					</c:forEach>
														
				</div>
			</div>

			<div id="page"></div>
		</div>
		
	</div>

	<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>

</body>
<script src="${pageContext.request.contextPath}/index/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/admin/js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">

	layui.use(['laypage'], function () {
		laypage = layui.laypage;//分页

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
					location.href = "${pageContext.request.contextPath}/customer/order?pageNum=" + e.curr;
				}
			}
		});

	});

</script>
</html>