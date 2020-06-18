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
<meta charset="UTF-8">
<!-- IE将使用最新的引擎渲染网页 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 页面的宽度与设备屏幕的宽度一致  初始缩放比例 1:1 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="www.cnblogs.com/kemingli">
<!-- 引入外部bootstrap的css文件(压缩版)，版本是3.3.7 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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
/* 响应式布局 - 小于 600 px 时改为上下布局 */
@media screen and (max-width: 600px) {
	.column {
		width: 100%;
	}
}
</style>
</head>

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
    
</script>

<body>
	<div class="header">
		<div class="footer text-center"
			style="background-color: #46A3FF; height: 90px;">
			<div class="container" style="padding-top: 20px;">
				<div class="navbar-header">
					<a class="navbar-brand" style="font-size: 30px; color: #ffffff">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</a>
				</div>

				<div class="text-right ">
					<div>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<c:if test="${empty police && empty user}">
						    <a href="<%=basePath %>index.jsp" style="color: #ffffff">首页</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
						    <a href="<%=policePath %>login" style="color: #ffffff">警务服务</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=userPath %>login" style="color: #ffffff">用户服务</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=indexPath %>about" style="color: #ffffff">关于我们</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=userPath %>login" style="color: #ffffff">登录</a>
                            <a href="<%=userPath %>register" style="color: #ffffff">|注册</a>
					  	</c:if>
					  	<c:if test="${!empty police && empty user}">
					  	    <a href="<%=basePath %>index.jsp" style="color: #ffffff">首页</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=policePath %>find" style="color: #ffffff">警务服务</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=policePath %>message" style="color: #ffffff">个人中心</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=indexPath %>about" style="color: #ffffff">关于我们</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=policePath %>logout" style="color: #ffffff">登出</a>
					  	</c:if>
					  	<c:if test="${empty police && !empty user}">
                            <a href="<%=basePath %>index.jsp" style="color: #ffffff">首页</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=userPath %>message" style="color: #ffffff">用户服务</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=indexPath %>about" style="color: #ffffff">关于我们</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=userPath %>logout" style="color: #ffffff">登出</a>
                        </c:if>
						
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide"
			style="width: 100%; height: 350px">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>

			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div id="pic0" class="item active">

					<img src="<%=basePath%>plug-in/system/images/face1.jpg"
						alt="First slide" style="height: 350px; width: 100%">
					<div class="carousel-caption">
						<div style="text-align: left">
							<h1>麋鹿寻途系统</h1>
							<br/>
							<p>麋鹿寻途系统是一款帮助民警找到走失老人的家人的便民惠民系统，能够有效地提高对走失老人的寻找效率。
							用户在注册完成后便可将自己或家人的住址信息、联系方式、面部信息上传到系统中，在民警遇到走失的老人之后，
							便可通过对走失者进行面部扫描，快速找到走失者的家人信息，将其安全快速地送回。</p>
							<br>
							<br>
							<br>
							<br>
							<br>
						</div>
					</div>
				</div>
				<div id="pic1" class="item">
					<img src="<%=basePath%>plug-in/system/images/face1.jpg"
						alt="Second slide" style="height: 350px; width: 100%">
				</div>
				<div id="pic2" class="item">
					<img src="<%=basePath%>plug-in/system/images/face2.jpg"
						alt="Third slide" style="height: 350px; width: 100%">
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-md-6">
			<div style="height: 300px; margin-left: 40px; font-size: 20px;">
				<br>
				<br>
				<br>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来，老人走失的新闻越来越频繁的
					出现在人们的视线中。帮助老人回家已是当 今社会热点内容。在“刷脸”的风潮下，我们 将利用人脸识别技术，采集老人面部信息,获
					取家人的联系方式
					<button type="button" class="btn btn-link">了解更多</button>
				</p>
			</div>
		</div>
		<div class="col-md-4"
			style="margin-top: 20px; width: 400px; text-align: center;">
			<img src="plug-in/system/images/face4.gif" class="img-responsive">
		</div>
	</div>
	<div class="container">
		<div class="col-md-4"
			style="margin-top: 20px; width: 400px; text-align: center;">
			<img src="plug-in/system/images/face4.gif" class="img-responsive">
		</div>
		<div class="col-md-6">
			<div style="height: 300px; margin-left: 40px; font-size: 20px;">
				<br>
				<br>
				<br>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来，老人走失的新闻越来越频繁的
					出现在人们的视线中。帮助老人回家已是当 今社会热点内容。在“刷脸”的风潮下，我们 将利用人脸识别技术，采集老人面部信息,获
					取家人的联系方式
					<button type="button" class="btn btn-link">了解更多</button>
				</p>
			</div>
		</div>
	</div>
	<div class="footer" style="height: 180px;">
		<div class="footer text-center"
			style="background-color: #46A3FF; height: 180px;">
			<div class="container" style="padding-top: 20px;">
				<div class="container">
					<br> <a class="navbar-brand"
						style="font-size: 30px; color: #ffffff">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</a>
				</div>
				<div class="container">
					<a class="navbar-brand" href="#"
						style="font-size: 15px; color: #ffffff">地址：甘肃省兰州市西北师范大学</a> <a
						class="navbar-brand" href="#"
						style="font-size: 15px; color: #ffffff">电话：XXXXXXXXXXX</a> <a
						class="navbar-brand" href="#"
						style="font-size: 15px; color: #ffffff">邮箱：sandaiyi08@163.com</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>