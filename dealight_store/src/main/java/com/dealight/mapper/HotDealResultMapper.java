package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.HotDealResultVO;

public interface HotDealResultMapper {
	
	// create
	public void insert(HotDealResultVO htdlRs);
	
	// read
	public HotDealResultVO findById(long htdlId);
	
	// read list
	public List<HotDealResultVO> findAll();
	
	// update
	public int update(HotDealResultVO htdlRs);
	
	// delete
	public int delete(long htdlId);

}
