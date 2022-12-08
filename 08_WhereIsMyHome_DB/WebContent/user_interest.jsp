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
				<h1>관심지역 등록하기</h1>
			</div>
			<div class="form-content">
				<form>
					<form>
						<div class="form-group">
							<label class="pb-2" for="garages">시/구/군</label> <select
								class="form-control form-select form-control-a" id="gugun">
								<option>전체</option>
							</select>
						</div>
						<div class="form-group">
							<label class="pb-2" for="price">동</label> <select
								class="form-control form-select form-control-a" id="dong">
								<option>전체</option>
							</select>
						</div>
						<div class="form-group">
							<label class="pb-2" for="price">거래연도</label> <select
								class="form-control form-select form-control-a" id="year">
								<option>전체</option>
							</select>
						</div>
						<div class="form-group">
							<label class="pb-2" for="price">거래월</label> <select
								class="form-control form-select form-control-a" id="month">
								<option>전체</option>
							</select>
						</div>


						<div class="form-group row justify-content-end">
							<button type="button" onclick="location.href='index.jsp'">관심지역
								등록</button>
						</div>

					</form>
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