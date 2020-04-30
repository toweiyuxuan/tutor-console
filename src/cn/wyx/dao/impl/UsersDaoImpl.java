package cn.wyx.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.UsersDao;
import cn.wyx.model.Teachertype;
import cn.wyx.model.Users;
import cn.wyx.query.UsersQuery;

public class UsersDaoImpl extends BaseDaoImpl<Users, UsersQuery> implements UsersDao 
{

	@Override
	public String createHql(UsersQuery equery) 
	{
		String hql = "from Users u where 1=1 ";	
		hql = hql + createHqlCondition(equery);// + " order by u.UId desc";
		return hql;
	}

	@Override
	public String createHqlCount(UsersQuery q) 
	{
		String hql = "select count(UId) from Users u where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(UsersQuery equery) 
	{
		String hql = "";
		if (equery.getUSf() != null)
		{
			hql = hql + " and u.USf = :USf";
		}			
		if (StringUtils.isNotBlank(equery.getUTel()))
		{
			hql = hql + " and u.UTel like :UTel";
		}
		return hql;
	}

	@Override
	public Users getUsersByUname(String user)
	{
		Users user1 = null;
		String hql = "from Users u where u.UTel = ?";
		List list = this.getHibernateTemplate().find(hql, user);
		if(list.size() > 0)
		{
			user1 = (Users) list.get(0);
		}
		return user1;
	}
	
}
