<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="keywords" content="昆明市中小学家教服务中心" />
<meta name="description" content="昆明市中小学家教服务中心" />

<link rel="stylesheet" type="text/css" href="${path}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${path}/Css/style.css" />

<script type="text/javascript" src="${path}/Js/jquery.js"></script>
<script type="text/javascript" src="${path}/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="${path}/Js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/Js/ckform.js"></script>
<script type="text/javascript" src="${path}/Js/common.js"></script>

<script type="text/javascript" src="${path}/Js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/Js/jquery.form.js"></script>

<style type="text/css">
    body 
    {
        padding-bottom: 40px;
    }
    .sidebar-nav 
    {
        padding: 9px 0;
    }

    @media (max-width: 980px) 
    {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right 
        {
            float: none;
            padding-left: 5px;
            padding-right: 5px;
        }
    }
</style>

<script type="text/javascript">
	//var path = "${path}";
	//从session中拿到用户信息
	var user='<%=session.getAttribute("user")%>';
</script>

<title>昆明市中小学家教服务中心后台管理系统</title>
</head>
<body>

<!--遮罩-->
<div id="load_f" style="background: #FFFFFF;position: absolute;top: 0px;left: 0px;width: 100%;height: 100%;z-index: 100; opacity:0.2;display: none"></div>
<img id="load" src="${path}/Images/load.gif" style="position: absolute;left: 50%;top: 50%;z-index: 101;display: none">

</body>
<script type="text/javascript">

window.onload = function () 
{
	function loadingEffect()
	{
		$(document).ajaxStart(function () 
		{
			$("#load_f").show();
	       	$("#load").show();
	    }).ajaxSuccess(function () 
	    {
	      	$("#load_f").hide();
	       	$("#load").hide();
		});
	};
	loadingEffect();
}
 
</script>

</html>