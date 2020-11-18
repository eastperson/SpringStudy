package com.dealight.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import com.dealight.handler.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CallServiceImpl implements CallService {
	
	/*
	 * 카카오 메시지 API의 REST API 방식은 다음의 순서로 진행된다. 
	 * 
	 * 0. 카카오 개발자에 가입을 한 후 REST API KEY, redirect URI를 지정한다.
	 * 1. 인가 코드를 받아야 한다. GET 방식으로 REST API key와 redirect URI를 통해 code를 받아오자.
	 * 1-1. **시크릿 모드로 진행하자.
	 * 1-2. localhost:8080/oauth에 가서 a링크를 간다.
	 * 1-3. 그러면 받아온 url의 code를 복사하자
	 * 1-4. **인가코드는 서버가 동작할 때에만 유효하다. 서버를 종료하면 다시 발급받아야 한다.
	 * 2. 인가 코드를 통해 액세스 토큰을 발급받아야 한다.
	 * 2-1. code를 get 방식 (/token?code={})으로 넘기자
	 * 2-2. POST 타입의 경우 쿼리 스트링을 활용하는것이 편할수 있다.
	 * 2-3. https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id={REST키}&redirect_uri={리다이렉트 URI}&code={코드}
	 * 2-4. JSON타입으로 access_token을 반환받을 수 있다.
	 * 3. 엑세스 토큰을 활용해서 메시지를 넣는다.
	 * 3-1. 토큰도 get 방식으로 uri
	 * 3-2. https://kapi.kakao.com/v2/api/talk/memo/default/send?template_object={메시지 JSON}
	 * 3-3. 헤더에 Authorization : Bearer + access_token
	 * 3-4. 200 ok를 받으면 메시지 전달된 것
	 * 
	 * 
	 * 앞으로
	 * 
	 * > oauth를 자동으로 받아서 저장할 수 있는 방법을 찾아보자. -> 일단 URI를 확인하고 코드를 직접 입력해서 토큰 받는 방식
	 * > 액세스 토큰을 받아 저장하는 방법 -> POST로 json을 보내서 JSON으로 토큰을 받는다. 
	 * > 메시지를 발송하는 방법을 찾아보자. -> 토큰과 함께 메시지 보내는 형식을 만든다. JSON으로 보내는 방법을 찾아보자.
	 * > 메시지를 작성해서 발송해보자 -> TEST
	 * -- 나에게 메시지 보내기 완료
	 * > 프로필 가져오기 -> 프로필 구현
	 * > 친구 목록 가져오기 api -> 친구 목록 구현
	 * > 친구에게 메시지 보내기 -> 메시지보내기 구현
	 * > 완료!
	 * 
	 * ***참고로 HTTP method 오류가 나면 https로 접속했는지 확인하자. http로 접속해야한다.
	 * 
	 * 
	 * 
	 */
	
	
	@Override
	public String getAuth() {
		
		
		
		// 1. RestTemplat 생성
		RestTemplate restTemplate = new RestTemplate();	
		
		String url = "https://kauth.kakao.com/oauth/authorize?client_id=dba6ebc24e85989c7afde75bd48c5746&redirect_uri=https://localhost:8080/oauth&response_type=code";
		
		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
		
		// 시크릿 모드로 받아오자 ㅠ
		// 얻은 코드 O67g7f5UQRDFIrAfiMwe3mxQTgX1_905Safvjt2_WSbjfqL4v3hflGR9xLGMQSkAS4_W5wo9dVoAAAF11gJ1Kw
		
		// 이 한줄의 코드로 API로 호출하여 MAP타입으로 전달받는다.
		String strResult = restTemplate.getForObject(url, String.class);

       return strResult;

	}

	@Override
	public HashMap<String, Object> getToken(String code) {
		
		log.info("get token.................");
		
		log.info("code......................."+code);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		 String jsonInString = "";
		 String restKey = "dba6ebc24e85989c7afde75bd48c5746";
		 String redirectURI = "http://localhost:8080/oauth";
		 
		 try {
		
		// 1. RestTemplat 생성
		RestTemplate restTemplate = new RestTemplate();	
		
		// 1-1. error 핸들러를 만들어준다.
		RestTemplateResponseErrorHandler errorHandler = new RestTemplateResponseErrorHandler();
		
		restTemplate.setErrorHandler(errorHandler);
		
		
		// 2. 헤더를 만들어준다.
		HttpHeaders header = new HttpHeaders();
		
		// 2-1. content-type을 만들어준다.
		header.setContentType(MediaType.APPLICATION_JSON);
		
		// 3. request body parameter를 설정한다.
		
		// 3-1. json의 형태를 담을 map을 만들어준다.
		// *****************토큰을 받을 때는 쿼리 스트링으로 넣어보자.
//		Map<String, Object> map = new HashMap<>();
//
//		map.put("grant_type", "authorization_code");
//		map.put("client_id", "dba6ebc24e85989c7afde75bd48c5746");
//		map.put("redirect_uri", "http://localhost:8080");
//		map.put("code", "O67g7f5UQRDFIrAfiMwe3mxQTgX1_905Safvjt2_WSbjfqL4v3hflGR9xLGMQSkAS4_W5wo9dVoAAAF11gJ1Kw");
		
		// 4. map과 header를 추가해준다.
//       HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map,header);
	
		String url = "https://kauth.kakao.com/oauth/token";
		
		UriComponents uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("grant_type", "authorization_code")
				.queryParam("client_id", restKey)
				.queryParam("redirect_uri", redirectURI)
				.queryParam("code", code)
				.build();
				
		log.info(uri.toString());
		
		// 이 한줄의 코드로 API로 호출하여 MAP타입으로 전달받는다.
		ResponseEntity<Map> resultMap = restTemplate.postForEntity(uri.toString(), header, Map.class);
		
		
		
		log.info(resultMap);
		
		
		result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
       result.put("header", resultMap.getHeaders()); //헤더 정보 확인
       result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
		
       //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
       ObjectMapper mapper = new ObjectMapper();
       jsonInString = mapper.writeValueAsString(resultMap.getBody());
       
		} catch (Exception e) {
           result.put("statusCode", "999");
           result.put("body"  , "excpetion오류");
           System.out.println(e.toString());
       }

       return result;
	}
	
public String sendMessage(String access_token) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		 String jsonInString = "";
		 try {
		
		// 1. RestTemplat 생성
		RestTemplate restTemplate = new RestTemplate();	
		
		RestTemplateResponseErrorHandler errorHandler = new RestTemplateResponseErrorHandler();
		
		restTemplate.setErrorHandler(errorHandler);
		
		// 2. 헤더를 만들어준다.
		HttpHeaders header = new HttpHeaders();
		
		// 2-1. content-type을 만들어준다.
		header.setContentType(MediaType.APPLICATION_JSON);
		
		// 2-2. accept 헤더를 만들어준다.
	//	header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		// 2-3. Authorization 을 설정해준다.
		String authHeader = "Bearer " + access_token;
		
		header.set("Authorization", authHeader);
		
		// 3. request body parameter를 설정한다.
		
		// 3-1. json의 형태를 담을 map을 만들어준다.
		//String requestJson = "template_object={\"object_type\":\"feed\",\"content\":{\"title\":\"디저트 사진\",\"description\": \"아메리카노, 빵, 케익\",\"image_url\":\"http://mud-kage.kakao.co.kr/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg\",\"image_width\":640,\"image_height\": 640,\"link\":{\"web_url\": \"http://www.daum.net\",\"mobile_web_url\": \"http://m.daum.net\",\"android_execution_params\": \"contentId=100\",\"ios_execution_params\": \"contentId=100\"}},\"social\": {\"like_count\": 100,\"comment_count\": 200,\"shared_count\": 300,\"view_count\": 400,\"subscriber_count\": 500},\"buttons\": [{\"title\": \"웹으로 이동\",\"link\": {\"web_url\": \"http://www.daum.net\",\"mobile_web_url\": \"http://m.daum.net\"}},{\"title\": \"앱으로 이동\",\"link\": {\"android_execution_params\": \"contentId=100\",\"ios_execution_params\": \"contentId=100\"}}]}";
		
		
		Map<String, Object> map = new HashMap<>();

		map.put("object_type", "feed");
		
		Map<String, Object> content = new HashMap<>();
		
		content.put("title", "디저트 사진");
		content.put("description","아메리카노, 빵, 케익");
		content.put("image_url", "http://mud-kage.kakao.co.kr/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg");
		content.put("image_width", "640");
		content.put("image_height","640");
		
		Map<String, Object> link = new HashMap<>();
		
		link.put("web_url", "http://www.daum.net");
		link.put("mobile_web_url", "http://m.daum.net");
		link.put("android_execution_params", "contentId=100");
		link.put("ios_execution_params", "contentId=100");
		
		content.put("link", link);
		
		map.put("content", content);
		
		Map<String, Object> social = new HashMap<>();
		
		social.put("like_count", "100");
		social.put("comment_count", "200");
		social.put("shared_count", "300");
		social.put("view_count", "400");
		social.put("subscriber_count", "500");
		
		map.put("social", social);
		
		List<Map> buttons = new ArrayList();
		
		Map<String, Object> button1 = new HashMap<>();
		
		button1.put("title", "웹으로 이동");
		
		Map<String, Object> link2 = new HashMap<>();
		
		link2.put("web_url", "http://www.daum.net");
		link2.put("mobile_web_url", "http://m.daum.net");
		
		button1.put("link", link2);
		
		buttons.add(button1);
		
		Map<String, Object> button2 = new HashMap<>();
		
		button2.put("title", "앱으로 이동");
		
		Map<String, Object> link3 = new HashMap<>();
		
		link3.put("android_execution_params", "contentId=100");
		link3.put("ios_execution_params", "contentId=100");
		
		button2.put("link", link3);
		
		buttons.add(button2);
		
		map.put("buttons", buttons);
		
		Gson gson = new Gson();
		
		String requestJson =  gson.toJson(map);
		
		// 4. map과 header를 추가해준다.
        HttpEntity<String> entity = new HttpEntity<>(requestJson,header);
	
		String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
		
		
		UriComponents uri = UriComponentsBuilder.fromUriString(url)
				//.queryParam("template_object", requestJson)
				.queryParam("template_object", requestJson)
				.build();
		
		// 이 한줄의 코드로 API로 호출하여 MAP타입으로 전달받는다.
		ResponseEntity<Map> resultMap = restTemplate.postForEntity(uri.toUri(), header, Map.class);
		
		result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); //헤더 정보 확인
        result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
		
        //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(resultMap.getBody());
        
		} catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
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
	
	@Override
	public String getProfile() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
