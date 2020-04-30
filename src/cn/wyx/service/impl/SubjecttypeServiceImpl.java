package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.SubjecttypeDao;
import cn.wyx.model.Parent;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.SubjecttypeQuery;
import cn.wyx.service.SubjecttypeService;

public class SubjecttypeServiceImpl extends BaseServiceImpl<Subjecttype, SubjecttypeQuery> implements SubjecttypeService 
{	
	private SubjecttypeDao subjecttypeDao;
	
	public void setSubjecttypeDao(SubjecttypeDao subjecttypeDao) 
	{
		this.subjecttypeDao = subjecttypeDao;
		this.baseDao = subjecttypeDao;
	}

	@Override
	public void updateSubjecttype(Subjecttype subjecttype)
	{
		Subjecttype subjecttype1 = subjecttypeDao.getObj(subjecttype.getSId());
		try 
		{
			BeanUtils.copyProperties(subjecttype1, subjecttype);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		subjecttypeDao.update(subjecttype1);		
	}

	@Override
	public Subjecttype getSubjecttypeByUname(String subjecttype)
	{
		return subjecttypeDao.getSubjecttypeByUname(subjecttype);
	}
}
