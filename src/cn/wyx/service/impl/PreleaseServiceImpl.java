package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.PreleaseDao;
import cn.wyx.model.Parent;
import cn.wyx.model.Prelease;
import cn.wyx.query.PreleaseQuery;
import cn.wyx.service.PreleaseService;

public class PreleaseServiceImpl extends BaseServiceImpl<Prelease, PreleaseQuery> implements PreleaseService 
{	
	private PreleaseDao preleaseDao;
	
	public void setPreleaseDao(PreleaseDao preleaseDao) 
	{
		this.preleaseDao = preleaseDao;
		this.baseDao = preleaseDao;
	}

	@Override
	public void updatePrelease(Prelease prelease)
	{
		Prelease prelease1 = preleaseDao.getObj(prelease.getRId());
		//id和发布时间不能动
		prelease.setRId(prelease1.getRId());
		prelease.setUId(prelease1.getUId());
		prelease.setRTime(prelease1.getRTime());
		prelease.setPTel(prelease1.getPTel());
		prelease.setSiCount(prelease1.getSiCount());
		try 
		{
			//把Parent中的所有属性拷贝到Parent1中
			BeanUtils.copyProperties(prelease1, prelease);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		preleaseDao.update(prelease1);		
	}
}
