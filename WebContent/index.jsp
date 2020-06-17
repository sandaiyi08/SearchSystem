<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<style type="text/css">
.starter-template {
	padding: 40px 15px;
	text-align: center;
}

.address {
	background: #efb73e;
	color: #fff;
	padding: 10px 0;
}
.code {
	background-image: url();
	font-family: Arial, 宋体;
	font-style: italic;
	color: green;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}
.unchanged {
	border: 0;
}
</style>
</head>

<script type="text/javascript">
	function adminbtn() {
		<%session.setAttribute("usertype", 1); %>
	}
	function userbtn() {
		<%session.setAttribute("usertype", 0); %>
	}
</script>
<!-- 轮播图 -->
<script>
	var i=0;
	var c = null;
	c = setTimeout(carousel,2000);//开始执行
    function carousel() {
     clearTimeout(c);//清除定时器
     	$("#pic"+i).removeClass("active");
		$("#pic"+(i+1)).addClass("active");
		i++;
      	$("ol li").removeClass("active");
      	$("ol li:eq("+i+")").addClass("active");
     	if(i>2){
      		$("#pic"+(i-1)).removeClass("active");
        	$("#pic0").addClass("active");
        	i=0;
        	$("ol li:eq("+i+")").addClass("active");
      	}
       	c = setTimeout(carousel,2000); //设定定时器，循环执行             
    } 
</script>
<!-- 验证码 -->
<script type="text/javascript">

	var code; //在全局 定义验证码
	function createCode() {
		code = new Array();
		var codeLength = 4;//验证码的长度
		var checkCode = document.getElementById("checkCode");
		checkCode.value = "";
		var selectChar = new Array(2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 32);
			code += selectChar[charIndex];
		}
		if (code.length != codeLength) {
			createCode();
		}
		checkCode.value = code;
	}
	
	function validate() {
		var inputCode = document.getElementById("input1").value.toUpperCase();
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		
		if (inputCode.length <= 0) {
			alert("请输入验证码！");
			return false;
		} else if (inputCode != code) {
			alert("验证码输入错误！");
			createCode();
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
			saveStudent();
		}
	};
	function saveStudent() {
		$.post("<%=indexPath %>insertStudent.do", $("#addStudentForm").serialize(),
		function(data){
			if(data == "OK"){
				alert("添加学生成功！");
				clearFormData();
				clearSearchForm();
				window.location.reload();
			} else{
				alert("操作失败！");
			}
		});
	};
	function clearFormData(){
		$("#addStudentForm #name").val("");
		$("#addStudentForm #code").val("");
		$("#addStudentForm #password").val("");
		$("#addStudentForm #repassword").val("");
		$("#addStudentForm #major").val("");
		$("#addStudentForm #tel").val("");
		$("#addStudentForm #email").val("");
	}
</script>
	
