package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.ReservationDetailVO;

public interface ReservationDetailMapper {
	
	// create
	public void insert(ReservationDetailVO rsvdDt);
	
	public void insertSelectKey(ReservationDetailVO rsvdDt);
	
	// read
	public ReservationDetailVO findBySeq(long rsvdDtSeq);
	
	// read list
	public List<ReservationDetailVO> findAll();
	
	// update
	public int update(ReservationDetailVO rsvdDt);
	
	// delete
	public int delete(long rsvdDtSeq);

}
