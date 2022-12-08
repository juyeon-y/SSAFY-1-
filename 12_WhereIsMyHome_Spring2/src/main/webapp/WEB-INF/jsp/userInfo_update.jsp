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

	<!-- partial:index.partial.html -->
	<!-- Form-->
	<div style="padding: 50px;"></div>
	<div class="form">
		<div class="form-toggle"></div>
		<div class="form-panel one">
			<div class="form-header">
				<h1>Account Edit</h1>
			</div>
			<div class="form-content">
				<form action="/member/update" method="post">
					<div class="form-group">
						<%--@declare id="email"--%><label for="email">Email Address</label> <input type="email"
							id="infoedit-email" name="email" value=${member.email } readonly />
					</div>
					<div class="form-group">
						<%--@declare id="password"--%><label for="password">Password</label> <input type="password"
							id="infoedit-pass" name="password" value=${member.password } />
					</div>
					<div class="form-group">
						<%--@declare id="name"--%><label for="name">Username</label> <input type="text"
							id="infoedit-nm" name="name" value=${member.name } />
					</div>
					<div class="form-group">
						<%--@declare id="nickname"--%><label for="nickname">Nickname</label> <input type="text"
							id="infoedit-nicknm" name="nickname" value=${member.nickname } />
					</div>
					<div class="row">
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<%--@declare id="city"--%><label class="pb-2" for="city">도/광역시</label> <select
									class="form-control form-select form-control-a" id="loginsido">
									<option>전체</option>
								</select>
							</div>
						</div>
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<%--@declare id="garages"--%><label class="pb-2" for="garages">시/구/군</label> <select
									class="form-control form-select form-control-a" id="logingugun">
									<option>전체</option>
								</select>
							</div>
						</div>
						<div class="col-md-12 mb-2">
							<div class="form-group mt-3">
								<%--@declare id="price"--%><label class="pb-2" for="price">동</label> <select
									class="form-control form-select form-control-a" id="logindong">
									<option>전체</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group row justify-content-end">
						<button type="button" id="updateform">수정</button>
						<button type="button" id="deleteform"
							style="background-color: gray">탈퇴</button>
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
</body>


<%@ include file="./include/footer.jsp"%>
<script src="/assets/js/login.js"></script>


</html>