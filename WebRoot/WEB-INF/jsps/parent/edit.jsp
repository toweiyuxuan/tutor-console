<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="updateForm" action="${path}/parent_update" method="post" class="definewidth m20">	
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">用户名称</td>
            <td>
	    		<s:textfield id="name" name="parent.PName" type="text" required="true"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td class="tableleft">家教区域</td>
            <td>
            	<s:select id="area" list="#{'1':'呈贡区','2':'官渡区','3':'西山区','4':'五华区','5':'盘龙区'}" name="parent.PArea"></s:select>					
			</td>
        </tr>
        <tr>
            <td class="tableleft">具体地址</td>
            <td>
            	<s:textfield id="address" name="parent.PAddress" type="text" size="50"></s:textfield>				      
			</td>
        </tr>
        <tr>
            <td class="tableleft">学生性别</td>
            <td>
            	<s:select id="gender" list="#{'1':'男','2':'女' }" name="parent.PGender"></s:select>
			</td>
        </tr>
        <tr>
            <td class="tableleft">学生年级</td>
            <td>
           		<s:select id="grade" list="#{'1':'一年级','2':'二年级','3':'三年级','4':'四年级','5':'五年级','6':'六年级','7':'七年级','8':'八年级','9':'九年级','10':'高一','11':'高二','12':'高三'}" name="parent.PGrade"></s:select>					
			</td>
        </tr>
        <tr>
            <td class="tableleft">学生性格类型</td>
            <td>
            	<s:select id="character" list="#{'1':'外向型','2':'内向型','3':'理智型','4':'情绪型','5':'意志型','6':'中间型'}" name="parent.PCharacter"></s:select>					
			</td>
        </tr>
        <tr>
            <td class="tableleft">报酬范围</td>
            <td>
            	<s:select id="money" list="#{'1':'<40','2':'40-50','3':'50-60','4':'60-70','5':'>70'}" name="parent.PMoney"></s:select>	
            </td>
        </tr>
        <tr>
            <td class="tableleft">老师性别限制</td>
            <td>
            	<s:select id="limitgender" list="#{'0':'不限制','1':'限男生','2':'限女生'}" name="parent.PLimitgender"></s:select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">其他说明</td>
            <td>
            	<s:textarea id="other" name="parent.POther" type="text" cols="80" cssStyle="width:630px; height:60px;"></s:textarea>		
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
            	<input type="hidden" name="parent.UId" value="<s:property value="#parent.UId"/>"/>
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
		window.location.href="${path}/parent_list";
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
					window.location.href="${path}/parent_list";
				}
			}
		});
	});
});
</script>
</html>