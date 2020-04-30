package cn.wyx.service;

import cn.wyx.model.Admin;
import cn.wyx.query.AdminQuery;

public interface AdminService extends BaseService<Admin, AdminQuery> 
{
	public Admin getAdminByUnameAndPWord(String username, String password);
}
