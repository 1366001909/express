<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>快递定位信息管理</title>
   <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
</head>

<body class="rightBody">
<form id="form" name="form" action="${basePath}goodsPosition/goodsPositionAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_Position">
    <div class="c_crumbs"><div><b></b><strong>快递定位信息管理</strong>&nbsp;-&nbsp;新增快递定位信息</div></div>
    <div class="tableH2">新增快递定位信息</div>
    
    
    <table id="basePosition" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">mailNo：</td>
            <td><input type="text" name="goodsPosition.mailNo"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">定位记录：</td>
            <td><input type="text" name="goodsPosition.locateRecorder"/></td>
        </tr>
         <tr>
            <td class="tdBg" width="200px">日期date：</td>
            
            <td>	
              <input type="text" id="goodsPositionDate" name="goodsPosition.date" readonly="readonly"
			onfocus="WdatePicker({skin:'whyGreen',el:'goodsPositionDate',dateFmt: 'yyyy-MM-dd'})"
			value="${goodsPosition.date}"/></tr> 
       <tr>
        
        
        <tr>
            <td class="tdBg" width="200px">日期time：</td>
            
            <td>	
              <input type="text" id="goodsPositionTime" name="goodsPosition.time" readonly="readonly"
			onfocus="WdatePicker({skin:'whyGreen',el:'goodsPositionTime',dateFmt: 'HH:mm:ss'})"
			value="${goodsPosition.time}"/></tr> 
       <tr>
       
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>