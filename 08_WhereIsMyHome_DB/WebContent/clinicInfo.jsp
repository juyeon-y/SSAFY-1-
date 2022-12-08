<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@ include file="/include/head.jsp"%>
  </head>
  <body>
  <script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d6df9c420c4b084fa3083596e893250&libraries=services"
      ></script>
  	<%@ include file="/include/nav.jsp"%>
  	
    <main id="main"> <!-- ======= Services Section ======= -->

	<section class="section-services section-t8" style="margin: 100px;">
		<div id="notice-div">

			<div layout:fragment="content">
				<!-- Content Wrapper. Contains page content -->
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<section class="content-header">
						<div class="title-box">
							<h2 class="title-a">Clinic</h2>
						</div>
					</section>

					<!-- Main content -->
					<section class="content container-fluid">

						<!--------------------------
        | Your Page Content Here |
        -------------------------->
	
    <!-- 중앙 content start -->
    <div class="container">
      <div style="height: 70px"></div>
      <h2 class="text-center mt-5 mb-3">관심지역 선별진료소</h2>
        
      <div class="row col-md-12 justify-content-center mb-2">
      <table class="table table-hover text-center">
        <thead>
        <tr>
          <td>시도</td>
          <td>시군구</td>
          <td>의료기관명</td>
          <td>주소</td>
          <td>평일 운영시간</td>
          <td>토요일 운영시간</td>
          <td>일요일 운영시간</td>
          <td>공휴일 운영시간</td>
          <td>대표 전화번호</td>
        </tr>
        </thead>
        <tbody id="cliniclist">
        <c:forEach items="${list }" var="clinic">
        	<tr>
        		<td>${clinic.sidoname }</td>
        		<td>${clinic.sigugunname }</td>
        		<td>${clinic.clinicname }</td>
        		<td>${clinic.address }</td>
        		<td>${clinic.daytime }</td>
        		<td>${clinic.saturdaytime }</td>
        		<td>${clinic.sundaytime }</td>
        		<td>${clinic.redtime }</td>
        		<td>${clinic.phone }</td>
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
    
   	<%@ include file="/include/footer.jsp"%>
  </body>
</html>
