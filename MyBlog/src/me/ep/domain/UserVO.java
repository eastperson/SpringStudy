package me.ep.domain;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phoneNum;
	private Date dateOfBirth;
	private Date inDate;
	private Date updateDate;
	private int grade;
	
	public UserVO(){}

	// 각 인스턴스변수에 예외 상활을 정의한다.
	public UserVO(String id, String pw, String name, String email, String phoneNum, Date dateOfBirth) {
		if(id.length() > 10) 
			throw new IllegalArgumentException("ID는 10자 이하의 글자로만 저장이 되어야 합니다.");
		
		if(pw.length() < 4 || 19 < pw.length()) 
			throw new IllegalArgumentException("PW는 4글자 이상, 20자 미만의 글자로 저장이 되어야 합니다.");
		
		if(name.length() > 10)
			throw new IllegalArgumentException("이름은 10글자 이하의 글자로만 저장이 되어야 합니다.");
		
		if(email.lastIndexOf('@') == -1)
			throw new IllegalArgumentException("email은 '@'를 포함하고 있어야 합니다.");
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.inDate = new Date();
		this.updateDate = inDate;
		this.grade = GradeVO.BRONZE;
	}
	
	public UserVO(String id, String pw, String name, String email, String phoneNum, Date dateOfBirth, Date inDate, Date updateDate) {
		this(id, pw, name, email, phoneNum, dateOfBirth);
		this.inDate = inDate;
		this.updateDate = updateDate;
	}
}
