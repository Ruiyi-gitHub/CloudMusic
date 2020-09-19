package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.WookingDao;
import entity.Working;

/**数据库操作类*/
public class WookingDaoImpl extends BaseDao implements WookingDao{

	@Override
	public List<Working> selectWookingAll() {
		//查询所有会员信息的SQL语句
		String sql="select * from working;";
		//执行SQL语句返回结果
		ResultSet rs = this.executeQuery(sql, null);
		//创建结果集合
		List<Working> wookings = new ArrayList<Working>();
		//遍历结果集
		try {
			while (rs.next()) {
				Working wooking = new Working();
				wooking.setId(rs.getInt("id"));
				wooking.setTitle(rs.getString("title"));
				wooking.setContent(rs.getString("content"));
				wooking.setType(rs.getInt("type"));
				wooking.setCreateDate(rs.getDate("createDate"));
				//将拿到的对象存入结果集合中
				wookings.add(wooking);
			}
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wookings;
	}

	

	@Override
	public Working getWookingBymId(int id) {
		//定义SQL语句
		String sql="select * from working where id=?";
		//定义参数列表
		ArrayList param = new ArrayList();
		param.add(id);
		//执行SQL语句拿到结果集
		ResultSet rs=this.executeQuery(sql, param);
		Working wooking = null;
		try {
			while (rs.next()) {
				wooking = new Working();
				wooking.setId(rs.getInt("id"));
				wooking.setTitle(rs.getString("title"));
				wooking.setContent(rs.getString("content"));
				wooking.setType(rs.getInt("type"));
				wooking.setCreateDate(rs.getDate("createDate"));
			}
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wooking;
	}



	@Override
	public int addWoofing(Working wooking) {
		String sql="insert into working(title,content,type)VALUES(?,?,?)";
		ArrayList param = new ArrayList();
		param.add(wooking.getTitle());
		param.add(wooking.getContent());
		param.add(wooking.getType());
		int reuslt = this.executeUpdate(sql, param);
		return reuslt;
	}



	@Override
	public List<Working> selectWookingByTitle(String title) {
		//查询所有会员信息的SQL语句
				String sql="select * from working where title=?;";
				ArrayList param = new ArrayList();
				param.add(title);
				//执行SQL语句返回结果
				ResultSet rs = this.executeQuery(sql, null);
				//创建结果集合
				List<Working> wookings = new ArrayList<Working>();
				//遍历结果集
				try {
					while (rs.next()) {
						Working wooking = new Working();
						wooking.setId(rs.getInt("id"));
						wooking.setTitle(rs.getString("title"));
						wooking.setContent(rs.getString("content"));
						wooking.setType(rs.getInt("type"));
						wooking.setCreateDate(rs.getDate("createDate"));
						//将拿到的对象存入结果集合中
						wookings.add(wooking);
					}
					closeAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return wookings;
	}



	@Override
	public List<Working> getWooking(int index) {
		//定义查询SQL语句
		String sql="select * from working limit ?,5;";
		ArrayList param = new ArrayList();
		param.add(index*5);
		//执行SQL语句返回结果
		ResultSet rs = this.executeQuery(sql, param);
		//创建结果集合
		List<Working> wookings = new ArrayList<Working>();
		//遍历结果集
		try {
			while (rs.next()) {
				Working wooking = new Working();
				wooking.setId(rs.getInt("id"));
				wooking.setTitle(rs.getString("title"));
				wooking.setContent(rs.getString("content"));
				wooking.setType(rs.getInt("type"));
				wooking.setCreateDate(rs.getDate("createDate"));
				//将拿到的对象存入结果集合中
				wookings.add(wooking);
			}
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wookings;
		
	}



	
	
}
