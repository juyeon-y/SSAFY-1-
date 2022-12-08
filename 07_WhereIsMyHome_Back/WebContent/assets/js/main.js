/**
 * Template Name: EstateAgency - v4.8.0
 * Template URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
 * Author: BootstrapMade.com
 * License: https://bootstrapmade.com/license/
 */
let cookie_loginId = $.cookie("loginId"); // get method
if (cookie_loginId) {
	document.querySelector("#loginLi").innerHTML = "<li class='nav-item'><a class='nav-link ' id='logout'>로그아웃</a></li> <li class='nav-item'><a class='nav-link' id='userInfo'>회원정보</a></li>";
}

(function () {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim();
    if (all) {
      return [...document.querySelectorAll(el)];
    } else {
      return document.querySelector(el);
    }
  };

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all);
    if (selectEl) {
      if (all) {
        selectEl.forEach((e) => e.addEventListener(type, listener));
      } else {
        selectEl.addEventListener(type, listener);
      }
    }
  };

  /**
   * Easy on scroll event listener
   */
  const onscroll = (el, listener) => {
    el.addEventListener("scroll", listener);
  };

  /**
   * Toggle .navbar-reduce
   */
  let selectHNavbar = select(".navbar-default");
  if (selectHNavbar) {
    onscroll(document, () => {
      if (window.scrollY > 100) {
        selectHNavbar.classList.add("navbar-reduce");
        selectHNavbar.classList.remove("navbar-trans");
      } else {
        selectHNavbar.classList.remove("navbar-reduce");
        selectHNavbar.classList.add("navbar-trans");
      }
    });
  }

  /**
   * Back to top button
   */
  let backtotop = select(".back-to-top");
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add("active");
      } else {
        backtotop.classList.remove("active");
      }
    };
    window.addEventListener("load", toggleBacktotop);
    onscroll(document, toggleBacktotop);
  }

  /**
   * Preloader
   */
  let preloader = select("#preloader");
  if (preloader) {
    window.addEventListener("load", () => {
      preloader.remove();
    });
  }

  /**
   * Search window open/close
   */
  let body = select("body");
  on("click", ".navbar-toggle-box", function (e) {
    e.preventDefault();
    body.classList.add("box-collapse-open");
    body.classList.remove("box-collapse-closed");
  });

  on("click", ".close-box-collapse", function (e) {
    e.preventDefault();
    body.classList.remove("box-collapse-open");
    body.classList.add("box-collapse-closed");
  });

  /**
   * Intro Carousel
   */
  new Swiper(".intro-carousel", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 2000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".swiper-pagination",
      type: "bullets",
      clickable: true,
    },
  });

  /**
   * Property carousel
   */
  new Swiper("#property-carousel", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".propery-carousel-pagination",
      type: "bullets",
      clickable: true,
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20,
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20,
      },
    },
  });

  /**
   * News carousel
   */
  new Swiper("#news-carousel", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".news-carousel-pagination",
      type: "bullets",
      clickable: true,
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20,
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20,
      },
    },
  });

  /**
   * Testimonial carousel
   */
  new Swiper("#testimonial-carousel", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".testimonial-carousel-pagination",
      type: "bullets",
      clickable: true,
    },
  });

  /**
   * Property Single carousel
   */
  new Swiper("#property-single-carousel", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".property-single-carousel-pagination",
      type: "bullets",
      clickable: true,
    },
  });
})();

 $(document).ready(function() {
	var panelOne = $(".form-panel.two").height(),
		panelTwo = $(".form-panel.two")[0].scrollHeight;
	$(".form-panel.two")
		.not(".form-panel.two.active")
		.on("click", function(e) {
			e.preventDefault();
			$(".form-toggle").addClass("visible");
			$(".form-panel.one").addClass("hidden");
			$(".form-panel.two").addClass("active");
			$(".form").animate(
				{
					height: panelTwo,
				},
				200
			);
		});

	$(".form-toggle").on("click", function(e) {
		e.preventDefault();
		$(this).removeClass("visible");
		$(".form-panel.one").removeClass("hidden");
		$(".form-panel.two").removeClass("active");
		$(".form").animate(
			{
				height: panelOne,
			},
			200
		);
	});

});

