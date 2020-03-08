<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>快递信息管理</title>
    
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}goodsInfo/goodsInfoAction_edit.action" method="post" enctype="multipart/form-data">
	<!-- 设置隐藏标签，传递id到后台，以便后台根据id执行update语句
	update goodsInfo set name='' , dept='' where id=; -->
	<input type="hidden" name="goodsInfo.id" value="${goodsInfo.id}"/>
	
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>快递信息管理</strong>&nbsp;-&nbsp;编辑快递信息</div></div>
    <div class="tableH2">编辑快递信息</div>
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">序列号：</td>
            <td><input type="text" name="goodsInfo.num" value="${goodsInfo.num}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">快递名：</td>
            <td><input type="text" name="goodsInfo.mailName" value="${goodsInfo.mailName}"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">物流公司：</td>
            <td><input type="text" name="goodsInfo.mailCompany" value="${goodsInfo.mailCompany}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">运输码：</td>
            <td><input type="text" name="goodsInfo.tCode" value="${goodsInfo.tCode}"/></td>
        </tr>
        
        <tr>
            <td class="tdBg" width="200px">取件码：</td>
            <td><input type="text" name="goodsInfo.gCode" value="${goodsInfo.gCode}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">mailNo：</td>
            <td><input type="text" name="goodsInfo.mailNo" value="${goodsInfo.mailNo}"/></td>
        </tr>    
        
         <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td><input type="text" name="goodsInfo.state" value="${goodsInfo.state}"/></td>
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