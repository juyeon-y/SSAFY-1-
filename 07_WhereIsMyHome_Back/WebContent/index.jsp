<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <%@ include file="/include/head.jsp" %>
  
</head>

<body>
  <script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d6df9c420c4b084fa3083596e893250&libraries=services"
      ></script>

 <%@ include file="/include/nav.jsp" %>

  <!-- ======= Intro Section ======= -->
  <div id = "aptlist-div" style="margin: 100px;">
    <div id="map" style="width: 100%; height: 500px"></div>
    <table class="table table-hover text-center" style="display: none; ">
      <tr>
        <th>아파트이름</th>
        <th>층</th>
        <th>면적</th>
        <th>법정동</th>
        <th>거래금액</th>
      </tr>
      <tbody id="aptlist"></tbody>
    </table>

  </div>
  <div class="intro intro-carousel swiper position-relative" id = "introimg">
    
    <div class="swiper-wrapper" >

      <div class="swiper-slide carousel-item-a intro-item bg-image" style="background-image: url(assets/img/slide-1.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <p class="intro-title-top">Seoul
                      <br> 78345
                    </p>
                    <h1 class="intro-title mb-4 ">
                      <span class="color-b">서울 </span> Mount
                      <br> Olive Road Two
                    </h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">rent | $ 12.000</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="swiper-slide carousel-item-a intro-item bg-image" style="background-image: url(assets/img/slide-2.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <p class="intro-title-top">Busan
                      <br> 78345
                    </p>
                    <h1 class="intro-title mb-4">
                      <span class="color-b">부산 </span> Rino
                      <br> Venda Road Five
                    </h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">rent | $ 12.000</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="swiper-slide carousel-item-a intro-item bg-image" style="background-image: url(assets/img/slide-3.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <p class="intro-title-top">Apartment
                      <br> 78345
                    </p>
                    <h1 class="intro-title mb-4">
                      <span class="color-b">아파트 </span> Alira
                      <br> Roan Road One
                    </h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">rent | $ 12.000</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="swiper-pagination"></div>
  </div><!-- End Intro Section -->
  
    
  <!-- ======= Services Section ======= -->
	<section class="section-services section-t8">
		<div class="container">
			
			<div class="row">
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="bi bi-card-checklist"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Notice</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">사이트 이용 및 관련하여 공지사항을 안내드립니다.</p>
						</div>
						<div class="card-footer-c">
							<a href="board?sign=mvnotice" class="link-c link-icon">Read more <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="bi bi-calendar4-week"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Business</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">동네 업종 정보 조회</p>
						</div>
						<div class="card-footer-c">
							<a href="businessInfo.jsp" class="link-c link-icon">Read more <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="bi bi-card-checklist"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Environment</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">동네 환경 점검 정보 조회</p>
						</div>
						<div class="card-footer-c">
							<a href="envInspInfo.jsp" class="link-c link-icon"> Read more <span 
								class="bi bi-chevron-right"></span> 
							</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a"></h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Services Section -->
	

  <%@ include file="/include/footer.jsp" %>
   <script src="assets/js/apt.js"></script>
</body>

</html>