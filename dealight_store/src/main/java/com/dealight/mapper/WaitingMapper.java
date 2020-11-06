package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.WaitingVO;

public interface WaitingMapper {
	
	// create
	public void insert(WaitingVO waiting);
	
	public void insertSelectKey(WaitingVO waiting);
	
	// read
	public WaitingVO findById(long id);
	
	// read list
	public List<WaitingVO> findAll();
	
	// update
	public int update(WaitingVO waiting);
	
	// delete
	public int delete(long id);

}
