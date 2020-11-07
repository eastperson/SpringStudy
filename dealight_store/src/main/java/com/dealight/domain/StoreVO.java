package com.dealight.domain;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreVO {
	
    // �����ȣ 
	private long storeId;

    // �����̸�
    @NotNull
    private String storeNm;

    // ������ȭ��ȣ 
    private String telno;

    // ����з��ڵ� 
    private String clsCd;
    
    //     test
    // composition
    private NStoreVO nstore;
    
    public static class Builder{
    	
        // �ʼ��Է°�
        private long storeId;
        private String storeNm;
        private String telno;

        // �����Է°� 
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
