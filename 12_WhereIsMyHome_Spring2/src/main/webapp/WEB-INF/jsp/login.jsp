<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="./include/head.jsp"%>
</head>


<body>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d6df9c420c4b084fa3083596e893250&libraries=services"></script>

	<%@ include file="./include/nav.jsp"%>
	<!-- partial:index.partial.jsp -->
	<!-- Form-->
	<div style="padding: 50px;"></div>
	<div class="form" id="form">
		<div class="form-toggle"></div>
		<div class="form-panel one" id="form-panel one">
			<div class="form-header">
				<h1>Account Login</h1>
			</div>
			<div class="form-content">
				<form>
					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							id="loginemail" name="email" required="required" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							id="loginpassword" name="password" required="required" />
					</div>
					<div class="form-group">
						<label class="form-remember"> <!--input type="checkbox"/>Remember Me-->
						</label><a class="form-recovery" href="userInfo_find.jsp">Forgot
							Password?</a>
					</div>
					<div class="form-group">
						<button type="button" id="loginform">LogIn</button>
					</div>
				</form>
			</div>
		</div>
		<div class="form-panel two" id="form-panel two">
			<div class="form-header">
				<h1>Register Account</h1>
			</div>
			<div class="form-content">
				<form action="joinMember" method="get">
					<div class="form-group">
						<label for="email">Email Address</label> <input type="email"
							id="email" name="email" required="required"
							placeholder="example@ssafy.com" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							id="password" name="password" required="required"
							placeholder="비밀번호를 입력해주세요" />
					</div>
					<div class="form-group">
						<label for="cpassword">Confirm Password</label> <input
							type="password" id="cpassword" name="cpassword"
							required="required" placeholder="비밀번호를 다시 입력해주세요" />
					</div>
					<div class="form-group">
						<label for="name">Username</label> <input type="text" id="name"
							name="name" required="required" placeholder="이름을 입력해주세요" />
					</div>
					<div class="form-group">
						<label for="nickname">Nickname</label> <input type="text"
							id="nickname" name="nickname" required="required"
							placeholder="닉네임을 입력해주세요" />
					</div>
					<div class="row">
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<label class="pb-2" for="city">도/광역시</label> <select
									class="form-control form-select form-control-a" id="loginsido">
									<option>전체</option>
								</select>
							</div>
						</div>
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<label class="pb-2" for="garages">시/구/군</label> <select
									class="form-control form-select form-control-a" id="logingugun">
									<option>전체</option>
								</select>
							</div>
						</div>
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<label class="pb-2" for="price">동</label> <select
									class="form-control form-select form-control-a" id="logindong">
									<option>전체</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<button type="submit" id="joinform">JOIN</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="padding: 50px;"></div>
	<!-- partial -->
	<!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
	<!--  <script src='https://codepen.io/andytran/pen/vLmRVp.js'></script> -->
	<!--  <script src="./script.js"></script> -->
	<%@ include file="./include/footer.jsp" %>
	<script src="/assets/js/login.js"></script>

</body>

</html>