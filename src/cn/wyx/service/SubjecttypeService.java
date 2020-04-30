package cn.wyx.service;

import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teachertype;
import cn.wyx.query.SubjecttypeQuery;

public interface SubjecttypeService extends BaseService<Subjecttype, SubjecttypeQuery> 
{
	public void updateSubjecttype(Subjecttype subjecttype);
	public Subjecttype getSubjecttypeByUname(String subjecttype);
}
