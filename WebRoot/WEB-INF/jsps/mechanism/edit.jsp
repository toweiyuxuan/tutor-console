<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="updateForm" action="${path}/mechanism_update" method="post" class="definewidth m20">	
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">机构名称</td>
            <td>
	    		<s:textfield id="name" name="mechanism.MName" type="text" required="true" cssStyle="width:630px;"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">机构所在区域</td>
            <td>
	    		<s:select id="area" list="#{'1':'呈贡区','2':'官渡区','3':'西山区','4':'五华区','5':'盘龙区'}" name="mechanism.MArea"></s:select>						
			</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">机构所在地址</td>
            <td>
	    		<s:textfield id="name" name="mechanism.MAddress" type="text" required="true" cssStyle="width:630px;"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">机构特点</td>
            <td>
	    		<s:textarea id="name" name="mechanism.MTedian" type="text" required="true" cssStyle="width:630px; height:60px;"></s:textarea>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">机构简介</td>
            <td>
	    		<s:textarea id="name" name="mechanism.MIntroduce" type="text" required="true" cssStyle="width:630px; height:100px;"></s:textarea>    		
           	</td>
        </tr>
         <tr>
            <td width="10%" class="tableleft">联系方式</td>
            <td>
	    		<s:textarea id="name" name="mechanism.MContact" type="text" required="true" cssStyle="width:630px; height:60px;"></s:textarea>    		
           	</td>
        </tr>
        
        <tr>
            <td class="tableleft"></td>
            <td>
            	<input type="hidden" name="mechanism.UId" value="<s:property value="#mechanism.UId"/>"/>
                <button type="button" class="btn btn-primary" id="save">保存</button>	&nbsp;&nbsp;
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
		window.location.href="${path}/mechanism_list";
	});
	
	$("#save").click(function()
	{		
		$("#updateForm").ajaxSubmit
		({
			async:true,
			dataType:"text",
			success:function(result)
			{
				if(result == "success")
				{
					window.location.href="${path}/mechanism_list";
				}
			}
		});
	});
});
</script>
</html>