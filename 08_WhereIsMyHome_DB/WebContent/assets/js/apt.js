let date = new Date();

function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1) );
};

window.onload = function () {
  

  let yearEl = document.querySelector("#year");
  let yearOpt = `<option value="">매매년도선택</option>`;
  let year = date.getFullYear();
  for (let i = year; i > year - 20; i--) {
    yearOpt += `<option value="${i}">${i}년</option>`;
  }
  yearEl.innerHTML = yearOpt;

  // 브라우저가 열리면 시도정보 얻기.
  //sendRequest("sido", "*00000000");
  document.getElementById("aptlist-div").style.display = "none";
  
  
/*
  // alert(sessionStorage.getItem("userid"));
  if (sessionStorage.getItem("userid") == null) {
    document.getElementById("logout").style.display = "none";
    document.getElementById("userInfo").style.display = "none";

    document.getElementById("join").style.display = "block";
    // document.getElementById("login").style.display = "none";
    
  } else {
    document.getElementById("logout").style.display = "block";
    document.getElementById("userInfo").style.display = "block";

    document.getElementById("join").style.display = "none";
    // document.getElementById("login").style.display = "none";
  }
  */
};

document.querySelector("#year").addEventListener("change", function () {
  let month = date.getMonth() + 1;
  let monthEl = document.querySelector("#month");
  let monthOpt = `<option value="">매매월선택</option>`;
  let yearSel = document.querySelector("#year");
  let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
  for (let i = 1; i < m; i++) {
    monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
  }
  monthEl.innerHTML = monthOpt;

});

// https://juso.dev/docs/reg-code-api/
// let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
// let regcode = "*00000000";
// 전국 특별/광역시, 도
// https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000
$(document).ready(function () {
    $.get(getContextPath() + "/map"
    	, {sign : "sido"}
        , function (data, status) {
            $.each(data.sidoList, function (index, vo) {
                $("#sido").append("<option>" + vo.sidoName + "</option>");
            });
        }
        , "json"
    );
});

$(document).on("change", "#sido", function () {
    $.get(getContextPath() + "/map"
        , { sido: $("#sido").val(), 
    		sign : "gugun"}
        , function (data, status) {
            $("#gugun").empty();
            $("#gugun").append('<option value="0">선택</option>');
            $.each(data.gugunList, function (index, vo) {
                $("#gugun").append("<option>" + vo.gugunName + "</option>");
            });
        }
        , "json"
    );
});
$(document).on("change", "#gugun", function () {
    $.get(getContextPath() + "/map"
        , { gugun: $("#gugun").val(),
    		sign : "dong"}
        , function (data, status) {
            $("#dong").empty();
            $("#dong").append('<option value="0">선택</option>');
            $.each(data.dongList, function (index, vo) {
                $("#dong").append("<option>" + vo.dongName + "</option>");
            });
        }
        , "json"
    );
});
/*
$(document).on("change", "#dong", function () {
    
});

// 시도가 바뀌면 구군정보 얻기.
document.querySelector("#sido").addEventListener("change", function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
    sendRequest("gugun", regcode);
  } else {
    initOption("gugun");
    initOption("dong");
  }
});

// 구군이 바뀌면 동정보 얻기.
document.querySelector("#gugun").addEventListener("change", function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
    sendRequest("dong", regcode);
  } else {
    initOption("dong");
  }
});


function sendRequest(selid, regcode) {
  const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
  let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
  fetch(`${url}?${params}`)
    .then((response) => response.json())
    .then((data) => addOption(selid, data));
}

function addOption(selid, data) {
  let opt = ``;
  initOption(selid);
  switch (selid) {
    case "sido":
      opt += `<option value="">시도선택</option>`;
      data.regcodes.forEach(function (regcode) {
        opt += `
        <option value="${regcode.code}">${regcode.name}</option>
        `;
      });
      break;
    case "gugun":
      opt += `<option value="">구군선택</option>`;
      for (let i = 0; i < data.regcodes.length; i++) {
        if (i != data.regcodes.length - 1) {
          if (
            data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
            data.regcodes[i].name.split(" ").length != data.regcodes[i + 1].name.split(" ").length
          ) {
            data.regcodes.splice(i, 1);
            i--;
          }
        }
      }
      let name = "";
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
        else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
        opt += `
        <option value="${regcode.code}">${name}</option>
        `;
      });
      break;
    case "dong":
      opt += `<option value="">동선택</option>`;
      let idx = 2;
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length != 3) idx = 3;
        opt += `
        <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
        `;
      });
  }
  document.querySelector(`#${selid}`).innerHTML = opt;
}
*/

function initOption(selid) {
  let options = document.querySelector(`#${selid}`);
  options.length = 0;
}

document.querySelector("#search").addEventListener("click", function () {
  document.getElementById("introimg").style.display = "none";
  document.getElementById("aptlist-div").style.display = "block";
  
  $.get(getContextPath() + "/map"
	        , { sido: $("#sido").val(),
	    		gugun: $("#gugun").val(),
	    		dong: $("#dong").val(),
	    		year: $("#year").val(),
	    		month: $("#month").val(),
	    		sign : "apt"}
	        , function (data, status) {
	        	makeList(data);
	        }
	        , "json"
	    );
});

///////
var mapContainer = document.getElementById("map"), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 6, // 지도의 확대 레벨
  };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
////////////

function makeList(data) {
  document.querySelector("table").setAttribute("style", "display: ;");
  let tbody = document.querySelector("#aptlist");
  initTable();
  let apts = data.houseList;
  apts.forEach((apt) => {
    let address =
      apt.roadName +
      " " +
      apt.roadNameBonBun;
    let aptName = apt.apartmentName;
    var geocoder = new kakao.maps.services.Geocoder();

    let lat = 0;
    let lng = 0;
    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(address, function (result, status) {
      // 정상적으로 검색이 완료됐으면
      if (status === kakao.maps.services.Status.OK) {
        lat = result[0].y;
        lng = result[0].x;

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
          map: map,
          position: coords,
        });

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
      }
    });
    let tr = document.createElement("tr");
    tr.addEventListener("click", function () {
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new kakao.maps.LatLng(lat, lng);

      // 지도의 레벨 변경.
      map.setLevel(2);
      // 지도 중심을 이동 시킵니다
      map.setCenter(moveLatLon);
    });

    let nameTd = document.createElement("td");
    nameTd.appendChild(document.createTextNode(apt.apartmentName));
    tr.appendChild(nameTd);

    let floorTd = document.createElement("td");
    floorTd.appendChild(document.createTextNode(apt.floor));
    tr.appendChild(floorTd);

    let areaTd = document.createElement("td");
    areaTd.appendChild(document.createTextNode(apt.area));
    tr.appendChild(areaTd);

    let dongTd = document.createElement("td");
    dongTd.appendChild(document.createTextNode(apt.dong));
    tr.appendChild(dongTd);

    let priceTd = document.createElement("td");
    priceTd.appendChild(
      document.createTextNode(apt.dealAmount + "만원")
    );
    priceTd.classList.add("text-end");
    tr.appendChild(priceTd);

    tbody.appendChild(tr);

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
  });
}

function initTable() {
  let tbody = document.querySelector("#aptlist");
  let len = tbody.rows.length;
  for (let i = len - 1; i >= 0; i--) {
    tbody.deleteRow(i);
  }
}
