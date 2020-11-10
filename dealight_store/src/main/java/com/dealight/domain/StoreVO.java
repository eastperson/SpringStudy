package com.dealight.domain;



import java.util.List;

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
    //@NotNull
    private String storeNm;

    // ������ȭ��ȣ 
    private String telno;

    // ����з��ڵ� 
    private String clsCd;
    
    // composition
    private NStoreVO nstore;
    
    // composition
    private BStoreVO bstore;
    

    
    public static class Builder{
    	
        // �ʼ��Է°�
        private long storeId;
        private String storeNm;
        private String telno;
        private BStoreVO bstore;
        private NStoreVO nstore;

        // �����Է°� 
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
