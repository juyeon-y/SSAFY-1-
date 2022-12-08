
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
 /*
$(document).on("click", "#loginform", login);
$(document).on("click", "#logout", logout);
$(document).on("click", "#joinform", regist);

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
	} else {
		alert(data.msg);
	}
	window.location.href = "/HappyHouse";
}

async function regist() {
	let id = document.querySelector("#username").value;
	let pw = document.querySelector("#password").value;
	let cpw = document.querySelector("#cpassword").value;
	let email = document.querySelector("#email").value;

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
	}
	if (pw == cpw) {
		let data = JSON.stringify({ sign: "joinMember", id, pw, email });
		data = await fetch("../member", { method: "POST", body: data });
		data = await data.text();
		data = JSON.parse(data);
		console.log(data);
		alert(data.msg);
		window.close();
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
*/