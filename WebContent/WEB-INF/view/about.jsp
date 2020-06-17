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
%>
<!DOCTYPE html>
<html>
<head>
<title>关于我们</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap-theme.css"
	rel="stylesheet" type="text/css" />
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
<body>
		<div class="container">
			<div class="footer text-center" style="background-color:#46A3FF; height: 90px;">
				<div class="container" style="padding-top: 20px;">
					<div class="navbar-header">
						<a class="navbar-brand" 
							style="font-size: 30px; color: #ffffff">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</a>
					</div>
					
						<div class="text-center ">
						<div>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="index.jsp" style="color: #ffffff">首页</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="policeLogin.jsp" style="color: #ffffff">警务服务</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="login.jsp" style="color: #ffffff">用户中心</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="about.jsp" style="color:#ffffff">关于我们</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="login.jsp" style="color:#ffffff">登录</a>
							<a href="register.jsp" style="color:#ffffff">|注册</a>
						</div>
					</div>
				
				</div>
			</div>
		</div>
		
		<div class="container" style="width: 1000px; height: 300px">
			<div class="col-md-4" style="width: 450px">
				<div style="height: 180px; margin-left: 40px; margin-top: 80px; font-size: 16px;line-height:30px;">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来，老人走失的新闻越来越频繁的出现在人们的视线中。中民社会救助研究院联合今日头条在民政部发布了《中国老年人走失状况白皮书》。据显示，每年全国走失老人约有50万人，平均每天约1370名老人走失，老年痴呆症成为老人走失的主因。</p>
				</div>
			</div>
			<div class="col-md-4" style="margin-top: 20px; width: 200px">
				<div style="height: 300px;margin-left: 28px; ">
					<img src="plug-in/system/images/pic1.png"
						style="height: 250px; width: 450px">
				</div>
			</div>
		</div>
		
		<div class="container" style="width: 1000px; height: 250px">
			<div class="col-md-2"
				style="margin-top: 10px; left: 20px; width: 400px">
				<div style="height: 200px;">
					<img src="plug-in/system/images/pic2.png"
						style="height: 250px; width: 420px">
				</div>
			</div>
			<div class="col-md-4" style="width: 500px">
				<div style="height: 200px; margin-left: 95px; margin-top: 50px;font-size: 16px;line-height:30px">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目前较为有效的老人防走失措施就是随身携带手机、姓名贴、防走失智能手环等，但是必须随身携带。现在也有很多人会利用媒体效应，在网上发布寻人信息，或者直接张贴寻人启事，但这些方法在时间上有着一定的缓慢，一般24小时以内是找回老人的黄金时间，所以在老人走失问题上的一大难点就是快速找回。</p>
				</div>
			</div>

		</div>

		<div class="container" style="width: 1000px; height: 300px">
			<div class="col-md-5" style="width: 450px">
				<div style="height: 250px; margin-left: 40px;margin-top: 110px; font-size: 16px;line-height:30px">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在老人及其家属信息已经注册登记的情况下，只需对老人的面部信息进行识别，便会迅速得到老人家属的联系方式，为了保障家属的信息安全，我们仅是提供家属的姓名以及电话号码，并不会泄漏重要信息。</p>
				</div>
			</div>
			<div class="col-md-4" style="margin-top: 30px; width: 200px;margin-left: 20px;">
				<div style="height: 300px;margin-left: 28px; ">
					<img src="plug-in/system/images/pic3.png"
						style="height: 250px; width: 400px">
				</div>
			</div>
		</div>
	<br><br>
	<div class="container" style="height: 180px;">
		<div class="footer text-center" style="background-color: #46A3FF; height: 180px;">
			<div class="container" style="padding-top: 20px;">
				<div class="container">
					<br>
					<a class="navbar-brand" 
						style="font-size: 30px; color: #ffffff">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</a>
				</div>
				<div class="container">
					<a class="navbar-brand" href="#" style="font-size: 15px; color: #ffffff">地址：甘肃省兰州市西北师范大学</a>
					<a class="navbar-brand" href="#" style="font-size: 15px; color: #ffffff">电话：XXXXXXXXXXX</a>
					<a class="navbar-brand" href="#" style="font-size: 15px; color: #ffffff">邮箱：sandaiyi08@163.com</a>
				</div>	
			</div>
		</div>
	</div>

</body>
</html>
