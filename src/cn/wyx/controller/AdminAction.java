package cn.wyx.controller;

import java.io.IOException;
import java.util.Map;

import cn.wyx.model.Admin;
import cn.wyx.service.AdminService;

import com.opensymphony.xwork2.ActionContext;

public class AdminAction extends BaseAction 
{	
	private Admin admin;
	private AdminService adminService;
		
	//登录
	public void ajax_a_login() throws IOException
	{		
		ActionContext context = ActionContext.getContext();
		Admin admin1 = adminService.getAdminByUnameAndPWord(admin.getAUsername(), admin.getAPassword());
		if(admin1 == null)
		{
			response.getWriter().write("fail");
		}
		else
		{
			Map<String, Object> session2 = context.getSession();
			//把用户的信息放入session中
			session2.put("admin", admin1);
			response.getWriter().write("success");
		}		
	}
	
	//注销
	public String ajax_a_logout()
	{
		ActionContext context = ActionContext.getContext();		
		Map<String, Object> session2 = context.getSession();
		session2.remove("admin");
		return MAIN;
	}
	
	
	
	
	//============================================setter and getter=====================================================

	public AdminService getAdminService() 
	{
		return adminService;
	}
	public void setAdminService(AdminService adminService) 
	{
		this.adminService = adminService;
	}
	public Admin getAdmin()
	{
		return admin;
	}
	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}
	
}