<body onload="createCode()">
	<div class="navbar navbar-default">
		<div class="footer text-center"
			style="background-color: #337ab7; height: 80px;">
			<div class="container" style="padding-top: 20px;">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"
						style="font-size: 25px; color: #ffffff">网络考试系统</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="#" style="color: #ffffff">首页</a></li>
						<li><a href="#" style="color: #ffffff">新闻</a></li>
						<li><a href="#" style="color: #ffffff">论坛</a></li>
						<li><a href="#" style="color: #ffffff">知识库</a></li>
					</ul>
					<div class="navbar-right">
						<form class="navbar-form navbar-left" role="search">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="搜索...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Go</button>
								</span>
							</div>
						</form>
						<form class="navbar-form navbar-left">
							<div class="input-group">
								<a href="<%=userPath %>login" class="btn btn-default" type="button" onclick="userbtn()">
									登录</a> &nbsp;&nbsp;
								<a href="<%=userPath %>register" class="btn btn-default" type="button" onclick="userbtn()">
                                                                        注册</a>&nbsp;&nbsp;
                                <a href="<%=policePath %>login" class="btn btn-default" type="button" onclick="adminbtn()">
                                                                        警察</a>&nbsp;&nbsp;
								<a href="<%=managePath %>login" class="btn btn-default" type="button" onclick="adminbtn()">
								        管理 </a>&nbsp;&nbsp;
								
							</div>
						</form>
						<button type="submit" class="btn btn-default" data-toggle="modal"
							data-target="#regist" style="margin-top: 8px">注册</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div id="myCarousel" class="carousel slide"
			style="width: 100%; height: 400px">
			<!-- 轮播 指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>

			</ol>
			<!-- 轮播 项目 -->
			<div class="carousel-inner">
				<div id="pic0" class="item active">
					<img src="<%=basePath%>plug-in/system/images/exam1.jpg" alt="First slide"
						style="height: 400px; width: 100%">
				</div>
				<div id="pic1" class="item">
					<img src="<%=basePath%>plug-in/system/images/exam2.jpg" alt="Second slide"
						style="height: 400px; width: 100%">
				</div>
				<div id="pic2" class="item">
					<img src="<%=basePath%>plug-in/system/images/exam1.jpg" alt="Third slide"
						style="height: 400px; width: 100%">
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-md-4" style="margin-top: 20px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">欢迎使用网络考试系统</h3>
				</div>
				<div class="panel-body" style="height: 300px;">
					<br/>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网络考试系统为数以万计的用户提供了良好的网络考试解决方案。它基于JAVA与MYSQL开发，可以稳定、顺畅的运行在Windows平台上。您可以通过它在公网或局域网快捷方便的创建题库，发布试卷，组织考试，并由系统自动批改。高度的可配置性和灵活性使得它可以被应用于很多领域。</P>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该系统支持各种常见题型，提供普通试卷、随机试卷两种试卷形式，并且支持试题随机混排，单题与整卷展示模式，有效防止作弊。			
					<p>
				</div>
			</div>
		</div>
		<div class="col-md-4" style="margin-top: 20px;">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">功能与特性介绍</h3>
				</div>
				<div class="panel-body" style="height: 300px;">
					<h3>安全、稳定、高效</h3>
					<p>基于高效的缓存机制，安全、严谨的程序算法开发，支持横向扩展，提升处理能力。</p>
					<h3>操作方便、灵活</h3>
					<p>优化操作流程，鼠标拖拽，数据克隆等技术使得操作简便快捷。</p>
				</div>
			</div>
		</div>
		<div class="col-md-4" style="margin-top: 20px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">最新动态</h3>
				</div>
				<div class="panel-body" style="height: 300px;">
					<blockquote class="tm_blockquote">
						<strong>2019-02-01 </strong><br /> <b style="font-weight: bold">3.1标准版</b>：管理员组卷功能优化、考生答卷界面优化、在线学习、移动端试卷优化，考生账号与题库导出，部分常见问题提示等。
					</blockquote>
				</div>
			</div>
		</div>

	</div>
	<div class="navbar navbar-default " style="padding-top: 5px;margin-bottom: 0px;">
		<div class="footer text-center"
			style="background-color: #337ab7; height: 100px">
			<div class="container" style="padding-top: 25px; color: #ffffff">
				<p style="margin-top: 15px;">-越狱小队-
				<p>
			</div>
		</div>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="regist" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户注册</h4>
				</div>
				<div class="modal-body">
					<form id="addStudentForm">
						<table style="width: 30px;border: 0;cellspacing: 3px;cellpadding: 3px;line-height: 25px" class="table">
							<tr>
								<td>姓名：</td>
								<td><input type="text" name="name" id="name" /></td>
							</tr>
							<tr>
								<td>学号：</td>
								<td><input type="text" name="code" id="code" /></td>
							</tr>
							<tr>
								<td>密码：</td>
								<td><input type="password" name="password" id="password" /></td>
							</tr>
							<tr>
								<td>确认密码：</td>
								<td><input type="password" name="repassword"
									id="repassword" /></td>
							</tr>
							<tr>
								<td>专业：${majorList}</td>
								<td>
								<select name="major" id="major">
								<c:forEach var="item" items="${majorList}">
									<option value="${item.itemCode}">${item.itemName}</option>
								</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>联系方式：</td>
								<td><input type="text" name="tel" id="tel" /></td>
							</tr>
							<tr>
								<td>电子信箱：</td>
								<td><input type="text" name="email" id="email" /></td>
							</tr>
							<tr>
								<td>验证：</td>
								<td><input type="text" id="input1" /> <input type="button"
									id="checkCode" class="code" style="width: 60px"
									onClick="createCode()" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="Button1"
						onClick="validate();">注册</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
