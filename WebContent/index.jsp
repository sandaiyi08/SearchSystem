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
<meta charset="UTF-8" http-equiv="refresh" content="0;url=<%=indexPath %>index">
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
</head>
<body>
</body>
</html>