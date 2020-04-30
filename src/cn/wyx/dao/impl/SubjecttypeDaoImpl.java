package cn.wyx.dao.impl;

import java.util.List;

import cn.wyx.dao.SubjecttypeDao;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.SubjecttypeQuery;

public class SubjecttypeDaoImpl extends BaseDaoImpl<Subjecttype, SubjecttypeQuery> implements SubjecttypeDao 
{

	@Override
	public String createHql(SubjecttypeQuery equery) 
	{
		String hql = "from Subjecttype s where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(SubjecttypeQuery q) 
	{
		String hql = "select count(SId) from Subjecttype s where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(SubjecttypeQuery q) 
	{
		String hql = "";
		return hql;
	}

	@Override
	public Subjecttype getSubjecttypeByUname(String subjecttype)
	{
		Subjecttype subjecttype1 = null;
		String hql = "from Subjecttype s where s.SName = ?";
		List list = this.getHibernateTemplate().find(hql, subjecttype);
		if(list.size() > 0)
		{
			subjecttype1 = (Subjecttype) list.get(0);
		}
		return subjecttype1;
	}
	
}
