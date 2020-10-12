window.onload = function () {
	const info_pw = document.querySelector("#info_pw"),
	info_pw_check = document.querySelector("#info_pw_check"),
	info_name = document.querySelector("#info_name"),
	info_email = document.querySelector("#info_email"),
	info_phoneNum = document.querySelector("#info_phoneNum"),
	info_dateOfBirth = document.querySelector("#info_dateOfBirth"),
	btn_submit = document.querySelector("#form_submit"),
	form = document.querySelector(".form"),
	pw_msg = document.querySelector("#pw_msg"),
	pwCheck_msg = document.querySelector("#pwCheck_msg"),
	name_msg = document.querySelector("#name_msg"),
	inputList = document.querySelectorAll("input");

	idLenCheck = function () {
		if(1 <= info_id.value.length && info_id.value.length <= 10)
			return true;
		return false;
	}

	pwLenCheck = function () {
		if(4 <= info_pw.value.length && info_pw.value.length < 20)
			return true;
		return false;
	}

	nameLenCheck = function () {
		if(1 <= info_name.value.length && info_name.value.length <= 10)
			return true;
		return false;
	}

	pwCheck = function () {
	    if(info_pw.value === info_pw_check.value)
	        return true;
	    return false;
	}

	info_id.addEventListener("focusout", () => {
		if(1 <= info_id.value.length){
		    if(!idLenCheck()){
		    	id_msg.innerText = "🙅‍♂️아이디 길이를 다시 확인해 주세요.";
		    }
		}
	})

	info_pw.addEventListener("focusout", () => {
		if(1 <= info_pw.value.length){
		    if(!pwLenCheck()){
		    	pw_msg.innerText = "🙅‍♂️비밀번호 길이를 다시 확인해 주세요.";
		    }
		}
	})

	info_name.addEventListener("focusout", () => {
		if(1 <= info_name.value.length){
		    if(!nameLenCheck()){
		    	name_msg.innerText = "🙅‍♂️ 이름 길이를 다시 확인해 주세요.";
		    }
		}
	})


	info_pw_check.addEventListener("focusout", () => {
		if(1 <= info_pw.value.length){
		    if(!pwCheck()){
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
	    let email = document.querySelector("#info_email"),
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


	info_email.addEventListener("focusout", () => {
		if(1 <= info_email.value.length){
		    if(!emailCheck()){
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