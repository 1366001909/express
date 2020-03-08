<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<!-- 引入绝对路径 -->
 <%@include file="/common/header.jsp"%>
    <base href="${basePath}">

</head>
<frameset rows="100,*" cols="*" scrolling="No" framespacing="0"
	frameborder="no" border="0">
	<!-- 引用头部 -->
	<frame src="${basePath}home/homeAction_top.action" scrolling="No"
		noresize="noresize" name="headmenu" id="mainFrame" title="mainFrame">
	<!-- 引用左边和主体部分 -->
	<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0"
		frameborder="no" border="0">
		<frame src="${basePath}home/homeAction_left.action" name="leftmenu"
			id="mainFrame" title="mainFrame">

		<frame src="${basePath}common/welcome.jsp" name="main" scrolling="yes"
			noresize="noresize" id="rightFrame" title="rightFrame">
	</frameset>
</frameset>

<body>

</body>
</html>