package cn.wyx.controller;

import java.io.IOException;

import cn.wyx.model.Mphoto;
import cn.wyx.query.MphotoQuery;
import cn.wyx.service.MphotoService;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class MphotoAction extends BaseAction 
{	
	private Mphoto mphoto;
	private MphotoService mphotoService;
	private MphotoQuery query = new MphotoQuery();
	
	public String mphoto_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = mphotoService.queryObjByCondition(query, exclude);		
		context.put("page", page);		
		return SUCCESS;
	}
	//É¾³ý
	public void mphoto_detele() throws IOException
	{
		mphotoService.delete(mphoto.getMpId());	
		response.getWriter().write("success");
	}
	
	
	
	
	//============================================setter and getter=====================================================
	public MphotoQuery getQuery() 
	{
		return query;
	}
	public void setQuery(MphotoQuery query)
	{
		this.query = query;
	}
	public MphotoService getMphotoService() 
	{
		return mphotoService;
	}
	public void setMphotoService(MphotoService mphotoService) 
	{
		this.mphotoService = mphotoService;
	}
	public Mphoto getMphoto()
	{
		return mphoto;
	}
	public void setMphoto(Mphoto mphoto)
	{
		this.mphoto = mphoto;
	}
	
}
