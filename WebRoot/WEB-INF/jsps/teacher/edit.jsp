<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="updateForm" action="${path}/teacher_update" method="post" class="definewidth m20">	
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">用户姓名</td>
            <td>
	    		<s:textfield id="name" name="teacher.TName" type="text" required="true"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">用户年龄</td>
            <td>
	    		<s:textfield id="age" name="teacher.TAge" type="text" required="true"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">用户性别</td>
            <td>
	    		<s:select id="gender" list="#{'1':'男','2':'女' }" name="teacher.TGender"></s:select>
			</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">毕业学校</td>
            <td>
	    		<s:textfield id="school" name="teacher.TSchool" type="text" required="true" cssStyle="width:630px;"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">专业</td>
            <td>
	    		<s:textfield id="major" name="teacher.TMajor" type="text" required="true" cssStyle="width:630px;"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">地址</td>
            <td>
	    		<s:textfield id="address" name="teacher.TAddress" type="text" required="true" cssStyle="width:630px;"></s:textfield>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">自我介绍</td>
            <td>
	    		<s:textarea id="introduce" name="teacher.TIntroduce" type="text" required="true" cssStyle="width:630px; height:60px;"></s:textarea>    		
           	</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">经验分享</td>
            <td>
	    		<s:textarea id="experience" name="teacher.TExperience" type="text" required="true" cssStyle="width:630px; height:100px;"></s:textarea>    		
           	</td>
        </tr>
       
        <tr>
            <td class="tableleft"></td>
            <td>
            	<input type="hidden" name="teacher.UId" value="<s:property value="#teacher.UId"/>"/>
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
		window.location.href="${path}/teacher_list";
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
					window.location.href="${path}/teacher_list";
				}
			}
		});
	});
});
</script>
</html>