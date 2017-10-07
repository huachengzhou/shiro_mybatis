<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
	<style type="text/css">
	.odiv{
		margin:0 auto;
		text-align: center;
		}
	</style>
</head>
<body style="background:http://www.w3school.com.cn/clouds.gif">
		<div class="panel panel-default">
		
		<div style="margin-top:40px;" class="panel-heading odiv">
			<p class="text-success glyphicon glyphicon-heart"><shiro:user>欢迎您!${user.username}</shiro:user></p><!-- user标签  认证通过或已记住的用户。 -->
			
			<p class="text-info glyphicon glyphicon-user">
			<shiro:hasRole name="admin"><!-- 判断是否包含某个角色 -->
				欢迎有admin角色的用户！<shiro:principal /><br>
			</shiro:hasRole>            <!-- principal 标签  输出当前用户信息，通常为登录帐号信息。 -->
			</p>
			
			<p class="text-center glyphicon glyphicon-euro">
			<shiro:hasPermission name="user:admin">
			欢迎有user:admin权限的用户！<shiro:principal />
				<hr>
			</shiro:hasPermission>
			</p>
			
			<p class="text-muted glyphicon glyphicon-heart">
			<shiro:authenticated>认证用户</shiro:authenticated><!-- authenticated标签  已认证通过的用户。不包含已记住的用户，这是与user标签的区别所在。 -->
			</p>
				
		</div>
	
		<div class="odiv panel-body" style="margin-top:50px;">
			<ul class="nav nav-pills" style="margin-left:100px;">
				  <li class="active"><a href="main_forward">Home</a></li>
				  <li><a href="showListInfo">信息列表</a></li>
				  <li><a href="showListUser">用户列表</a></li>
				  <li><a href="#">角色列表</a></li>
				  <li><a href="#">权限列表</a></li>
				  <li><a href="logout">退出</a></li>
			</ul>
		</div>
		
		<div class="panel-footer" style="margin-top:90px;"><label id="timeShow"></lable></div>
	
	</div>
	<script language="javascript">
     var t = null;
	    t = setTimeout(time,1000);//开始执行
	    function time() {
	       clearTimeout(t);//清除定时器
	       dt = new Date();
	       var h=dt.getHours();
	       var m=dt.getMinutes();
	       var s=dt.getSeconds();
	       document.getElementById("timeShow").innerHTML =  "现在的时间为："+h+"时"+m+"分"+s+"秒";
	       t = setTimeout(time,1000); //设定定时器，循环执行             
    	} 
  </script>
</body>
</html>