// member.js
$(document).on("click", "#loginform", login);
$(document).on("click", "#logout", logout);
$(document).on("click", "#joinform", registMember);
$(document).on("click", "#userInfo", getMember);
$(document).on("click", "#updateform", updateMember);
$(document).on("click", "#deleteform", deleteMember);

async function login() {
	let id = document.querySelector("#loginusername").value;
	let pw = document.querySelector("#loginpassword").value;
	let data = JSON.stringify({sign:"login", id, pw});
	data = await fetch("member", {method: "POST", body: data});
	data = await data.text();
	data = JSON.parse(data);
	console.log(data);
	if (data.loginId) {
		$.cookie("loginId", data.loginId); // set method 
		document.querySelector("#loginLi").innerHTML = data.loginId + " <button id='logoutBtn'>logout</button>";
		window.location.href = ".";
	} else {
		alert(data.msg);
	}
}

function checkId(id) {
	if (id == "" || id == 'undefined') {
		alert("이름을 입력해주세요");
		return false;
	} 
	
	if (id.length < 4 || id.length > 10) {
		alert("아이디는 4 ~ 10자 이내로 입력 가능합니다.")
		return false;
	}
	return true;
}

function checkPwd(pw) {		
	if (pw == "" || pw == 'undefined') {
		alert("비밀번호를 입력해주세요");
		return false;
	} 
	
	if (pw.length < 6 || pw.length > 20) {
		alert("비밀번호는 6 ~ 20자 이내로 입력 가능합니다.")
		return false;
	}
	return true;
}

function checkEmail(email) {
	var r_email = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/; // 이메일 검사식

	if (email == "" || email == 'undefined') {
		alert("이메일을 입력해주세요");
		return false;
	}
	
	if (r_email.test(email) != true) {
		alert("이메일 형식으로 적어주세요");
		return false;
	} else return true;
}

async function registMember() {
	let id = document.querySelector("#username").value;
	let pw = document.querySelector("#password").value;
	let cpw = document.querySelector("#cpassword").value;
	let email = document.querySelector("#email").value;

	if (cpw == "" || cpw == 'undefined') {
		alert("비밀번호를 다시 입력해주세요");
		return;
	} else if (pw != cpw) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		return;
	}

	if (!checkId(id) || !checkPwd(pw) || !checkEmail(email)) return;
	
	if (pw == cpw) {
		let data = JSON.stringify({ sign: "joinMember", id, pw, email });
		data = await fetch("member", { method: "POST", body: data });
		data = await data.text();
		data = JSON.parse(data);
		console.log(data);
		alert(data.msg);
		window.location.href = "member?sign=mvjoin";
	} else {
		alert("비밀번호가 같지 않습니다.");
	}
}

async function logout() {
	let data = JSON.stringify({ sign: "logout" });
	data = await fetch("member", { method: "POST", body: data });
	$.removeCookie("loginId"); // cookie 삭제 
	location.reload();
}

async function getMember() {
	window.location.href = "member?sign=mvInfo";
}

async function updateMember() {
	let pw = document.querySelector("#infoedit-pass").value;
	let email = document.querySelector("#infoedit-email").value;

	if (!checkPwd(pw) || !checkEmail(email)) return;
	
	let data = JSON.stringify({ sign: "updateMember", pw, email });
	data = await fetch("member", { method: "POST", body: data });
	window.location.href = "member?sign=mvInfo";
}

async function deleteMember() {
	if(confirm("정말 삭제하시겠습니까?")) {
		let data = JSON.stringify({ sign: "deleteMember" });
		data = await fetch("member", { method: "POST", body: data });
		$.removeCookie("loginId"); // cookie 삭제 
		window.location.href = ".";
	}
}