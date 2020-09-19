package dao;
/**链接数据库的工具类*/

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class BaseDao {
	private static String dirver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/working";
	private static String user = "root";
	private static String pwd = "root";
	
	private static Connection conn =null;
	private static PreparedStatement state = null;
	private static ResultSet rs = null;
	
	/**获取Connection的方法*/
	public static Connection getConnection()  {
			try {
				Class.forName(dirver);
				conn = DriverManager.getConnection(url,user,pwd);
				return conn;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
	
	/**关闭链接*/
	public static void closeAll() {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null != state) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null !=conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增删改方法*/
	public static int executeUpdate(String sql,ArrayList param) {
		int result = 0;
		try {
			state =  getConnection().prepareStatement(sql);
			if(param!=null) {
				for (int i = 0; i < param.size(); i++) {
					state.setObject((i+1),param.get(i));
				}
			}
			result = state.executeUpdate();
			System.out.println(state.toString());
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return result;
	}
	/**
	 * 执行查找方法*/
	public static ResultSet executeQuery(String sql,ArrayList param) {
		try {
			state = getConnection().prepareStatement(sql);
			if(null != param) {
				for (int i = 0; i < param.size(); i++) {
					state.setObject((i+1), param.get(i));
				}
			}
			rs = state.executeQuery();
			System.out.println(state.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
