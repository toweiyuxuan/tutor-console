package cn.wyx.service.impl;

import cn.wyx.dao.MphotoDao;
import cn.wyx.model.Mphoto;
import cn.wyx.query.MphotoQuery;
import cn.wyx.service.MphotoService;

public class MphotoServiceImpl extends BaseServiceImpl<Mphoto, MphotoQuery> implements MphotoService 
{	
	private MphotoDao mphotoDao;
	
	public void setMphotoDao(MphotoDao mphotoDao) 
	{
		this.mphotoDao = mphotoDao;
		this.baseDao = mphotoDao;
	}
}
