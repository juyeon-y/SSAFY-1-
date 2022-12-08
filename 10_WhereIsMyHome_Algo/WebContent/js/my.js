window.onload = function() {
	let loginId = $.cookie("loginId");
	if(loginId) {
		login(loginId);
	}
}

$(document).on("click", "#loginBtn", login);
$(document).on("click", "#logoutBtn", logout);
$(document).on("click", "#memberInsertBtn", memberInsert);
$(document).on("change", "#sido", getGugun);
$(document).on("change", "#gugun", getDong);
$(document).on("change","#dong",selectDong);
$(document).on("change","#year",selectYear);
$(document).on("change","#month",selectMonth);
$(document).on("click","#houseDealInfoBtn",getHouseDealInfo);

let isUseId = false;
$(document).on("keyup","#mid",idCheck);

async function idCheck() {
    let id = $("#mid").val();
    let resultDiv = document.querySelector("#idcheck-result");
    let data = JSON.stringify({sign:"idcheck", id});
        data = await fetch("../main", {method: "post", body: data});
        data = await data.text();
        data = JSON.parse(data);
        if (data.cnt == 0) {
            resultDiv.setAttribute("class", "mb-3 text-primary");
            resultDiv.textContent = id + "는 사용할 수 있습니다.";
            isUseId = true;
        } else {
            resultDiv.setAttribute("class", "mb-3 text-danger");
            resultDiv.textContent = id + "는 사용할 수 없습니다.";
            isUseId = false;
        }
    }

async function getHouseDealInfo() {	
	console.log(sido,gugun,dong,year,month);
	if (sido==undefined || gugun==undefined || dong==undefined || year==undefined || month==undefined) {	
		alert("검색 조건을 모두 선택해 주세요");
	}else{
		let data = JSON.stringify({ sign: "getHouseDealInfo", sido,gugun,dong,year,month});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let houseDealInfoListTable=`  <table class="table table-hover">
								    <thead>
								      <tr>
								        <th>no</th>
								        <th>dong</th>
								        <th>roadName</th>
								        <th>apartmentName</th>
								        <th>floor</th>
								        <th>area</th>
								        <th>dealAmount</th>
								      </tr>
								    </thead><tbody>`;
		data.houseDealInfoList.forEach(function (item, index) {
			item=JSON.parse(item);
			houseDealInfoListTable += `<tr onclick="alert(${item.lat}+':'+${item.lng})">
								        <th>${item.no}</th>
								        <th>${item.dong}</th>
								        <th>${item.roadName}</th>
								        <th>${item.apartmentName}</th>
								        <th>${item.floor}</th>
								        <th>${item.area}</th>
								        <th>${item.dealAmount}</th>
								      </tr>`;
		});
		
		houseDealInfoListTable += `</tbody></table>`;

		$("#contentTopDiv").html(houseDealInfoListTable);		 
		
	} 
}



let month;
function selectMonth() {
	month=$("#month option:selected").val();
}

let year;
function selectYear() {
	year=$("#year option:selected").val();
}

let dong;
function selectDong() {
	dong=$("#dong option:selected").val();
}

let gugun;
async function getDong() {
	gugun=$("#gugun option:selected").val();
//	alert(gugun);
	
	if (gugun !== "구군") {	
		let data = JSON.stringify({ sign: "getDong", sido, gugun});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">동</option>`;
		data.dongList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#dong").html(options);		 
		
	} 
}

let sido;
async function getGugun() {
	sido=$("#sido option:selected").val();
//	alert(sido);
	
	if (sido.length>2) {	
		let data = JSON.stringify({ sign: "getGugun", sido});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">구군</option>`;
		data.gugunList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#gugun").html(options);		 
		
	} 
}

async function memberInsert() {
	let data;
	let id = $("#mid").val();
	let pw = $("#mpw").val();
	let name = $("#name").val();
	data = JSON.stringify({sign:"memberInsert", id, pw, name});
	console.log(data);

	data = await fetch("../main", {method:"POST", body:data});
	console.log(data);
	data = await data.text();
	console.log(data);
	data = JSON.parse(data);
	console.log(data);
	alert(data.msg);
	if(data.flag) {
		window.close();
	}
}

async function logout() {
	data = JSON.stringify({sign:"logout"});
	data = await fetch("main", {method:"POST", body:data});
	$.removeCookie("loginId");
	location.reload();
}

async function login(id) {
	let data;
	if(typeof id == "string") {
		data = JSON.stringify({sign:"login", id});
	} else {
		let id = $("#id").val();
		let pw = $("#pw").val();
		data = JSON.stringify({sign:"login", id, pw});
	}
	console.log(data);
	
	data = await fetch("main", {method:"POST", body:data});
	console.log(data);
	data = await data.text();
	console.log(data);
	data = JSON.parse(data);
	console.log(data);
	if(data.loginId) {
		$.cookie("loginId", data.loginId);
		$("#loginDiv").html(`<div class="text-white"> ${data.loginId}님 환영합니다. <button class="btn btn-primary" type="button" id="logoutBtn">Logout</button></div>`);
	} else {
		alert(data.msg);
		$.removeCookie("loginId");
	}
}