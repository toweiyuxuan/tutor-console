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
<form id="queryForm" class="form-inline definewidth m20" action="${path}/mrelease_list" method="post">	
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.MTel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
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
	        <th width="80px">发布账号</th>
	        <th width="80px">发布时间 </th>
	        <th width="80px">机构名称</th>
	        <th width="60px">老师类型 </th>
	        <th width="60px">老师性别 </th>
	        <th width="60px">机构区域</th>
	        <th width="60px">机构地址</th>
	        <th width="60px">机构标签</th>
	        <th width="80px">机构特点</th>
	        <th width="80px">机构简介</th>
	        <th width="80px">联系方式</th>
	        <th width="60px">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="mrelease">
	    <tr>
	    	<td><s:property value="#mrelease.MTel"/></td>
	    	<td><s:date name="#mrelease.RTime" format="yyyy-MM-dd"/></td>
	    	<td title="<s:property value="#mrelease.MName"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MName"/>
	    	</td>
	    	<td title="<s:property value="#mrelease.MTeachertype"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MTeachertype"/>
	    	</td>
	    	<td>
	    		<s:if test="#mrelease.MLimitgender==0">不限</s:if>
	    		<s:if test="#mrelease.MLimitgender==1">男</s:if>
				<s:if test="#mrelease.MLimitgender==2">女</s:if>
	    	</td>
	    	<td>
	          	<s:if test="#mrelease.MArea==1">呈贡区</s:if>
				<s:if test="#mrelease.MArea==2">官渡区</s:if>
				<s:if test="#mrelease.MArea==3">西山区</s:if>
				<s:if test="#mrelease.MArea==4">五华区</s:if>
				<s:if test="#mrelease.MArea==5">盘龙区</s:if>
			</td>
	    	<td title="<s:property value="#mrelease.MAddress"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MAddress"/>
	    	</td>
	    	<td title="<s:property value="#mrelease.MMechanismtype"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MMechanismtype"/>
	    	</td>
	    	<td title="<s:property value="#mrelease.MTedian"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MTedian"/>
	    	</td>
	    	<td title="<s:property value="#mrelease.MIntroduce"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MIntroduce"/>
	    	</td>
	    	<td title="<s:property value="#mrelease.MContact"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#mrelease.MContact"/>
	    	</td>
          	<td>
              	<a href="${path}/mrelease_edit?mrelease.RId=<s:property value="#mrelease.RId"/>">编辑</a> &nbsp;  
          	</td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
</html>