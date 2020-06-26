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
<title>麋鹿寻途系统</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<style type="text/css">
	* {
		box-sizing: border-box;
	}
	body {
		margin: 0;
	}
	/* 头部样式 */
	.header {
		background-color: #ffffff;
		padding: 20px;
		text-align: center;
  		height:80px;
  		color: #3894FF;
	}
	/* 创建三个相等的列 */
	.left {
		float: left;
		width: 20%;
  		height:100%;
	}
	.right {
  		float: left;
  		width: 80%;
  		height:100%;
	}
	/* 列后清除浮动 */
	.row:after {
  		content: "";
  		display: table;
  		clear: both;
	}
	/* 响应式布局 - 小于 600 px 时改为上下布局 */
	@media screen and (max-width: 600px) {
  		.column {
    		width: 100%;
  		}
	}
</style>

<script type="text/javascript" >
	$(function(){
		$(".left a").on("click",function(){
			var address =$(this).attr("data-src");
			$("iframe").attr("src",address);
		});
	});
	function SetWinHeight(obj) {
        obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';   
    }
</script>

</head>
<body>
	<div class="header">
		<div style="margin-left: 35px; float: left; line-height: 50px; font-size: 30px;">后&nbsp;&nbsp;台&nbsp;&nbsp;管&nbsp;&nbsp;理</div>
		<div style="margin-right: 20px; float: right; text-align: left; line-height: 50px;">
			<a href="<%=managePath %>index" style="color:  #3894FF;">首页</a>&nbsp;&nbsp;&nbsp;
			<a href="" style="color: #337ab7;">管理员中心</a>&nbsp;&nbsp;&nbsp;
			<a href="<%=managePath %>logout" style="color:  #3894FF;">退出登录</a>	
		</div>
	</div>
	<div class="row" style="margin-right: 0px">
		<div class="left" style="text-align: center; margin-top: 15px;">
			<a class="list-group-item active" style="background-color: #3894FF;">信息显示</a>
			<a class="list-group-item" data-src="<%=managePath %>policeMessage">警察信息</a>
			<a class="list-group-item" data-src="<%=managePath %>peopleMessage">用户信息</a>
			<a class="list-group-item active" style="background-color:  #3894FF;">信息管理</a>
			<a class="list-group-item" data-src="<%=managePath %>managePolice">管理警察信息</a>
			<a class="list-group-item" data-src="<%=managePath %>manageUser">管理用户信息</a>
		</div>
		<div class="right">
			<!-- 修改改改改改 -->
            <iframe
				style="width: 98%; height: 100%; margin-top: 15px; margin-left: 10px; margin-right: auto; scolling: no; border-style: none;"
				onload="Javascript:SetWinHeight(this)" src="<%=managePath %>policeMessage" id="policeMes">
			</iframe>
		</div>
	</div>		
</body>
</html>