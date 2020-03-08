<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>快递信息管理</title>
   
</head>

<body class="rightBody">
<form id="form" name="form" action="${basePath}goodsInfo/goodsInfoAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>快递信息管理</strong>&nbsp;-&nbsp;新增快递信息</div></div>
    <div class="tableH2">新增快递信息</div>
    
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">序列号：</td>
            <td><input type="text" name="goodsInfo.num"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">快递名：</td>
            <td><input type="text" name="goodsInfo.mailName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">物流公司：</td>
            <td><input type="text" name="goodsInfo.mailCompany"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">运输码：</td>
            <td><input type="text" name="goodsInfo.tCode"/></td>
        </tr>
        
        <tr>
            <td class="tdBg" width="200px">取件码：</td>
            <td><input type="text" name="goodsInfo.gCode"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">mailNo：</td>
            <td><input type="text" name="goodsInfo.mailNo"/></td>
        </tr>
        
         <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td><input type="text" name="goodsInfo.state"/></td>
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