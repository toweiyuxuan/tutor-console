package cn.wyx.model;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable
{

	// Fields

	private Integer AId;
	private String AUsername;
	private String APassword;

	// Constructors

	/** default constructor */
	public Admin()
	{
	}

	/** full constructor */
	public Admin(String AUsername, String APassword)
	{
		this.AUsername = AUsername;
		this.APassword = APassword;
	}

	// Property accessors

	public Integer getAId()
	{
		return this.AId;
	}

	public void setAId(Integer AId)
	{
		this.AId = AId;
	}

	public String getAUsername()
	{
		return this.AUsername;
	}

	public void setAUsername(String AUsername)
	{
		this.AUsername = AUsername;
	}

	public String getAPassword()
	{
		return this.APassword;
	}

	public void setAPassword(String APassword)
	{
		this.APassword = APassword;
	}

}