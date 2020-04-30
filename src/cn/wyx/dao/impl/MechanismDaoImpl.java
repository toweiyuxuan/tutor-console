package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.MechanismDao;
import cn.wyx.model.Mechanism;
import cn.wyx.query.MechanismQuery;

public class MechanismDaoImpl extends BaseDaoImpl<Mechanism, MechanismQuery> implements MechanismDao 
{

	@Override
	public String createHql(MechanismQuery equery) 
	{
		String hql = "from Mechanism m where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(MechanismQuery q) 
	{
		String hql = "select count(UId) from Mechanism m where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(MechanismQuery equery) 
	{
		String hql = "";
		if (equery.getMArea() != null)
		{
			hql = hql + " and m.MArea = :MArea";
		}
		if (StringUtils.isNotBlank(equery.getTel()))
		{
			hql = hql + " and m.user.UTel like " + "'%" + equery.getTel().toString() + "%'";
		}
		if (StringUtils.isNotBlank(equery.getMAddress()))
		{
			hql = hql + " and m.MAddress like :MAddress";
		}
		return hql;
	}
	
}
