package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.PphotoDao;
import cn.wyx.model.Pphoto;
import cn.wyx.query.PphotoQuery;

public class PphotoDaoImpl extends BaseDaoImpl<Pphoto, PphotoQuery> implements PphotoDao 
{

	@Override
	public String createHql(PphotoQuery equery) 
	{
		String hql = "from Pphoto p where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(PphotoQuery q) 
	{
		String hql = "select count(UId) from Pphoto p where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(PphotoQuery equery) 
	{
		String hql = "";
		
		if(StringUtils.isNotBlank(equery.getTel()))
		{
			hql = hql + " and p.user.UTel like " +"'%" + equery.getTel().toString() + "%'";
		}
		if(equery.getIspass() != null)
		{
			hql = hql + " and p.user.UAttestation = " + equery.getIspass().toString();
		}
		
		return hql;
	}
	
}
