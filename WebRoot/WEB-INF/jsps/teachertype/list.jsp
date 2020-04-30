<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">	
$(function() 
{
	$("#query").click(function() 
	{	
		$("#pageNo").val(1);
		$("#queryForm").submit();
	});
});
</script>
</head>
<body>
<form id="queryForm" class="form-inline definewidth m20" action="${path}/teachertype_list" method="post">	 
	<button type="button" class="btn btn-success" id="addnew">新增老师类型</button>
	<table class="table table-bordered table-hover definewidth m10">
	    <thead>
	    <tr>
	        <th>类型名称</th>
	        <th>操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="teachertype">
	    <tr valign="middle">
	    	<td>
          		<s:property value="#teachertype.ttName"/>
          	</td>
          	<td>
          		<a href="javascript:void(0);" onclick="del(<s:property value="#teachertype.ttId"/>)">删除</a> &nbsp;
          		<a href="${path}/teachertype_edit?teachertype.ttId=<s:property value="#teachertype.ttId"/>">编辑</a> &nbsp;  
          </td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
<script>
$("#addnew").click(function()
{
	window.location.href="${path}/teachertype_input";
});
function del(id)
{
	if(confirm("确定删除该教师类型吗？"))
	{
		 $.ajax
		({
		    url: "${path}/teachertype_detele?teachertype.ttId="+id,
		    type: "post",
		    async:true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/teachertype_list";
				}
		 	}
		});
	}
}
</script>
</html>