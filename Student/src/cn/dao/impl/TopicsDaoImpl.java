package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BaseDao;
import cn.dao.TopicsDao;
import cn.entity.Topic;
import cn.util.JdbcUtils;


public class TopicsDaoImpl extends BaseDao implements TopicsDao {

	public List<Topic> getAllTopics() {
		String sql = "select * from topic ";
		Connection conn=JdbcUtils.getConnection();
		//ResultSet rs = this.exxcuteQuery(sql);
		List<Topic> list = new ArrayList<Topic>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			//ptmt.setString(1, name);
			ResultSet rs=ptmt.executeQuery();
			while (rs.next()) {
				
				Topic topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(String.valueOf(rs.getObject("tname")));
				System.out.println(topic.getTname());
				list.add(topic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BaseDao.closeAll(connection, pstmt, rs);
		return list;
	}

	public int updateTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update topic set tname = ? where  tid = ?";
		Object[] parm = { topic.getTname(), topic.getTid() };
		//int result = this.executeUpdateSQL(sql, parm);
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	public boolean findTopicByName(String name) throws SQLException {
		boolean flag = true;
		Topic topic = new Topic();
		//ResultSet rs = null;
		Connection conn=JdbcUtils.getConnection();
		//List<Topic> list = new ArrayList<Topic>();
		String sql = "select * from topic where tname=?";
		//rs = this.exxcuteQuery(sql, name);
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet rs=ptmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				if(num>0){
					System.out.println("存在这个用户");
					flag = false;
				}else{
					System.out.println("不存在这个用户");
					flag = true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BaseDao.closeAll(connection, pstmt, rs);
		return flag;
		
	}

	// 添加主题
	public int addTopic(Topic topic) throws SQLException {
		String sql = "INSERT INTO topic (tname) values(?)";
		Object[] parm = { topic.getTname() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	public int deleteTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from topic where tid = ?";
		Object[] parm = { topic.getTid() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	// 根据Id值查找新闻主题
	@Override
	public List<Topic> findAlltopicId(int tid) throws SQLException {
		ResultSet rs = null;
		List<Topic> list = new ArrayList<Topic>();
		String sql = "select * from topic where tid = ?";
		rs = this.exxcuteQuery(sql, tid);
		try {
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(String.valueOf(rs.getObject("tname")));
				list.add(topic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BaseDao.closeAll(connection, pstmt, rs);
		return list;
	}
}
