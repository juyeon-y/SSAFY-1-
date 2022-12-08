<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@ include file="./include/head.jsp"%>
  </head>
  <body>
  <script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d6df9c420c4b084fa3083596e893250&libraries=services"
      ></script>
  	<%@ include file="./include/nav.jsp"%>
  	
    <main id="main"> <!-- ======= Services Section ======= -->

	<section class="section-services section-t8" style="margin: 100px;">
		<div id="notice-div">

			<div layout:fragment="content">
				<!-- Content Wrapper. Contains page content -->
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<section class="content-header">
						<div class="title-box">
							<h2 class="title-a">Environment</h2>
						</div>
					</section>

					<!-- Main content -->
					<section class="content container-fluid">

						<!--------------------------
        | Your Page Content Here |
        -------------------------->
    <div align="center" id="map" style="width: 100%; height: 500px""></div>
    <script src="/assets/js/envInspInfo.js"></script>
	<script>
		let data = [];
		<c:forEach var="env" items="${list}" varStatus="status">
		data.push("${env.address}");
		</c:forEach>
		makeList(data)
	</script>

    <!-- 중앙 content start -->
    <div class="container">
      <div style="height: 70px"></div>
      <h2 class="text-center mt-5 mb-3">동네 환경 점검 정보</h2>
        
      <div class="row col-md-12 justify-content-center mb-2">
      <table class="table table-hover text-center">
        <thead>
        <tr>
          <td>업체(시설)명</td>
          <td>업종코드</td>
          <td>업종명</td>
          <td>지도점검일자</td>
          <td>점검기관</td>
          <td>점검기관명</td>
          <td>지도점검구분</td>
          <td>처분대상여부</td>
          <td>점검사항</td>
          <td>점검결과</td>
          <td>소재지주소</td>
        </tr>
        </thead>
        <tbody id="envlist">
        <c:forEach items="${list }" var="env">
        	<tr>
        		<td>${env.wrkpNm }</td>
        		<td>${env.upchCobCode }</td>
        		<td>${env.upchCobNm }</td>
        		<td>${env.drtInspYmd }</td>
        		<td>${env.orgAndTeamCode }</td>
        		<td>${env.sfTeamNm }</td>
        		<td>${env.drtInspSeNm }</td>
        		<td>${env.dispoTgtYn }</td>
        		<td>${env.drtInspItem }</td>
        		<td>${env.drtInspRtDtl }</td>
        		<td>${env.address }</td>
        	</tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    
    <%@ include file="./include/footer.jsp"%>
    
  </body>
</html>
