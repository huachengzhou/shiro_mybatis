<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("ctx", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>Info</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
</head>

<body>
	<center>
		<div style="margin-top:50px;">
		<form:form commandName="info" action="saveInfo" method="post" cssClass="form-horizontal">
			<div style="margin-bottom:40px;"> <label class="label label-info">信息</label> </div>
			
			<textarea class="form-control" rows="10" name="description"></textarea><br>
			
			<input type="submit" value="submit" class="btn-success"><br>
		</form:form>
		</div>
	</center>
	<hr>
	<center>
		<a href="main_forward">main</a>
	</center>
</body>
</html>
