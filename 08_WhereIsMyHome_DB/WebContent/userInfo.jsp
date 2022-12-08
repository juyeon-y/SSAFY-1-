<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="/include/head.jsp"%>
</head>

<body>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d6df9c420c4b084fa3083596e893250&libraries=services"></script>


	<%@ include file="/include/nav.jsp"%>

	<!-- partial:index.partial.jsp -->
	<!-- Form-->
	<div style="padding: 50px;"></div>
	<div class="form">
		<div class="form-toggle"></div>
		<div class="form-panel one">
			<div class="form-header">
				<h1>Account Check</h1>
			</div>
			<div class="form-content">
				<form>
					<div class="form-group">
						<label for="email">Email Address</label> <a id="userinfo-email">${info.email }</a>
						<!-- <input type="email" id="email" name="email" required="required" placeholder="example@ssafy.com"/> -->
					</div>
					<div class="form-group">
						<label for="password">Password</label> <a id="userinfo-pass">*********</a>
						<!-- <input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력해주세요"/> -->
					</div>
					<div class="form-group">
						<label for="name">Username</label> <a id="userinfo-id">${info.name }</a>
						<!-- <input type="text" id="name" name="name" required="required" placeholder="이름을 입력해주세요"/> -->
					</div>
					<div class="form-group">
						<label for="nickname">Nickname</label> <a id="userinfo-id">${info.nickname }</a>
						<!-- <input type="text" id="nickname" name="nickname" required="required" placeholder="이름을 입력해주세요"/> -->
					</div>
					<div class="form-group">
						<label for="interest">Interest Location</label> <a id="userinfo-interest">${interest }</a>
						<!-- <input type="text" id="nickname" name="nickname" required="required" placeholder="이름을 입력해주세요"/> -->
					</div>
					<div class="form-group row justify-content-end">
						<button type="button"
							onclick="location.href='user?sign=mvUpdateInfo'" id="joinform">수정하러
							가기</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<div style="padding: 50px;"></div>
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>
	<script src="./script.js"></script>

<%@ include file="/include/footer.jsp"%>

</body>

</html>