package cn.wyx.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.wyx.dao.TeacherDao;
import cn.wyx.model.Teacher;
import cn.wyx.query.TeacherQuery;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher, TeacherQuery> implements TeacherDao 
{

	@Override
	public String createHql(TeacherQuery equery) 
	{
		String hql = "from Teacher t where 1=1 ";		
		hql = hql + createHqlCondition(equery);
		return hql;
	}

	@Override
	public String createHqlCount(TeacherQuery q) 
	{
		String hql = "select count(UId) from Teacher t where 1=1";
		hql = hql + createHqlCondition(q);
		return hql;
	}

	@Override
	public String createHqlCondition(TeacherQuery equery) 
	{
		String hql = "";
		if (StringUtils.isNotBlank(equery.getTel()))
		{
			hql = hql + " and t.user.UTel like " + "'%" + equery.getTel().toString() + "%'";
		}
		if (StringUtils.isNotBlank(equery.getTAddress()))
		{
			hql = hql + " and t.TAddress like :TAddress";
		}
		if (StringUtils.isNotBlank(equery.getTSchool()))
		{
			hql = hql + " and t.TSchool like :TSchool";
		}
		if (equery.getTGender() != null)
		{
			hql = hql + " and t.TGender = :TGender";
		}
		return hql;
	}
	
}
