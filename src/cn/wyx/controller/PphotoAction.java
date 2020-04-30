package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Users;
import cn.wyx.query.PphotoQuery;
import cn.wyx.service.PphotoService;
import cn.wyx.service.UsersService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class PphotoAction extends BaseAction 
{	
	private Users user;
	private UsersService usersService;
	private PphotoService pphotoService;
	private PphotoQuery query = new PphotoQuery();
	
	public String pphoto_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}
		Page page = pphotoService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}

	//²µ»Ø
	public void pphoto_back() throws IOException
	{
		user = usersService.getObj(user.getUId());
		user.setUAttestation(3);
		user.setUIsfinish(1);
		usersService.updateUsers(user);
		response.getWriter().write("success");
	}
	
	//Í¨¹ý
	public void pphoto_pass() throws IOException
	{
		user = usersService.getObj(user.getUId());
		user.setUAttestation(4);
		user.setUIsfinish(2);
		usersService.updateUsers(user);
		response.getWriter().write("success");
	}
	
	//============================================setter and getter=====================================================
	public PphotoQuery getQuery() 
	{
		return query;
	}
	public void setQuery(PphotoQuery query)
	{
		this.query = query;
	}
	public PphotoService getPphotoService() 
	{
		return pphotoService;
	}
	public void setPphotoService(PphotoService pphotoService) 
	{
		this.pphotoService = pphotoService;
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}

	public UsersService getUsersService()
	{
		return usersService;
	}

	public void setUsersService(UsersService usersService)
	{
		this.usersService = usersService;
	}
	
}
