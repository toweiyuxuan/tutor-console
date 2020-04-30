package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.TphotoDao;
import cn.wyx.model.Tphoto;
import cn.wyx.query.TphotoQuery;

public class TphotoDaoImpl extends BaseDaoImpl<Tphoto, TphotoQuery> implements TphotoDao 
{

	@Override
	public String createHql(TphotoQuery equery) 
	{
		String hql = "from Tphoto t where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(TphotoQuery q) 
	{
		String hql = "select count(tpId) from Tphoto t where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(TphotoQuery equery) 
	{
		String hql = "";
		if (StringUtils.isNotBlank(equery.getUTel()))
		{
			hql = hql + " and t.UTel like :UTel";
		}
		return hql;
	}
	
}
