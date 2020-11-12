<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장 관리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<h1>Business Manage Main Page</h1>

	storeId : ${storeId}

	<h1>매장 정보</h1>
	<ul class="store"></ul>

	<h1>웨이팅 리스트</h1>
	<ul class="waitList"></ul>

	<h1>예약 리스트</h1>
	<ul class="rsvdList"></ul>
	
	<h1>다음 웨이팅 정보</h1>
	<ul class="nextWait"></ul>

	<h1>다음 예약자 정보</h1>
	<div class="nextRsvd"></div>
	
	
	<h1>테스트</h1>

	<h1>
		<a href="/business/manage/dealhistory?storeId=${storeId}">Deal
			History</a>
	</h1>


	<p>
		현재 날짜 :
		<fmt:formatDate pattern="yyyy-MM-dd" value="${today}" />
	</p>
	<p>
		현재 시간 :
		<fmt:formatDate pattern="HH:mm:ss" value="${today}" />
	</p>
        <form id="seatStusForm" action="/business/manage/" method="post">
            <input name="seatStusColor" id="color_value" value="" hidden>
            <input name="storeId" value="${storeId}" hidden>
            <button class="btn_seat_stus">Green</button>
            <button class="btn_seat_stus">Yellow</button>
            <button class="btn_seat_stus">Red</button></br>
        </form>
		</br> ${curSeatStus}
	<p>다음 예약 정보 : ${nextRsvd}</p>

	<p>다음 웨이팅 정보 : ${nextWait}</p>
	<a
		href="/business/manage/enter?waitId=${nextWait.id}&storeId=${storeId}">입장</a>
	</br>
	<a
		href="/business/manage/noshow?waitId=${nextWait.id}&storeId=${storeId}">노쇼</a>

	<p>현재 착석 가능 여부 : ${store.bstore.seatStusCd}</p>

	<p>
		<a href="/business/manage/waiting/register?storeId=${storeId}">오프라인
			웨이팅 등록</a>
	</p>

	<p>
		<a href="/business/manage/modify?storeId=${storeId}">매장 정보 수정</a>
	</p>

	<h2>웨이팅 리스트</h2>

	<c:if test="${not empty waitList}">
		<c:forEach items="${waitList}" var="wait">
=====================================</br>
			<a href="/business/manage/waiting?waitId=${wait.id}"><div>
					웨이팅 번호 : ${wait.id}</br> 매장 번호 : ${wait.storeId}</br> 회원 아이디 : ${wait.userId}</br>
					웨이팅 접수시간 : ${wait.waitRegTm}</br> 웨이팅 인원 = ${wait.waitPnum}</br> 고객 연락처 =
					${wait.custTelno }</br> 고객 이름 = ${wait.custNm }</br> 웨이팅 상태 =
					${wait.waitStusCd}</br>
				</div> </a>
		</c:forEach>
	</c:if>


	<p>매장정보 : ${store}</p>
	<p>라스트 오더 시간 : ${lastOrder}</p>


	<h2>예약리스트</h2>
	<c:if test="${not empty rsvdList}">
		<c:forEach items="${rsvdList}" var="rsvd">
			<a href="/business/manage/reservation?rsvdId=${rsvd.id}"><div>
					=====================================</br> 예약 번호: ${rsvd.id}</br> 매장 번호:
					${rsvd.storeId}</br> 예약 회원 아이디: ${rsvd.userId}</br> 핫딜 번호: ${rsvd.htdlId}</br> 승인
					번호: ${rsvd.aprvNo}</br> 예약 인원: ${rsvd.pnum}</br> 예약 시간: ${rsvd.time}</br> 예약 상태:
					${rsvd.stusCd}</br> 예약 총 금액: ${rsvd.totAmt}</br> 예약 총 수량: ${rsvd.totQty}</br> 예약
					작성 날짜: ${rsvd.inDate}</br>
				</div> </a>
		</c:forEach>
	</c:if>

	<p>시간대별 예약자 현황 : ${todayRsvdMap }</p>
	-------
	<p>오늘 예약 수 : ${totalTodayRsvd }</p>
	<p>오늘 예약 인원 수 : ${totalTodayRsvdPnum}</p>
	<p>오늘 선호 메뉴 맵 : ${todayFavMenuMap }</p>

	<h2>오늘 예약 회원</h2>
	<c:if test="${not empty todayRsvdUserList}">
		<c:forEach items="${todayRsvdUserList}" var="user">
			<div>
				==========================================</br> 회원 아이디 : ${user.userId}</br>
				회원 이름 : ${user.name}</br> 회원 이메일 : ${user.email}</br> 회원 전화번호 : ${user.telno}</br>
				생년 월일 : ${user.brdt}</br> 성별 : ${user.sex }</br> 회원 프로필 사진 : ${user.photoSrc}</br>
				패널티 회원 여부 : ${user.pmStus}</br>
			</div>
		</c:forEach>
	</c:if>
