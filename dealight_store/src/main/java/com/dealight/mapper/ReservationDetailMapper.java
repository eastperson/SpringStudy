package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.ReservationDetailVO;

public interface ReservationDetailMapper {
	
	// create
	public void insert(ReservationDetailVO rsvdDt);
	
	// insert
	public void insertSelectKey(ReservationDetailVO rsvdDt);
	
	// insert n
	public int insertRsvdDtls(List<ReservationDetailVO> rsvdDtls);
	
	// read
	public ReservationDetailVO findBySeq(long rsvdDtSeq);
	
	// read by rsvd id
	public List<ReservationDetailVO> findByRsvdId(long rsvdId);
	
	// read list
	public List<ReservationDetailVO> findAll();
	
	// update
	public int update(ReservationDetailVO rsvdDt);
	
	// delete
	public int delete(long rsvdDtSeq);
	

}
