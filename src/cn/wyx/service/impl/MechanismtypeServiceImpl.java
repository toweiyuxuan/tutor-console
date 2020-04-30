package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.MechanismtypeDao;
import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.MechanismtypeQuery;
import cn.wyx.service.MechanismtypeService;

public class MechanismtypeServiceImpl extends BaseServiceImpl<Mechanismtype, MechanismtypeQuery> implements MechanismtypeService 
{	
	private MechanismtypeDao mechanismtypeDao;
	
	public void setMechanismtypeDao(MechanismtypeDao mechanismtypeDao) 
	{
		this.mechanismtypeDao = mechanismtypeDao;
		this.baseDao = mechanismtypeDao;
	}

	@Override
	public void updateMechanismtype(Mechanismtype mechanismtype)
	{
		Mechanismtype mechanismtype1 = mechanismtypeDao.getObj(mechanismtype.getMId());
		try 
		{
			BeanUtils.copyProperties(mechanismtype1, mechanismtype);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		mechanismtypeDao.update(mechanismtype1);	
		
	}

	@Override
	public Mechanismtype getMechanismtypeByUname(String mechanismtype)
	{
		return mechanismtypeDao.getMechanismtypeByUname(mechanismtype);
	}
}
