window.onload = function () {
const user_pw = document.querySelector("#user_pw"),
user_pw_check = document.querySelector("#user_pw_check"),
user_id = document.querySelector("#user_id"),
user_name = document.querySelector("#name"),
user_email = document.querySelector("#email"),
user_phoneNum = document.querySelector("#phoneNum"),
user_dateOfBirth = document.querySelector("#dateOfBirth"),
btn_submit = document.querySelector("#form_submit"),
form = document.querySelector("#register_action"),
id_msg = document.querySelector("#id_msg"),
pw_msg = document.querySelector("#pw_msg"),
name_msg = document.querySelector("#name_msg"),
inputList = document.querySelectorAll("input");

idLenCheck = function () {
	if(1 <= user_id.value.length && user_id.value.length <= 10)
		return true;
	return false;
}

pwLenCheck = function () {
	if(4 <= user_pw.value.length && user_pw.value.length < 20)
		return true;
	return false;
}

nameLenCheck = function () {
	if(1 <= user_name.value.length && user_name.value.length <= 10)
		return true;
	return false;
}

pwCheck = function () {
    if(user_pw.value === user_pw_check.value)
        return true;
    return false;
}

user_id.addEventListener("focusout", () => {
	if(1 <= user_id.value.length){
	    if(idLenCheck()){
	        id_msg.innerText = "🙆‍♂️ 아이디 형식이 적당합니다.";
	    }
	    else {
	    	id_msg.innerText = "🙅‍♂️아이디 길이를 다시 확인해 주세요.";
	    }
	}
})

user_pw.addEventListener("focusout", () => {
	if(1 <= user_pw.value.length){
	    if(pwLenCheck()){
	        pw_msg.innerText = "🙆‍♂️ 비밀번호 형식이 적당합니다.";
	    }
	    else {
	    	pw_msg.innerText = "🙅‍♂️비밀번호 길이를 다시 확인해 주세요.";
	    }
	}
})

user_name.addEventListener("focusout", () => {
	if(1 <= user_name.value.length){
	    if(nameLenCheck()){
	        name_msg.innerText = "🙆‍♂️ 이름 형식이 적당합니다.";
	    }
	    else {
	    	name_msg.innerText = "🙅‍♂️ 이름 길이를 다시 확인해 주세요.";
	    }
	}
})


user_pw_check.addEventListener("focusout", () => {
	if(1 <= user_pw.value.length){
	    if(pwCheck()){
	        pwCheck_msg.innerText = "🙆‍♂️ 비밀번호 체크 완료";
	    }
	    else {
	    	pwCheck_msg.innerText = "🙅‍♂️비밀번호를 다시 한 번 확인해주세요.";
	    }
	}
})

        nullCheck = function(inputList) {
            for(let i = 0; i < inputList.length; i++)
                if(inputList[i].value == "")
                    return false;
            
            return true;
        };

emailCheck = function () {
    let email = document.querySelector("#email"),
        preDot = email.value[email.value.trim().lastIndexOf(".") - 1],
        postDot = email.value[email.value.trim().lastIndexOf(".") + 1];

    if(email.value.lastIndexOf("@") === -1)
        return false;
    if(email.value.lastIndexOf(".") === -1)
        return false;
    if(preDot === "@" )
        return false;
    if( preDot ===" ")
        return false;
    if( postDot === " ")
        return false;
    if(preDot === undefined )
        return false;
    if(postDot === undefined)
        return false;

    return true;
};


user_email.addEventListener("focusout", () => {
	if(1 <= user_email.value.length){
	    if(emailCheck()){
	        email_msg.innerText = "🙆‍♂️ 이메일 체크 완료";
	    }
	    else {
	    	email_msg.innerText = "🙅‍♂️이메일 형식을 다시 한 번 확인해주세요.";
	    }
	}
});

nullCheck = function(inputList) {
    for(let i = 0; i < inputList.length; i++)
        if(inputList[i].value == "")
            return false;
    
    return true;
}
        
btn_submit.addEventListener("click", (e) => {

    e.preventDefault();

    if(!nullCheck(inputList)){
        alert("필드가 비었어요")
        return;
    }
    
    if(!idLenCheck()){
    	alert("🙅id를 형식에 맞게  입력해주세요");
        return;
    }
    
    if(!pwLenCheck()){
    	alert("🙅pw를 형식에 맞게 입력해주세요");
        return;
    }
    
    if(!pwCheck()){
        alert("🙅‍♂️비밀번호가 틀려요");
        return;
    }
    
    if(!nameLenCheck()){
    	alert("🙅이름을 형식에 맞게 입력해주세요");
        return;
    }
    
    if(!emailCheck()){
        alert("🙅email 형식이 올바르지 않아요.");
        return;
    }
    console.log("submit 성공");
    form.submit();
});
}