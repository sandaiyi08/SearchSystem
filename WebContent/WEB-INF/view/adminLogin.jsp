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
    session.setAttribute("indexPath", indexPath);
    session.setAttribute("managePath", basePath+"mlxt/manage/");
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

    function startload1(){
        /* var thiswidth = document.documentElement.clientWidth;
        var thisheignt = document.documentElement.clientHeight;
        var loginform = document.getElementById("loginform");
        var passworddiv = document.getElementById("passworddiv");
        var codetext = document.getElementById("codetext");
        var passwordtext = document.getElementById("passwordtext");
        var radioset = document.getElementById("radioset");
        
        var formwidth = 0.205*thiswidth;
        var formheight = 0.18*thisheignt;
        var textheight = 0.0745*thisheignt;
        
        loginform.style.position="absolute";
        passworddiv.style.position="absolute";
        passwordtext.style.position="absolute";
        radioset.style.position="absolute";
        
        loginform.style.width = formwidth+"px";
        loginform.style.height = formheight+"px";
        
        loginform.style.left = 0.4345*thiswidth+"px";
        loginform.style.top = 0.4747*thisheignt+"px";
        
        radioset.style.marginLeft = 0.01*thiswidth+"px";
        radioset.style.marginTop = 0.132*thisheignt+"px";
        
        passwordtext.style.marginTop = 0.179*formheight+"px";
        
        codetext.style.height = textheight+"px";
        codetext.style.width = formwidth+"px";
        
        passwordtext.style.height = textheight+"px";
        passwordtext.style.width = formwidth+"px"; */
        
        if("${manager}" == null){
            alert("您还未登录，请登录！");
        }else if("${msg}" != null && "${msg}" != ""){
            alert("${msg}");
        }
    };
    
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
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;
        
        if (password == null || password == '') {
            alert("密码不能为空！");
            return false;
        } else if (account == null || account == '') {
            alert("账号不能为空！");
            return false;
        } else {
            manageLogin();
        }
    };
    
    function manageLogin() {
        $("#manageLoginForm").attr("action", "<%=managePath %>login.do").submit();
    };
    
    function clearFormData(){
        $("#manageLoginForm #account").val("");
        $("#manageLoginForm #password").val("");
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
	style="background: url(<%=basePath%>plug-in/system/images/face.png) no-repeat center center fixed; background-size: 100%;"
	onkeydown="EnterPress()" onload="startload()">
	<div class="modal-dialog"
		style="margin-top: 13%; width: 500px; height: 400px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title text-center" id="myModalLabel">管&nbsp;&nbsp;理&nbsp;&nbsp;员&nbsp;&nbsp;登&nbsp;&nbsp;录</h4>
			</div>
			<div class="modal-body" id="model-body" style="height: 220px">
				<form id="manageLoginForm" class="form-horizontal" role="form">
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="account" class="col-sm-2 control-label"><img
							src="<%=basePath%>plug-in/system/images/demo1.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="account" name="account" type="text"
								class="form-control" placeholder="用户名 "
								style="width: 310px; height: 40px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="password" class="col-sm-2 control-label"><img
							src="<%=basePath%>plug-in/system/images/demo2.png" width="35" height="35"></label>
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
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a type="button"
					class="btn btn-default" href="<%=indexPath%>index">返回</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>

</body>

</html>