<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<link rel="stylesheet" type="text/css" href="${basePath}/css/index/public.css" />
<script type="text/javascript" src="${basePath}/js/index/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/js/index/public.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<!-- ${pageContext.request.contextPath}/images/logLOGO.png -->
</head>
<body>
<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="${basePath}/images/index/logo.png"/>
		</div>
		<div class="headR">
		<!--  使用target="_parent" 设置整体刷新-->
			<span style="color:#FFF"><font color="red">${sessionScope.SYS_USER.userName}<font color="white">&nbsp&nbsp欢迎进入全加密系统后台</span> <a href="${basePath}login/loginAction_logout.action"  target="_parent" rel="external">【退出】</a>
		</div>
	</div>
</body>
</html>