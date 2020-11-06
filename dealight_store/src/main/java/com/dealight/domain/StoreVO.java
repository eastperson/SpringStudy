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
	
    // �����ȣ 
    protected long storeId;

    // �����̸�
    @NotNull
    protected String storeNm;

    // ������ȭ��ȣ 
    protected String telno;

    // ����з��ڵ� 
    protected String clsCd;
    
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
