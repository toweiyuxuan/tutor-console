package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Signup;
import cn.wyx.query.SignupQuery;
import cn.wyx.service.SignupService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class SignupAction extends BaseAction 
{	
	private Signup signup;
	private SignupService signupService;
	private SignupQuery query = new SignupQuery();
	
	public String signup_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = signupService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String signup_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		signup = signupService.getObj(signup.getSiId());	
		context.put("signup", signup);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void signup_update() throws IOException
	{
		signupService.updateSignup(signup);
		response.getWriter().write("success");
	}
	
	
	
	
	
	//============================================setter and getter=====================================================
	public SignupQuery getQuery() 
	{
		return query;
	}
	public void setQuery(SignupQuery query)
	{
		this.query = query;
	}
	public SignupService getSignupService() 
	{
		return signupService;
	}
	public void setSignupService(SignupService signupService) 
	{
		this.signupService = signupService;
	}
	public Signup getSignup()
	{
		return signup;
	}
	public void setSignup(Signup signup)
	{
		this.signup = signup;
	}
	
}
