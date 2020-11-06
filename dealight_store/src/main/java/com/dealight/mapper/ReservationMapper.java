package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.ReservationVO;

public interface ReservationMapper {

	// create
	public void insert(ReservationVO rsvd);
	
	
	public void insertSelectKey(ReservationVO rsvd);
	
	
	// read
	public ReservationVO findById(long id);
	
	// read list
	public List<ReservationVO> findAll();
	
	// update
	public int update(ReservationVO rsvd);
	
	// delete
	public int delete(long id);
	
}
