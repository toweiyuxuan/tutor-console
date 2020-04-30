package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Mrelease;
import cn.wyx.query.MreleaseQuery;
import cn.wyx.service.MreleaseService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class MreleaseAction extends BaseAction 
{	
	private Mrelease mrelease;
	private MreleaseService mreleaseService;
	private MreleaseQuery query = new MreleaseQuery();
	
	public String mrelease_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = mreleaseService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String mrelease_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		mrelease = mreleaseService.getObj(mrelease.getRId());	
		context.put("mrelease", mrelease);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void mrelease_update() throws IOException
	{
		mreleaseService.updateMrelease(mrelease);
		response.getWriter().write("success");
	}
	
	
	
	
	
	
	//============================================setter and getter=====================================================
	public MreleaseQuery getQuery() 
	{
		return query;
	}
	public void setQuery(MreleaseQuery query)
	{
		this.query = query;
	}
	public MreleaseService getMreleaseService() 
	{
		return mreleaseService;
	}
	public void setMreleaseService(MreleaseService mreleaseService) 
	{
		this.mreleaseService = mreleaseService;
	}
	public Mrelease getMrelease()
	{
		return mrelease;
	}
	public void setMrelease(Mrelease mrelease)
	{
		this.mrelease = mrelease;
	}
	
}
