<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mlxt" uri="http://mlxt.com/"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String indexPath = basePath+"mlxt/";
    String userPath = path+"/mlxt/user/";
    String policePath = path+"/mlxt/police/";
    String managePath = path+"/mlxt/manage/";
    String systemPath = path+"/mlxt/";
    session.setAttribute("basePath", basePath);
    session.setAttribute("indexPath", indexPath);
    session.setAttribute("userPath", basePath+"mlxt/user/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script type="text/javascript" src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

    var code = 1111;
    var msg = "${msg}";

	function startload(){
		if(msg != null && msg != ""){
            alert(msg);
        }
	};
	
	function EnterPress(e){ //传入 event 
        var e = e || window.event;
        if(e.keyCode == 13){
            validate();
        }
    };
    
    function validate() {
        var tel = document.getElementById("tel").value;
        var password = document.getElementById("password").value;
        
        if (tel == null || tel == '') {
        	alert("账号不能为空！");
            return false;
        } else if (password == null || password == '') {
            alert("密码不能为空！");
            return false;
        } else {
        	userLogin();
        }
    };
    
    function userLogin() {
    	$("#userLoginForm").attr("action", "<%=userPath %>login.do").submit();
    };
    
    function clearFormData(){
        $("#userLoginForm #tel").val("");
        $("#userLoginForm #password").val("");
        $("#userLoginForm #code").val("");
    };
    
</script>

<style type="text/css">
	body {
		font-size: 16px;
		color: black;
	}
	.log_background{
		background: url("<%=basePath%>plug-in/system/images/face.png") no-repeat center center fixed;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
	}
	.logindiv{
		position="absolute";
	}
	input{
		background-color: transparent;
		outline: none;
		border: 0px;
	}
	
</style>
</head>

<body
	style="background: url(<%=basePath %>plug-in/system/images/face.png) no-repeat center center fixed; 
	background-size: cover; z-index: -1; " onkeydown="EnterPress()" onload="startload()">
	<div class="modal-dialog"
		style="margin-top: 10%; width: 500px; height: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title text-center" id="myModalLabel">登&nbsp;&nbsp;&nbsp;&nbsp;录</h4>
			</div>
			<div class="modal-body" id="model-body" style="height: 220px">
				<form class="form-horizontal" role="form" id="userLoginForm">
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="tel" class="col-sm-2 control-label"><img
							src="<%=basePath %>plug-in/system/images/demo1.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="tel" name="tel" type="text" class="form-control"
								placeholder="用户名 " style="width: 310px; height: 40px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="password" class="col-sm-2 control-label"><img
							src="<%=basePath %>plug-in/system/images/demo2.png" width="35" height="35"></label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="password" name="password" type="password"
									class="form-control" placeholder="密码" autocomplete="off"
									style="width: 310px; height: 40px;">
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<a type="button" class="btn btn-primary" onclick="validate()">登录</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<a type="button"
					class="btn btn-default" href="<%=userPath%>register">注册</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>

</html>