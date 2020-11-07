package com.dealight.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dealight.domain.BUserVO;
import com.dealight.domain.HotDealVO;

public interface HotDealMapper {
	
	// create
	public void insert(HotDealVO htdl);
	
	public void insertSelectKey(HotDealVO htdl);
	
	// read
	public HotDealVO findById(long htdlId);
	
	// read
	// by store id
	public List<HotDealVO> findByStoreId(long storeId);
	
	// read
	// by store id
	public List<HotDealVO> findByStoreIdStusCd(@Param("storeId")long storeId,@Param("stusCd") String stusCd);
	
	// read list
	public List<HotDealVO> findAll();
	
	// update
	public int update(HotDealVO htdl);
	
	// delete
	public int delete(long htdlId);

}
