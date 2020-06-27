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
    session.setAttribute("policePath", basePath+"mlxt/police/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询</title>
<link rel="shortcut icon"
	href="<%=basePath%>plug-in/system/images/favicon.ico">
<link href="<%=basePath%>plug-in/bootstrap-3.3.7/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>plug-in/jquery-3.4.1/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>plug-in/bootstrap-3.3.7/js/bootstrap.js"></script>

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
        
        if("${user}" == null && "${police}" == null){
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

	//上传图片后预览图片
	function viewImage(file) {
		var preview = document.getElementById('preview');
		if (file.files && file.files[0]) {
			//火狐下
			preview.style.display = "inline";
			preview.style.width = "200px";
			preview.style.height = "200px";
			preview.src = window.URL.createObjectURL(file.files[0]);
		} else {
			//ie下，使用滤镜
			file.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//必须设置初始大小 
			localImagId.style.width = "150px";
			localImagId.style.height = "150px";
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				locem("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			preview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	};
	
	function setImagePreview(docObj, localImagId, imgObjPreview) {
        if (docObj.files && docObj.files[0]) {
            //火狐下，直接设img属性  
            imgObjPreview.style.display = 'inline';
            imgObjPreview.style.width = '225px';
            imgObjPreview.style.height = '200px';
            imgObjPreview.style.margin = '15px';

            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式    
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;

            //必须设置初始大小  
            localImagId.style.width = "240px";
            localImagId.style.height = "200px";

            //图片异常的捕捉，防止用户修改后缀来伪造图片  
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                        .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    };
    
    function validate() {
        var imgFile = document.getElementById("imgFile").value;
        
        if (imgFile == null || imgFile == '') {
            alert("图片不能为空！");
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
            imageUplode();
        }
    };    
    
    function imageUplode() {
        var formData = new FormData($("#imgUplodeForm")[0]);
        alert("正在查询，请稍后...");
        $.ajax({
            type: "post",
            url: "find.do",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
                if(data == "OK"){
                    alert("查询成功！");
                    window.location.href = "<%=policePath %>findResult";
                } else{
                    alert("${msg}");
                }
            }
        });
    };
	
</script>

<style type="text/css">
body {
	font-size: 16px;
	color: black;
}

input {
	background-color: transparent;
	outline: none;
	border: 0px;
}

div.transbox {
	width: 40%;
	height: 30%;
	margin: 10%;
	background-color: #FFFAFA;
	filter: alpha(opacity = 60);
	opacity: 0.8;
}

.div_imgall {
	border: 1px dashed black;
	width: 42%;
	height: 81%;
	position: absolute;
	top: 11%;
	left: 29%;
	z-index: 100;
}

.input_flie {
	display: block;
	width: 100%;
	height: 100%;
	opacity: 0;
	z-index: 100;
	position: absolute;
	left: 0;
	top: 0;
}

.div_shuline {
	position: absolute;
    width: 36%;
    height: 2%;
    background-color: black;
    left: 32%;
    top: 49%;
    z-index: -1;
}

.div_hengline {
	position: absolute;
	width: 2%;
	height: 50%;
	background-color: black;
	left: 49%;
	top: 25%;
	z-index: -1;
}
</style>
</head>


<body onload="startload()"
	style="background: url(<%=basePath%>plug-in/system/images/mes.PNG) no-repeat center center fixed; background-size: cover;">
	<div class="header" style="height: 100px">
		<div
			style="margin-left: 80px; margin-top: 30px; float: left; line-height: 50px; color: #ffffff; font-size: 30px;">麋&nbsp;&nbsp;鹿&nbsp;&nbsp;寻&nbsp;&nbsp;途&nbsp;&nbsp;系&nbsp;&nbsp;统</div>
		<div
			style="margin-right: 80px; margin-top: 30px; float: right; text-align: left; line-height: 50px;">
			<a href="<%=indexPath %>index" style="color: #ffffff">首页</a>&nbsp;&nbsp;&nbsp; <a
				href="" style="color: #ffffff">用户中心</a>&nbsp;&nbsp;&nbsp; <a
				href="<%=policePath %>logout" style="color: #ffffff">退出登录</a>
		</div>
	</div>
	<div class="background" align="center">
		<div class="transbox" style="margin-top: 60px; margin-bottom: 140px;">
			<div class="modal-body" id="model-body" style="height: 250px">
				<form id="imgUplodeForm" class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group" id="caseIma">
						<label class="div_imgall">
						<input id="imgFile" name="imgFile" type="file"
							style="display: none" class="form-control" id="caseImage"
							accept=".gif,.jpg,.jpeg,.png"
							onchange="javascript:setImagePreview(this,localImag,preview)">
						</label>
						<!-- 修改改改改改 -->
						<div class="div_shuline"></div>
						<div class="div_hengline"></div>
						<div id="localImag">
							<img id="preview" width=-1 height=-1 style="diplay: none" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div class="row-fluid" style="margin-top: 20px;">
					<div class="span12">
						<button class="btn btn-large btn-block" type="button" onclick="validate()">开始识别</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>