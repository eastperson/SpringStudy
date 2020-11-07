package com.dealight.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface ReservationMapper {

	// create
	public void insert(ReservationVO rsvd);
	
	public void insertSelectKey(ReservationVO rsvd);
	
	// read
	public ReservationVO findById(long id);
	
	// read by user id
	public List<ReservationVO> findByUserId(String userId);
	
	// read by store id
	public List<ReservationVO> findByStoreId(@Param("storeId") long storeId);
	
	// read by store id and UserVO user
	public List<ReservationVO> findByStoreIdAndUserId(@Param("storeId") long storeId, @Param("userId")String userId);
	
	// read by store id and cur suts "W"
	public List<ReservationVO> findByStoreIdAndCurStus(@Param("storeId") long storeId, @Param("stusCd") String stusCd);
	
	// read by store id and today
	public List<ReservationVO> findByStoreIdToday(@Param("storeId") long storeId, @Param("today") String today);
	
	// read by store id and date
	public List<ReservationVO> findByStoreIdAndDate(@Param("storeId") long storeId, @Param("date") String date);
	
	// read by store and date and menu count ORDER BY count
	public HashMap<String, Integer> findMenuCntByStoreIdAndDate(@Param("storeId") long storeId, @Param("date") String date);
	
	// read by store and date and menu count ORDER BY count
	public List<UserVO> findUserByStoreIdAndDateAndStus(@Param("storeId") long storeId, @Param("date") String date);
	
	// read list
	public List<ReservationVO> findAll();
	
	// update
	public int update(ReservationVO rsvd);
	
	// delete
	public int delete(long id);
	
}
