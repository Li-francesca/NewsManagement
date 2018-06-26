package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.BaseDao;
import cn.dao.UserDao;
import cn.entity.User;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-10  All rights reserved.
 *
 * @ class description：操作用户
 *
 */
public class UserDaoimp extends BaseDao implements UserDao{

	@Override
	//查找用户
	public boolean findUser(User user) {
		boolean flag = true;
		String sql = "select count(1) from user where `username`=? and `password`=?";
		Object[] params = {user.getUsername(),user.getPassword()};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while(rs.next()){
				int num = rs.getInt(1);
				if(num>0){
					System.out.println("存在这个用户");
					flag = true;
				}else{
					System.out.println("不存在这个用户");
					flag = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
//	insert into student(`id`,`name`,`age`,`sex`,`gradeId`,`profile`) values(?,?,?,?,?,?)
	@Override
	//添加用户
	public boolean addUser(User user) {
		/*String sql = "INSERT INTO user (username,password) values(?,?,?,?,?,?,?)";
		Object[] parm = {news.getNtitle(),news.getNtid(), news.getNauthor(),
				news.getNcreatedate(), news.getNpicpath(), news.getNsummary(),
				news.getNcontent() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;*/
		
		
		boolean flag = false;
		//int row = 0;
		//String sql = "select count(1) from user where `username`=? and `password`=?";
		String sql = "INSERT INTO user (username,password) values(?,?)";
		Object[] params = {user.getUsername(),user.getPassword()};
		int row = this.executeUpdateSQL(sql, params);
		System.out.println(row);
		if(row>0){
			System.out.println("注册用户成功");
			flag = true;
		}else{
			System.out.println("注册用户失败");
		}
		return flag;
	}

	@Override
	//更新用户
    public boolean updateUser(User user) {
    	boolean flag = true;
    	int row = 0;
		String sql = "update user SET password= ?,username= ? where id=?";
		Object[] params = {user.getUsername(),user.getPassword()};
		ResultSet rs = this.executeQuerySQL(sql, params);
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("修改账户成功");
			flag = true ;
		}else{
			System.out.println("修改账户失败");
		}
		
		return flag;
    }

}


