package cn.wyx.dao;

import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teachertype;
import cn.wyx.query.TeachertypeQuery;

public interface TeachertypeDao extends BaseDao<Teachertype, TeachertypeQuery> 
{
	public Teachertype getTeachertypeByUname(String teachertype);
}
