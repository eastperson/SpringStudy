package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.HotDealDetailVO;

public interface HotDealDetailMapper {
	
	// create
	public void insert(HotDealDetailVO htdlDt);
	
	public void insertSelectKey(HotDealDetailVO htdlDt);
	
	// read
	public HotDealDetailVO findBySeq(long htdlSeq);
	
	// read list
	public List<HotDealDetailVO> findAll();
	
	// update
	public int update(HotDealDetailVO htdl);
	
	// delete
	public int delete(long htdlSeq);

}
