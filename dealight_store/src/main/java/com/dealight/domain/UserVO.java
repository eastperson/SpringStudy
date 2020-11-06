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

	// ȸ�����̵� 
	private String userId;

	// ȸ���̸� 
	private String name;

	// ȸ����й�ȣ 
	private String pwd;

	// ȸ���̸��� 
	private String email;

	// ȸ����ȭ��ȣ 
	private String telno;

	// ������� 
	private String brdt;

	// ���� 
	private String sex;

	// ȸ�������ʻ��� 
	private String photoSrc;

	// �Ҽȷα��ο��� 
	private String snsLginYn = "N";

	// ȸ�������ڵ� 
	private String clsCd = "C";

	// �г�Ƽȸ������ 
	private String pmStus = "N";

	// �г�ƼȽ�� 
	private int pmCnt = 0;

	// �г�Ƽ�������� 
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

		// �ʼ� �Է°�
		public Builder(String userId, String name,String pwd, String email, String telno, String sex){
			
			// id�� 20�� �̳����� �Ѵ�.
			if(userId.length() > 20)
				throw new IllegalArgumentException("id�� ���ڼ��� 20�ڸ� �ʰ��߽��ϴ�.");
			
			if(name.length() > 5)
				throw new IllegalArgumentException("�̸��� ���ڼ��� 5�ڸ� �ʰ��߽��ϴ�.");
			
			if(pwd.length() > 20)
				throw new IllegalArgumentException("��й�ȣ�� ���ڼ��� 20�ڸ� �ʰ��߽��ϴ�.");
			
			if(email.length() > 30)
				throw new IllegalArgumentException("email�� ���ڼ��� 30�ڸ� �ʰ��߽��ϴ�.");
			
			if(telno.length() > 13)
				throw new IllegalArgumentException("��ȭ��ȣ�� ���ڼ��� 13�ڸ� �ʰ��߽��ϴ�.");
			
			if(!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F"))
				throw new IllegalArgumentException("���� �Է��ڵ尡 �߸��Ǿ����ϴ�.");
			
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
