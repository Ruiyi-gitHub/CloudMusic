package service;

import java.util.List;

import entity.Working;


public interface WookingServcie {
	/**查询工作笔记的业务逻辑处理*/
	public List<Working> selectWookingAll();

	/**添加工作笔记的业务逻辑处理*/
	public int addWoofing(Working wooking);
	
	/**根据工作笔记ID查询的业务逻辑处理*/
	public Working getWookingBymId(int id);
	
	/**根据工作标题查询工作笔记数的业务逻辑处理*/
	public List<Working> selectWookingByTitle(String title);
	
	/**分页查询的业务逻辑处理*/
	public List<Working> getWookingService(int index);
	
}
