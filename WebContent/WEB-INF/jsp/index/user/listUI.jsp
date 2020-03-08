<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>角色管理</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript">
    //跳转新增页面
      function doAdd(){
    	  //${basePath}user/userAction_addUI.action
    	  //$("#form1")通过id选择器定位到form表单
    	  $("#form1").prop("action","${basePath}user/userAction_addUI.action");
    	  $("#form1").submit();
      }
      //批量删除
      function doDeleteSelected(){
    	  //jq选择器：选择所有<input>里面name属性值为selectedRows 且被勾选的标签（复选框）
    	  var length = $("input[name=selectedRows]:checked").length;
    	  if(length<=0){
    		  alert("请选择要删除的数据!");
    		  return;
    	  }
    	  $("#form1").prop("action","${basePath}user/userAction_deleteSelected.action")
    	  $("#form1").submit();
      }
      
      //实现全选与反选
      function doSelectAll(){
    	  //选择所有<input>里面name属性值为selectedRows
    	  $("input[name=selectedRows]").prop("checked",$("#selAll").is(":checked"));
      }
      
      
      //批量导出
      function doExportExcel(){
    	  $("#form1").prop("action","${basePath}user/userAction_exportExcel.action");
    	  $("#form1").submit();
      }
      
   	//实现搜索功能
	 	function doSearch(){
	 		$("#form1").prop("action","${basePath}user/userAction_listUI.action");
	 		$("#form1").submit();

	 	}
      //分页实现
     	function findByPage(pageNo){
     		$("#form1").prop("action","${basePath}user/userAction_listUI.action?pageNo="+pageNo);
     		$("#form1").submit();
     	
     	}
        
    </script>
</head>

<body class="rightBody">
<form name="form1" id="form1" action="#" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>角色管理</strong></div> </div>
                <div class="search_art">
                    <li> 
                    	输入帐号查询：
                        <input type="text" name="user.accounts"  value = "${user.accounts}" class="s_text" id="user.accounts" style="width:160px;" />
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteSelected()"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="150" align="center">帐号</td>
                            <td width="150" align="center">密码</td>
                            <td width="150" align="center">用户名</td>
                            
                            <td width="150" align="center">真实姓名</td>
                            <td width="80" align="center">性别</td>
                            <td width="150"align="center">电话</td>
                          
                            <td width = "270" align="center">权限</td>
                            <td width="180" align="center">操作</td>
                        </tr>
                       
                        <%-- <%for(User user : userList) %> --%>
                        <c:forEach items="${pageResult.items}" var="user">
	                        <tr bgcolor="f8f8f8">
	                            <td align="center"><input type="checkbox" name="selectedRows" value="${user.id}"/></td>
	                            <td align="center">${user.accounts }</td>
	                            <td align="center">${user.password}</td>
	                            <td align="center">${user.userName}</td>
	                            <td align="center">${user.realName}</td>
	                            <td align="center">${user.sex}</td>
	                            <td align="center">${user.tel}</td>
	                            <td align="center">${user.permissions}</td>
	                            <td align="center">
	                                <a href="${basePath}user/userAction_editUI.action?user.id=${user.id}">编辑</a>
	                                <a href="${basePath}user/userAction_delete.action?user.id=${user.id}">删除</a>
	                            </td>
	                        </tr>
                        </c:forEach>
                         
                    </table>
                
                </div>
                
                
            </div>

    
			<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
       		
        </div>
    </div>
</form>

</body>
</html>