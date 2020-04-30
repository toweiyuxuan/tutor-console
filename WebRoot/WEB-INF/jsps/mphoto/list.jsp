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
<form id="queryForm" class="form-inline definewidth m20" action="${path}/mphoto_list" method="post">	
	用户名称：
	<s:textfield style="width: 100px" autocomplete="off" name="query.UTel" type="text" class="abc input-default"></s:textfield>
	&nbsp;&nbsp;
	<button id="query" type="button" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<!-- <button type="button" class="btn btn-success" id="addnew">新增用户</button> -->
	<table class="table table-bordered table-hover definewidth m10">
	    <thead>
	    <tr>
	    	<th>用户</th>
	        <th>图片</th>
	        <th>操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="mphoto">
	    <tr>
	    	<td>
          		<s:property value="#mphoto.UTel"/>
          	</td>
          	<td>
	    		<img src="/wyx_jj<s:property value="#mphoto.mpAddress"/>" width="100px" height="50px"/>
          	</td>
          	<td>
          		<a href="javascript:void(0);" onclick="del(<s:property value="#mphoto.mpId"/>)">删除</a> &nbsp;
            </td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
<script>
function del(id)
{
	if(confirm("确定删除该用户的此张图片吗？"))
	{
		 $.ajax
		({
		    url: "${path}/mphoto_detele?mphoto.mpId="+id,
		    type: "post",
		    async:true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/mphoto_list";
				}
		 	}
		});
	}
}
</script>
</html>