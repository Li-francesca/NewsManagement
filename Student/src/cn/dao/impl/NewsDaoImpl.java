package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.dao.BaseDao;
import cn.dao.NewsDao;
import cn.entity.News;
import cn.entity.Page;
import cn.entity.Topic;
import cn.util.JdbcUtils;




public class NewsDaoImpl extends BaseDao implements NewsDao {

	public List<News> getAllnews() {
		List<News> list = new ArrayList<News>();
		ResultSet rs = null;
		String sql = "SELECT * from news,topic where news.ntid =topic.tid order by ntid,ncreatedate desc limit 30";
		/*Object[] params = {};
		rs = this.executeQuerySQL(sql, params);*/
		try {
			
			rs = this.exxcuteQuery(sql);
			//News news = null;
			while (rs.next()) {
				News news = new News();
				news.setNid(rs.getObject("nid").toString());
				news.setNtid(rs.getString("ntid").toString());// 主题
				news.setNtitle(rs.getObject("ntitle").toString());// 标题
				news.setNauthor(rs.getObject("nauthor").toString());// 作者
				news.setNcreatedate(rs.getObject("ncreateDate").toString());// 日期
				news.setNsummary(rs.getObject("nsummary").toString());// 摘要
				news.setNtname(rs.getObject("tname").toString());// 内容
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		/*} finally {
			BaseDao.closeAll(connection, pstmt, rs);
*/
		}
		return list;
	}

	// 获取某主题下的所有新闻
	public List<News> getAllnewsByTID(int tid) throws SQLException {
		// select * from news left join topic on news.ntid = topic.tid limit ?,?
		
		List<News> list = new ArrayList<News>();
		String sql = "select * from news left join topic on news.ntid = topic.tid where ntid=?  order by  ncreateDate desc ";
		Connection conn=JdbcUtils.getConnection();
		
		//rs = this.exxcuteQuery(sql, Tid);
		//rs = this.executeQuerySQL(sql, Tid);
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);					
			ptmt.setInt(1, tid);
			ResultSet rs=ptmt.executeQuery();
			News news = null;
			while (rs.next()) {
				news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtname(String.valueOf(rs.getObject("tname")));
				news.setNtitle(String.valueOf(rs.getObject("ntitle")));
				news.setNauthor(String.valueOf(rs.getObject("nauthor")));
				news.setNcreatedate(String.valueOf(rs.getObject("ncreateDate")));
				news.setNpicpath(String.valueOf(rs.getObject("npicPath")));
				news.setNcontent(String.valueOf(rs.getObject("ncontent")));
				news.setNmodifydate(String.valueOf(rs.getObject("nmodifyDate")));
				news.setNsummary(String.valueOf(rs.getObject("nsummary")));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*finally {
			BaseDao.closeAll(connection, pstm, rs);
		}*/
		return list;
	}

	// 获取某主题下的最新新闻
	public List<News> getAllnewsByTname(String tname) throws SQLException {
		return null;

	}

	// 获取某主题下的新闻数量
	public int getNewsCountByTID(int Tid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	// 获取某条新闻
	public List<News> getLatestNewsByTID(int tid, int limit)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// 获取新闻select * from news left join topic on news.ntid = topic.tid limit ?,?
	public News getNewsByNID(int nid) throws SQLException {
		News n=new News();
		Connection conn=JdbcUtils.getConnection();
		String sql=" SELECT * FROM news left join topic on news.ntid = topic.tid where nid = ?" ;				
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);					
			ptmt.setInt(1, nid);
			ResultSet rs=ptmt.executeQuery();			
			while(rs.next()){
				n.setNid(rs.getString("nid"));
				n.setNtid(rs.getString("ntid"));
				n.setNtname(rs.getString("tname"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcreatedate(rs.getString("ncreatedate"));
				//n.setNpicpath(rs.getString("npicPath"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNmodifydate(rs.getString("nmodifydate"));
				//n.setNsummary(rs.getString("nsummary"));
				
				/*n.setNid(String.valueOf(rs.getObject("nid")));
				n.setNtid(String.valueOf(rs.getObject("ntid")));
				n.setNtitle(String.valueOf(rs.getObject("ntitle")));
				n.setNauthor(String.valueOf(rs.getObject("nauthor")));
				n.setNcreatedate(String.valueOf(rs.getObject("ncreateDate")));
				n.setNpicpath(String.valueOf(rs.getObject("npicPath")));
				n.setNcontent(String.valueOf(rs.getObject("ncontent")));
				n.setNmodifydate(String.valueOf(rs.getObject("nmodifyDate")));
				n.setNsummary(String.valueOf(rs.getObject("nsummary")));*/
				/*n.setNtitle(rs.getString("ntitle"));				
				n.setContent(rs.getString("content"));	
				n.setType(rs.getString("type"));
				n.setAdmin(rs.getString("admin"));	
				n.setDate(rs.getString("date"));
				n.setId(rs.getInt("id"));	*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
		
	}

	// 添加新闻
	public int Savae(News news) {
		String sql = "INSERT INTO news (ntid,ntitle,nauthor,ncreateDate,nsummary,ncontent) values(?,?,?,?,?,?)";
		Object[] parm = { news.getNtid(), news.getNtitle(), news.getNauthor(),
				news.getNcreatedate(), news.getNsummary(), news.getNcontent() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	// 删除新闻

	public int del(News news) {
		String sql = "delete from news where nid = ?";
		Object[] parm = { news.getNid() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	// 修改新闻

	public int update(News news) {
		// TODO Auto-generated method stub
		//String sql = "update news set ntid = ?,ntitle = ?,nauthor = ?,nmodifyDate = ?,ncontent=? where Nid = ?";
		String sql = "update news set ntitle = ?,nauthor = ?,nmodifyDate = ?,ncontent=? where nid = ?";
		Object[] parm = { news.getNtitle(), news.getNauthor(),
				news.getNmodifydate(), news.getNcontent(),
				news.getNid() };
		/*Object[] parm = { news.getNtid(), news.getNtitle(), news.getNauthor(),
				news.getNmodifydate(), news.getNcontent(),
				news.getNid() };*/
		
		int result = this.executeUpdateSQL(sql, parm);
		System.out.println("修改新闻页面-----");
		return result;

	}

	// 获取总记录数
	@Override
	public int getTotalCount() throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT COUNT(1) FROM `news`";
		int count = -1;
		try {
			rs = this.exxcuteQuery(sql);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*finally {
			BaseDao.closeAll(connection, pstmt, rs);
		}*/
		return count;
	}

	// 分页获得新闻
	@Override
	public List<News> getPageNewsList(int pageNo, int pageSize) {
		List<News> list = new ArrayList<News>();
		ResultSet rs = null;
		String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
				+ " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
				+ " WHERE `NEWS`.`ntid` = `TOPIC`.`tid`"
				+ " ORDER BY `ncreateDate` DESC LIMIT ?, ?";
		try {
			rs = this.exxcuteQuery(sql, (pageNo - 1) * pageSize, pageSize);
			News news = null;
			while (rs.next()) {
				news = new News();
				news.setNid(rs.getString("nid"));
				news.setNtid(rs.getString("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreatedate(rs.getString("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				news.setNtname(rs.getString("tname"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} /*finally {
			BaseDao.closeAll(connection, pstmt, rs);
		}*/
		return list;
	}

	@Override
	public int addNews(News news) {
		String sql = "INSERT INTO news (ntitle,ntid,nauthor,ncreateDate,ncontent) values(?,?,?,?,?)";
		Object[] parm = {news.getNtitle(),news.getNtid(), news.getNauthor(),
				news.getNcreatedate(), news.getNcontent() };
		int result = this.executeUpdateSQL(sql, parm);
		return result;
	}

	@Override
	public List<News> getAllnewsByNTID(String ntid) throws SQLException {
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		String sql = "select * from news where ntid=?  order by  ncreateDate desc limit 5 ";
		try {
			rs = this.exxcuteQuery(sql, ntid);
			News news = null;
			while (rs.next()) {
				news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle(String.valueOf(rs.getObject("ntitle")));
				news.setNauthor(String.valueOf(rs.getObject("nauthor")));
				news.setNcreatedate(String.valueOf(rs.getObject("ncreateDate")));
				news.setNpicpath(String.valueOf(rs.getObject("npicPath")));
				news.setNcontent(String.valueOf(rs.getObject("ncontent")));
				news.setNmodifydate(String.valueOf(rs.getObject("nmodifyDate")));
				news.setNsummary(String.valueOf(rs.getObject("nsummary")));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*finally {
			BaseDao.closeAll(connection, pstmt, rs);
		}*/
		return list;
	}

	@Override
	public List<News> getAllnewsByNtid(String ntid) throws SQLException {
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		String sql = "select * from news where ntid=?  order by  ncreateDate desc limit 30 ";
		try {
			rs = this.exxcuteQuery(sql, ntid);
			News news = null;
			while (rs.next()) {
				news = new News();
				news.setNid(String.valueOf(rs.getObject("nid")));
				news.setNtid(String.valueOf(rs.getObject("ntid")));
				news.setNtitle(String.valueOf(rs.getObject("ntitle")));
				news.setNauthor(String.valueOf(rs.getObject("nauthor")));
				news.setNcreatedate(String.valueOf(rs.getObject("ncreateDate")));
				news.setNpicpath(String.valueOf(rs.getObject("npicPath")));
				news.setNcontent(String.valueOf(rs.getObject("ncontent")));
				news.setNmodifydate(String.valueOf(rs.getObject("nmodifyDate")));
				news.setNsummary(String.valueOf(rs.getObject("nsummary")));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*finally {
			BaseDao.closeAll(connection, pstmt, rs);
		}*/
		return list;
	}
	
	/**
	 * 新闻的 分页查询
	 * @param page
	 * @return
	 */
    public Page pageQuery(Page page) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        //BaseDao baseDao = new BaseDao();
        try{
        	/*
        	 * SELECT blog_title,blog_content,blog_edit
        from blog LEFT JOIN friend ON friend.user_id=blog.user_id
        	 */
        	//  select * from cms_article limit (page.getPageNo())*page.getPageSize(),page.getPageSize()
        	conn = JdbcUtils.getConnection();
            String sql = "select * from news left join topic on news.ntid = topic.tid limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1, (page.getPageNo()-1)*page.getPageSize());
            st.setInt(2, page.getPageSize());
            rs = st.executeQuery();
            List contentList = new ArrayList();
            //rs = this.executeQuerySQL(sql, (page.getPageNo()-1) * page.getPageSize(), page.getPageSize());
            
            while(rs.next()) {
            	System.out.println(rs);
                News news = new News();
                news.setNid(rs.getString("nid"));
                news.setNtid(rs.getString("ntid"));
				news.setNtname(rs.getString("tname"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreatedate(rs.getString("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				//news.setNtname(rs.getString("tname"));
                contentList.add(news);
                
            }System.out.println("分页查询2");
            page.setList(contentList);
            //获取了页面数据后还没结束，还得获取总记录数
            sql = "select count(*) from news";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                int totalRecords = rs.getInt(1);  //rs.getInt("count(*)")也是可以的
                page.setCount(totalRecords);
            }
            return page;    
        }catch (Exception e) {
            throw new RuntimeException(e);
        }/*finally{
            JdbcUtils.release(conn, st, rs);
        }*/
    }

}
