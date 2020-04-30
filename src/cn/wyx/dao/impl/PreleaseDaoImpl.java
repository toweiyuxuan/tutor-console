package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.PreleaseDao;
import cn.wyx.model.Prelease;
import cn.wyx.query.PreleaseQuery;

public class PreleaseDaoImpl extends BaseDaoImpl<Prelease, PreleaseQuery> implements PreleaseDao 
{

	@Override
	public String createHql(PreleaseQuery equery) 
	{
		String hql = "from Prelease p where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(PreleaseQuery q) 
	{
		String hql = "select count(RId) from Prelease p where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(PreleaseQuery equery) 
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
		if (StringUtils.isNotBlank(equery.getPTel()))
		{
			hql = hql + " and p.PTel like :PTel";
		}
		if (StringUtils.isNotBlank(equery.getPAddress()))
		{
			hql = hql + " and p.PAddress like :PAddress";
		}
		return hql;
	}
	
}
