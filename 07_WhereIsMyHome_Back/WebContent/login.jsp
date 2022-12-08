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
	<div class="form" id="form">
		<div class="form-toggle"></div>
		<div class="form-panel one" id="form-panel one">
			<div class="form-header">
				<h1>Account Login</h1>
			</div>
			<div class="form-content">
				<form>
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							id="loginusername" name="username" required="required" />
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
				<form>
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							id="username" name="username" required="required"
							placeholder="이름을 입력해주세요" />
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
						<label for="email">Email Address</label> <input type="email"
							id="email" name="email" required="required"
							placeholder="example@ssafy.com" />
					</div>
					<div class="form-group">
						<button type="button" id="joinform">JOIN</button>
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
</html>


<%@ include file="/include/footer.jsp"%>

</body>

</html>