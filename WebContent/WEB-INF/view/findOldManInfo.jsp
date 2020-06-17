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
    session.setAttribute("policePath", basePath+"mlxt/police/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>查询</title>
<link rel="shortcut icon"
	href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

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
	
</script>

<style type="text/css">
body {
    font-size: 16px;
    color: black;
}

input {
	background-color: transparent;
	outline: none;
	border: 0px;
}

div.transbox {
	width: 550px;
	height: 430px;
	margin: 6.5%;
	background-color: #ffffff;
	filter: alpha(opacity = 60);
	opacity: 0.8;
	border-radius: 15px;
	z-index: 0;
}

.div_hengline {
	position: absolute;
	height: 1px;
	background-color: gray;
	left: 50px;
	z-index: 5;
}

.photo {
	position: absolute;
	border: black solid thin;
	height: 120px;
	width: 120px;
	left: 400px;
	top: 5px;
}
</style>
</head>

<body
	style="background: url(plug-in/system/images/mes1.PNG) no-repeat center center fixed; background-size: cover;">
	<div class="header" style="height: 100px">
		<div
			style="margin-left: 80px; margin-top: 30px; float: left; line-height: 50px; color: #ffffff; font-size: 30px;">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</div>
		<div
			style="margin-right: 80px; margin-top: 30px; float: right; text-align: left; line-height: 50px;">
			<a href="<%=basePath%>index.jsp" style="color: #ffffff">首页</a>&nbsp;&nbsp;&nbsp;
			<a href="###" style="color: #ffffff">用户中心</a>&nbsp;&nbsp;&nbsp; <a
				href="<%=policePath%>logout" style="color: #ffffff">退出登录</a>
		</div>
	</div>

	<div class="background" align="center">
		<div class="transbox" style="margin-top: 80px;">
			<div class="modal-header" id="modal-header" style="height: 50px">
				<h4 class="modal-title text-left" id="myModalLabel">老人信息</h4>
			</div>
			<div class="modal-body" id="model-body" style="height: 160px">
				<div class="text-left" style="height: 100px; top: 0px;">
					<br>
					<p>姓名:</p>
					<br>
					<p>住址:</p>
				</div>
				<div class="photo"></div>
				<div class="div_hengline" style="width: 90%; top: 94%; left: 1px;">
					<div class="modal-footer">
						<h4 class="modal-title text-left" id="myModalLabel">家庭成员</h4>
						<div class="div_hengline"
							style="width: 80%; left: 1px; top: 50px;"></div>
						<div class="text-left">
							<br>
							<p>姓名:</p>
							<br>
							<p>联系方式:</p>
							<br>
							<div class="div_hengline"
								style="width: 100%; left: 1px; top: 150px;">
								<br>
							</div>

							<div class="row-fluid">
								<div class="span12">
									<button type="button" class="btn btn-default" type="button"
										style="width: 500px;"
										onClick="window.location.href='<%=policePath%>find'">返回</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>