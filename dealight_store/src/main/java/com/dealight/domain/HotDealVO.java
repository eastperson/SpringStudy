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
public class HotDealVO {
	
	// composition
	private HotDealDetailVO htdlDtls;
	
	// ÇÖµô¹øÈ£ 
	@NonNull
    private long hotdealId;

    // ÇÖµôÀÌ¸§
	@NonNull
    private String name;

    // ¸ÅÀå¹øÈ£
	@NonNull
    private long storeId;

    // ÇÒÀÎÀ² 
	@NonNull
    private double dcRate;

    // ÇÖµô½ÃÀÛ½Ã°£
	@NonNull
    private String startTm;

    // ÇÖµô¸¶°¨½Ã°£
	@NonNull
    private String endTm;

    // ÇÖµô¸¶°¨ÀÎ¿ø
	@NonNull
    private int lmtPnum;

    // ÇÖµô¼Ò°³ 
    private String intro;

    // ÇÖµôÀû¿ëÀü°¡°İ
    @NonNull
    private int befPrice;

    // ÇÒÀÎÂ÷°¨±İ¾×
    @NonNull
    private int ddct;

    // ÇÖµôÇöÀç¿¹¾àÀÎ¿ø
    @NonNull
    private int curPnum;

    // ÇÖµô»óÅÂÄÚµå
    @NonNull
    @Builder.Default
    private String stusCd = "A";

}
