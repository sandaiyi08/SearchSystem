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
    session.setAttribute("indexPath", basePath);
    session.setAttribute("userPath", basePath+"mlxt/user/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script type="text/javascript" src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

    var code = 1111;
    
	function startload(){
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
		
		if("${user}" == null && "${police}" == null){
			alert("您还未登录，请登录！");
		}else if("${msg}" != null && "${msg}" != ""){
			alert("${msg}");
		}
	};
	
	function EnterPress(e){ //传入 event 
		var e = e || window.event;
		if(e.keyCode == 13){
			validate();
		}
	};
	
	function validate() {
        var inputCode = document.getElementById("code").value.toUpperCase();
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        
        if (inputCode.length <= 0) {
            alert("请输入验证码！");
            return false;
        } else if (inputCode != code) {
            alert("验证码输入错误！");
            
            //createCode();
            return false;
        } else if (password == null || password == '' || repassword == null || repassword == '') {
            alert("密码不能为空！");
            return false;
        } else if (password != repassword) {
            alert("两次密码输入不一致！");
            $("#addStudentForm #password").val("");
            $("#addStudentForm #repassword").val("");
            return false;
        } else {
        	saveUser();
        }
    };
    
    function saveUser() {
        $.post("<%=userPath %>register.do", $("#addUserForm").serialize(),
        function(data){
            if(data == "OK"){
            	window.location.href = "<%=userPath %>collect";
                alert("添加用户成功！");
                clearFormData();
                clearSearchForm();
            } else{
                alert("操作失败！");
            }
        });
    };
    
    function clearFormData(){
    	$("#addUserForm #tel").val("");
        $("#addUserForm #password").val("");
        $("#addUserForm #repassword").val("");
        $("#addUserForm #code").val("");
    };
</script>

<style type="text/css">
	body {
		font-size: 16px;
		color: black;
	}
	.log_background{
		background: url("<%=basePath%>plug-in/system/images/face1.jpg") no-repeat center center fixed;
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
	style="background: url(plug-in/system/images/face1.jpg) no-repeat center center fixed; background-size: 100%;" 
	onkeydown="EnterPress()">
	<div class="modal-dialog"
		style="margin-top: 7.5%; width: 500px; height: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title text-center" id="myModalLabel">注&nbsp;&nbsp;&nbsp;&nbsp;册</h4>
			</div>
			<div class="modal-body" id="model-body" style="height: 400px">
				<form class="form-horizontal" role="form" id="addUserForm">
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="tel" class="col-sm-2 control-label"><img
							src="plug-in/system/images/demo1.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="tel" name="tel" type="text" class="form-control"
								placeholder="手机号 " style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="password" class="col-sm-2 control-label"><img
							src="plug-in/system/images/demo2.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="password" name="password" type="text"
								class="form-control" placeholder="密码" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="repassword" class="col-sm-2 control-label"><img
							src="plug-in/system/images/demo2.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="repassword" name="repassword" type="text"
								class="form-control" placeholder="确认密码" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="lastname" class="col-sm-2 control-label"><img
							src="plug-in/system/images/demo3.png" width="25" height="30"></label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="code" name="code" type="text" class="form-control"
									placeholder="验证码" autocomplete="off" style="width: 240px;">
								<button class="btn btn-default" type="button">验证码</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<a type="button" class="btn btn-primary" onclick="validate()">注册</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<a type="button" class="btn btn-default" href="<%=basePath%>index.jsp">返回</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>

</html>