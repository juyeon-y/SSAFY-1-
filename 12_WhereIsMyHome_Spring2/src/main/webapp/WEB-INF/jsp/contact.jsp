<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/include/head.jsp"%>
</head>

<body>
	<%@ include file="/include/nav.jsp" %>

	<main id="main"> <!-- ======= Intro Single ======= -->
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">회원가입</h1>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Intro Single-->
	<form class="form-horizontal">
		<div class="form-group has-feedback row">
			<label for="inputName"
				class="col-md-3 control-label text-md-right col-form-label">아이디
				<span class="text-danger small">*</span>
			</label>
			<div class="col-md-8">
				<input type="text" class="form-control" id="inputName"
					placeholder="" required="" name="id" /> <i
					class="fa fa-pencil form-control-feedback pr-4"></i>
			</div>
		</div>
		<div class="form-group has-feedback row">
			<label for="inputLastName"
				class="col-md-3 control-label text-md-right col-form-label">비밀번호
				<span class="text-danger small">*</span>
			</label>
			<div class="col-md-8">
				<input type="password" class="form-control" id="inputLastName"
					placeholder="영문 숫자 포함 6자리 이상" required="" name="pw" />
				<i class="fa fa-pencil form-control-feedback pr-4"></i>
			</div>
		</div>
		<div class="form-group has-feedback row">
			<label for="inputUserName"
				class="col-md-3 control-label text-md-right col-form-label">이름
				<span class="text-danger small">*</span>
			</label>
			<div class="col-md-8">
				<input type="text" class="form-control" id="inputUserName"
					placeholder="User Name" required="" name="name" />
				<i class="fa fa-user form-control-feedback pr-4"></i>
			</div>
		</div>
		<div class="form-group has-feedback row">
			<label for="inputEmail"
				class="col-md-3 control-label text-md-right col-form-label">주소
				<span class="text-danger small">*</span>
			</label>
			<div class="col-md-8">
				<input type="text" class="form-control" id="inputEmail"
					placeholder="address" required="" name="addr" />
				<i class="fa fa-envelope form-control-feedback pr-4"></i>
			</div>
		</div>
		<div class="form-group has-feedback row">
			<label for="inputPassword"
				class="col-md-3 control-label text-md-right col-form-label">전화번호
				<span class="text-danger small">*</span>
			</label>
			<div class="col-md-8">
				<input type="text" class="form-control" id="inputPassword"
					placeholder="010-xxx-xxxx" required="" name="tel" />
				<i class="fa fa-lock form-control-feedback pr-4"></i>
			</div>
		</div>

		<div class="form-group row">
			<div class="ml-md-auto col-md-9">
				<button type="submit" class="btn btn-group btn-animated"
					style="background-color: green; color: white;">
					등록 <i class="fa fa-check"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- End Contact Single--> </main>
	<!-- End #main -->

	<%@ include file="/include/footer.jsp" %>
</body>
</html>
