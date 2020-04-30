package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.MphotoDao;
import cn.wyx.model.Mphoto;
import cn.wyx.query.MphotoQuery;

public class MphotoDaoImpl extends BaseDaoImpl<Mphoto, MphotoQuery> implements MphotoDao 
{

	@Override
	public String createHql(MphotoQuery equery) 
	{
		String hql = "from Mphoto m where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(MphotoQuery q) 
	{
		String hql = "select count(mpId) from Mphoto m where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(MphotoQuery equery) 
	{
		String hql = "";
		if (StringUtils.isNotBlank(equery.getUTel()))
		{
			hql = hql + " and m.UTel like :UTel";
		}
		return hql;
	}
	
}
