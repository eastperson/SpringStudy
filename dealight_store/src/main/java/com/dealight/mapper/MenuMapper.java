package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.HotDealVO;
import com.dealight.domain.MenuVO;

public interface MenuMapper {
	
	// create
	public void insert(MenuVO menu);
	
	public void insertSelectKey(MenuVO menu);
	
	
	// read
	public MenuVO findBySeq(long menuSeq);
	
	// read list
	public List<MenuVO> findAll();
	
	// update
	public int update(MenuVO menu);
	
	// delete
	public int delete(long menuSeq);

}
