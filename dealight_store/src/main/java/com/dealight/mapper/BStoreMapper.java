package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.BStoreVO;

public interface BStoreMapper {
	
	// create
	public void insert(BStoreVO bstore);
	
	// read
	public BStoreVO findByStoreId(long storeId);
	
	// read list
	public List<BStoreVO> findAll();
	
	// update
	public int update(BStoreVO bstore);
	
	// delete
	public int delete(long storeId);

}
