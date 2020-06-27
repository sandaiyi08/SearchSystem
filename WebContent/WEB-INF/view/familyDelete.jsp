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
<title>删除家庭成员</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

    var msg = "${msg}";
    function startload(){
        if(msg != null && msg != ""){
            alert(msg);
        }
    };

	function deleteFamily(oldManId, familyName, familyTel) {
		var r = confirm("您确定删除吗？");
		if (r == true) {
			$.post("delFamily.do", {"oldManId":oldManId,"familyName":familyName,"familyTel":familyTel}, 
			function(data) {
				if (data == "OK") {
					alert("删除成员成功！");
					window.location.reload();
				} else {
					alert("删除成员失败！");
				}
			});
		}
	};
	
</script>

</head>


<body>
	<div class="containter">
		<div class="container text-center"
			style="height: 60px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">删&nbsp;&nbsp;除&nbsp;&nbsp;成&nbsp;&nbsp;员</font>
			</h3>
		</div>
		<div class="container" style="margin-top: 20px;">
			<table class="table table-striped" style="margin-top: 15px;">
				<thead>
					<tr>
						<th>成员姓名</th>
						<th>联系方式</th>
						<th>成员删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="familyMember" items="${page.rows}">
						<tr>
							<td>${familyMember.familyName}</td>
							<td>${familyMember.familyTel}</td>
							<td><button type="button" class="label label-danger" 
							onclick="deleteFamily('${familyMember.oldManId}', '${familyMember.familyName}', '${familyMember.familyTel}')">
							删除</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>