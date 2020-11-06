package com.dealight.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dealight.domain.WaitingVO;

public interface WaitingMapper {
	
	// create
	public void insert(WaitingVO waiting);
	
	public void insertSelectKey(WaitingVO waiting);
	
	// read
	public WaitingVO findById(long id);
	
	// read by UserID and stus_cd
	public WaitingVO findByUserId(@Param("userId") String userId, @Param("waitStusCd") String waitStusCd);
	
	// read list
	public List<WaitingVO> findAll();

	
	// update
	public int update(WaitingVO waiting);
	
	// delete
	public int delete(long id);

}
