<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="com.mlxt.pojo.User"%>
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
<title>老人信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>

	<div class="containter">
	    <div class="container text-center" style="height:60px;background-color:  #3894FF">
	    	<h3  style="margin-top:14px;"><font color="#ffffff">老&nbsp;&nbsp;人&nbsp;&nbsp;信&nbsp;&nbsp;息</font></h3>
	    </div>
	    <div class="container">
			    <div class="col-sm-4">
			      	<div style="margin-left: 50px; margin-top: 30px; font-size: 16px;" >
			      		<img src="${oldMan.imgPath}" class="img-responsive" alt="Cinque Terre" width="304" height="236"> 
				  	</div>
			    </div>
		    	<div class="col-sm-6" >
		    		<div style="margin-left: 40px; margin-top: 80px; font-size: 16px;" >
			      		<h3>姓名：${oldMan.name}</h3><br>
			      		<h3>现住地址：${oldMan.address}</h3><br>
				  	</div>
			      	
			    </div>
		</div>
	</div>
</body>
</html>