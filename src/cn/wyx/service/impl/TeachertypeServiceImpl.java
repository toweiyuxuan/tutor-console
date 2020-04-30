package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.TeachertypeDao;
import cn.wyx.model.Parent;
import cn.wyx.model.Teachertype;
import cn.wyx.query.TeachertypeQuery;
import cn.wyx.service.TeachertypeService;

public class TeachertypeServiceImpl extends BaseServiceImpl<Teachertype, TeachertypeQuery> implements TeachertypeService 
{	
	private TeachertypeDao teachertypeDao;
	
	public void setTeachertypeDao(TeachertypeDao teachertypeDao) 
	{
		this.teachertypeDao = teachertypeDao;
		this.baseDao = teachertypeDao;
	}

	@Override
	public void updateTeachertype(Teachertype teachertype)
	{
		Teachertype teachertype1 = teachertypeDao.getObj(teachertype.getTtId());
		try 
		{
			BeanUtils.copyProperties(teachertype1, teachertype);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		teachertypeDao.update(teachertype1);		
	}

	@Override
	public Teachertype getTeachertypeByUname(String teachertype)
	{
		return teachertypeDao.getTeachertypeByUname(teachertype);
	}
}
