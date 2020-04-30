package cn.wyx.model;

/**
 * Mechanismtype entity. @author MyEclipse Persistence Tools
 */

public class Mechanismtype implements java.io.Serializable
{

	// Fields

	private Integer MId;
	private String MName;

	// Constructors

	/** default constructor */
	public Mechanismtype()
	{
	}

	/** full constructor */
	public Mechanismtype(String MName)
	{
		this.MName = MName;
	}

	// Property accessors

	public Integer getMId()
	{
		return this.MId;
	}

	public void setMId(Integer MId)
	{
		this.MId = MId;
	}

	public String getMName()
	{
		return this.MName;
	}

	public void setMName(String MName)
	{
		this.MName = MName;
	}

}