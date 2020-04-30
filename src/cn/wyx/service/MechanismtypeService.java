package cn.wyx.service;

import cn.wyx.model.Mechanismtype;
import cn.wyx.model.Subjecttype;
import cn.wyx.query.MechanismtypeQuery;

public interface MechanismtypeService extends BaseService<Mechanismtype, MechanismtypeQuery> 
{
	public void updateMechanismtype(Mechanismtype mechanismtype);
	public Mechanismtype getMechanismtypeByUname(String mechanismtype);
}
