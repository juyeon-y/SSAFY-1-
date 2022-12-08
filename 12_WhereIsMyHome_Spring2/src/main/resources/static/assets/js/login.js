/*
function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	//return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1) );
	return "111111";
};
*/

$(document).ready(function () {
    $.get("/map/sido"
        , function (data, status) {
            $.each(data, function (index, vo) {
                $("#loginsido").append("<option>" + vo.sidoName + "</option>");
            });
        }
        , "json"
    );
});

$(document).on("change", "#loginsido", function () {
    $.post("/map/gugun"
        , { sido: $("#loginsido").val()}
        , function (data, status) {
            $("#logingugun").empty();
            $("#logingugun").append('<option value="0">선택</option>');
            $.each(data, function (index, vo) {
                $("#logingugun").append("<option>" + vo.gugunName + "</option>");
            });
        }
        , "json"
    );
});
$(document).on("change", "#logingugun", function () {
    $.post("/map/dong"
        , { gugun: $("#logingugun").val()}
        , function (data, status) {
            $("#logindong").empty();
            $("#logindong").append('<option value="0">선택</option>');
            $.each(data, function (index, vo) {
                $("#logindong").append("<option>" + vo.dongName + "</option>");
            });
        }
        , "json"
    );
});
