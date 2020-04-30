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
<form id="queryForm" class="form-inline definewidth m20" action="${path}/prelease_list" method="post">
	<div style="width: 1300px">
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.PTel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;
	性别：
	<s:select style="cursor:pointer;width: 100px;color:gray;" 
			  list="#{'1':'男','2':'女'}" 
			  name="query.PGender" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	年级：
	<s:select style="cursor:pointer;width: 100px;color:gray;" 
			  list="#{'1':'一年级','2':'二年级','3':'三年级','4':'四年级','5':'五年级','6':'六年级','7':'七年级','8':'八年级','9':'九年级','10':'高一','11':'高二','12':'高三'}" 
			  name="query.PGrade" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	性格：
	<s:select style="cursor:pointer;width: 100px;color:gray;" 
			  list="#{'1':'外向型','2':'内向型','3':'理智型','4':'情绪型','5':'意志型','6':'中间型'}" 
			  name="query.PCharacter" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>	
	&nbsp;&nbsp;
	区域：	
	<s:select style="cursor:pointer;color:gray;width: 100px;" 
			  list="#{'1':'呈贡区','2':'官渡区','3':'西山区','4':'五华区','5':'盘龙区'}" 
			  name="query.PArea" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	地址：
	<s:textfield style="width: 100px" autocomplete="off" name="query.PAddress" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;	
		
	<button id="query" type="button" class="btn btn-primary">查询</button>
	&nbsp;&nbsp; 
	</div>

	<table class="table table-bordered table-hover definewidth m10" style="table-layout:fixed;">
	    <thead>
	    <tr>
	        <th width="80px">发布账号</th>
	        <th width="80px">发布时间</th>
	        <th width="60px">家教区域</th>
	        <th width="60px">具体地址</th>
	        <th width="60px">学生性别</th>
	        <th width="60px">学生年级</th>
	        <th width="60px">学生性格</th>
	        <th width="60px">报酬范围</th>
	        <th width="60px">辅导学科</th>
	        <th width="60px">老师性别</th>
	        <th width="60px">老师类型</th>
	        <th width="60px">其他说明</th>
	        <th width="60px">报名人数</th>
	        <th width="60px">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="prelease">
	    <tr>
	    	<td><s:property value="#prelease.PTel"/></td>
	    	<td><s:date name="#prelease.RTime" format="yyyy-MM-dd"/></td>
	    	<td>
	          	<s:if test="#prelease.PArea==1">呈贡区</s:if>
				<s:if test="#prelease.PArea==2">官渡区</s:if>
				<s:if test="#prelease.PArea==3">西山区</s:if>
				<s:if test="#prelease.PArea==4">五华区</s:if>
				<s:if test="#prelease.PArea==5">盘龙区</s:if>
			</td>
          	<td title="<s:property value="#prelease.PAddress"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#prelease.PAddress"/>
          	</td>
          	<td>
				<s:if test="#prelease.PGender==1">男</s:if>
				<s:if test="#prelease.PGender==2">女</s:if>
			</td>
			<td>
				<s:if test="#prelease.PGrade==1">一年级</s:if>
				<s:if test="#prelease.PGrade==2">二年级</s:if>
				<s:if test="#prelease.PGrade==3">三年级</s:if>
				<s:if test="#prelease.PGrade==4">四年级</s:if>
				<s:if test="#prelease.PGrade==5">五年级</s:if>
				<s:if test="#prelease.PGrade==6">六年级</s:if>
				<s:if test="#prelease.PGrade==7">七年级</s:if>
				<s:if test="#prelease.PGrade==8">八年级</s:if>
				<s:if test="#prelease.PGrade==9">九年级</s:if>
				<s:if test="#prelease.PGrade==10">高一</s:if>
				<s:if test="#prelease.PGrade==11">高二</s:if>
				<s:if test="#prelease.PGrade==12">高三</s:if>
			</td>
			<td>
				<s:if test="#prelease.PCharacter==1">外向型</s:if>
				<s:if test="#prelease.PCharacter==2">内向型</s:if>
				<s:if test="#prelease.PCharacter==3">理智型</s:if>
				<s:if test="#prelease.PCharacter==4">情绪型</s:if>
				<s:if test="#prelease.PCharacter==5">意志型</s:if>
				<s:if test="#prelease.PCharacter==6">中间型</s:if>
			</td>
		  	<td>
				<s:if test="#prelease.PMoney==1">&lt;40</s:if>
				<s:if test="#prelease.PMoney==2">40-50</s:if>
				<s:if test="#prelease.PMoney==3">50-60</s:if>
				<s:if test="#prelease.PMoney==4">60-70</s:if>
				<s:if test="#prelease.PMoney==5">&lt;70</s:if>
			</td>
			<td title="<s:property value="#prelease.PSubjecttype"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#prelease.PSubjecttype"/>
			</td>
			<td>
				<s:if test="#prelease.PLimitgender==0">不限</s:if>
				<s:if test="#prelease.PLimitgender==1">限男生</s:if>
				<s:if test="#prelease.PLimitgender==2">限女生</s:if>
			</td>
			<td title="<s:property value="#prelease.PLimitteachertype"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#prelease.PLimitteachertype"/>
			</td>
			<td title="<s:property value="#prelease.POther"/>" style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;cursor:pointer;">
	    		<s:property value="#prelease.POther"/>
			</td>
			<td><s:property value="#prelease.siCount"/></td>
          	<td>
              	<a href="${path}/prelease_edit?prelease.RId=<s:property value="#prelease.RId"/>">编辑</a> &nbsp;  
          	</td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
</html>