<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String examIndexPath = basePath + "exam/";
	String studentPath = path + "/exam/student/";
	String teacherPath = path + "/exam/teacher/";
	String systemPath = path + "/exam/";
	session.setAttribute("indexPath", basePath);
	session.setAttribute("examIndexPath", examIndexPath);
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
			      		<img src="plug-in/system/images/face4.gif" class="img-responsive" alt="Cinque Terre" width="304" height="236"> 
				  	</div>
			    </div>
		    	<div class="col-sm-6" >
		    		<div style="margin-left: 40px; margin-top: 80px; font-size: 16px;" >             
			      		<h3>姓名：</h3><br>
			      		<h3>现住地址：</h3><br> 
				  	</div>
			      	
			    </div>
		</div>
	</div>
</body>
</html>