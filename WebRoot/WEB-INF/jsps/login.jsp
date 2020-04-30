<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<title>后台管理员登录</title>
 
  	<link rel="stylesheet" media="screen" href="${path}/login/css/style.css">
  	<link rel="stylesheet" type="text/css" href="${path}/login/css/reset.css">
	
</head>  
<body>

<div id="particles-js">
		<div class="login" style="display: block;">
			<div class="login-top">后台登录</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${path}/login/images/name.png"></div>
				<div class="login-center-input">
					<input type="text" name="username" id="username" value="" placeholder="请输入您的用户名" onfocus="" onblur="请输入您的用户名" autocomplete="off">
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${path}/login/images/password.png"></div>
				<div class="login-center-input">
					<input type="password" name="password" id="password" value="" placeholder="请输入您的密码" onfocus="" onblur="请输入您的密码">
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button">登录</div>
		</div>
		<div class="sk-rotating-plane"></div>
	<canvas class="particles-js-canvas-el" width="1147" height="952" style="width: 100%; height: 100%;"></canvas></div>

<!-- scripts -->
<script src="${path}/login/js/particles.min.js"></script>
<script src="${path}/login/js/app.js"></script>
<script src="${path}/login/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">

if(top.location!=self.location)
{	
	top.location.href = self.location.href;
} 
 	
function hasClass(elem, cls) 
{
  	cls = cls || '';
  	if (cls.replace(/\s/g, '').length == 0) return false;
  	return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
}
	 
function addClass(ele, cls) 
{
  	if (!hasClass(ele, cls)) 
  	{
    	ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
  	}
}
	 
function removeClass(ele, cls) 
{
  	if (hasClass(ele, cls)) 
  	{
    	var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
    	while (newClass.indexOf(' ' + cls + ' ') >= 0) 
    	{
      		newClass = newClass.replace(' ' + cls + ' ', ' ');
    	}
    	ele.className = newClass.replace(/^\s+|\s+$/g, '');
  	}
}
	
function changeCpacha()
{
	$("#cpacha-img").attr("src",'get_cpacha?vl=4&w=150&h=40&type=loginCpacha&t=' + new Date().getTime());
}
document.querySelector(".login-button").onclick = function()
{
	var username = $("#username").val();
	var password = $("#password").val();
	
	if(username == '' || username == 'undefined')
	{
		alert("请填写用户名！");
		return;
	}
	if(password == '' || password == 'undefined')
	{
		alert("请填写密码！");
		return;
	}
	
	addClass(document.querySelector(".login"), "active")
	addClass(document.querySelector(".sk-rotating-plane"), "active")
	document.querySelector(".login").style.display = "none"

	$.ajax
	({
		url:"${path}/ajax_a_login",
		data:{"admin.AUsername":username,"admin.APassword":password},
		type:"post",
		dataType:"text",
		success:function(result)
		{
			if(result=="success")
			{
				window.location.href = "${path}/JJ_index";
			}
			else
			{
				removeClass(document.querySelector(".login"), "active");
				removeClass(document.querySelector(".sk-rotating-plane"), "active");
				document.querySelector(".login").style.display = "block";
				alert("用户名或者密码不正确");
				changeCpacha();
			}
		}
	});		
}
</script>
</body></html>