package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Prelease;
import cn.wyx.query.PreleaseQuery;
import cn.wyx.service.PreleaseService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class PreleaseAction extends BaseAction 
{
	private Prelease prelease;
	private PreleaseService preleaseService;
	private PreleaseQuery query = new PreleaseQuery();
	
	public String prelease_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = preleaseService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String prelease_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		prelease = preleaseService.getObj(prelease.getRId());	
		context.put("prelease", prelease);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void prelease_update() throws IOException
	{
		preleaseService.updatePrelease(prelease);
		response.getWriter().write("success");
	}
	
	
	
	
	//============================================setter and getter=====================================================
	public PreleaseQuery getQuery() 
	{
		return query;
	}
	public void setQuery(PreleaseQuery query)
	{
		this.query = query;
	}
	public PreleaseService getPreleaseService() 
	{
		return preleaseService;
	}
	public void setPreleaseService(PreleaseService preleaseService) 
	{
		this.preleaseService = preleaseService;
	}
	public Prelease getPrelease()
	{
		return prelease;
	}
	public void setPrelease(Prelease prelease)
	{
		this.prelease = prelease;
	}
	
}
