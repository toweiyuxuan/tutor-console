package cn.wyx.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import cn.wyx.dao.SignupDao;
import cn.wyx.model.Prelease;
import cn.wyx.model.Signup;
import cn.wyx.query.SignupQuery;
import cn.wyx.service.SignupService;

public class SignupServiceImpl extends BaseServiceImpl<Signup, SignupQuery> implements SignupService 
{	
	private SignupDao signupDao;
	
	public void setSignupDao(SignupDao signupDao) 
	{
		this.signupDao = signupDao;
		this.baseDao = signupDao;
	}

	@Override
	public void updateSignup(Signup signup)
	{
		Signup signup1 = signupDao.getObj(signup.getSiId());
		
		//id、用户和时间不能动
		signup.setRId(signup1.getRId());
		signup.setUId(signup1.getUId());
		
		signup.setPTel(signup1.getPTel());
		signup.setTTel(signup1.getTTel());
		
		signup.setRTime(signup1.getRTime());
		signup.setSiTime(signup1.getSiTime());
		
		signup.setTId(signup1.getTId());
		signup.setPName(signup1.getPName());
		try 
		{
			//把Parent中的所有属性拷贝到Parent1中
			BeanUtils.copyProperties(signup1, signup);
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		signupDao.update(signup1);		
	}
}
