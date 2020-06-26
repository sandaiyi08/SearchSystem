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
<title>用户信息</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

    function startload(){
        /* var thiswidth = document.documentElement.clientWidth;
        var thisheignt = document.documentElement.clientHeight;
        var loginform = document.getElementById("loginform");
        var passworddiv = document.getElementById("passworddiv");
        var codetext = document.getElementById("codetext");
        var passwordtext = document.getElementById("passwordtext");
        var radioset = document.getElementById("radioset");
        
        var formwidth = 0.205*thiswidth;
        var formheight = 0.18*thisheignt;
        var textheight = 0.0745*thisheignt;
        
        loginform.style.position="absolute";
        passworddiv.style.position="absolute";
        passwordtext.style.position="absolute";
        radioset.style.position="absolute";
        
        loginform.style.width = formwidth+"px";
        loginform.style.height = formheight+"px";
        
        loginform.style.left = 0.4345*thiswidth+"px";
        loginform.style.top = 0.4747*thisheignt+"px";
        
        radioset.style.marginLeft = 0.01*thiswidth+"px";
        radioset.style.marginTop = 0.132*thisheignt+"px";
        
        passwordtext.style.marginTop = 0.179*formheight+"px";
        
        codetext.style.height = textheight+"px";
        codetext.style.width = formwidth+"px";
        
        passwordtext.style.height = textheight+"px";
        passwordtext.style.width = formwidth+"px"; */
        
        if("${manager}" == null){
            alert("您还未登录，请登录！");
        }else if("${msg}" != null && "${msg}" != ""){
            alert("${msg}");
        }
    };
    
    function EnterPress(e){ //传入 event 
        var e = e || window.event;
        if(e.keyCode == 13){
            validate();
        }
    };
    
    function validate() {
        var telModify = document.getElementById("telModify").value;
        var password = document.getElementById("mpassword").value;
        var name = document.getElementById("sname").value;
        
        if ((telModify == null || telModify == '') && (password == null || password == '') && (name == null || name == '')) {
            alert("要修改的信息不能全为空！");
            return false;
        } else {
            userInfoModify();
        }
    };

    function userInfoModify() {
    	$.post("modifyUser.do", $("#modifyUserForm").serialize(),
    	function(data) {
    		if(data == "OK"){
                alert("信息修改成功！");
                $("#modifyUserForm #stel").attr("value","");
                clearFormData();
                window.location.reload();
            } else{
                alert("${msg}");
            }
    	});
    };

    function clearFormData(){
        $("#modifyUserForm #telModify").val("");
        $("#modifyUserForm #sname").val("");
        $("#modifyUserForm #mpassword").val("");
    };
    
    function changeUserTel(tel) {
        if (tel != null && tel > 0) {
            var userTel = document.getElementById("userTel");
            userTel.innerHTML = tel;
            $("#modifyUserForm #stel").attr("value",tel);
            //alert(document.getElementById("stel").value);
    	}
	};
    
</script>

</head>

<body>

	<div class="containter" style="height: 600px">
		<div class="container text-center"
			style="height: 60px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">用&nbsp;&nbsp;户&nbsp;&nbsp;管&nbsp;&nbsp;理</font>
			</h3>
		</div>
		<div class="container" style="margin-top: 5px;">
			<form id="searchForm" class="navbar-form navbar-right" role="search" action="<%=managePath %>manageUser" method="get">
				<div class="input-group">
					<br>
					<button class="btn btn-default" type="submit"
						style="background-color: #3894FF">
						<font style="color: #ffffff;">查询</font>
					</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="name" name="name" type="text" class="form-control" placeholder="姓名查询..." style="width: 140px; margin-right: 10px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="tel" name="tel" type="text" class="form-control" placeholder="电话查询..." style="width: 140px; margin-right: 10px;">
				</div>
			</form>
			<br>
			<table class="table table-striped" style="margin-top: 15px;">
				<thead>
					<tr>
						<th>用户姓名</th>
						<th>用户电话</th>
						<th>用户密码</th>
						<th>信息管理</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${page.rows}">
						<tr>
							<td>${user.name}</td>
							<td>${user.tel}</td>
							<td>${user.password}</td>
							<td><button type="button" class="label label-default" data-target="#modify" data-toggle="modal" 
							onclick="changeUserTel('${user.tel}')" style="background-color: #3894FF;">修改</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="modify" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改电话号码为<a id="userTel"></a>的用户信息</h4>
				</div>
				<div class="modal-body">
					<form id="modifyUserForm" class="form-horizontal" role="form">
						<div class="form-group">
							<label for="telModify" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo7.png" width="30"
								height="30"></label>
							<div class="col-sm-10">
							    <input id="stel" name="tel" type="hidden">
								<input id="telModify" name="telModify" type="text" class="form-control"
									placeholder="电话号码" style="width: 310px;">
							</div>
						</div>
						<div class="form-group">
                            <label for="sname" class="col-sm-2 control-label"><img
                                src="<%=basePath%>plug-in/system/images/demo5.png" width="30"
                                height="30"></label>
                            <div class="col-sm-10">
                                <input id="sname" name="name" type="text" class="form-control"
                                    placeholder="用户姓名" style="width: 310px;">
                            </div>
                        </div>
						<div class="form-group">
							<label for="mpassword" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo2.png" width="30"
								height="30"></label>
							<div class="col-sm-10">
								<input id="mpassword" name="password" type="text"
									class="form-control" placeholder="密码" style="width: 310px;">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="Button1"
						onClick="validate();">完成</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>