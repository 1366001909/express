<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}consumer/consumerAction_edit.action" method="post" enctype="multipart/form-data">
	<!-- 设置隐藏标签，传递id到后台，以便后台根据id执行update语句
	update consumer set name='' , dept='' where id=; -->
	<input type="hidden" name="consumer.id" value="${consumer.id}"/>
	
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;编辑用户</div></div>
    <div class="tableH2">编辑用户</div>
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">序列号：</td>
            <td><input type="text" name="consumer.num" value="${consumer.num}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">微信号：</td>
            <td><input type="text" name="consumer.wetChatAccounts" value="${consumer.wetChatAccounts}"/> </td>
        </tr>
        
         <tr>
            <td class="tdBg" width="200px">openid：</td>
            <td><input type="text" name="consumer.openid" value="${consumer.openid}"/> </td>
        </tr>
        
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
           
            	<input type="radio" name="consumer.sex" ${consumer.sex.equals("男")?'checked="checked"':'' } value="男"/>男
            	<input type="radio" name="consumer.sex" ${consumer.sex.equals("女")?'checked="checked"':'' } value="女"/>女
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="consumer.tel" value="${consumer.tel}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">地址：</td>
            <td><input type="text" name="consumer.address" value="${consumer.address}"/></td>
        </tr>        

    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>

</html>