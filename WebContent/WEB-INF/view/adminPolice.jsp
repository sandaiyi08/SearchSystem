<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String examIndexPath = basePath + "exam/";
	String studentPath = path + "/exam/student/";
	String teacherPath = path + "/exam/teacher/";
	String systemPath = path + "/exam/";
	session.setAttribute("indexPath", basePath);
	session.setAttribute("examIndexPath", examIndexPath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>

	<div class="containter" style="height:600px">
		<div class="container text-center" style="height:60px;background-color:  #3894FF">
	    	<h3  style="margin-top:14px;"><font color="#ffffff">警&nbsp;&nbsp;察&nbsp;&nbsp;管&nbsp;&nbsp;理</font></h3>
	    </div>
	    <div class="container" style="margin-top: 5px;"> 
	    	<form class="navbar-form navbar-right" role="search">
				<div class="input-group">
					<br>
					<button class="btn btn-default" type="button" style="background-color: #3894FF"><font style="color:#ffffff;">查询</font></button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="form-control" placeholder="搜索..." style="width:300px">
					<button class="btn btn-default" type="button" data-toggle="modal" data-target="#add"
						style="background-color: #3894FF"><font style="color:#ffffff;">添加成员</font></button>
				</div>
			</form>  
			<br>
		    <table class="table table-striped" style=" margin-top: 15px;">
				<thead>
					<tr>
						<th>登录账号</th>
						<th>使用密码</th>
						<th>信息管理</th>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td>xxx</td>
						<td>xxx</td>
						<td><a href="#">删除</a></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">增加成员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="">
				  		<div class="form-group" >
						    <label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo5.png" width="30" height="30"></label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="firstname" placeholder="用户名" style="width: 310px;">
						    </div>
						</div>
				  		<div class="form-group" >
				  
						    <label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo2.png" width="30" height="30"></label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="firstname" placeholder="密码" style="width: 310px;">
						    </div>
				 		</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="Button1"
						onClick="validate();">完成</button>
					<button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>