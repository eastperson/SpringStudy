package com.dealight.domain;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import jdk.internal.org.jline.utils.Log;

public class AllStoreVOTests {

    private long storeId = 13;
    private String storeNm = "영동족발";
    private String telno = "010-2737-5157";
    private String clsCd = "I";
    // 매장번호 

    // 해시태그이름 
    private String tagNm = "분식";
    // 매장번호 
    private String park = "Y";
    private String nokids = "Y";
    private String pg = "N";
    private String wifi = "N";
    private String pet = "N";
    private String smoke = "N";
	private String addr = "주소";
	private int lt = 90;
	private int lo = 30;
	private long imgSeq = 1;
	private String imgUrl = "/a.jpg";
	private double avgRating = 4.5;
	private int revwTotNum = 5;
	private int likeTotNum = 25;
	// 필수 입력값
    private long id = 1;
    private String cnts = "너무 맛있어용~";
    private Date regDt = new Date(); 
    private double rating = 5.5;
    private String replyCnts = "또 시켜주세요~";
    private Date replyRegDt = new Date();
    
    // 선택 입력값
    private long rsvdId = 1;
    private long waitId = 1;
	// 필수 입력값
    private long menuSeq = 1;
    private int price = 5000;
    private String name = "돈까스"; 
    private String recoMenu;

    //선택 입력값
	private String userId = "kjuioq";
	
    private String seatStusCd;
    private String openTm = "09:30";
    private String closeTm = "21:30";
    
    private String buserId = "kjuioq";
    private String breakSttm = "15:00";
    private String breakEntm = "16:00";
    private String lastOrdTm = "21:00";
    private int n1SeatNo = 8;
    private int n2SeatNo = 10;
    private int n4SeatNo = 5;
    private String storeIntro = "안녕?";
    private int avgMealTm = 30;
    private String hldy = "일요일"; 
    private int acmPnum = 40;
    
    @Test
    public void test() {
    	
    }
    
	// 2. 모든 입력값 테스트
	@Test
	public void AllStoreDTOGenerateTest() {
		
		StoreVO store = new StoreVO.Builder(storeId, storeNm, telno)
				.setClsCd(clsCd)
				.build();
    	StoreTagVO stag = new StoreTagVO().builder()
    			.storeId(storeId)
    			.tagNm(tagNm)
    			.build();
		StoreOptionVO sopt = new StoreOptionVO.StoreOptionVOBuilder()
				.park(park)
				.nokids(nokids)
				.pg(pg)
				.wifi(wifi)
				.pet(pet)
				.smoke(smoke)
				.storeId(storeId)
				.build();
		StoreLocVO sloc = new StoreLocVO.StoreLocVOBuilder()
				.addr(addr)
				.lt(lt)
				.lo(lo)
				.storeId(storeId)
				.build();
		StoreImgVO simg = new StoreImgVO.StoreImgVOBuilder()
				.storeId(storeId)
				.imgSeq(imgSeq)
				.imgUrl(imgUrl)
				.build();
		StoreEvalVO seval = new StoreEvalVO.StoreEvalVOBuilder()
				.storeId(storeId)
				.avgRating(avgRating)
				.revwTotNum(revwTotNum)
				.likeTotNum(likeTotNum)
				.build();
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
		MenuVO menu = new MenuVO.MenuVOBuilder()
				.storeId(storeId)
				.menuSeq(menuSeq)
				.price(price)
				.name(name)
				.build();
		LikeVO like = new LikeVO.LikeVOBuilder()
				.storeId(storeId)
				.userId(userId)
				.build();
		BStoreVO bstore = new BStoreVO.BStoreVOBuilder()
				.storeId(storeId)
				.openTm(openTm)
				.closeTm(closeTm)
				.breakSttm(breakSttm)
				.breakEntm(breakEntm)
				.lastOrdTm(lastOrdTm)
				.n1SeatNo(n1SeatNo)
				.n2SeatNo(n2SeatNo)
				.n4SeatNo(n4SeatNo)
				.storeIntro(storeIntro)
				.avgMealTm(avgMealTm)
				.hldy(hldy)
				.acmPnum(acmPnum)
				.build();
		
		List<MenuVO> menuList = new ArrayList();
		menuList.add(menu);
	    
		List<StoreEvalVO> evalList = new ArrayList();
		evalList.add(seval);
	    
	    List<StoreImgVO> imgList = new ArrayList();
	    imgList.add(simg);
		
	    List<StoreTagVO> tagList = new ArrayList();
	    tagList.add(stag);
	    
	    List<RevwVO> revwList = new ArrayList();
	    revwList.add(review);
	    
	    AllStoreVO allStore = new AllStoreVO().builder()
	    		.imgList(imgList)
	    		.menuList(menuList)
	    		.revwList(revwList)
	    		.tagList(tagList)
				.storeNm(storeNm)
				.telno(telno)
				.clsCd(clsCd)
				.park(park)
				.nokids(nokids)
				.pg(pg)
				.wifi(wifi)
				.pet(pet)
				.smoke(smoke)
				.addr(addr)
				.lt(lt)
				.lo(lo)
				.storeId(storeId)
				.avgRating(avgRating)
				.revwTotNum(revwTotNum)
				.likeTotNum(likeTotNum)
				.storeId(storeId)
				.openTm(openTm)
				.closeTm(closeTm)
				.breakSttm(breakSttm)
				.breakEntm(breakEntm)
				.lastOrdTm(lastOrdTm)
				.n1SeatNo(n1SeatNo)
				.n2SeatNo(n2SeatNo)
				.n4SeatNo(n4SeatNo)
				.storeIntro(storeIntro)
				.avgMealTm(avgMealTm)
				.hldy(hldy)
				.acmPnum(acmPnum)
	    		.build();
	    	
	    
		
		/*
		AllStoreVO allStore = new AllStoreVO().builder()
				.storeNm(storeNm)
				.telno(telno)
				.clsCd(clsCd)
				.tagNm(tagNm)
				.park(park)
				.nokids(nokids)
				.pg(pg)
				.wifi(wifi)
				.pet(pet)
				.smoke(smoke)
				.addr(addr)
				.lt(lt)
				.lo(lo)
				.imgSeq(imgSeq)
				.imgUrl(imgUrl)
				.storeId(storeId)
				.avgRating(avgRating)
				.revwTotNum(revwTotNum)
				.likeTotNum(likeTotNum)
				.id(id)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts(replyCnts)
				.replyRegDt(replyRegDt)
				.rsvdId(rsvdId)
				.waitId(waitId)
				.menuSeq(menuSeq)
				.price(price)
				.name(name)
				.userId(userId)
				.storeId(storeId)
				.openTm(openTm)
				.closeTm(closeTm)
				.breakSttm(breakSttm)
				.breakEntm(breakEntm)
				.lastOrdTm(lastOrdTm)
				.n1SeatNo(n1SeatNo)
				.n2SeatNo(n2SeatNo)
				.n4SeatNo(n4SeatNo)
				.storeIntro(storeIntro)
				.avgMealTm(avgMealTm)
				.hldy(hldy)
				.acmPnum(acmPnum)
				.build();
		*/
		System.out.println(allStore);
		
	}
	
}
