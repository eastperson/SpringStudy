package org.ep.service;

import org.ep.domain.Criteria;
import org.ep.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private ReplyService service;
	
	@Test
	public void registerTest() {
		
		ReplyVO reply = new ReplyVO();
		reply.setReply("안녕?");
		reply.setReplyer("동인");
		
		service.register(reply);
		
		log.info("생성된 댓글의 번호: " + reply.getRno());
		
	}
	

	
}
