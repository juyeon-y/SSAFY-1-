
$(document).ready(function(){
	selectAllBoard(1);
});

function selectAllBoard(pageNo){
	console.log(pageNo);
	let keyword = $("#searchKeyword").val();
	$.post('/board/selectAll',{pageNum:pageNo,pageSize:5,keyword},function(data){
		console.log(data);
		let board=`<center><table class="table table-hover"><tr><th>index</th><th>글번호</th><th>제목</th></tr>`;
		data.list.forEach(function(item,index){
			board += `<tr style="cursor: pointer" onclick="location.href='/board/${item.code}'"><td>${++index}</td><td>${item.code}</td><td>${item.title}</td></tr>`;
		});
		board += `</table><br>`;
if(data.hasPreviousPage) board+=`<a href="#" onclick="selectAllBoard(${data.prePage})"> << </a>`;
board+=`${data.pageNum}`;
if(data.hasNextPage) board+=`<a href="#" onclick="selectAllBoard(${data.nextPage})"> >> </a>`;
board+=`</center>`;
console.log(board);
$("#boardListDiv").html(board);
});
}
