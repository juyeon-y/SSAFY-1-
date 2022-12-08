$(document).ready(function () {
  // let userid=localStorage.setItem("userid", getId);
  // if (userid != "null") {
  //   alert("이미 로그인 되었습니다");
  //   location.href = "index.html";
  // }

  
  let userid = sessionStorage.getItem("id");
  // // let userpass = sessionStorage.getItem("pass");//값 가져올 수 있지만.. 일단 보안상 화면에 띄우지는 않음.... (아예 안넣어야하는데 구현 확인상)
  // // let useremail=document.getElementById("hiddenemail").value;

  $("#userinfo-id").text(userid);
  // // $("#userinfo-pass").text(userpass);
  // // $("#userinfo-email").text(useremail);

  // document.getElementById("infoedit-id").value = userid;
  // // document.getElementById("infoedit-email").value=useremail;


  var panelOne = $(".form-panel.two").height(),
    panelTwo = $(".form-panel.two")[0].scrollHeight;
  $(".form-panel.two")
    .not(".form-panel.two.active")
    .on("click", function (e) {
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
    
  $(".form-toggle").on("click", function (e) {
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



document.querySelector("#loginform").addEventListener("click", function () {
  var id = sessionStorage.getItem("id");
  var password = sessionStorage.getItem("pass");

  var getId = document.getElementById("loginusername").value;
  var getPass = document.getElementById("loginpassword").value;

  if (id == getId && password == getPass) {
    alert("로그인 성공!!!");
    sessionStorage.setItem("userid", getId);
    sessionStorage.setItem("userpass", getPass);
    location.href = "index.html";
    // document.getElementById("logout").style.display = "block";
    // document.getElementById("userInfo").style.display = "block";

    // document.getElementById("join-dropdown").style.display = "none";
    // document.getElementById("login-dropdown").style.display = "none";
  } else {
    alert("로그인 실패");
  }
});

document.querySelector("#joinform").addEventListener("click", function () {
  
  var getId = document.getElementById("username").value;
  var getPass = document.getElementById("password").value;
  var getcPass = document.getElementById("cpassword").value;
  var getemail = document.getElementById("email").value;


  // localStorage.setItem("userid", getId);
  // localStorage.setItem("userpass", getPass);
  
  if (getId == "") {
    alert("이름을 입력해주세요");
  } else if (getPass == "") {
    alert("비밀번호를 입력해주세요");
  } else if (getcPass == "") {
    alert("비밀번호를 다시 입력해주세요");
  } else if (getPass != getcPass) {
    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
  } else if (getemail == "") {
    alert("이메일을 입력해주세요");
  } else {
    alert("환영합니다!" + getId + "님!");
    sessionStorage.setItem("userid", getId);
    sessionStorage.setItem("userpass", getPass);
    
    sessionStorage.setItem("id", getId);
    sessionStorage.setItem("pass", getPass);
    sessionStorage.setItem("email", getemail);
    // document.getElementById("hiddenemail").value = sessionStorage.getItem("email");
    location.href = "index.html";
  }
});
