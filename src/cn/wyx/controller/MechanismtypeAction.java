package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.MechanismtypeQuery;
import cn.wyx.service.MechanismtypeService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class MechanismtypeAction extends BaseAction 
{
	private Mechanismtype mechanismtype;
	private MechanismtypeService mechanismtypeService;
	private MechanismtypeQuery query = new MechanismtypeQuery();
	
	public String mechanismtype_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = mechanismtypeService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}

	public String mechanismtype_input()
	{
		return SUCCESS;
	}
	
	//ÐÂÔö
	public void mechanismtype_add() throws IOException
	{	
		Mechanismtype mechanismtype1 = mechanismtypeService.getMechanismtypeByUname(mechanismtype.getMName());
		if(mechanismtype1 == null)
		{
			Mechanismtype mechanismtype2 = new Mechanismtype();
			mechanismtype2.setMName(mechanismtype.getMName());
			mechanismtypeService.save(mechanismtype2);
			response.getWriter().write("success");
		}
		if(mechanismtype1 != null)
		{
			response.getWriter().write("no");
		}
	}
	
	public String mechanismtype_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		mechanismtype = mechanismtypeService.getObj(mechanismtype.getMId());	
		context.put("mechanismtype", mechanismtype);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void mechanismtype_update() throws IOException
	{
		Mechanismtype mechanismtype1 = mechanismtypeService.getMechanismtypeByUname(mechanismtype.getMName());
		if(mechanismtype1 == null)
		{
			mechanismtypeService.updateMechanismtype(mechanismtype);
			response.getWriter().write("success");
		}
		if(mechanismtype1 != null)
		{
			response.getWriter().write("no");
		}
	}
	
	//É¾³ý
	public void mechanismtype_detele() throws IOException
	{		
		mechanismtypeService.delete(mechanismtype.getMId());
		response.getWriter().write("success");		
	}
	
	//============================================setter and getter=====================================================
	public MechanismtypeQuery getQuery() 
	{
		return query;
	}
	public void setQuery(MechanismtypeQuery query)
	{
		this.query = query;
	}
	public MechanismtypeService getMechanismtypeService() 
	{
		return mechanismtypeService;
	}
	public void setMechanismtypeService(MechanismtypeService mechanismtypeService) 
	{
		this.mechanismtypeService = mechanismtypeService;
	}

	public Mechanismtype getMechanismtype()
	{
		return mechanismtype;
	}

	public void setMechanismtype(Mechanismtype mechanismtype)
	{
		this.mechanismtype = mechanismtype;
	}
	
}
