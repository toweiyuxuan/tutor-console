package cn.wyx.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import cn.wyx.model.Mechanism;
import cn.wyx.model.Parent;
import cn.wyx.model.Pphoto;
import cn.wyx.model.Subjecttype;
import cn.wyx.model.Teacher;
import cn.wyx.model.Users;
import cn.wyx.query.UsersQuery;
import cn.wyx.service.UsersService;
import cn.wyx.utils.MD5Utils;
import cn.wyx.utils.Page;

import com.opensymphony.xwork2.ActionContext;

public class UsersAction extends BaseAction 
{
	private Users user;
	private UsersService usersService;
	private UsersQuery query = new UsersQuery();
	
	public String users_list()
	{		
		ActionContext context = ActionContext.getContext();		
		Integer pageNo = query.getPageNo();
		if(pageNo == null )
		{
			query.setPageNo(1);
		}		
		Page page = usersService.queryObjByCondition(query, exclude);		
		context.put("page", page);	
		
		return SUCCESS;
	}
	public String users_input()
	{
		return SUCCESS;
	}
	
	//ע��
	public void users_detele() throws IOException
	{
		usersService.delete(user.getUId());	
		response.getWriter().write("success");
	}
	
	//����
	public void users_forbid() throws IOException
	{
		user = usersService.getObj(user.getUId());
		user.setUStation(2);
		usersService.updateUsers(user);
		response.getWriter().write("success");
	}
	//����
	public void users_start() throws IOException
	{
		user = usersService.getObj(user.getUId());
		user.setUStation(1);
		usersService.updateUsers(user);
		response.getWriter().write("success");
	}
		
	//����
	public void users_add() throws IOException
	{	
		Users user1 = usersService.getUsersByUname(user.getUTel());
		if(user1 == null)
		{
			
			String password = user.getUPassword();
			password = MD5Utils.md5(password);		
			user.setUPassword(password);
			//��ע�������Ϣ�϶��ǲ����Ƶ�
			user.setUIsfinish(1);
			//��ע����״̬ʱ���õ�	
			user.setUStation(1);
			
			Date date = new Date();
			//�õ�һ��timestamp��ʽ��ʱ�䣬����mysql�е�ʱ���ʽΪ"yyyy-MM-dd HH:mm:ss"
			Timestamp timestamp = new Timestamp(date.getTime());
			
			if(user.getUSf()==1)
			{
				//��ע�������Ϣ�϶���δ��֤��
				user.setUAttestation(1);
				user.setUTime(timestamp);
				
				Parent parent = new Parent();
				Pphoto pPhotos = new Pphoto();
				
				parent.setUser(user);
				pPhotos.setUser(user);
				
				user.setParent(parent);
				user.setPphoto(pPhotos);
						
				usersService.save(user);
				
				//ʹ�ü������赥������parent��pphoto
				//parentService.save(parent);
				//pphotoService.save(pphoto);
				
			}
			
			if(user.getUSf()==2)
			{
				//��ʦ�����
				user.setUAttestation(4);
				user.setUTime(timestamp);
				
				Teacher teacher = new Teacher();
				
				teacher.setUser(user);
				
				user.setTeacher(teacher);
				
				usersService.save(user);
				
				//ʹ�ü������赥������teacher
				//teacherService.save(teacher);
				
			}
			
			if(user.getUSf()==3)
			{
				//���������
				user.setUAttestation(4);
				user.setUTime(timestamp);
				
				Mechanism mechanism = new Mechanism();
				
				mechanism.setUser(user);
				
				user.setMechanism(mechanism);
				
				usersService.save(user);
				
				//ʹ�ü������赥������mechanism
				//mechanismService.save(mechanism);
				
			}
			response.getWriter().write("success");
		}
		
		if(user1 != null)
		{
			response.getWriter().write("no");
		}
	}
	
	//============================================setter and getter=====================================================
	public UsersQuery getQuery() 
	{
		return query;
	}
	public void setQuery(UsersQuery query)
	{
		this.query = query;
	}
	public UsersService getUsersService() 
	{
		return usersService;
	}
	public void setUsersService(UsersService usersService) 
	{
		this.usersService = usersService;
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}
	
}
