package dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;

import entity.Working;



public interface WookingDao {
	/**查询工作笔记*/
	public List<Working> selectWookingAll();

	/**添加工作笔记*/
	public int addWoofing(Working wooking);
	
	/**根据工作笔记ID查询*/
	public Working getWookingBymId(int id);
	
	/**根据工作标题查询工作笔记数*/
	public List<Working> selectWookingByTitle(String title);
	
	/**按分页查询*/
	public List<Working> getWooking(int index);
}
