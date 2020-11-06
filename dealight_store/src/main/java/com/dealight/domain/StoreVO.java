package com.dealight.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreVO {
	
    // 매장번호 
    protected long storeId;

    // 매장이름
    @NotNull
    protected String storeNm;

    // 매장전화번호 
    protected String telno;

    // 매장분류코드 
    protected String clsCd;
    
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
