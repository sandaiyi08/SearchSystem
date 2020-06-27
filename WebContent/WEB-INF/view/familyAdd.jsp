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
<title>添加家庭成员</title>
<link rel="shortcut icon" href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

<script type="text/javascript">

    function startload1(){
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
        
        if("${user}" == null){
            alert("您还未登录，请登录！");
        }else if("${msg}" != null && "${msg}" != ""){
            alert("${msg}");
        }
    };
    
    var msg = "${msg}";
    function startload(){
        if(msg != null && msg != ""){
            alert(msg);
        }
    };
    
    function EnterPress(e){ //传入 event 
        var e = e || window.event;
        if(e.keyCode == 13){
            validate();
        }
    };
    
    function validate() {
        var familyTel = document.getElementById("familyTel").value;
        var familyName = document.getElementById("familyName").value;
        
        if (familyTel == null || familyTel == '') {
            alert("联系电话不能为空！");
            return false;
        } else if (familyName == null || familyName == '') {
            alert("姓名不能为空！");
            return false;
        } else {
        	familyInfoAdd();
        }
    };
    
    function familyInfoAdd() {
    	$.post("collectFamily.do", $("#addFamilyForm").serialize(),
    	function(data){
    	    if (data == "OK") {
    	        alert("添加成员成功！");
    	        clearFormData();
    	        window.location.reload();
    	    } else{
    	        alert("${msg}");
    	    }
    	});
    };
    
    function clearFormData(){
        $("#addFamilyForm #familyTel").val("");
        $("#addFamilyForm #familyName").val("");
    };
    
</script>
</head>

<body>
	<div class="containter">
		<div class="container text-center"
			style="height: 60px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">增&nbsp;&nbsp;添&nbsp;&nbsp;成&nbsp;&nbsp;员</font>
			</h3>
		</div>
		<div class="container">
			<div class="col-sm-8">
				<div style="margin-left: 300px; margin-top: 50px; font-size: 16px;">
					<form id="addFamilyForm"class="form-horizontal" role="form">
						<div class="form-group">
							<br> <label for="familyName" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo5.png" width="30" height="30"></label>
							<div class="col-sm-10">
								<input id="familyName" name="familyName" type="text" class="form-control"
									placeholder="姓名" style="width: 310px;">
							</div>
						</div>
						<div class="form-group">
							<br> <label for="familyTel" class="col-sm-2 control-label"><img
								src="<%=basePath%>plug-in/system/images/demo7.png" width="30" height="30"></label>
							<div class="col-sm-10">
								<input id="familyTel" name="familyTel" type="text" class="form-control"
									placeholder="联系方式" style="width: 310px;">
							</div>
						</div>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a type="submit" class="btn btn-primary" data-toggle="modal"
							style="background-color: #3894FF" onclick="validate()">完成</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a type="button"
							class="btn btn-primary" data-dismiss="modal"
							style="background-color: #3894FF" onclick="clearFormData()">取消</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>