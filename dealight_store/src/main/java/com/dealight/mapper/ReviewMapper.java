package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.ReviewVO;

public interface ReviewMapper {
	
	// create
	
	public void insert(ReviewVO revw);

	
	public void insertSelectKey(ReviewVO revw);
	
	
	// read
	public ReviewVO findById(long id);
	
	// read list
	public List<ReviewVO> findAll();
	
	// update
	public int update(ReviewVO revw);
	
	// delete
	public int delete(long id);

}
