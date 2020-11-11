package com.dealight.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dealight.domain.RsvdVO;
import com.dealight.domain.WaitingVO;

import lombok.experimental.PackagePrivate;

public interface WaitingMapper {
	
	// create
	public void insert(WaitingVO waiting);
	
	public void insertSelectKey(WaitingVO waiting);
	
	// read
	public WaitingVO findById(long id);
	
	// read
	// by store id
	public List<WaitingVO> findByStoreId(long storeId);
	
	// read
	// by store id and date
	public List<WaitingVO> findByStoreIdAndDate(@Param("storeId") long storeId, @Param("date") String date);
	
	// read
	// by store id and stus_cd
	public List<WaitingVO> findByStoreIdAndStusCd(@Param("storeId")long storeId,@Param("waitStusCd") String waitStusCd);

	
	// read by UserID and stus_cd
	public List<WaitingVO> findByUserId(@Param("userId") String userId, @Param("waitStusCd") String waitStusCd);
	
	// read list
	public List<WaitingVO> findAll();	

	
	// update
	public int update(WaitingVO waiting);
	
	// update
	// changeWaitStusCd
	public int changeWaitStusCd(@Param("id") long id, @Param("waitStusCd") String waitStusCd);
	
	// delete
	public int delete(long id);

}
