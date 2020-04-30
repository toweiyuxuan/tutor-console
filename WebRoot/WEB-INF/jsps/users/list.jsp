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

<!--遮罩-->
<div id="load_f" style="background: #FFFFFF;position: absolute;top: 0px;left: 0px;width: 100%;height: 100%;z-index: 100; opacity:0.2;display: none"></div>
<img id="load" src="${path}/Images/load.gif" style="position: absolute;left: 50%;top: 50%;z-index: 101;display: none">

<form id="queryForm" class="form-inline definewidth m20" action="${path}/users_list" method="get">    
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.UTel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	身份：	
	<s:select style="cursor:pointer;color:gray;width:100px;" 
			  list="#{'1':'家长','2':'老师','3':'机构'}" 
			  name="query.USf" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<button type="button" class="btn btn-success" id="addnew">新增用户</button>
	<table class="table table-bordered table-hover definewidth m10" style="table-layout:fixed;">
	    <thead>
	    <tr>
	    	<th width="150">注册时间</th>
	    	<th width="100">用户账号</th>
	        <th width="60">用户身份</th>
	        <th width="260">用户密码</th>
	        <th width="60">使用状态</th>
	        <th width="60">审核进度</th>
	        <th width="60">信息完善</th>
	        <th width="80">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="user">
	    <tr>
	    	<td><s:date name="#user.UTime" format="yyyy-MM-dd HH:mm:ss"/></td>
	    	<td><s:property value="#user.UTel"/></td>
	    	<td>
	          	<s:if test="#user.USf==1">家长</s:if>
				<s:if test="#user.USf==2">老师</s:if>
				<s:if test="#user.USf==3">机构</s:if>
			</td>
          	<td><s:property value="#user.UPassword"/></td>  
          	<td>
          		<s:if test="#user.UStation==1"><font color="#66CD00">正常</font></s:if>
				<s:if test="#user.UStation==2"><font color="red">禁用</font></s:if>
		  	</td>
		  	<td>
	          	<s:if test="#user.UAttestation==1"><font color="#EDEDED">未提交</font></s:if>
				<s:if test="#user.UAttestation==2"><font color="red">待审核</font></s:if>
				<s:if test="#user.UAttestation==3"><font color="black">审核失败</font></s:if>
				<s:if test="#user.UAttestation==4"><font color="#66CD00">已通过</font></s:if>
		  	</td>
		  	<td>
          		<s:if test="#user.UIsfinish==1"><font color="red">未完善</font></s:if>
				<s:if test="#user.UIsfinish==2"><font color="#66CD00">已完善</font></s:if>
		  	</td>
          	<td>
	          	<s:if test="#user.UStation==1">
	          		<a href="javascript:void(0);" onclick="forbid(<s:property value="#user.UId"/>)">禁用</a> &nbsp;
	          	</s:if>
	          	<s:if test="#user.UStation==2">
	          		<a href="javascript:void(0);" onclick="start(<s:property value="#user.UId"/>)">启用</a> &nbsp;
	          	</s:if>
              	<a href="javascript:void(0);" onclick="del(<s:property value="#user.UId"/>)">注销</a> &nbsp; 
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
	window.location.href="${path}/users_input";
});

function forbid(id)
{
	if(confirm("确定禁用该账户吗？"))
	{
		 $.ajax
		({
		    url: "${path}/users_forbid?user.UId="+id,
		    type: "post",
		    async: true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/users_list";		
				}
		 	}
		}); 
	}
}

function start(id)
{
	if(confirm("确定启用该账户吗？"))
	{
		 $.ajax
		({
		    url: "${path}/users_start?user.UId="+id,
		    type: "post",
		    async: true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/users_list";
				}
		 	}
		});
	}
}

function del(id)
{
	if(confirm("该操作不可恢复，确定要注销吗？"))
	{
		 $.ajax
		({
		    url: "${path}/users_detele?user.UId="+id,
		    type: "post",
		    async: true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/users_list";
				}
		 	}
		});
	}
}
</script>
</html>