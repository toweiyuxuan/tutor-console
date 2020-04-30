package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Parent;
import cn.wyx.query.ParentQuery;
import cn.wyx.service.ParentService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class ParentAction extends BaseAction 
{	
	private Parent parent;
	private ParentService parentService;
	private ParentQuery query = new ParentQuery();
	
	public String parent_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = parentService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String parent_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		parent = parentService.getObj(parent.getUId());	
		context.put("parent", parent);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void parent_update() throws IOException
	{
		parentService.updateParent(parent);
		response.getWriter().write("success");
	}
	
	
	//============================================setter and getter=====================================================
	public ParentQuery getQuery() 
	{
		return query;
	}
	public void setQuery(ParentQuery query)
	{
		this.query = query;
	}
	public ParentService getParentService() 
	{
		return parentService;
	}
	public void setParentService(ParentService parentService) 
	{
		this.parentService = parentService;
	}
	public Parent getParent()
	{
		return parent;
	}
	public void setParent(Parent parent)
	{
		this.parent = parent;
	}
	
}
