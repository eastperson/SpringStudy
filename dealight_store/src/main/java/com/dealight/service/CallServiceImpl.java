package com.dealight.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.dealight.domain.WaitingVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CallServiceImpl implements CallService {

	@Override
	public String getProfile() {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		 String jsonInString = "";
		 
		 try {
		
		// 1. RestTemplat ����
		RestTemplate restTemplate = new RestTemplate();	
		
		// 2. ����� ������ش�.
		HttpHeaders header = new HttpHeaders();
		
		// 2-1. content-type�� ������ش�.
		header.setContentType(MediaType.APPLICATION_JSON);
		
		// 2-2. accept ����� ������ش�.
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		// 2-3. Authorization �� �������ش�.
		
		String token = "S2aGvVwOVH-_Az3TwIFcs5w0hVDqXqO4PCs1VAorDNIAAAF11Oit3A";
		
		String authHeader = "Bearer " + token;
		
		header.set("Authorization", authHeader);
		
		// 3. request body parameter�� �����Ѵ�.
		
		// 3-1. json�� ���¸� ���� map�� ������ش�.
		Map<String, Object> map = new HashMap<>();

		map.put("object_type", "feed");
		
		Map<String, Object> content = new HashMap<>();
		
		content.put("title", "����Ʈ ����");
		content.put("description","�Ƹ޸�ī��, ��, ����");
		content.put("image_url", "http://mud-kage.kakao.co.kr/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg");
		content.put("image_width", 640);
		content.put("image_height",640);
		
		Map<String, Object> link = new HashMap<>();
		
		link.put("web_url", "http://www.daum.net");
		link.put("mobile_web_url", "http://m.daum.net");
		link.put("android_execution_params", "contentId=100");
		link.put("ios_execution_params", "contentId=100");
		
		content.put("link", link);
		
		map.put("content", content);
		
		Map<String, Object> social = new HashMap<>();
		
		social.put("like_count", 100);
		social.put("comment_count", 200);
		social.put("shared_count", 300);
		social.put("view_count", 400);
		social.put("subscriber_count", 500);
		
		map.put("social", social);
		
		List<Map> buttons = new ArrayList();
		
		Map<String, Object> button1 = new HashMap<>();
		
		button1.put("title", "������ �̵�");
		
		Map<String, Object> link2 = new HashMap<>();
		
		link2.put("web_url", "http://www.daum.net");
		link2.put("mobile_web_url", "http://m.daum.net");
		
		button1.put("link", link2);
		
		buttons.add(button1);
		
		Map<String, Object> button2 = new HashMap<>();
		
		button2.put("title", "������ �̵�");
		
		Map<String, Object> link3 = new HashMap<>();
		
		link3.put("android_execution_params", "contentId=100");
		link3.put("ios_execution_params", "contentId=100");
		
		map.put("buttons", buttons);
		
		// 4. map�� header�� �߰����ش�.
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map,header);
	
		String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
		
		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
		
		// �� ������ �ڵ�� API�� ȣ���Ͽ� MAPŸ������ ���޹޴´�.
		ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.POST, entity, Map.class);
		
		result.put("statusCode", resultMap.getStatusCodeValue()); //http status code�� Ȯ��
        result.put("header", resultMap.getHeaders()); //��� ���� Ȯ��
        result.put("body", resultMap.getBody()); //���� ������ ���� Ȯ��
		
        //�����͸� ����� ���� �޾Ҵ��� Ȯ�� string���·� �Ľ�����
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(resultMap.getBody());
        
		} catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion����");
            System.out.println(e.toString());
        }
 
        return jsonInString;
	}

	@Override
	public int callAllList(List<WaitingVO> curStoreWaitList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean call(long waitingId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
