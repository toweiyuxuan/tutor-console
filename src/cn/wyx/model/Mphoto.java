package cn.wyx.model;

/**
 * Mphoto entity. @author MyEclipse Persistence Tools
 */

public class Mphoto implements java.io.Serializable
{

	// Fields

	private Integer mpId;
	private Integer UId;
	private String mpAddress;
	private String UTel;
	
	//∂‡∂‘“ª
	private Users user;

	// Constructors

	/** default constructor */
	public Mphoto()
	{
	}

	/** full constructor */
	public Mphoto(Integer UId, String mpAddress, String UTel)
	{
		this.UId = UId;
		this.mpAddress = mpAddress;
		this.UTel = UTel;
	}

	// Property accessors

	public Integer getMpId()
	{
		return this.mpId;
	}

	public void setMpId(Integer mpId)
	{
		this.mpId = mpId;
	}

	public Integer getUId()
	{
		return this.UId;
	}

	public void setUId(Integer UId)
	{
		this.UId = UId;
	}

	public String getMpAddress()
	{
		return this.mpAddress;
	}

	public void setMpAddress(String mpAddress)
	{
		this.mpAddress = mpAddress;
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}

	public String getUTel()
	{
		return UTel;
	}

	public void setUTel(String uTel)
	{
		UTel = uTel;
	}
	
}