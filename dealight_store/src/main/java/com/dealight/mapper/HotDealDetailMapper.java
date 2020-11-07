package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.ReservationDetailVO;

public interface HotDealDetailMapper {
	
	// create
	public void insert(HotDealDetailVO htdlDt);
	
	public void insertSelectKey(HotDealDetailVO htdlDt);
	
	// insert n
	public int insertHtdlDtls(List<HotDealDetailVO> rsvdDtls);
	
	// read
	public HotDealDetailVO findBySeq(long htdlSeq);
	
	// read
	// by htdl id
	public List<HotDealDetailVO> findByHtdlId(long htdlId);
	
	// read list
	public List<HotDealDetailVO> findAll();
	
	// update
	public int update(HotDealDetailVO htdl);
	
	// delete
	public int delete(long htdlSeq);

}
