package com.dealight.mapper;

import com.dealight.domain.AllStoreDTO;

public interface AllStoreMapper {
	
	// read
	AllStoreDTO findAllStoreByStoreId(long storeId);

}
