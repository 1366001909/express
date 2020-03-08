<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>快递员管理</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
</head>

<body class="rightBody">
<form id="form" name="form" action="${basePath}courier/courierAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>快递员管理</strong>&nbsp;-&nbsp;新增快递员</div></div>
    <div class="tableH2">新增快递员</div>
    
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
       
        <tr>
            <td class="tdBg" width="200px">openid：</td>
            <td><input type="text" name="courier.openid"/></td>
        </tr>
       
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="courier.accounts"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="courier.password"/></td>
        </tr>
       
        <tr>
            <td class="tdBg" width="200px">真实姓名：</td>
            <td><input type="text" name="courier.realName"/></td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">电话号码：</td>
            <td><input type="text" name="courier.tel"/></td>
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