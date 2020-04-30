package cn.wyx.dao.impl;

import java.util.List;

import cn.wyx.dao.TeachertypeDao;
import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teachertype;
import cn.wyx.query.TeachertypeQuery;

public class TeachertypeDaoImpl extends BaseDaoImpl<Teachertype, TeachertypeQuery> implements TeachertypeDao 
{

	@Override
	public String createHql(TeachertypeQuery equery) 
	{
		String hql = "from Teachertype t where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(TeachertypeQuery q) 
	{
		String hql = "select count(ttId) from Teachertype t where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(TeachertypeQuery q) 
	{
		String hql = "";
		return hql;
	}

	@Override
	public Teachertype getTeachertypeByUname(String teachertype)
	{
		Teachertype teachertype1 = null;
		String hql = "from Teachertype t where t.ttName = ?";
		List list = this.getHibernateTemplate().find(hql, teachertype);
		if(list.size() > 0)
		{
			teachertype1 = (Teachertype) list.get(0);
		}
		return teachertype1;
	}
	
}
