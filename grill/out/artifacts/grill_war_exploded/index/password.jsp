<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>修改密码</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/public.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/address.css">
</head>
<body>
	
	<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>

	<div id="main">
	
		<div class="new-address">
			<form method="post" action="${pageContext.request.contextPath}/customer/personal/passwordUpdate" class="registerform">
				<div class="box clearfix">
					<div class="left">
						<span>原密码&nbsp;：&nbsp;</span>
					</div>
					<div class="right">
						<input type="password" name="password" value="" required="required" placeholder="请输入原密码">
					<span class="Validform_checktip"></span></div>
				</div>
				<div class="box clearfix">
					<div class="left">
						<span>新密码&nbsp;：&nbsp;</span>
					</div>
					<div class="right">
						<input type="password" name="passwordNew" value="" required="required" placeholder="请输入新密码">
					<span class="Validform_checktip"></span></div>
				</div>
				<div class="save" style="padding-left: 65px;">
					<button>保存</button>
					<p style="color:green;">${msg}</p>
				</div>
			</form>
		</div>
		
	</div>

	<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>

</body>
<script src="${pageContext.request.contextPath}/index/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</html>