package com.dealight.domain;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreVO {
	
    // 매장번호 
	private long storeId;

    // 매장이름
    @NotNull
    private String storeNm;

    // 매장전화번호 
    private String telno;

    // 매장분류코드 
    private String clsCd;
    
    //     test
    // composition
    private NStoreVO nstore;
    
    public static class Builder{
    	
        // 필수입력값
        private long storeId;
        private String storeNm;
        private String telno;

        // 선택입력값 
        private String clsCd;
    
    public Builder(long storeId, String storeNm, String telno){
		
    	this.storeId = storeId;
    	this.storeNm = storeNm;
    	this.telno = telno;
		
	}

	public Builder setClsCd(String clsCd){

		this.clsCd = clsCd;

		return this;
	}

	public StoreVO build(){

		StoreVO store = new StoreVO();

		store.storeId = storeId;
		store.storeNm = storeNm;
		store.telno = telno;
		store.clsCd = clsCd;
		
		return store;

	}
    }
}
