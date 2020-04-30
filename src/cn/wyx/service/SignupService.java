package cn.wyx.service;

import cn.wyx.model.Prelease;
import cn.wyx.model.Signup;
import cn.wyx.query.SignupQuery;

public interface SignupService extends BaseService<Signup, SignupQuery> 
{
	public void updateSignup(Signup signup);
}
