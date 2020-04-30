package cn.wyx.service.impl;

import cn.wyx.dao.AdminDao;
import cn.wyx.model.Admin;
import cn.wyx.query.AdminQuery;
import cn.wyx.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminQuery> implements AdminService 
{	
	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) 
	{
		this.adminDao = adminDao;
		this.baseDao = adminDao;
	}

	@Override
	public Admin getAdminByUnameAndPWord(String username, String password)
	{
		return adminDao.getAdminByUnameAndPWord(username, password);
	}
}
