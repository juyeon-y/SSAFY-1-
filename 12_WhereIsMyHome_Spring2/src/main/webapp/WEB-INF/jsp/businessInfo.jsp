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
							<h2 class="title-a">Business</h2>
						</div>
					</section>

					<!-- Main content -->
					<section class="content container-fluid">

						<!--------------------------
        | Your Page Content Here |
        -------------------------->
    <div align="center" id="map" style="width: 100%; height: 500px""></div>
    <script src="/assets/js/business.js"></script>
	<script>
		let dList = [];
		<c:forEach var="biz" items="${list}" varStatus="status">
		dList.push(["${biz.lng}", "${biz.lat}"]);
		</c:forEach>
		makeList(dList);
	</script>
	
    <!-- 중앙 content start -->
    <div class="container">
      <div style="height: 70px"></div>
      <h2 class="text-center mt-5 mb-3">동네 업종 정보</h2>
        
      <div class="row col-md-12 justify-content-center mb-2">
      <!--
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="sido">
            <option value="">시도선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="gugun">
            <option value="">구군선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="dong">
            <option value="">동선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-dark text-light" id="year"></select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-dark text-light" id="month">
            <option value="">매매월선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <button type="button" id="list-btn" class="btn btn-outline-primary">
            아파트매매정보가져오기
          </button>
        </div>
      </div>
      -->
      <table class="table table-hover text-center">
        <thead>
        <tr>
          <td>상호명</td>
          <td>상권업종대분류명</td>
          <td>상권업종중분류명</td>
          <td>상권업종소분류명</td>
          <td>표준산업분류명</td>
          <td>주소</td>
        </tr>
        </thead>
        <tbody id="bizlist">
        <c:forEach items="${list }" var="biz">
        	<tr>
        		<td>${biz.bizname }</td>
        		<td>${biz.maincategory }</td>
        		<td>${biz.middleclass }</td>
        		<td>${biz.subcategory }</td>
        		<td>${biz.category }</td>
        		<td>${biz.address }</td>
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
