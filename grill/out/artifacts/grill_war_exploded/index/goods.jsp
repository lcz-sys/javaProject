<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<c:if test="${flag==2}"><title>今日推荐</title></c:if>
	<c:if test="${flag==3}"><title>热销排行</title></c:if>
	<c:if test="${flag==4}"><title>新品上市</title></c:if>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/reclassify.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/x-admin.css" media="all">
</head>
<body>
	
	<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
	
	<div id="main" class="main">
		
		<c:if test="${type!=null}">
			<div id="mnav" style="background: #f6f6f6;border: 1px solid #eee;">
				<a href="${pageContext.request.contextPath}/index/type?id=${type.id}&pageNum=1"><span style="color:#ff852b;">${type.name}</span></a>
				<i class="iconfont icon-arrow-left"></i>					
			</div>
		</c:if>
		<c:if test="${goodName!=null}">
			<div id="mnav" style="background: #f6f6f6;border: 1px solid #eee;">
				<span>搜索结果</span>
				<i class="iconfont icon-arrow-left"></i>					
				<span>${goodName}</span>
			</div>
		</c:if>
	
		<div class="goodscont clearfix">
				
			<c:forEach items="${pageInfo.list}" var="good">
				<div class="goods-box animated wobble">
					<div class="goods">
						<a target="_blank" href="${pageContext.request.contextPath}/index/detail?id=${good.id}">
							<div class="img-box">
								<img src="${good.cover}">	
							</div>
						</a>
						<a target="_blank" href="${pageContext.request.contextPath}/index/detail?id=${good.id}">
							<p class="goodsname">${good.name}</p>
						</a>
						<p class="goods-descript">${good.intro}</p>
						<p class="goods-spec">${good.spec}</p>
						<p class="goodsprices" style="display:block;">
							<span class="yj">￥<span class="yjcont">${good.price}</span></span>
						</p>
						<p class="addcart" data-id="${good.id}" style="display:none;"><i class="iconfont icon-gouwuche3"></i>加入购物车</p>
					</div>
				</div>			
			</c:forEach>	
			
			<c:if test="${pageInfo.list==null || fn:length(pageInfo.list)==0}">
				<div id="searchnull">
					<img src="${pageContext.request.contextPath}/index/img/searchnull.png">
					<p>很抱歉，没有找到相关产品~<br>换个关键词吧~</p>
				</div>
			</c:if>
					
		</div>

		<div id="page"></div>
		
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
					location.href = "${pageContext.request.contextPath}/index/good?goodName=${goodName}&flag=${flag}&pageNum=" + e.curr;
				}
			}
		});

	});

// 显示隐藏购物车
$(".goods-box").on("mouseenter", function() {
	$(this).addClass("active");
	$(this).find(".addcart").show();
	$(this).find(".reserve").show();
	$(this).find(".m_stop").show();
	$(this).find(".goodsprices").hide();
});
$(".goods-box").on("mouseleave", function() {
	$(this).removeClass("active");
	$(this).find(".addcart").hide();
	$(this).find(".reserve").hide();
	$(this).find(".m_stop").hide();
	$(this).find(".goodsprices").show();
});
</script>
</html>