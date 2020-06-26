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
    String savePath = basePath+"plug-in/person-data/";
    session.setAttribute("savePath", savePath);
    session.setAttribute("indexPath", indexPath);
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
        
        if("${user}" == null){
            alert("您还未登录，请登录！");
        }else if("${msg}" != null && "${msg}" != ""){
            alert("${msg}");
        }
    }
    
    function EnterPress(e){ //传入 event 
        var e = e || window.event;
        if(e.keyCode == 13){
            validate();
        }
    };
    
    function validate() {
        var name = document.getElementById("name").value;
        var address = document.getElementById("address").value;
        var imgFile = document.getElementById("imgFile").value;
        
        if ((name == null || name == '') && (address == null || address == '') && (imgFile == null || imgFile == '')) {
            alert("要修改的信息不能全为空！");
            return false;
        } else {
        	if (imgFile != null && imgFile != '') {
        		var file = $("input[name='imgFile']").val();
        		var fileType = file.substring(file.lastIndexOf(".") + 1).toLowerCase();
        		if (fileType != "jpg" && fileType != "png") {
        			alert("请上传图片文件（jpg、png）！");
        			return false;
        		}
        		var fileSize = $("input[name='imgFile']")[0].files[0].size;
        		if (fileSize > 10485760) {
        			alert("图片文件大小不得超过10M！");
        			return false;
        		}
        	}
        	oldManInfoModify();
        }
    };    
    
    function oldManInfoModify() {
    	var formData = new FormData($("#modifyOldManForm")[0]);
    	alert("正在编码图片，请稍后...");
    	$.ajax({
    		type: "post",
    		url: "modifyOldMan.do",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
    		success: function(data) {
    			if(data == "OK"){
                    alert("信息修改成功！");
                    clearFormData();
                    window.location.reload();
                } else{
                    alert("${msg}");
                }
    		}
    	});
    };
    
    function clearFormData(){
        $("#modifyOldManForm #name").val("");
        $("#modifyOldManForm #address").val("");
        $("#modifyOldManForm #imgFile").val("");
    };
    
</script>

</head>

<body onkeydown="EnterPress()">

	<div class="containter">
		<div class="container text-center"
			style="height: 60px; background-color: #3894FF">
			<h3 style="margin-top: 14px;">
				<font color="#ffffff">老&nbsp;&nbsp;人&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;修&nbsp;&nbsp;改</font>
			</h3>
		</div>
		<div class="container">
			<div class="col-sm-4">
				<div style="margin-left: 50px; margin-top: 50px; font-size: 16px;">
					<img src="<%=basePath%>plug-in/system/images/face4.gif"
						class="img-responsive" alt="Cinque Terre" width="304" height="236">
				</div>
			</div>
			<div class="col-sm-6"
				style="margin-left: 50px; margin-top: 80px; font-size: 16px;">
				<form id="modifyOldManForm" class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><img
							src="<%=basePath%>plug-in/system/images/demo4.png" width="30"
							height="30"></label>
						<div class="col-sm-10">
							<input id="name" name="name" type="text" class="form-control"
								placeholder="老人姓名" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label"><img
							src="<%=basePath%>plug-in/system/images/demo8.png" width="30"
							height="30"></label>
						<div class="col-sm-10">
							<input id="address" name="address" type="text" class="form-control"
								placeholder="老人现住地址" style="width: 310px;">
						</div>
					</div>
					<div class="form-group">
						<label for="imgFile" class="col-sm-2 control-label"><img
							src="<%=basePath%>plug-in/system/images/demo6.png" width="30" height="30"></label>
						<div class="col-sm-10">
							<input id="imgFile" name="imgFile" type="file">
						</div>
					</div>
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<a type="button" class="btn btn-primary" data-toggle="modal" 
					style="background-color: #3894FF" onclick="validate()">完成</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a type="button" class="btn btn-primary" data-dismiss="modal"
						style="background-color: #3894FF" onclick="clearFormData()">取消</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</form>
			</div>
		</div>
	</div>

</body>
</html>