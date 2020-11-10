package com.dealight.domain;



import java.util.List;

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
    //@NotNull
    private String storeNm;

    // 매장전화번호 
    private String telno;

    // 매장분류코드 
    private String clsCd;
    
    // composition
    private NStoreVO nstore;
    
    // composition
    private BStoreVO bstore;
    

    
    public static class Builder{
    	
        // 필수입력값
        private long storeId;
        private String storeNm;
        private String telno;
        private BStoreVO bstore;
        private NStoreVO nstore;

        // 선택입력값 
        private String clsCd;
    
    public Builder(long storeId, String storeNm, String telno){
		
    	this.storeId = storeId;
    	this.storeNm = storeNm;
    	this.telno = telno;
		
	}

	public Builder setBStore(BStoreVO bstore){

		this.bstore = bstore;

		return this;
	}
	
	public Builder setNStore(NStoreVO nstore){

		this.nstore = nstore;

		return this;
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
		store.bstore = bstore;
		store.nstore = nstore;
		
		return store;

	}
    }
}
