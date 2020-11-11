package com.dealight.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class RevwVOTests {
	
	// 필수 입력값
    private long id = 1;
    private long storeId = 1;
    private String userId = "kjuioq";
    private String cnts = "너무 맛있어용~";
    private Date regDt = new Date(); 
    private double rating = 5.5;
    private String replyCnts = "또 시켜주세요~";
    private Date replyRegDt = new Date();
    
    // 선택 입력값
    private long rsvdId = 1;
    private long waitId = 1;

	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	@Test
	public void reviewGenerateTest1() {
		
		RevwVO review = new RevwVO.RevwVOBuilder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts(replyCnts)
				.replyRegDt(replyRegDt)
				.build();
		
		assertTrue(review.getId() == id);
		assertTrue(review.getStoreId() == storeId);
		assertTrue(review.getUserId().equals(userId));
		assertTrue(review.getCnts().equals(cnts));
		assertTrue(review.getRegDt().equals(regDt));
		assertTrue(review.getRating() == rating);
		assertTrue(review.getReplyCnts().equals(replyCnts));
		assertTrue(review.getRegDt().equals(replyRegDt));
		
		assertTrue(review.getRsvdId() == 0);
		assertTrue(review.getWaitSeq() == 0);
		
	}
	
	// 모든 입력값
	@Test
	public void reviewGenerateTest2() {
		
		RevwVO review = new RevwVO.RevwVOBuilder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts(replyCnts)
				.replyRegDt(replyRegDt)
				.rsvdId(rsvdId)
				.waitSeq(waitId)
				.build();
		
		assertTrue(review.getId() == id);
		assertTrue(review.getStoreId() == storeId);
		assertTrue(review.getUserId().equals(userId));
		assertTrue(review.getCnts().equals(cnts));
		assertTrue(review.getRegDt().equals(regDt));
		assertTrue(review.getRating() == rating);
		assertTrue(review.getReplyCnts().equals(replyCnts));
		assertTrue(review.getRegDt().equals(replyRegDt));
		assertTrue(review.getRsvdId() == rsvdId);
		assertTrue(review.getWaitSeq() == waitId);
		
	}

}
