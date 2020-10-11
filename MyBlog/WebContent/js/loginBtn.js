window.onload = function() {
            		const loginForm = document.querySelector("#login_form"),
            			inputList = document.querySelectorAll("input"),
                    	btn_submit = document.querySelector(".btn_submit"),
                    	btn_join = document.querySelector(".btn_join");
            		
            		btn_submit.addEventListener("click", (e) => {

            	            e.preventDefault();

            	            console.log("submit 성공");
            	            loginForm.submit();
            	     })
            	     
            	     btn_join.addEventListener("click", (e) => {

            	            e.preventDefault();
            	            
            	            console.log("submit 성공");
            	            location.replace("/views/registerForm.jsp");
            	     });
            		
            	}