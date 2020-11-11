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
public class HtdlDtlsVO {
	
    // ÇÖµô¹øÈ£
	@NonNull
    private long htdlId;

    // ÇÖµô»ó¼¼ÀÏ·Ã¹øÈ£
	@NonNull
    private long htdlSeq;

    // ÇÖµô¸Þ´ºÀÌ¸§
	@NonNull
    private String menuName;

    // ¸Þ´º°¡°Ý
	@NonNull
    private int menuPrice;

}
