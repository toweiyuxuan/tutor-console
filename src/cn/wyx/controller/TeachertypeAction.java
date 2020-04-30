package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teachertype;
import cn.wyx.query.TeachertypeQuery;
import cn.wyx.service.TeachertypeService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class TeachertypeAction extends BaseAction 
{	
	private Teachertype teachertype;
	private TeachertypeService teachertypeService;
	private TeachertypeQuery query = new TeachertypeQuery();
	
	public String teachertype_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = teachertypeService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	
	public String teachertype_input()
	{	
		return SUCCESS;
	}
	
	//ÐÂÔö
	public void teachertype_add() throws IOException
	{	
		Teachertype teachertype1 = teachertypeService.getTeachertypeByUname(teachertype.getTtName());
		if(teachertype1 == null)
		{
			Teachertype teachertype2 = new Teachertype();
			teachertype2.setTtName(teachertype.getTtName());
			teachertypeService.save(teachertype2);
			response.getWriter().write("success");
		}
		if(teachertype1 != null)
		{
			response.getWriter().write("no");
		}
		
	}
	
	public String teachertype_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		teachertype = teachertypeService.getObj(teachertype.getTtId());	
		context.put("teachertype", teachertype);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void teachertype_update() throws IOException
	{
		Teachertype teachertype1 = teachertypeService.getTeachertypeByUname(teachertype.getTtName());
		if(teachertype1 == null)
		{
			teachertypeService.updateTeachertype(teachertype);
			response.getWriter().write("success");
		}
		else
		{
			response.getWriter().write("no");
		}
	}
	
	//É¾³ý
	public void teachertype_detele() throws IOException
	{
		teachertypeService.delete(teachertype.getTtId());
		response.getWriter().write("success");
	}
	
	
	//============================================setter and getter=====================================================
	public TeachertypeQuery getQuery() 
	{
		return query;
	}
	public void setQuery(TeachertypeQuery query)
	{
		this.query = query;
	}
	public TeachertypeService getTeachertypeService() 
	{
		return teachertypeService;
	}
	public void setTeachertypeService(TeachertypeService teachertypeService) 
	{
		this.teachertypeService = teachertypeService;
	}
	public Teachertype getTeachertype()
	{
		return teachertype;
	}
	public void setTeachertype(Teachertype teachertype)
	{
		this.teachertype = teachertype;
	}
	
}
