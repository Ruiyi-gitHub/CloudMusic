package service.impl;

import java.util.List;

import dao.impl.WookingDaoImpl;
import entity.Working;
import service.WookingServcie;

public class WookingServcieImpl implements WookingServcie{
	WookingDaoImpl wookingSer = new WookingDaoImpl();
	@Override
	public List<Working> selectWookingAll() {
		// TODO Auto-generated method stub
		return wookingSer.selectWookingAll();
	}

	@Override
	public int addWoofing(Working wooking) {
		// TODO Auto-generated method stub
		return wookingSer.addWoofing(wooking);
	}

	@Override
	public Working getWookingBymId(int id) {
		// TODO Auto-generated method stub
		return wookingSer.getWookingBymId(id);
	}

	@Override
	public List<Working> selectWookingByTitle(String title) {
		return wookingSer.selectWookingByTitle(title);
	}

	@Override
	public List<Working> getWookingService(int index) {
		
		return wookingSer.getWooking(index);
	}
	

}
