package com.dealight.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllStoreDTO {
	
	// comopisition
	private StoreVO store;
    
    // composition
    private BStoreVO bstore;
	
    // composition
    private List<MenuVO> menuList;
    
    // composition
    private List<StoreEvalVO> evalList;
    
    // composition
    private List<StoreImgVO> imgList;
    
    // composition
    private StoreLocVO loc;
    
    // composition
    private List<StoreTagVO> tagList;
    
    // compoisition
    private StoreOptionVO option;
    
    // compoisition
    private ReviewVO revw;

}
