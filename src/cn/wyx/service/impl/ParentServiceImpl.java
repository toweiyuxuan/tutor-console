package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.ParentDao;
import cn.wyx.model.Parent;
import cn.wyx.model.Users;
import cn.wyx.query.ParentQuery;
import cn.wyx.service.ParentService;

public class ParentServiceImpl extends BaseServiceImpl<Parent, ParentQuery> implements ParentService 
{	
	private ParentDao parentDao;
	
	public void setParentDao(ParentDao parentDao) 
	{
		this.parentDao = parentDao;
		this.baseDao = parentDao;
	}

	@Override
	public void updateParent(Parent parent)
	{
		Parent parent1 = parentDao.getObj(parent.getUId());
		try 
		{
			//把Parent中的所有属性拷贝到Parent1中
			BeanUtils.copyProperties(parent1, parent);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		parentDao.update(parent1);		
	}
}
