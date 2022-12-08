<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@ include file="/include/head.jsp"%>
  </head>
  <body>
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
							<h2 class="title-a">Business</h2>
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
        <tr>
          <th>광역시도</th>
          <th>시군구</th>
          <th>업종대분류</th>
          <th>업종중분류</th>
          <th>업종소분류</th>
          <th>건수</th>
        </tr>
        <tbody id="bizlist"></tbody>
      </table>
    </div>
    </div>
    <script>
      ///////////////////////// 정보 /////////////////////////
      loadData();
      
      function loadData(){
        let url =
          "https://api.odcloud.kr/api/15083033/v1/uddi:324125cb-6185-41a8-9480-8be3a8e4a717";
        let queryParams =
          encodeURIComponent("serviceKey") +
          "=" +
          "CXsQAYRx37qQ6NHyG5Za3NABuctWkleT1EQY7u1UaX2iHR72Rg6njovekaRfIYAjyIMXOS2tgwMqcncCDiepPw%3D%3D"; /*Service Key*/
        queryParams +=
          "&" + encodeURIComponent("page") + "=" + encodeURIComponent("1"); /*페이지번호*/
        queryParams +=
          "&" + encodeURIComponent("perPage") + "=" + encodeURIComponent("30"); /*페이지당건수*/
          
          fetch(url+'?'+queryParams)
          .then((response) => response.text())
          .then((data) => makeList(data));
      }

      function makeList(param) {
        let tbody = document.querySelector("#bizlist");
        let bizs = JSON.parse(param).data;
        initTable();
        
        bizs.forEach((biz) => {
          
          let tr = document.createElement("tr");

          let sidoTd = document.createElement("td");
          sidoTd.appendChild(document.createTextNode(biz.광역시도));
          tr.appendChild(sidoTd);

          let sigunguTd = document.createElement("td");
          sigunguTd.appendChild(document.createTextNode(biz.시군구));
          tr.appendChild(sigunguTd);

          let largeCateTd = document.createElement("td");
          largeCateTd.appendChild(document.createTextNode(biz.업종대분류));
          tr.appendChild(largeCateTd);
          
          let mediumCateTd = document.createElement("td");
          mediumCateTd.appendChild(document.createTextNode(biz.업종중분류));
          tr.appendChild(mediumCateTd);

          let smallCateTd = document.createElement("td");
          smallCateTd.appendChild(document.createTextNode(biz.업종소분류));
          tr.appendChild(smallCateTd);

          let countTd = document.createElement("td");
          countTd.appendChild(document.createTextNode(biz.건수));
          countTd.classList.add("text-end");
          tr.appendChild(countTd);

          tbody.appendChild(tr);
        });
      }

      function initTable() {
        let tbody = document.querySelector("#bizlist");
        let len = tbody.rows.length;
        for (let i = len - 1; i >= 0; i--) {
          tbody.deleteRow(i);
        }
      }
    </script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    
   	<%@ include file="/include/footer.jsp"%>
  </body>
</html>
