package cn.wyx.model;

import java.util.Set;

/**
 * Teachertype entity. @author MyEclipse Persistence Tools
 */

public class Teachertype implements java.io.Serializable
{

	// Fields

	private Integer ttId;
	private String ttName;
	
	private String select;
	
	// Constructors

	/** default constructor */
	public Teachertype()
	{
	}

	/** full constructor */
	public Teachertype(String ttName)
	{
		this.ttName = ttName;
	}

	// Property accessors

	public Integer getTtId()
	{
		return this.ttId;
	}

	public void setTtId(Integer ttId)
	{
		this.ttId = ttId;
	}

	public String getTtName()
	{
		return this.ttName;
	}

	public void setTtName(String ttName)
	{
		this.ttName = ttName;
	}

	public String getSelect()
	{
		return select;
	}

	public void setSelect(String select)
	{
		this.select = select;
	}
	
	@Override
	public String toString()
	{
		return ttName;
	}
}