package com.dealight.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

	// 회원아이디 
	private String userId;

	// 회원이름 
	private String name;

	// 회원비밀번호 
	private String pwd;

	// 회원이메일 
	private String email;

	// 회원전화번호 
	private String telno;

	// 생년월일 
	private String brdt;

	// 성별 
	private String sex;

	// 회원프로필사진 
	private String photoSrc;

	// 소셜로그인여부 
	private String snsLginYn = "N";

	// 회원구분코드 
	private String clsCd = "C";

	// 패널티회원여부 
	private String pmStus = "N";

	// 패널티횟수 
	private int pmCnt = 0;

	// 패널티만료일자 
	private Date pmExpi;







	public static class Builder{

		private String userId;
		private String name;
		private String pwd;
		private String email;
		private String telno;
		private String brdt;
		private String sex;
		private String photoSrc; 
		private String snsLginYn = "N"; 
		private String clsCd = "C";
		private String pmStus = "N";
		private int pmCnt = 0;
		private Date pmExpi;

		// 필수 입력값
		public Builder(String userId, String name,String pwd, String email, String telno, String sex){
			
			// id는 20자 이내여야 한다.
			if(userId.length() > 20)
				throw new IllegalArgumentException("id의 글자수가 20자를 초과했습니다.");
			
			if(name.length() > 5)
				throw new IllegalArgumentException("이름의 글자수가 5자를 초과했습니다.");
			
			if(pwd.length() > 20)
				throw new IllegalArgumentException("비밀번호의 글자수가 20자를 초과했습니다.");
			
			if(email.length() > 30)
				throw new IllegalArgumentException("email의 글자수가 30자를 초과했습니다.");
			
			if(telno.length() > 13)
				throw new IllegalArgumentException("전화번호의 글자수가 13자를 초과했습니다.");
			
			if(!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F"))
				throw new IllegalArgumentException("성별 입력코드가 잘못되었습니다.");
			
			this.userId = userId;
			this.name = name;
			this.pwd = pwd;
			this.email = email;
			this.telno = telno;
			this.sex = sex;
			this.snsLginYn = "N";
			this.clsCd = "C";
			this.pmStus = "N";
			this.pmCnt = 0;
		}

		public Builder setBrbt(String brbt){

			this.brdt = brbt;

			return this;
		}

		public Builder setPhotoSrc(String photoSrc){

			this.photoSrc = photoSrc;

			return this;

		}
		
		public Builder setPmExpi(Date pmExpi){

			this.pmExpi = pmExpi;

			return this;

		}

		public UserVO build(){

			UserVO user = new UserVO();

			user.userId = userId;
			user.name = name;
			user.pwd = pwd;
			user.email = email;
			user.telno = telno;
			user.brdt = brdt;
			user.sex = sex;
			user.photoSrc = photoSrc;
			user.snsLginYn = snsLginYn;
			user.clsCd = clsCd;
			user.pmStus = pmStus;
			user.pmCnt = pmCnt;
			user.pmExpi = pmExpi;
			
			return user;

		}
	}
}
