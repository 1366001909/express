<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
    
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}user/userAction_edit.action" method="post" enctype="multipart/form-data">
	<!-- 设置隐藏标签，传递id到后台，以便后台根据id执行update语句
	update user set name='' , dept='' where id=; -->
	<input type="hidden" name="user.id" value="${user.id}"/>
	
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;编辑角色</div></div>
    <div class="tableH2">编辑角色</div>
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	<!-- 
            		1、遍历显示所有标准权限
            	
            		
            		2、当前角色所拥有的权限中若包含标准权限，则选中该标准权限
            		   使用${fn:contains(string,subStr)}语法：
            		   判断string字符串中是否包含subStr字符串，包含的话返回true，否则返回false
            	 -->
            	<!-- 1、遍历显示所有标准权限-->
            	
            <c:forEach items="${permissionList}" var="pm">
            		<input type="checkbox" name="permissions"
            		<c:if test="${fn:contains(user.permissions,pm)}">
            			checked="checked"
            		</c:if>
            		value="${pm}"/>${pm}<br/>
            </c:forEach>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="user.accounts" value="${user.accounts}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="user.password" value="${user.password}"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="user.userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">真实姓名：</td>
            <td><input type="text" name="user.realName" value="${user.realName}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
           
            	<input type="radio" name="user.sex" ${user.sex.equals("男")?'checked="checked"':'' } value="男"/>男
            	<input type="radio" name="user.sex" ${user.sex.equals("女")?'checked="checked"':'' } value="女"/>女
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="user.tel" value="${user.tel}"/></td>
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