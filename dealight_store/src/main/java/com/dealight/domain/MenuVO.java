package com.dealight.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuVO {
	
    // 매장번호 
	@NonNull
    private long storeId;

    // 메뉴일련번호
	@NonNull
    private long menuSeq;

    // 메뉴가격
	@NonNull
    private int price;

    // 메뉴사진주소 
    private String imgUrl;

    // 메뉴이름
    @NonNull
    private String name;

    // 추천여부 
    @Builder.Default
    @NonNull
    private String recoMenu = "N";

}
