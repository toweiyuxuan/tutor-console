package cn.wyx.service;

import cn.wyx.model.Parent;
import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teachertype;
import cn.wyx.query.TeachertypeQuery;

public interface TeachertypeService extends BaseService<Teachertype, TeachertypeQuery> 
{
	public void updateTeachertype(Teachertype teachertype);
	public Teachertype getTeachertypeByUname(String teachertype);
}
