package cn.service.impl;

import java.util.List;

import org.apache.catalina.Manager;

import cn.dao.ManagerDao;
import cn.dao.UserDao;
import cn.dao.impl.ManagerDaoimp;
import cn.entity.User;
import cn.service.ManagerService;

public class ManagerServiceimp implements ManagerService{
	ManagerDao managerDao = null;
	public ManagerServiceimp() {
		managerDao = new ManagerDaoimp();
	}
	

	@Override
	public boolean delUser(int id) {
		
		return managerDao.delUser(id);
	}


	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		return managerDao.queryUserById(id);
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return managerDao.listAllUser();
	}

	@Override
	public List<User> queryUserByName(String name) {
		// TODO Auto-generated method stub
		return managerDao.queryUserByName(name);
	}



}
