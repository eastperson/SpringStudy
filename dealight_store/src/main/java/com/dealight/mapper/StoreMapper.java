package com.dealight.mapper;

import java.util.List;

import com.dealight.domain.StoreVO;
import com.dealight.domain.UserVO;

public interface StoreMapper {
	
	//Create
	public void insert(StoreVO store);
	
	public void insertSelectKey(StoreVO store);
	
	//@Select("SELECT store_id storeId, store_nm storeNm, telno, cls_cd clsCd  FROM tbl_store WHERE store_id = #{storeId}")
	public StoreVO findById(long storeId);
	
	// test
	// join
	public StoreVO findByIdJoinNStore(long storeId);
	
	// test
	// join
	public StoreVO findByIdJoinBStore(long storeId);
	
	// read
	// by user id
	public List<StoreVO> findByUserId(String userId);
	
	// read
	// by user id join bstore
	public List<StoreVO> findByUserIdJoinBStore(String userId);
	
	public List<StoreVO> findAll();
	
	//Update
	public int update(StoreVO store);
	
	//Delete
	public int delete(long storeId);

}
