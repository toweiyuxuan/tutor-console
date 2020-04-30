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
</head>
<body>
<!--遮罩-->
<div id="load_f" style="background: #FFFFFF;position: absolute;top: 0px;left: 0px;width: 100%;height: 100%;z-index: 100; opacity:0.2;display: none"></div>
<img id="load" src="${path}/Images/load.gif" style="position: absolute;left: 50%;top: 50%;z-index: 101;display: none">

<form id="queryForm" class="form-inline definewidth m20" action="${path}/pphoto_list" method="post">	
	账号：
	<s:textfield style="width: 100px" autocomplete="off" name="query.tel" type="text" class="abc input-default"></s:textfield>&nbsp;&nbsp;
	&nbsp;&nbsp;
	状态：
	<s:select style="cursor:pointer;width: 100px;color:gray;" 
			  list="#{'1':'未提交','2':'待审核','3':'未通过','4':'已通过'}" 
			  name="query.ispass" 
			  headerKey="" headerValue="---不-限 ---">
	</s:select>
	&nbsp;&nbsp;
	<button id="query" type="button" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<table class="table table-bordered table-hover definewidth m10" style="table-layout:fixed;">
	    <thead>
	    <tr>
	    	<th width="100px">用户账号</th>
	        <th width="200px">身份证正面</th>
	        <th width="200px">身份证反面</th>
	        <th width="200px">学生证</th>
	        <th width="60px">当前状态</th>
	        <th width="80px">操作</th>
	    </tr>
	    </thead>
	    <s:iterator value="#page.list" var="pphoto">
	    <tr valign="middle">
          	<td>
          		<s:property value="#pphoto.user.UTel"/>
          	</td>
          	<td>
          		<s:if test="#pphoto.ppZaddress!=null">
          		<a href="" class="text-muted">
	          		<span>《=====显示身份证正面=====》</span><br/>
	    			<img style="z-index:99" src="/wyx_jj<s:property value="#pphoto.ppZaddress"/>" width="200px"/>
    			</a>
    			</s:if>
          	</td>
          	<td>
          		<s:if test="#pphoto.ppFaddress!=null">
          		<a href="" class="text-muted">
	          		<span>《=====显示身份证反面=====》</span><br />
	    			<img style="z-index:99" src="/wyx_jj<s:property value="#pphoto.ppFaddress"/>" width="200px"/>
    			</a>
    			</s:if>
          	</td>
          	<td>
          		<s:if test="#pphoto.ppSaddress!=null">
          		<a href="" class="text-muted">
	          		<span>《=====显示学生证照片=====》</span><br />
	    			<img style="z-index:99" src="/wyx_jj<s:property value="#pphoto.ppSaddress"/>" width="200px"/>
    			</a>
    			</s:if>
          	</td>
          	<td>
          		<s:if test="#pphoto.user.UAttestation==1"><font color="#EDEDED">未提交</font></s:if>
          		<s:if test="#pphoto.user.UAttestation==2"><font color="red">待审核</font></s:if>
          		<s:if test="#pphoto.user.UAttestation==3"><font color="black">未通过</font></s:if>
          		<s:if test="#pphoto.user.UAttestation==4"><font color="#66CD00">已通过</font></s:if>
          	</td>
          	<td>
          		<s:if test="#pphoto.user.UAttestation==1"><font color="#EDEDED">未提交</font></s:if>
          		<s:if test="#pphoto.user.UAttestation==2">
          			<a href="javascript:void(0);" onclick="pass(<s:property value="#pphoto.UId"/>)">通过</a> &nbsp;
          			<a href="javascript:void(0);" onclick="back(<s:property value="#pphoto.UId"/>)">驳回</a>
          		</s:if>
          		<s:if test="#pphoto.user.UAttestation==3">
          			<a href="javascript:void(0);" onclick="pass(<s:property value="#pphoto.UId"/>)">通过</a> &nbsp;
          		</s:if>
          		<s:if test="#pphoto.user.UAttestation==4">
          			<a href="javascript:void(0);" onclick="back(<s:property value="#pphoto.UId"/>)">驳回</a>
          		</s:if>
            </td>
	    </tr>
	    </s:iterator>	
	</table><br><br>
	<%@ include file="../tools/paging.jsp" %>
</form>
</body>
<script>
function back(id)
{
	if(confirm("确定驳回该账户申请吗？"))
	{
		 $.ajax
		({
		    url: "${path}/pphoto_back?user.UId="+id,
		    type: "post",
		    async:true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/pphoto_list";
				}
		 	}
		}); 
	}
}
function pass(id)
{
	if(confirm("确定审核通过该账户吗？"))
	{
		 $.ajax
		({
		    url: "${path}/pphoto_pass?user.UId="+id,
		    type: "post",
		    async:true,
		    success: function (result) 
		    {
		    	if(result=="success")
				{
		    		window.location.href="${path}/pphoto_list";
				}
		 	}
		});
	}
}
</script>
</html>