package cn.wyx.query;

import cn.wyx.model.Tphoto;

public class TphotoQuery extends Tphoto
{
	
	private Integer pageNo;	
	private Integer startNum;
	
	private String tel;

	
	//============================================setter和getter方法=====================================================	
	public Integer getPageNo() 
	{
		return pageNo;
	}
	public void setPageNo(Integer pageNo) 
	{
		this.pageNo = pageNo;
	}
	public Integer getStartNum() 
	{
		return startNum;
	}
	public void setStartNum(Integer startNum) 
	{
		this.startNum = startNum;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
}
