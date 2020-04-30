package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.SubjecttypeQuery;
import cn.wyx.service.SubjecttypeService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class SubjecttypeAction extends BaseAction 
{
	private Subjecttype subjecttype;
	private SubjecttypeService subjecttypeService;
	private SubjecttypeQuery query = new SubjecttypeQuery();
	
	public String subjecttype_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = subjecttypeService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String subjecttype_input()
	{	
		return SUCCESS;
	}
	
	//ÐÂÔö
	public void subjecttype_add() throws IOException
	{	
		Subjecttype subjecttype1 = subjecttypeService.getSubjecttypeByUname(subjecttype.getSName());
		if(subjecttype1 == null)
		{
			Subjecttype subjecttype2 = new Subjecttype();
			subjecttype2.setSName(subjecttype.getSName());
			subjecttypeService.save(subjecttype2);
			response.getWriter().write("success");
		}
		if(subjecttype1 != null)
		{
			response.getWriter().write("no");
		}
		
	}
	
	public String subjecttype_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		subjecttype = subjecttypeService.getObj(subjecttype.getSId());	
		context.put("subjecttype", subjecttype);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void subjecttype_update() throws IOException
	{
		Subjecttype subjecttype1 = subjecttypeService.getSubjecttypeByUname(subjecttype.getSName());
		if(subjecttype1 == null)
		{
			subjecttypeService.updateSubjecttype(subjecttype);
			response.getWriter().write("success");
		}
		else
		{
			response.getWriter().write("no");
		}
	}
	
	//É¾³ý
	public void subjecttype_detele() throws IOException
	{
		subjecttypeService.delete(subjecttype.getSId());
		response.getWriter().write("success");
	}
	
	//============================================setter and getter=====================================================
	public SubjecttypeQuery getQuery() 
	{
		return query;
	}
	public void setQuery(SubjecttypeQuery query)
	{
		this.query = query;
	}
	public SubjecttypeService getSubjecttypeService() 
	{
		return subjecttypeService;
	}
	public void setSubjecttypeService(SubjecttypeService subjecttypeService) 
	{
		this.subjecttypeService = subjecttypeService;
	}
	public Subjecttype getSubjecttype()
	{
		return subjecttype;
	}
	public void setSubjecttype(Subjecttype subjecttype)
	{
		this.subjecttype = subjecttype;
	}
	
}
