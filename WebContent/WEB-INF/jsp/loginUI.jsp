<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>登陆页面</title>
<link href="${basePath}css/login/login.css" rel="stylesheet" type="text/css" />


</head>

<body>


<div class="login_box">
      <div class="login_l_img"><img src="${basePath}images/login/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="index.jsp"><img src="${basePath}images/login/login_logo.png" /></a></div>
          <div class="login_name">
               <p>后台管理系统</p>
          </div>
          <!-- 表單跳轉地址  ${basePath}login/loginAction_login.action-->
          <form method="post"  action = "${basePath}login/loginAction_login.action">
              <input name="user.Accounts" type="text"  value="帐号" onfocus="this.value=''" onblur="if(this.value==''){this.value='帐号'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
               <input name="user.Password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input id = "login" name = "submit_type" value="login" style="width:50%;" type="submit">
              <input id = "regist" name = submit_type value="regist" style="width:46%;" type="submit">
          </form>
      </div>
      <div class="copyright">全加密快递系统有限公司 开发人员：杨伟锋</div>
</div>
<div style="text-align:center;">
<p>全加密快递系统</p>
</div>
</body>

<script type="text/javascript">

if("${errorMessage}"!=""){
	//弹出错误信息
	window.alert("${errorMessage}");
}


</script>
</html>
