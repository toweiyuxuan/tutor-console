package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Teacher;
import cn.wyx.query.TeacherQuery;
import cn.wyx.service.TeacherService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class TeacherAction extends BaseAction 
{	
	private Teacher teacher;
	private TeacherService teacherService;
	private TeacherQuery query = new TeacherQuery();
	
	public String teacher_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = teacherService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	public String teacher_edit()
	{	
		ActionContext context = ActionContext.getContext();		
		teacher = teacherService.getObj(teacher.getUId());	
		context.put("teacher", teacher);		
		return SUCCESS;
	}
	
	//±à¼­£¨ÐÞ¸Ä£©
	public void teacher_update() throws IOException
	{
		teacherService.updateTeacher(teacher);
		response.getWriter().write("success");
	}

	public String teacher_input()
	{
		return SUCCESS;
	}
	
	
	
	
	//============================================setter and getter=====================================================
	public TeacherQuery getQuery() 
	{
		return query;
	}
	public void setQuery(TeacherQuery query)
	{
		this.query = query;
	}
	public TeacherService getTeacherService() 
	{
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) 
	{
		this.teacherService = teacherService;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	
}
