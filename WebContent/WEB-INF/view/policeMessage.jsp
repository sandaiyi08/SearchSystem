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
<title>警察信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>

	<div class="containter">
		<div class="container text-center"
			style="height: 60px; width: 1000px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">警&nbsp;&nbsp;察&nbsp;&nbsp;信&nbsp;&nbsp;息</font>
			</h3>
		</div>
		<div class="container" style="width: 1000px;">

			<table class="table table-striped" style="margin-top: 15px;">
				<thead>
					<tr>
						<th>警察账号</th>
						<th>警察密码</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="police" items="${page.rows}">
						<tr>
							<td>${police.account}</td>
							<td>${police.password}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>