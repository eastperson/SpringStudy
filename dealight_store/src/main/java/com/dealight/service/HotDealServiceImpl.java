package com.dealight.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealResultVO;
import com.dealight.domain.HotDealVO;
import com.dealight.mapper.HotDealDetailMapper;
import com.dealight.mapper.HotDealMapper;
import com.dealight.mapper.HotDealResultMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class HotDealServiceImpl implements HotDealService {

	@Autowired
	private HotDealMapper htdlMapper;
	
	@Autowired
	private HotDealDetailMapper htdlDtlsMapper;
	
	@Autowired
	private HotDealResultMapper htdlRsltMapper;
	
	@Override
	public HotDealVO read(long htdlId) {

		return htdlMapper.findById(htdlId);
	}

	@Override
	public List<HotDealDetailVO> readDtls(long htdlId) {

		return htdlDtlsMapper.findByHtdlId(htdlId);
	}

	@Override
	public HotDealResultVO readRslt(long htdlId) {

		return htdlRsltMapper.findById(htdlId);
	}

	@Override
	public int calHtdlEndTm(HotDealVO htdl) {
		
		Date today = new Date();

		String pattern = "HH:mm";
    	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	String date = simpleDateFormat.format(today);
    	
    	//log.info("test.....................................date : " + date);
    	
    	String[] times1 = htdl.getEndTm().split(":");
    	int endTm = Integer.valueOf(times1[0])*60 + Integer.valueOf(times1[1]);
		
    	//log.info("test.....................................endTm : " + endTm);
    	
    	String[] times2 = date.split(":");
    	int curTm = Integer.valueOf(times2[0])*60 + Integer.valueOf(times2[1]);
    	
    	//log.info("test.....................................curTm : " + curTm);
    	
    	
		return endTm - curTm;
	}

	@Override
	public List<HotDealVO> readAllStoreHtdlList(long storeId) {
		
		return htdlMapper.findByStoreId(storeId);
	}

	@Override
	public List<HotDealVO> readActStoreHtdlList(long storeId) {
		
		return htdlMapper.findByStoreIdStusCd(storeId, "A");
	}

}
