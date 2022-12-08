function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1) );
};

$(document).ready(function () {
    $.get(getContextPath() + "/map"
    	, {sign : "sido"}
        , function (data, status) {
            $.each(data.sidoList, function (index, vo) {
                $("#loginsido").append("<option>" + vo.sidoName + "</option>");
            });
        }
        , "json"
    );
});

$(document).on("change", "#loginsido", function () {
    $.get(getContextPath() + "/map"
        , { sido: $("#loginsido").val(), 
    		sign : "gugun"}
        , function (data, status) {
            $("#logingugun").empty();
            $("#logingugun").append('<option value="0">선택</option>');
            $.each(data.gugunList, function (index, vo) {
                $("#logingugun").append("<option>" + vo.gugunName + "</option>");
            });
        }
        , "json"
    );
});
$(document).on("change", "#logingugun", function () {
    $.get(getContextPath() + "/map"
        , { gugun: $("#logingugun").val(),
    		sign : "dong"}
        , function (data, status) {
            $("#logindong").empty();
            $("#logindong").append('<option value="0">선택</option>');
            $.each(data.dongList, function (index, vo) {
                $("#logindong").append("<option>" + vo.dongName + "</option>");
            });
        }
        , "json"
    );
});