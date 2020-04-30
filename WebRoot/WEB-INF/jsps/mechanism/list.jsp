<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a 
{
	position: relative;
}
a img
{
	display: none;
	position:absolute;
	left: 50%;
	margin-left: -60px;
	margin-top: -2px;
}
a:hover img
{
	display: block;
}
</style>
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
<form id="queryForm" class="form-inline definewidth m20" action="${path}/mechanism_list" method="post">	
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.tel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;
	区域：
	<s:select style="cursor:pointer;color:gray;width: 100px;" 
			  list="#{'1':'呈贡区','2':'官渡区','3':'西山区','4':'五华区','5':'盘龙区'}" 
			  name="query.MArea" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	地址：
	<s:textfield style="width: 100px" autocomplete="off" name="query.MAddress" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;	
		
	<button id="query" type="button" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	
	<table class="table table-bordered table-hover definewidth m10" style="table-layout:fixed;">
	    <thead>
	    <tr>
	        <th width="100px">用户账号</th>
	        <th width="200px">机构名称</th>
	        <th width="100px">机构所在区域</th>
	        <th width="100px">机构所在地址</th>
	        <th width="130px">机构特点</th>
	        <th width="130px">机构简介</th>
	        <th width="130px">联系方式</th>
	        <th width="100px">首页图片</th>
	        <th width="100px">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="mechanism">
	    <tr>
	    	<td><s:property value="#mechanism.user.UTel"/></td>
	    	<td title="<s:property value="#mechanism.MName"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mechanism.MName"/>
	    	</td>
	    	<td>
	          	<s:if test="#mechanism.MArea==1">呈贡区</s:if>
				<s:if test="#mechanism.MArea==2">官渡区</s:if>
				<s:if test="#mechanism.MArea==3">西山区</s:if>
				<s:if test="#mechanism.MArea==4">五华区</s:if>
				<s:if test="#mechanism.MArea==5">盘龙区</s:if>
			</td>
	    	<td title="<s:property value="#mechanism.MAddress"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mechanism.MAddress"/>
	    	</td>
	    	<td title="<s:property value="#mechanism.MTedian"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mechanism.MTedian"/>
	    	</td>
	    	<td title="<s:property value="#mechanism.MIntroduce"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mechanism.MIntroduce"/>
	    	</td>
	    	<td title="<s:property value="#mechanism.MContact"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mechanism.MContact"/>
	    	</td>
	    	<td>
	    		<s:if test="#mechanism.MHomepage!=null">
	    		<a href="" class="text-muted">
	          		<span>显示首页图片</span><br/>
	    			<img style="z-index:99" src="/wyx_jj<s:property value="#mechanism.MHomepage"/>" width="200px"/>
    			 </a>
    			 </s:if>
			</td>
          	<td>
              	<a href="${path}/mechanism_edit?mechanism.UId=<s:property value="#mechanism.UId"/>">编辑</a> &nbsp;  
          	</td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
</html>