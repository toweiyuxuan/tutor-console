<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理系统</title>

<!-- css样式文件 -->
<link href="${path}/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="${path}/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="${path}/assets/css/main-min.css" rel="stylesheet" type="text/css" />

<!-- js脚本文件 -->
<script type="text/javascript" src="${path}/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${path}/assets/js/bui-min.js"></script>
<script type="text/javascript" src="${path}/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="${path}/assets/js/config-min.js"></script>
</head>
<body>
	<div class="header" style="height: 70px">
		<div class="dl-log">
			<a href="/wyx_jj/JJ_main" title="" target="blank">[前台页面]</a>
			欢迎您，<span class="dl-log-user"><s:property value="#session.admin.AUsername"/></span> 
			<a href="${path}/ajax_a_logout" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-home">系统管理</div>
				</li>
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-order">业务管理</div>
				</li>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten"></ul>
	</div>
</body>
<script>

BUI.use("common/main",function()
{
	var config = 
	[
		{
			id:"1",homePage :"1",
			menu:
			[
		      {
				text:"系统管理",
				items:
				[
					{
						id:"1",
		      		  	text:"用户管理",href:"${path}/users_list"
		     		}
				]
			  },
		      {
					text:"家长信息管理",
					items:
					[
						{
							id:"2",
			      		  	text:"用户信息",href:"${path}/parent_list"
			     		},
			     		{
			     			id:"3",
			     			text:"身份审核",href:"${path}/pphoto_list"
			     		}
					]
				},
			  	{
					text:"老师信息管理",
					items:
					[
						{
							id:"4",
			      		  	text:"用户信息",href:"${path}/teacher_list"
			     		},
			     		{
			     			id:"5",
			     			text:"相册管理",href:"${path}/tphoto_list"
			     		}
					]
				},
			  	{
					text:"机构信息管理",
					items:
					[
						{
							id:"6",
			      		  	text:"用户信息",href:"${path}/mechanism_list"
			     		},
			     		{
			     			id:"7",
			     			text:"相册管理",href:"${path}/mphoto_list"
			     		}
					]
				},
				{
					text:"其他管理",
					items:
					[
						{
							id:"11",
			      		  	text:"学科类型管理",href:"${path}/subjecttype_list"
			     		},
			     		{
			     			id:"12",
			     			text:"老师类型管理",href:"${path}/teachertype_list"
			     		},
			     		{
			     			id:"13",
			     			text:"机构标签管理",href:"${path}/mechanismtype_list"
			     		}
					]
				}
			]
		},
		{
			id:"2",homePage : "1",
			menu:
			[
				{
	        		text:"业务管理",
	        		items:
	        		[
		        		{
		        			id:"1",text:"老师报名信息管理",href:"${path}/signup_list"
		        		},
		        		{
		        			id:"2",text:"家长发布信息管理",href:"${path}/prelease_list"
		        		},
		        		{
		        			id:"3",text:"机构发布信息管理",href:"${path}/mrelease_list"
		        		}
	        		]
	      		}
			]
     	}
	];    
    new PageUtil.MainPage
    ({
		modulesConfig : config
    });
  });
</script>
</html>