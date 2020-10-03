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
									<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
									<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>	 
									<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>	 
									<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>	
									<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
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
	</div>
	<!-- /#page-wrapper -->
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