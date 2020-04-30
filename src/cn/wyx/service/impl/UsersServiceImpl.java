package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.UsersDao;
import cn.wyx.model.Users;
import cn.wyx.query.UsersQuery;
import cn.wyx.service.UsersService;

public class UsersServiceImpl extends BaseServiceImpl<Users, UsersQuery> implements UsersService 
{	
	private UsersDao usersDao;
	
	public void setUsersDao(UsersDao usersDao) 
	{
		this.usersDao = usersDao;
		this.baseDao = usersDao;
	}

	@Override
	public void updateUsers(Users user)
	{
		Users user1 = usersDao.getObj(user.getUId());
		user.setUSf(user1.getUSf());
		if(user.getUAttestation() == 4)
		{
			user.setUIsfinish(2);
		}
		else
		{
			user.setUIsfinish(1);
		}
		try 
		{
			BeanUtils.copyProperties(user1, user);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		usersDao.update(user1);		
	}

	@Override
	public Users getUsersByUname(String user)
	{
		return usersDao.getUsersByUname(user);
	}
}
