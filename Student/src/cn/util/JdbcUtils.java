package cn.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/newsmanagersystem";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	static {
		try {
			
			Class.forName(DRIVER);//加载驱动
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);//创建数据库的连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}

	public static void close(Connection conn2) {
		// TODO Auto-generated method stub
		
	}
    /*private static Properties config = new Properties(); 
    
    static{
        InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("database.properties");
        try{
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            
        
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
    	
        String url = config.getProperty("jdbc.url");
        String username = config.getProperty("jdbc.username");
        String password = config.getProperty("jdbc.password");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    
    public static void release(Connection conn,Statement st,ResultSet rs) {
        if(rs!=null) {
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(st!=null) {
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
}
