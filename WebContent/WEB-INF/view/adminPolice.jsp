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
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;
        
        if (account == null || account == '') {
            alert("账号信息不能为空！");
            return false;
        } else if (password == null || password == '') {
        	alert("密码信息不能为空！");
            return false;
        } else {
        	addPoliceman();
        }
    };

    function addPoliceman() {
        $.post("addPolice.do", $("#addPoliceForm").serialize(),
        function(data) {
            if(data == "OK"){
                alert("信息添加成功！");
                $("#addPoliceForm #account").attr("value","");
                clearFormData();
                window.location.reload();
            } else{
                alert("${msg}");
            }
        });
    };

    function clearFormData(){
        $("#addPoliceForm #account").val("");
        $("#addPoliceForm #password").val("");
    };
    
    function deletePolice(account) {
        var r = confirm("您确定删除吗？");
        if (r == true) {
            $.post("delPolice.do", {"account":account}, 
            function(data) {
                if (data == "OK") {
                    alert("删除警察成功！");
                    window.location.reload();
                } else {
                    alert("删除警察失败！");
                }
            });
        }
    };
    
</script>

</head>
<body>
	<div class="containter" style="height: 600px">
		<div class="container text-center"
			style="height: 60px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">警&nbsp;&nbsp;察&nbsp;&nbsp;管&nbsp;&nbsp;理</font>
			</h3>
		</div>
		<div class="container" style="margin-top: 5px;">
			<form id="searchForm" class="navbar-form navbar-right" role="search" action="<%=managePath %>managePolice" method="get">
				<div class="input-group">
					<br>
					<button class="btn btn-default" type="submit"
						style="background-color: #3894FF">
						<font style="color: #ffffff;">查询</font>
					</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="serachAccount" name="account" type="text" class="form-control" placeholder="账号查询..."
						style="width: 200px; margin-right: 5px;">
					<button class="btn btn-default" type="button" data-toggle="modal"
						data-target="#add" style="background-color: #3894FF">
						<font style="color: #ffffff;">添加成员</font>
					</button>
				</div>
			</form>
			<br>
			<table class="table table-striped" style="margin-top: 15px;">
				<thead>
					<tr>
						<th>警察账号</th>
                        <th>警察密码</th>
						<th>信息管理</th>
					</tr>
				</thead>
				<tbody>
				    <c:forEach var="police" items="${page.rows}">
                        <tr>
                            <td>${police.account}</td>
                            <td>${police.password}</td>
                            <td><button type="button" class="label label-danger" 
                            onclick="deletePolice('${police.account}')">删除</button></td>
                        </tr>
                    </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">增加成员</h4>
				</div>
				<div class="modal-body">
					<form id="addPoliceForm" class="form-horizontal" role="form">
						<div class="form-group">
							<label for="account" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo5.png" width="30"
								height="30"></label>
							<div class="col-sm-10">
								<input id="account" name="account" type="text" class="form-control"
									placeholder="警察账号" style="width: 310px;">
							</div>
						</div>
						<div class="form-group">

							<label for="password" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo2.png" width="30"
								height="30"></label>
							<div class="col-sm-10">
								<input id="password" name="password" type="text" class="form-control"
									placeholder="密码" style="width: 310px;">
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