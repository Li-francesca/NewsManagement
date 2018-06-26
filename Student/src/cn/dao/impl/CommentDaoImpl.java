package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BaseDao;
import cn.dao.CommentDao;
import cn.entity.Comment;



public class CommentDaoImpl extends BaseDao implements CommentDao {

	@Override
	public List<Comment> getCommentsByNid(int nid) throws SQLException {
		List<Comment> list = new ArrayList<Comment>();
		String sql = "SELECT * FROM `comments` WHERE `cnid` = ?"
				+ " ORDER BY `cdate` desc";
		ResultSet rs = null;
		try {
			rs = exxcuteQuery(sql, nid);
			Comment comment = null;
			while (rs.next()) {
				comment = new Comment();
				comment.setCid(rs.getString("cid"));
				comment.setCnid(rs.getString("cnid"));
				comment.setCauthor(rs.getString("cauthor"));
				comment.setCip(rs.getString("cip"));
				comment.setCcontent(rs.getString("ccontent"));
				comment.setCdate(rs.getString("cdate"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*finally {
			BaseDao.closeAll(null, null, rs);
		}*/
		return list;
	}

	@Override
	public int addComment(Comment comment) throws SQLException {
		String sql = "INSERT INTO `comments`(`CNID`, `CCONTENT`, `CDATE`,"
				+ "`CIP`,`CAUTHOR`) VALUES(?, ?, ?, ?, ?)";
		System.out.println(comment.getCnid() + ":" + comment.getCcontent()
				+ ":" + comment.getCdate() + ":" + comment.getCip() + ":"
				+ comment.getCauthor());
		Object[] params = new Object[] { comment.getCnid(),
				comment.getCcontent(), comment.getCdate(), comment.getCip(),
				comment.getCauthor() };
		int result = 0;
		result = executeUpdateSQL(sql, params);
		return result;
	}

}
