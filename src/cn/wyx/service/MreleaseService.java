package cn.wyx.service;

import cn.wyx.model.Mechanism;
import cn.wyx.model.Mrelease;
import cn.wyx.query.MreleaseQuery;

public interface MreleaseService extends BaseService<Mrelease, MreleaseQuery> 
{
	public void updateMrelease(Mrelease mrelease);
}
