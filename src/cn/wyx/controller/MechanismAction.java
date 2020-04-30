package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Mechanism;
import cn.wyx.query.MechanismQuery;
import cn.wyx.service.MechanismService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class MechanismAction extends BaseAction 
{	
	private Mechanism mechanism;
	private MechanismService mechanismService;
	private MechanismQuery query = new MechanismQuery();
	
	public String mechanism_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = mechanismService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String mechanism_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		mechanism = mechanismService.getObj(mechanism.getUId());	
		context.put("mechanism", mechanism);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void mechanism_update() throws IOException
	{
		mechanismService.updateMechanism(mechanism);
		response.getWriter().write("success");
	}
	
	
	
	
	//============================================setter and getter=====================================================
	public MechanismQuery getQuery() 
	{
		return query;
	}
	public void setQuery(MechanismQuery query)
	{
		this.query = query;
	}
	public MechanismService getMechanismService() 
	{
		return mechanismService;
	}
	public void setMechanismService(MechanismService mechanismService) 
	{
		this.mechanismService = mechanismService;
	}
	public Mechanism getMechanism()
	{
		return mechanism;
	}
	public void setMechanism(Mechanism mechanism)
	{
		this.mechanism = mechanism;
	}
	
}
