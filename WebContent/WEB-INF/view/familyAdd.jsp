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
<title>老人信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<div class="containter">
		<div class="container text-center" style="height:60px;background-color:  #3894FF">
	    	<h3  style="margin-top:14px;"><font color="#ffffff">增&nbsp;&nbsp;添&nbsp;&nbsp;成&nbsp;&nbsp;员</font></h3>
	    </div>
	    <div class="container">
			<div class="col-sm-8">
		    		<div style="margin-left: 300px; margin-top: 50px; font-size: 16px;">
			    		<form class="form-horizontal" role="form">
							<div class="form-group" >
								<br>
						    	<label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo5.png" width="30" height="30"></label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="firstname" placeholder="姓名" style="width: 310px;">
						   		</div>
						  	</div>
						  	<div class="form-group" >
						  		<br>
						    	<label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo7.png" width="30" height="30"></label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="firstname" placeholder="联系方式" style="width: 310px;">
						    	</div>
						  	</div>
						  	<br>
						  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   	<a type="submit" class="btn btn-primary" data-toggle="modal" style="background-color:  #3894FF"
								data-target="#regist">完成</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                 	<a type="button" class="btn btn-primary" href="#" data-dismiss="modal" style="background-color:  #3894FF">取消</a>
		                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 </form>
					</div>
			    </div>
		</div>
	</div>
</body>
</html>