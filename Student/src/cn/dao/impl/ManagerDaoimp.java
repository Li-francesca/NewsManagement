package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.Manager;

import cn.dao.BaseDao;
import cn.dao.ManagerDao;
import cn.dao.UserDao;
import cn.entity.User;

public class ManagerDaoimp extends BaseDao implements ManagerDao{

	@Override
	public boolean delUser(int id) {
		int row = 0;
		boolean flag = false;
		String sql = "delete from user where `id`=?";
		Object[] params = {User.getId()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("删除学生成功");
			flag =true;
		}else{
			System.out.println("删除学生失败");
		}
		return flag;
	}

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
