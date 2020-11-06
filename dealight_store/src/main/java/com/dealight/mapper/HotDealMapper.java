package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.BUserVO;
import com.dealight.domain.HotDealVO;

public interface HotDealMapper {
	
	// create
	public void insert(HotDealVO htdl);
	
	public void insertSelectKey(HotDealVO htdl);
	
	// read
	public HotDealVO findById(long htdlId);
	
	// read list
	public List<HotDealVO> findAll();
	
	// update
	public int update(HotDealVO htdl);
	
	// delete
	public int delete(long htdlId);

}
