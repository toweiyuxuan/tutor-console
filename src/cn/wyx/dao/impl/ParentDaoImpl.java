package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.ParentDao;
import cn.wyx.model.Parent;
import cn.wyx.query.ParentQuery;

public class ParentDaoImpl extends BaseDaoImpl<Parent, ParentQuery> implements ParentDao 
{

	@Override
	public String createHql(ParentQuery equery) 
	{
		String hql = "from Parent p where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(ParentQuery q) 
	{
		String hql = "select count(UId) from Parent p where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(ParentQuery equery) 
	{
		String hql = "";
		if (equery.getPGender() != null)
		{
			hql = hql + " and p.PGender = :PGender";
		}
		if (equery.getPGrade() != null)
		{
			hql = hql + " and p.PGrade = :PGrade";
		}
		if (equery.getPCharacter() != null)
		{
			hql = hql + " and p.PCharacter = :PCharacter";
		}
		if (equery.getPArea() != null)
		{
			hql = hql + " and p.PArea = :PArea";
		}	
		if(StringUtils.isNotBlank(equery.getTel()))
		{
			hql = hql + " and p.user.UTel like " + "'%" + equery.getTel().toString() + "%'";
		}			
		if (StringUtils.isNotBlank(equery.getPAddress()))
		{
			hql = hql + " and p.PAddress like :PAddress";
		}
		return hql;
	}
	
}
