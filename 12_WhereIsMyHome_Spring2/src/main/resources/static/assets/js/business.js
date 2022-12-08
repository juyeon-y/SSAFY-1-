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

function makeList(dList) {
  let list = dList;
  
  list.forEach((l) => {
    var coords = new kakao.maps.LatLng(l[1], l[0]);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
       	map: map,
       	position: coords,
     });

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
     map.setCenter(coords);
    
    let tr = document.createElement("tr");
    tr.addEventListener("click", function () {
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new kakao.maps.LatLng(lat, lng);

      // 지도의 레벨 변경.
      map.setLevel(2);
      // 지도 중심을 이동 시킵니다
      map.setCenter(moveLatLon);
    });

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
  });
}
