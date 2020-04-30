package cn.wyx.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import cn.wyx.dao.AdminDao;
import cn.wyx.model.Admin;
import cn.wyx.query.AdminQuery;

public class AdminDaoImpl extends BaseDaoImpl<Admin, AdminQuery> implements AdminDao 
{

	@Override
	public String createHql(AdminQuery equery) 
	{
		String hql = "from Admin a where 1=1 ";		
		return hql;
	}

	@Override
	public String createHqlCount(AdminQuery q) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createHqlCondition(AdminQuery q) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getAdminByUnameAndPWord(final String username, final String password)
	{
		final String hql = "from Admin a where a.AUsername = :AUsername and a.APassword = :APassword";
		Admin admin = this.getHibernateTemplate().execute(new HibernateCallback<Admin>() 
		{
			@Override
			public Admin doInHibernate(Session session) throws HibernateException,SQLException 
			{
				Query query = session.createQuery(hql);
				query.setParameter("AUsername",username);
				query.setParameter("APassword",password);
				return (Admin) query.uniqueResult();
			}
		});
		return admin;
	}
}
