<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ======= Property Search Section ======= -->
  <div class="click-closed"></div>
  <!--/ Form Search Star /-->
  <div class="box-collapse">
    <div class="title-box-d">
      <h3 class="title-d">실거래가 조회</h3>
    </div>
    <span class="close-box-collapse right-boxed bi bi-x"></span>
    <div class="box-collapse-wrap form">
      <form class="form-a">
        <div class="row">
          <div class="col-md-12 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="city">도/광역시</label>
              <select class="form-control form-select form-control-a" id="sido">
                <option>전체</option>
              </select>
            </div>
          </div>
          <div class="col-md-12 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="garages">시/구/군</label>
              <select class="form-control form-select form-control-a" id="gugun">
                <option>전체</option>
              </select>
            </div>
          </div>
          <div class="col-md-12 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="price">동</label>
              <select class="form-control form-select form-control-a" id="dong">
                <option>전체</option>
              </select>
            </div>
          </div>
          <div class="col-md-12 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="price">거래연도</label>
              <select class="form-control form-select form-control-a" id="year">
                <option>전체</option>
              </select>
            </div>
          </div>
          <div class="col-md-12 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="price">거래월</label>
              <select class="form-control form-select form-control-a" id="month">
                <option>전체</option>
              </select>
            </div>
          </div>
          <div class="col-md-12">
            <button type="button" class="btn btn-b" id="search">조회</button>
          </div>
        </div>
      </form>
    </div>
  </div><!-- End Property Search Section -->

<!-- ======= Header/Navbar ======= -->
<nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
  <div class="container">
    <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span></span>
      <span></span>
      <span></span>
    </button>
    <a class="navbar-brand text-brand" href="index.jsp">WhereIs<span class="color-b">MyHouse</span></a>

      <div class="navbar-collapse collapse justify-content-end mx-5" id="navbarDefault">
        <ul class="navbar-nav" id="loginLi">

          <input type="hidden" id="hiddenemail" value="">

          <li class="nav-item" >
            <a class="nav-link " href = "member?sign=mvjoin" id="join">로그인 / 회원가입</a>
          </li>

          <!-- <li class="nav-item">
            <a class="nav-link " href="login.jsp" id="login">로그인</a>
          </li> -->

          <!-- <li class="nav-item dropdown" id = "join-dropdown">
            <a class="nav-link dropdown-toggle "  id="navbarDropdownMenuLinkjoin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">회원가입</a>
            <div class="dropdown-menu" style="width: 300px; height : 500px; padding: 15px; padding-bottom: 10px;">
                <form class="form-horizontal" method="post" accept-charset="UTF-8">
                  <a>아이디</a>
                  <input class="form-control login" type="text" id = "joinid" placeholder="아이디를 입력해주세요"><br>
                  <a>비밀번호</a>
                  <input class="form-control login" type="password" id="joinpassword" placeholder="영문 숫자 포함 6자리 이상"><br>
                  <a>이름</a>
                  <input class="form-control login" type="text" id="joinname" placeholder="이름을 입력해주세요"><br>
                  <a>이메일</a>
                  <input class="form-control login" type="email" id="joinemail" placeholder="origin@ssafy.com"><br>
                  <a>전화번호</a>
                  <input class="form-control login" type="tel" id="jointel" placeholder="010-0000-0000"><br>
                  <input class="btn btn-primary" type="button" name="submit" value="join" id = "join">
                </form>
            </div>
        </li>

          <li class="nav-item dropdown" id="login-dropdown">
            <a class="nav-link dropdown-toggle "  id="navbarDropdownMenuLinklogin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">로그인</a>

            <div class="dropdown-menu" style="width: 300px; height : 250px; padding: 15px; padding-bottom: 10px;">
                <form class="form-horizontal" method="post" accept-charset="UTF-8">
                  <a>아이디</a>
                  <input class="form-control login" type="text" id = "loginid" placeholder="Username.."><br>
                  <a>비밀번호</a>
                  <input class="form-control login" type="password" id="loginpassword" placeholder="Password.."><br>
                  <input class="btn btn-primary" type="button" name="submit" value="Login" id = "login">
                </form>
            </div>
        </li> -->
          
          
        </ul>
      </div>
      
      <button type="button" class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
        <i class="bi bi-search"></i>
      </button>
  </div>
</nav><!-- End Header/Navbar -->