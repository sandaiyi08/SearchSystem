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
	
	var msg = "${msg}";
    function startload(){
        if(msg != null && msg != ""){
            alert(msg);
        }
    };
	
	var code;
    function createCode() {
        code = new Array();
        var codeLength = 4;
        var selectChar = new Array('1','2','3','4','5','6','7','8','9','0');
        for (var i = 0;i < codeLength; i++) {
            code += selectChar[Math.floor(Math.random() * 10)];
        }
        if (code.length != codeLength) {
            createCode();
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
        var inputCode = document.getElementById("code").value.toUpperCase();
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        
        if (tel == null || tel == '') {
        	alert("请输入手机号码！");
            return false;
        } else if (!(/^1[3456789]\d{9}$/.test(tel))) {
            alert("手机号码有误，请重新填写！");
            return false;
        } else if (inputCode.length <= 0) {
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
	style="background: url(<%=basePath %>plug-in/system/images/face.png) no-repeat center center fixed; background-size: 100%;" 
	onkeydown="EnterPress()" onload="startload()">
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
							src="<%=basePath %>plug-in/system/images/demo1.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="tel" name="tel" type="text" class="form-control"
								placeholder="手机号 " style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="password" class="col-sm-2 control-label"><img
							src="<%=basePath %>plug-in/system/images/demo2.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="password" name="password" type="password"
								class="form-control" placeholder="密码" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="repassword" class="col-sm-2 control-label"><img
							src="<%=basePath %>plug-in/system/images/demo2.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="repassword" name="repassword" type="password"
								class="form-control" placeholder="确认密码" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
						<label for="lastname" class="col-sm-2 control-label"><img
							src="<%=basePath %>plug-in/system/images/demo3.png" width="25" height="30"></label>
						<div class="col-sm-10">
							<div class="input-group">
								<input id="code" name="code" type="text" class="form-control"
									placeholder="验证码" autocomplete="off" style="width: 200px;">
								<button class="btn btn-default" type="button" id="codeBtn" style="width: 110px;">验证码</button>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						var codeBtn = document.getElementById("codeBtn");
						codeBtn.onclick = function() {
							createCode();
							alert("您的验证码为： " + code);
							codeBtn.disabled = true; //当点击后倒计时时候不能点击此按钮
							var time = 9; //倒计时59秒
							var timer = setInterval(fun1, 1000); //设置定时器
							function fun1() {
								time--;
								if (time >= 0) {
									codeBtn.innerHTML = time + "s后重新发送";
								} else {
									codeBtn.innerHTML = "重新发送验证码";
									codeBtn.disabled = false; //倒计时结束能够重新点击发送的按钮
									clearTimeout(timer); //清除定时器
									time = 9; //设置循环重新开始条件
								}
							}
						};
					</script>
				</form>
			</div>
			<div class="modal-footer">
				<a type="button" class="btn btn-primary" onclick="validate()">注册</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<a type="button" class="btn btn-default" href="<%=indexPath%>index">返回</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>

</html>