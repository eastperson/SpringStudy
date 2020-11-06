<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>

<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


</head>
<body>
	<%@include file="../includes/header.jsp"%>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Board Read</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Board Read Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">

								<div class="form-group">
									<label>Bno</label> <input class="form-control" name="bno"
										value='<c:out value="${board.bno }"/>' readonly="readonly">
								</div>
								<div class="form-group">
									<label>Title</label> <input class="form-control" name="title"
										value='<c:out value="${board.title }"/>' readonly="readonly">
								</div>
								<div class="form-group">
									<label>Text area</label>
									<textarea class="form-control" rows="3" name="content"
										readonly="readonly">
                                             <c:out
											value="${board.content }" />
                                            </textarea>
								</div>

								<div class="form-group">
									<label>Writer</label><input class="form-control" name="writer"
										value='<c:out value="${board.writer }"/>' readonly="readonly">
								</div>
								<button data-oper='modify' class="btn btn-default">Modify</button>
								<button data-oper='list' class="btn btn-default">List</button>
								<!--</form>-->
								<form id='operForm' action="/boad/modify" method="get">
									<input type='hidden' id='bno' name='bno'
										value='<c:out value="${board.bno}"/>'> <input
										type='hidden' name='pageNum'
										value='<c:out value="${cri.pageNum}"/>'> <input
										type='hidden' name='amount'
										value='<c:out value="${cri.amount}"/>'> <input
										type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
									<input type='hidden' name='keyword'
										value='<c:out value="${cri.keyword}"/>'>
								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->
						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class='row'>
			<div class="col=lg-12">
				<!-- /.panel -->
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<i class="fa fa-commentes fa-w"></i>Reply
					</div> -->
					
					<div class="panel-heading">
						<i class="fa fa-comments fa-fw"></i>Reply
							<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
					</div>			
					
					<!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="modal-body">
                                            <div class="form-group">
                                            	<label>Reply</label>
                                            	<input class="form-control" name='reply' value='New Reply!!!!!'>
                                            </div>
                                            <div class="form-group">
                                            	<label>Replyer</label>
                                            	<input class="form-control" name='replyer' value='replyer'>
                                            </div>
                                            <div class="form-group">
                                            	<label>Reply Date</label>
                                            	<input class="form-control" name='replyDate' value=''>
                                            </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                        	<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
                                        	<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
                                            <button id='modalRegisterBtn' type="button" data-dismiss="modal" class="btn btn-primary">Register</button>
                                            <button id='modalCloseBtn' type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- / -->
					
					<!-- /.panel-heading -->
					<div class="panel-body">
						<ul class="chat">
							<!--  start reply -->
							<li class="let clearfix" data-rno='12'>
								<div>
									<div class="header">
										<strong class="primary-font">user00</strong> <small
											class="pull-right text-muted">2018-01-01 13:13</small>
									</div>
									<p>Good job!</p>
								</div>
							</li>
							<!-- end reply -->
						</ul>
						<!--  ./end ul -->
					</div>
					<!-- /.panel-body -->
					<div class="panel-footer">
					
					</div>
					<!--  /.pannel .chat-panel -->
				</div>
			</div>
			<!-- end row -->
		</div>
	</div>
	<!-- /#page-wrapper -->
	<script type="text/javascript" src="/resources/js/reply.js"></script>
	<script>
	$(document).ready(function() {
		console.log("==============");
		console.log("JS Test");

		var bnoValue = '<c:out value="${board.bno}"/>';
		var replyUL = $(".chat");
		
		showList(1);
		
		function showList(page) {
			
			console.log("show list " + page);
			
			replyService.getList({bno:bnoValue, page : page || 1}, 
		
		function(replyCnt,list){
				
				console.log("replyCnt: " + replyCnt);
				console.log("list: " + list);
				console.log(list);
				
				if(page == -1){
					pageNum = Math.ceil(replyCnt/10.0);
					showList(pageNum);
					return;
				}
				
				var str = "";
				
				if(list == null || list.length == 0){
					return;
				}
				
				for(var i = 0, len = list.length || 0; i < len; i++){
					
					str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
					str += "<div><div class='header'><strong class='primary-font'>["+list[i].rno+"]"+list[i].replyer+"</strong>";
					str += "<small class='pull-right text-muted'>" +replyService.displayTime(list[i].replyDate)+"</small></div>";
					str += "<p>"+list[i].reply +"</p></div></li>";
				}
				
				for(var i = 0, len = list.length || 0; i < len; i++){
					
				}
				
				
				replyUL.html(str);
				
				showReplyPage(replyCnt);
			}); // end function
		} //end showList
		

		//add
		replyService.add({
			reply : "JS Test",
			replyer : "tester",
			bno : bnoValue
		}, function(result) {
			alert("RESULT: " + result);
		});

		//getList
		replyService.getList({
			bno : bnoValue,
			page : 1
		}, function(list) {
			for (var i = 0, len = list.length || 0; i < len; i++) {
				console.log(list[i]);
			}
		});

		//delete
		replyService.remove(63, function(count) {

			console.log(count);

			if (count === "success") {
				alert("REMOVED");
			}
		}, function(err) {
			alert('ERROR...');
		});

		//update
		replyService.update({
			rno : 22,
			bno : bnoValue,
			reply : "Modified Reply...."
		}, function(result) {
			alert("수정 완료...");
		});

		replyService.get(10, function(data) {
			console.log(data);
		});
		
		var modal = $(".modal");
		var modalInputReply = modal.find("input[name='reply']");
		var modalInputReplyer = modal.find("input[name='replyer']");
		var modalInputReplyDate = modal.find("input[name='replyDate']");
		
		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn =$("#modalRemoveBtn");
		var modalRegisterBtn = $("#modalRegisterBtn");
		
		$("#addReplyBtn").on("click", function(e){
			
			modal.find("input").val("");
			modalInputReplyDate.closest("div").hide();
			modal.find("button[id != 'modalCloseBtn']").hide();
			
			modalRegisterBtn.show();
			
			$(".modal").modal("show");
			
		});
		
		modalRegisterBtn.on("click", function(e){
		
			var reply = {
					reply :  modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bno:bnoValue
			};
			
			replyService.add(reply,function(result){
				
				alert(result);
				
				modal.find("input").val("");
				modal.modal("hide");
				
				//showList(1);
				showList(-1);
			});
		}); // end modalRegisterBun event
		
		$(".chat").on("click", "li", function(e){
			
			var rno = $(this).data("rno");
			
			replyService.get(rno, function(reply){
					
					modalInputReply.val(reply.reply);
					modalInputReplyer.val(reply.replyer);
					modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
					.attr("readonly","readonly");
					modal.data("rno",reply.rno);
					
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalModBtn.show();
					modalRemoveBtn.show();
					
					$(".modal").modal("show");
				});	
		}); // end click
		
		modalModBtn.on("click", function(e){
		
			var reply = {rno:modal.data("rno"), reply:modalInputReply.val()};
			
			replyService.update(reply, function(result){
				
				alert(result);
				modal.modal("hide");
				showList(1);
			});
		});
		
		modalRemoveBtn.on("click",function(e){
			
			var rno = modal.data("rno");
			
			replyService.remove(rno, function(result){
				
				alert(result);
				modal.modal("hide");
				showList(1);
				
			});
		});
		
		modalRegisterBtn.on("click", function(e){
			
			var reply = {
					reply:modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bn : bnoValue
			};
			
			replyService.add(reply,function(result){
				
				alert(result);
				
				modal.find("input").val("");
				modal.modal("hide");
				
				//showList(1);
				showList(-1);
			});
		}); //RegisterBtn
		
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");
		
		function showReplyPage(replyCnt){
			
			var endNum = Math.ceil(pageNum/ 10.0) * 10;
			var startNum = endNum - 9;
			
			var prev = startNum != 1;
			var next = false;
			
			if(endNum * 10 >= replyCnt) {
				endNum = Math.ceil(replyCnt/10.0);
			}
			
			if(endNum * 10 < replyCnt) {
				next = true;
			}
			
			var str = "<ul class='pagination pull-right'>";
			
			if(prev){
				str += "<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>Previous</a></li>";
			}
			
			for(var i = startNum; i <= endNum; i++){
				
				var active = pageNum == i ? "active" : "";
				
				str += "<li class='page-item " +active+" '><a class='page-link' href='" + i + "'>" + i +"</a></li>";
			}
			
			if(next){
				str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) +"'>Next</a></li>";
			}
			
			str += "</ul></div>";
			
			console.log(str);
			
			replyPageFooter.html(str);
			
		}
		
		
		
		replyPageFooter.on("click","li a", function(e){
			
			e.preventDefault();
			console.log("page click");
			
			var targetPageNum = $(this).attr("href");
			
			console.log("targetPageNum : " + targetPageNum);
			
			pageNum = targetPageNum;
			
			showList(pageNum);
		});
		
		modalModBtn.on("click", function(e){
			
			var reply = {rno:modal.date("rno"), reply:modalInputReply.val()};
			
			replyService.update(reply, function(result){
				
				alert(result);
				modal.modal("hide");
				showList(pageNum);
				
			});
		});
		
		modalRemoveBtn.on("click", function (e){
			
			var rno = modal.data("rno");
			
			replyService.remove(rno, function(result){
				
				alert(result);
				modal.modal("hide");
				showList(pageNum);
				
			});
			
		});
		
	}); // end ready
	
	</script>
	<!-- 
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("=============");
			console.log("JS TEST");
			
			var bnoValue = '<c:out value="${board.bno}"/>';
			
			replyService.add(
				{reply:"JS Test", replyer:"tester", bno:bnoValue}
				,
				function(result){
				alert("RESULT: " + result);					
				}
			)}
		);
	</script>
	 -->
	<script type="text/javascript">
		$(document).ready(function() {

			var operForm = $("#operForm");

			$("button[data-oper='modify']").on("click", function(e) {

				operForm.attr("action", "/board/modify").submit();

			});

			$("button[data-oper='list']").on("click", function(e) {

				operForm.find("#bno").remove();
				operForm.attr("action", "/board/list")
				operForm.submit();

			});
		});
	</script>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>