<script>
    console.log("board module........");
    
    let boardService = (() => {
        
        /*put 함수*/
        function putNoshowWaiting(waitId) {
            $.ajax({
                type:'put',
                url:'/business/manage/board/waiting/noshow/' + waitId,
                data : {waitId:waitId},
                contentType : "application/json",
                success : function(result, status, xhr) {
                    if(callback) {
                        callback(result);
                    }
                },
                error : function(xhr, status, er) {
                    if(error) {
                        error(er);
                    }               
                }
            });
            
            }
    
        function putEnterWaiting(waitId) {
    
            $.ajax({
                type:'put',
                url:'/business/manage/board/waiting/enter/' + waitId,
                data : {waitId:waitId},
                contentType : "application/json",
                success : function(result, status, xhr) {
                    if(callback) {
                        callback(result);
                    }
                },
                error : function(xhr, status, er) {
                    if(error) {
                        error(er);
                    }               
                }
            });
            
            }
    
        function putCancelWaiting(waitId) {
    
            $.ajax({
                type:'put',
                url:'/business/manage/board/waiting/cancel/' + waitId,
                data : {waitId:waitId},
                contentType : "application/json",
                success : function(result, status, xhr) {
                    if(callback) {
                        callback(result);
                    }
                },
                error : function(xhr, status, er) {
                    if(error) {
                        error(er);
                    }               
                }
            });
            
        }
    
        /*get 함수*/
        function getRsvdList(param,callback,error) {
            
            let storeId = param.storeId;
            
            let rsvdList = $.getJSON("/business/manage/board/reservation/"+storeId+".json",
                function(data){
                        if(callback){
                            callback(data);
                        }
                    }).fail(function(xhr,status,err){
                        if(error){
                            error();
                        }
            });
    	
            
            return rsvdList;
        }
    
        function getWaitList(param,callback,error) {
            
            let storeId = param.storeId;
            
            let waitList = $.getJSON("/business/manage/board/waiting/"+storeId+".json",
                function(data){
                        if(callback){
                            callback(data);
                        }
                    }).fail(function(xhr,status,err){
                        if(error){
                            error();
                        }
            });
            
            return waitList;
        }
    
        /*현재 들어온 매장 */
        function getStore(param,callback,error) {
            
            let storeId = param.storeId;
    
            $.getJSON("/business/manage/board/store/"+storeId+".json",
                    function(data){
                        if(callback){
                            callback(data);
                        }
                    }).fail(function(xhr,status,err){
                        if(error){
                            error();
                        }
            });
        }
        
        function getNextWait(waitList){
            if(!waitList){
                return;
            }
                       
            return waitList.filter(wait => {return wait.waitStusCd === 'W'})
                    .sort((w1,w2) => { return w1.id - w2.id})[0];
        };
        
        function getTodayRsvdMap(rsvdList,callback,error){
        	
        	let map = $.getJSON("/business/manage/board/reservation/map.json",rsvdList,
                    function(data){
                        if(callback){
                            callback(data);
                        }
                    }).fail(function(xhr,status,err){
                        if(error){
                            error();
                        }
            });
            
        	return map;
        };
        
        function getNextRsvd(rsvdList){
            
        };
    
        function regWait(wait, callback,error) {
    
            $.ajax({
                type : 'post',
                url : '/business/manage/board/waiting/new',
                data : JSON.stringify(wait),
                contentType : "application/json; charset=utf-8",
                success : function(result, status, xhr) {
                    if(callback) {
                        callback(result);
                    }
                },
                error : function(xhr, status, er) {
                    if(error) {
                        error(er);
                    }               
                }
            })
        }
    
        return {
            regWait:regWait,
            getStore : getStore,
            getWaitList : getWaitList,
            getRsvdList : getRsvdList,
            putCancelWaiting : putCancelWaiting,
            putNoshowWaiting : putNoshowWaiting,
            putEnterWaiting : putEnterWaiting,
            getNextWait : getNextWait,
            getNextRsvd : getNextRsvd,
            getTodayRsvdMap : getTodayRsvdMap
        };
    })();
    $(document).ready(() => {
        
        let seatStusForm = $("#seatStusForm"),
        colorVal = $("#color_value"),
        storeId = ${storeId},
        storeUL = $(".store"),
        rsvdListUL = $(".rsvdList"),
        waitListUL = $(".waitList"),
        nextWaitUL = $(".nextWait")
        ;
            
        showBoard(storeId);
    
        function showBoard(storeId) {
            
            boardService.getStore({storeId : storeId}, function (store) {
                let str = "";
                if(store == null){
                    storeUL.html("");
                    return;
                }
                str += "<li>매장번호 : " + store.storeId + "</li>";
                str += "<li>매장이름 : " + store.storeNm + "</li>";
                str += "<li>매장 연락처 : " + store.telno + "</li>";
                str += "<li>매장 수용인원 : " + store.bstore.acmPnum + "</li>";
                str += "<li>매장 평균식사시간 : " + store.bstore.avgMealTm + "</li>";
                str += "<li>매장 브레이크종료시간 : " + store.bstore.breakEntm + "</li>";
                str += "<li>매장 브레이크시작시간 : " + store.bstore.breakSttm + "</li>";
                str += "<li>매장 관리자 아이디 : " + store.bstore.buserId + "</li>";
                str += "<li>매장 영업종료시간 : " + store.bstore.closeTm + "</li>";
                str += "<li>매장 휴무일 : " + store.bstore.hldy + "</li>";
                str += "<li>매장 라스트오더시간 : " + store.bstore.lastOrdTm + "</li>";
                str += "<li>매장 메뉴 : " + store.bstore.menus + "</li>";
                str += "<li>매장 1인석 : " + store.bstore.n1SeatNo + "</li>";
                str += "<li>매장 2인석 : " + store.bstore.n2SeatNo + "</li>";
                str += "<li>매장 4인석 : " + store.bstore.n4SeatNo + "</li>";
                str += "<li>매장 시작시간 : " + store.bstore.openTm + "</li>";
                str += "<li>매장 착석상태 : " + store.bstore.seatStusCd + "</li>";
                str += "<li>매장 소개 : " + store.bstore.storeIntro + "</li>";
                
                storeUL.html(str);
            });
    
            
            boardService.getWaitList({storeId:storeId}, function (waitList) {
                let strWaitList = "";
                if(waitList == null){
                    waitList.html("");
                    return;
                }
                
                console.log(waitList);
                
                waitList.forEach(wait => {
                    strWaitList += "<ul>" + "<h3>웨이팅 번호 : "+wait.id+"</h3>";
                        strWaitList += "<li>웨이팅 회원 아이디 : "+ wait.userId + "</li>";
                        strWaitList += "<li>웨이팅 매장 번호"+ wait.storeId + "</li>";
                        strWaitList += "<li>웨이팅 인원"+ wait.waitPnum + "</li>";
                        strWaitList += "<li>웨이팅 등록 시간 : "+ wait.waitRegTm + "</li>";
                        strWaitList += "<li>웨이팅 상태 : "+ wait.waitStusCd + "</li>";
                        strWaitList += "<li>웨이팅 등록 시간 : "+ wait.inDate + "</li>";
                        strWaitList += "<li>웨이팅 회원 이름 : "+ wait.custNm + "</li>";
                        strWaitList += "<li>웨이팅 회원 번호 : "+ wait.custTelno + "</li>";
                    strWaitList += "</ul>"  
                });
    
              waitListUL.html(strWaitList);   
              
              
              let nextWait = boardService.getNextWait(waitList);
              
              console.log(nextWait);
              
              let strNextWait = "";
              
              strNextWait += "<li> 대기자 이름 : "+nextWait.custNm+"</li>";
              strNextWait += "<li> 대기자 연락처 : "+nextWait.custTelno+"</li>";
              strNextWait += "<li> 웨이팅 번호 :"+nextWait.id+"</li>";
              strNextWait += "<li> 웨이팅 등록 날짜 :"+nextWait.inDate+"</li>";
              strNextWait += "<li> 매장 번호 : "+nextWait.storeId+"</li>";
              strNextWait += "<li> 회원 아이디 : "+nextWait.userId+"</li>";
              strNextWait += "<li> 웨이팅 인원 : "+nextWait.waitPnum+"</li>";
              strNextWait += "<li> 웨이팅 등록 시간 : "+nextWait.waitRegTm+"</li>";
              strNextWait += "<li> 웨이팅 상태 : "+nextWait.waitStusCd+"</li>";
              
              nextWaitUL.html(strNextWait);
    
            }); 
    
            boardService.getRsvdList({storeId:storeId}, function (rsvdList) {
                let strRsvdList = "";
                if(rsvdList == null){
                    rsvdList.html("");
                    return;
                }
                rsvdList.forEach(rsvd => {
                    strRsvdList += "<ul>" + "<h3>예약 번호 : "+rsvd.id+"</h3>"; 
                        strRsvdList += "<li>매장번호 : "+ rsvd.storeId + "</li>";
                        strRsvdList += "<li>회원 아이디 : "+ rsvd.userId + "</li>";
                        strRsvdList += "<li>핫딜 번호 :"+ rsvd.htdlId + "</li>";
                        strRsvdList += "<li>승인 번호 : "+ rsvd.aprvNo + "</li>";
                        strRsvdList += "<li>예약 인원 : "+ rsvd.pnum + "</li>";
                        strRsvdList += "<li>예약 시간 : "+ rsvd.time + "</li>";
                        strRsvdList += "<li>예약 상태 : "+ rsvd.stusCd + "</li>";
                        strRsvdList += "<li>예약 총 금액 : "+ rsvd.totAmt + "</li>";
                        strRsvdList += "<li>예약 총 수량 : "+ rsvd.totQty + "</li>";
                        strRsvdList += "<li>예약 등록 날짜"+ rsvd.inDate + "</li>";
                    strRsvdList += "</ul>"  
                });
    
              rsvdListUL.html(strRsvdList);
   
            }); 
            }
        
        /* 이벤트 처리*/
        
        /* 매장 착석 상태 처리*/
        $(".btn_seat_stus").on("click", e => {
    
            e.preventDefault();
    
            if(e.target.innerHTML === 'Red')
                color = 'R';
            if(e.target.innerHTML === 'Yellow')
                color = 'Y';
            if(e.target.innerHTML === 'Green')
                color = 'G';
            
    
            colorVal
                .attr("value",color)
            seatStusForm
            .attr("method","post")
            .attr("action","/business/manage/seat").submit();
        })
        
    
    })
    </script>
	<!-- 
<script>
    console.log("============");
    console.log("get test");

    boardService.getStore({storeId : 101}, function(store){
        console.log(store);
    });

    boardService.getWaitList({storeId:101}, function(waitList){
        waitList.forEach(wait => {
            console.log(wait);
        });
    })

    boardService.getRsvdList({storeId:101}, function(rsvdList){
        rsvdList.forEach(rsvd => {
            console.log(rsvd);
        })
    })

    boardService.putCancelWaiting(182,function (result) {
        alert("수정 완료");
    })

</script>
 -->
</body>
</html>