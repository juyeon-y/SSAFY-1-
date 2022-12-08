<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h1>Find your Account</h1>
			</div>
			<div class="form-content">
				<form>
					<div class="form-group">
						<label for="username">UserId</label> <input type="text"
							id="infoedit-id" name="username" value="" />
					</div>
					<div class="form-group">
						<label for="email">Email Address</label> <input type="email"
							id="infoedit-email" name="email" placeholder="SSAFY@ssafy.com" />
					</div>
					<div class="form-group row justify-content-end">
						<button type="button" id="joinform">비밀번호 찾기</button>

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
</body>


<%@ include file="/include/footer.jsp"%>
</html>