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
	   	<h3  style="margin-top:14px;"><font color="#ffffff">老&nbsp;&nbsp;人&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;修&nbsp;&nbsp;改</font></h3>
	</div>
    <div class="container">
		    <div class="col-sm-4">
			    <div style="margin-left: 50px; margin-top: 50px; font-size: 16px;" >             
			      	<img src="plug-in/system/images/face4.gif" class="img-responsive" alt="Cinque Terre" width="304" height="236"> 
				</div>
			</div>
	    	<div class="col-sm-6" style="margin-left: 50px; margin-top: 80px; font-size: 16px;">
	    		<form class="form-horizontal" role="form">
				  <div class="form-group" >
				    <label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo4.png" width="30" height="30"></label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="firstname" placeholder="老人姓名" style="width: 310px;">
				    </div>
				  </div>
				  <div class="form-group" >
				    <label for="firstname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo8.png" width="30" height="30"></label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="firstname" placeholder="老人现住地址" style="width: 310px;">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastname" class="col-sm-2 control-label"><img src="plug-in/system/images/demo6.png" width="25" height="30"></label>
				    <div class="col-sm-10">
				      	<div class="input-group">
   							 <input type="file" id="inputfile">
						</div>		
				    </div>
				   </div>
				  <br>
				   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <a type="submit" class="btn btn-primary" data-toggle="modal" style="background-color:  #3894FF"
					data-target="#regist">完成</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <a type="button" class="btn btn-primary" href="#" data-dismiss="modal" style="background-color:  #3894FF">取消</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</form>
		    </div>
	</div>
</div>

</body>
</html>