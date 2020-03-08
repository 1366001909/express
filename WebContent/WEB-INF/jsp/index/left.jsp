<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/index/public.css" />
<script type="text/javascript" src="${basePath}/js/index/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/js/index/public.js"></script>

</head>
<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="${basePath}common/welcome.jsp"  target="main"><div class="line">
					<img src="${basePath}images/index/coin01.png" />&nbsp;&nbsp;首页
				</div></a>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin10.png" /><img class="icon2"
						src="${basePath}images/index/coin09.png" /> 角色管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}user/userAction_listUI.action" 
						target="main">角色管理</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin07.png" /><img class="icon2"
						src="${basePath}images/index/coin08.png" /> 用户管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a href="${basePath}consumer/consumerAction_listUI.action" target="main"
						class="cks">用户管理</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			
			
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin15.png" /><img class="icon2"
						src="${basePath}images/index/coin16.png" /> 快递信息<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}goodsInfo/goodsInfoAction_listUI.action"
						target="main">快递信息</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
				
			</dl>
			
			
			
			
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin17.png" /><img class="icon2"
						src="${basePath}images/index/coin18.png" /> 定位信息<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}goodsPosition/goodsPositionAction_listUI.action" target="main">定位信息</a><img class="icon5"
						src="${basePath}images/index/coin21.png" />
				</dd>
				</dl>
			
			
			
			
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin14.png" /><img class="icon2"
						src="${basePath}images/index/coin13.png" /> 快递员管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}courier/courierAction_listUI.action" target="main">快递员管理</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin15.png" /><img class="icon2"
						src="${basePath}images/index/coin16.png" /> 预警管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks">预警管理</a><img class="icon5"
						src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			
	
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coinL1.png" /><img class="icon2"
						src="${basePath}images/index/coinL2.png" /> 系统管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a href="changepwd.html"
						target="main" class="cks">修改密码</a><img class="icon5"
						src="${basePath}images/index/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks">退出</a><img
						class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin03.png" /><img class="icon2"
						src="${basePath}images/index/coin04.png" /> 物流管理<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}goods/goodsAction_listUI.action"
						target="main">物流查询</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${basePath}images/index/coin11.png" /><img class="icon2"
						src="${basePath}images/index/coin12.png" /> 串口信息<img class="icon3"
						src="${basePath}images/index/coin19.png" /><img class="icon4"
						src="${basePath}images/index/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${basePath}images/index/coin111.png" /><img class="coin22"
						src="${basePath}images/index/coin222.png" /><a class="cks" href="${basePath}serialPort/serialPortAction_listUI.action"
						target="main">串口信息</a><img class="icon5" src="${basePath}images/index/coin21.png" />
				</dd>
			</dl>
			

		</div>

	</div>
</body>

</html>