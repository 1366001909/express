<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
	//http://localhost:8080/itcast-tax/
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<%-- <base href="${basePath}"/> --%>
<script type="text/javascript" src="${basePath}js/jquery/jquery-1.10.2.min.js"></script>
<link href="${basePath}css/skin1.css" rel="stylesheet" type="text/css" />
