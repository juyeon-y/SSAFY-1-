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
							<h2 class="title-a">Environment</h2>
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
      <h2 class="text-center mt-5 mb-3">동네 환경 점검 정보</h2>
        
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
          <th>업체(시설)명</th>
          <th>인허가번호</th>
          <th>업종코드</th>
          <th>업종명</th>
          <th>지도점검일자</th>
          <th>점검기관</th>
          <th>점검기관명</th>
          <th>지도점검구분</th>
          <th>처분대상여부</th>
          <th>점검사항</th>
          <th>점검결과</th>
          <th>소재지도로명주소</th>
          <th>소재지주소</th>
        </tr>
        <tbody id="envlist"></tbody>
      </table>
    </div>
    </div>
    <script>
      ///////////////////////// 정보 /////////////////////////
      loadData();
      
      function loadData(){
        let url =
          "http://openAPI.gangnam.go.kr:8088/76656c666267656d38364d6c595853/xml/GnListEnvGuideCheck/1/30";
          fetch(url)
          .then((response) => response.text())
          .then((data) => makeList(data));
      }

      function makeList(data) {
        let tbody = document.querySelector("#envlist");
        let parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
        initTable();
        let envs = xml.querySelectorAll("row");
        
        envs.forEach((env) => {
          
          let tr = document.createElement("tr");

          let companyNameTd = document.createElement("td");
          companyNameTd.appendChild(document.createTextNode(env.querySelector("WRKP_NM").textContent));
          tr.appendChild(companyNameTd);

          let permitNumTd = document.createElement("td");
          permitNumTd.appendChild(document.createTextNode(env.querySelector("APV_PERM_MGT_NO").textContent));
          tr.appendChild(permitNumTd);
          
          let bizCodeTd = document.createElement("td");
          bizCodeTd.appendChild(document.createTextNode(env.querySelector("UPCH_COB_CODE").textContent));
          tr.appendChild(bizCodeTd);
          
          let bizNameTd = document.createElement("td");
          bizNameTd.appendChild(document.createTextNode(env.querySelector("UPCH_COB_NM").textContent));
          tr.appendChild(bizNameTd);
          
          let inspDateTd = document.createElement("td");
          inspDateTd.appendChild(document.createTextNode(env.querySelector("DRT_INSP_YMD").textContent));
          tr.appendChild(inspDateTd);
          
          let inspOrgCodeTd = document.createElement("td");
          inspOrgCodeTd.appendChild(document.createTextNode(env.querySelector("ORG_AND_TEAM_CODE").textContent));
          tr.appendChild(inspOrgCodeTd);
          
          let inspOrgNameTd = document.createElement("td");
          inspOrgNameTd.appendChild(document.createTextNode(env.querySelector("SF_TEAM_NM").textContent));
          tr.appendChild(inspOrgNameTd);
          
          let inspCateTd = document.createElement("td");
          inspCateTd.appendChild(document.createTextNode(env.querySelector("DRT_INSP_SE_NM").textContent));
          tr.appendChild(inspCateTd);
          
          let ifDispoTargetTd = document.createElement("td");
          ifDispoTargetTd.appendChild(document.createTextNode(env.querySelector("DISPO_TGT_YN").textContent));
          tr.appendChild(ifDispoTargetTd);
          
          let inspItemTd = document.createElement("td");
          inspItemTd.appendChild(document.createTextNode(env.querySelector("DRT_INSP_ITEM").textContent));
          tr.appendChild(inspItemTd);
          
          let inspResultTd = document.createElement("td");
          inspResultTd.appendChild(document.createTextNode(env.querySelector("DRT_INSP_RT_DTL").textContent));
          tr.appendChild(inspResultTd);
          
          let roadNameAddrTd = document.createElement("td");
          roadNameAddrTd.appendChild(document.createTextNode(env.querySelector("WRKP_NADDR").textContent));
          tr.appendChild(roadNameAddrTd);

          let addrTd = document.createElement("td");
          addrTd.appendChild(document.createTextNode(env.querySelector("WRKP_ADDR").textContent));
          addrTd.classList.add("text-end");
          tr.appendChild(addrTd);

          tbody.appendChild(tr);
        });
      }

      function initTable() {
        let tbody = document.querySelector("#envlist");
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
