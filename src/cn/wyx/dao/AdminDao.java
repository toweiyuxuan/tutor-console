package cn.wyx.dao;

import cn.wyx.model.Admin;
import cn.wyx.query.AdminQuery;

public interface AdminDao extends BaseDao<Admin, AdminQuery> 
{
	public Admin getAdminByUnameAndPWord(String username, String password);
}
