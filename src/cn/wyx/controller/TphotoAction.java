package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Tphoto;
import cn.wyx.query.TphotoQuery;
import cn.wyx.service.TphotoService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class TphotoAction extends BaseAction 
{	
	private Tphoto tphoto;
	private TphotoService tphotoService;
	private TphotoQuery query = new TphotoQuery();
	
	public String tphoto_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = tphotoService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	//É¾³ý
	public void tphoto_detele() throws IOException
	{
		tphotoService.delete(tphoto.getTpId());	
		response.getWriter().write("success");
	}
	
	
	
	
	//============================================setter and getter=====================================================
	public TphotoQuery getQuery() 
	{
		return query;
	}
	public void setQuery(TphotoQuery query)
	{
		this.query = query;
	}
	public TphotoService getTphotoService() 
	{
		return tphotoService;
	}
	public void setTphotoService(TphotoService tphotoService) 
	{
		this.tphotoService = tphotoService;
	}

	public Tphoto getTphoto()
	{
		return tphoto;
	}

	public void setTphoto(Tphoto tphoto)
	{
		this.tphoto = tphoto;
	}
	
}
