<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="" action="" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">机构标签名</td>
        <td>
        	<input id="mechanismtype" type="text" name="mechanismtype.MName"/>
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
		window.location.href="${path}/mechanismtype_list";
	});
	
	//以下都是提交按钮点击以后所做的事
	$("#save").click(function() 
	{
		var mechanismtypename = $("#mechanismtype").val();
		if(mechanismtypename != null && mechanismtypename != "")
		{
			$.ajax
			({
				url:"${path}/mechanismtype_add",
				type:"post",
				async:true,
				dataType:"text",
				data:{"mechanismtype.MName":mechanismtypename},
				success:function (result) 
				{
					if(result=="success")
					{
						window.location.href="${path}/mechanismtype_list";
					}
					if(result == "no")
					{
						alert("该标签已存在！");
					}
				},
			});
		}
		else
		{
			alert("标签名称不能为空！");
		}
	}); 

});
</script>
</html>