package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.SignupDao;
import cn.wyx.model.Signup;
import cn.wyx.query.SignupQuery;

public class SignupDaoImpl extends BaseDaoImpl<Signup, SignupQuery> implements SignupDao 
{

	@Override
	public String createHql(SignupQuery equery) 
	{
		String hql = "from Signup si where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(SignupQuery q) 
	{
		String hql = "select count(siId) from Signup si where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(SignupQuery equery) 
	{
		String hql = "";
		if (equery.getPGender() != null)
		{
			hql = hql + " and si.PGender = :PGender";
		}
		if (equery.getPGrade() != null)
		{
			hql = hql + " and si.PGrade = :PGrade";
		}
		if (equery.getPArea() != null)
		{
			hql = hql + " and si.PArea = :PArea";
		}
		if (StringUtils.isNotBlank(equery.getPTel()))
		{
			hql = hql + " and si.PTel like :PTel";
		}
		if (StringUtils.isNotBlank(equery.getTTel()))
		{
			hql = hql + " and si.TTel like :TTel";
		}
		if (StringUtils.isNotBlank(equery.getPAddress()))
		{
			hql = hql + " and si.PAddress like :PAddress";
		}
		return hql;
	}
	
}
