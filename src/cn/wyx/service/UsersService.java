package cn.wyx.service;

import cn.wyx.model.Subjecttype;
import cn.wyx.model.Users;
import cn.wyx.query.UsersQuery;

public interface UsersService extends BaseService<Users, UsersQuery> 
{
	public void updateUsers(Users user);
	public Users getUsersByUname(String user);
}
