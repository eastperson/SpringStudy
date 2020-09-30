package org.ep.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Resautrant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
