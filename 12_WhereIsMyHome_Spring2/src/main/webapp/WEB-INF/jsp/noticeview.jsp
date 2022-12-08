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
		<div class="form"></div>
		<div class="form-panel one">
			<div class="form-header">
				<h1>${board.title }</h1>
			</div>
			<div class="form-content">
				<form>
		
						<a id="contents">${board.contents }</a>

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