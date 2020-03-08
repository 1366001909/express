<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
</head>

<body class="rightBody">
<form id="form" name="form" action="${basePath}user/userAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色</div></div>
    <div class="tableH2">新增角色</div>
    
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	<!-- 遍历权限集合permissionList -->
      
            	<input type="checkbox" value="">权限名称<br>
            	<input type="checkbox" name="permissions" value="角色管理">角色管理<br>
            	<input type="checkbox" name="permissions" value="用户管理">用户管理<br>
            	<input type="checkbox" name="permissions" value="信息管理">快递管理<br>
            	<input type="checkbox" name="permissions" value="咨询管理">定位管理<br>
        
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="user.accounts"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="user.password"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="user.userName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">真实姓名：</td>
            <td><input type="text" name="user.realName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
				<input type="radio" name="user.sex" value="男"/>男
            	<input type="radio" name="user.sex" value="女"/>女            
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电话号码：</td>
            <td><input type="text" name="user.tel"/></td>
        </tr>
       
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>