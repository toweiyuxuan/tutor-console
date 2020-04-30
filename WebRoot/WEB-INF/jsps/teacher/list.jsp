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
<form id="queryForm" class="form-inline definewidth m20" action="${path}/teacher_list" method="post">	
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.tel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;
	地址：
	<s:textfield style="width: 100px" autocomplete="off" name="query.TAddress" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;
	学校：
	<s:textfield style="width: 100px" autocomplete="off" name="query.TSchool" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;	
	性别：
	<s:select style="cursor:pointer;width: 100px;color:gray;" 
			  list="#{'1':'男','2':'女'}" 
			  name="query.TGender" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
		
	<button id="query" type="button" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<!-- <button type="button" class="btn btn-success" id="addnew">新增用户</button> -->
	<table class="table table-bordered table-hover definewidth m10" style="table-layout:fixed;">
	    <thead>
	    <tr>
	        <th width="100px">用户账号</th>
	        <th width="100px">用户姓名</th>
	        <th width="60px">用户年龄</th>
	        <th width="60px">用户性别</th>
	        <th width="100px">毕业学校</th>
	        <th width="100px">专业</th>
	        <th width="100px">地址</th>
	        <th width="100px">微信二维码</th>
	        <th width="200px">自我介绍</th>
	        <th width="100px">经验分享</th>
	        <th width="40px">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="teacher">
	    <tr>
	    	<td><s:property value="#teacher.user.UTel"/></td>
	    	<td><s:property value="#teacher.TName"/></td>
	    	<td><s:property value="#teacher.TAge"/></td>
          	<td>
				<s:if test="#teacher.TGender==1">男</s:if>
				<s:if test="#teacher.TGender==2">女</s:if>
			</td>
			<td title="<s:property value="#teacher.TSchool"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#teacher.TSchool"/>
			</td>
			<td title="<s:property value="#teacher.TMajor"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#teacher.TMajor"/>
			</td>
			<td title="<s:property value="#teacher.TAddress"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#teacher.TAddress"/>
			</td>
			<td>
				<s:if test="#teacher.TWechat!=null">
	    		<a href="javascript:void(0);" class="text-muted">
	          		<span>显示微信二维码</span><br/>
	    			<img style="z-index:99" src="/wyx_jj<s:property value="#teacher.TWechat"/>" width="200px"/>
    			</a>
    			</s:if>
			</td>
			<td title="<s:property value="#teacher.TIntroduce"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#teacher.TIntroduce"/>
			</td>
			<td title="<s:property value="#teacher.TExperience"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#teacher.TExperience"/>
			</td>
          	<td>
              	<a href="${path}/teacher_edit?teacher.UId=<s:property value="#teacher.UId"/>">编辑</a> &nbsp;  
          	</td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
</html>