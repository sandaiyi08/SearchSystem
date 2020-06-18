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
<title>个人信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>

	<div class="containter">
	    <div class="container text-center" style="height:60px;background-color:  #3894FF">
	    	<h3  style="margin-top:14px;"><font color="#ffffff">家&nbsp;&nbsp;庭&nbsp;&nbsp;成&nbsp;&nbsp;员&nbsp;&nbsp;信&nbsp;&nbsp;息</font></h3>
	    </div>
	    <div class="container" style="margin-top: 20px;">
		    <table class="table table-striped" style=" margin-top: 15px;">
				<thead>
					<tr>
						<th>姓名</th>
						<th>联系方式</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${testPaperList2}">
					<tr>
						<td>${item.code}</td>
						<td>${item.name}</td>
						<td>${item.answerTime}</td>
						<td>${item.beginTime}</td>
						<td>${item.score}</td>
						<td><a href="#">详情</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>