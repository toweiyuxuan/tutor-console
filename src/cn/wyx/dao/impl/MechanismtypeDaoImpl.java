package cn.wyx.dao.impl;

import java.util.List;

import cn.wyx.dao.MechanismtypeDao;
import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.MechanismtypeQuery;

public class MechanismtypeDaoImpl extends BaseDaoImpl<Mechanismtype, MechanismtypeQuery> implements MechanismtypeDao 
{

	@Override
	public String createHql(MechanismtypeQuery equery) 
	{
		String hql = "from Mechanismtype m where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(MechanismtypeQuery q) 
	{
		String hql = "select count(MId) from Mechanismtype m where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(MechanismtypeQuery q) 
	{
		String hql = "";
		return hql;
	}

	@Override
	public Mechanismtype getMechanismtypeByUname(String mechanismtype)
	{
		Mechanismtype mechanismtype1 = null;
		String hql = "from Mechanismtype m where m.MName = ?";
		List list = this.getHibernateTemplate().find(hql, mechanismtype);
		if(list.size() > 0)
		{
			mechanismtype1 = (Mechanismtype) list.get(0);
		}
		return mechanismtype1;
	}
	
}
