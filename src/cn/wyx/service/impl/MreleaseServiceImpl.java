package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.MreleaseDao;
import cn.wyx.model.Mrelease;
import cn.wyx.model.Parent;
import cn.wyx.query.MreleaseQuery;
import cn.wyx.service.MreleaseService;

public class MreleaseServiceImpl extends BaseServiceImpl<Mrelease, MreleaseQuery> implements MreleaseService 
{	
	private MreleaseDao mreleaseDao;
	
	public void setMreleaseDao(MreleaseDao mreleaseDao) 
	{
		this.mreleaseDao = mreleaseDao;
		this.baseDao = mreleaseDao;
	}

	@Override
	public void updateMrelease(Mrelease mrelease)
	{
		Mrelease mrelease1 = mreleaseDao.getObj(mrelease.getRId());
		mrelease.setRTime(mrelease1.getRTime());
		mrelease.setUId(mrelease1.getUId());
		mrelease.setMTel(mrelease1.getMTel());
		try 
		{
			BeanUtils.copyProperties(mrelease1, mrelease);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		mreleaseDao.update(mrelease1);	
	}
}
