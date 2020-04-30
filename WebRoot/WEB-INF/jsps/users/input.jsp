<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="addForm" action="${path}/users_add" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">用户身份</td>
        <td>
        	<s:select id="sf" list="#{'1':'家长','2':'老师','3':'机构'}" name="user.USf"></s:select>	
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">用户账号</td>
        <td>
       		<s:textfield id="tel" name="user.UTel" type="text" required="true" autocomplete="off"></s:textfield>   
       		<span><font color="#EDEDED">请尽量使用手机号作为账号！</font></span>          
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">用户密码</td>
        <td>
        	<s:textfield id="password" name="user.UPassword" type="password" required="true" value="123456" autocomplete="off"></s:textfield>            
        	<span><font color="#EDEDED">初始密码为123456！</font></span> 
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary" id="save">保存</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
<script>
$(function () 
{       
	$("#backid").click(function()
	{
		window.location.href="${path}/users_list";
	});
	
	//以下都是提交按钮点击以后所做的事
	$("#save").click(function() 
	{
		var tel = $("#tel").val();
		var password = $("#password").val();
		if(tel != null && tel != "" && password != null && password != "")
		{			
			$("#addForm").ajaxSubmit
			({
				async:true,
				dataType:"text",
				success:function (result) 
				{
					if(result=="success")
					{
						window.location.href="${path}/users_list";
					}
					if(result == "no")
					{
						alert("该用户已存在！");
					}
				},
			});
		}
		else
		{
			alert("用户账号或密码不能为空！");
		}
	}); 
});
</script>
</html>