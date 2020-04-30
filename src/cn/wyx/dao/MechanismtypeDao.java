package cn.wyx.dao;

import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.MechanismtypeQuery;

public interface MechanismtypeDao extends BaseDao<Mechanismtype, MechanismtypeQuery> 
{
	public Mechanismtype getMechanismtypeByUname(String mechanismtype);
}
