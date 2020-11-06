package com.dealight.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.mapper.UserMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StoreVOTests {
	
    private long storeId = 1;
    private String storeNm = "영동족발";
    private String telno = "010-2737-5157";
    private String clsCd = "I";
    
    private Validator validator;
	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	// not null 값만 입력
	// 필수값 : store_id,store_nm,telno
	// 선택값 : cls_cd
    
    @Before
    public void setUp() {
    	//ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //validator = factory.getValidator();
    }
	@Test
	public void storeGenerateTest1() {
		StoreVO store = new StoreVO.Builder(storeId, storeNm, telno)
				.build();
		
		assertTrue(store.getStoreId() == storeId);
		assertTrue(store.getStoreNm().equals(storeNm));
		assertTrue(store.getTelno().equals(telno));
		assertNull(store.getClsCd());
		assertNotNull(store);
		
		//Set<ConstraintViolation<StoreVO>> set = validator.validate(store);
		
//		assertThat(set.size(), is(1232))
		//set.forEach(msg -> Log.info(msg.getMessage()));
	}
	
	// 2. 모든 입력값 테스트
	@Test
	public void storeGenerateTest2() {
		StoreVO store = new StoreVO.Builder(storeId, storeNm, telno)
				.setClsCd(clsCd)
				.build();
		
		assertTrue(store.getStoreId() == storeId);
		assertTrue(store.getStoreNm().equals(storeNm));
		assertTrue(store.getTelno().equals(telno));
		assertTrue(store.getClsCd().equals(clsCd));
		assertNotNull(store);
		
	}

}
