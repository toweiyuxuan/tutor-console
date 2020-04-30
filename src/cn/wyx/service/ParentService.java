package cn.wyx.service;

import cn.wyx.model.Parent;
import cn.wyx.model.Users;
import cn.wyx.query.ParentQuery;

public interface ParentService extends BaseService<Parent, ParentQuery> 
{
	public void updateParent(Parent parent);
}
