package cn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.entity.Comment;


public interface CommentDao {
	// 通过新闻id查找评论
	public List<Comment> getCommentsByNid(int nid) throws SQLException;

	// 添加评论
	public int addComment(Comment comment) throws SQLException;

}
