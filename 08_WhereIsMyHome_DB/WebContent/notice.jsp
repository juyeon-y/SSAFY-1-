<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="/include/head.jsp"%>
</head>

<body>
	<%@ include file="/include/nav.jsp"%>



	<main id="main"> <!-- ======= Services Section ======= -->

	<section class="section-services section-t8" style="margin: 100px;">
		<div id="notice-div">

			<div class="container">
				<div class="row">
					<div class="col">
						<div class="title-wrap d-flex justify-content-between">
							<div class="title-box">
								<h2 class="title-a">Notice</h2>
							</div>
						</div>
					</div>
				</div>
				<div id="searchForm" method="post" class="sib-frm-search">

					<form>
					<input type = "hidden" name = "sign" value = "searchNotice">
						<input type="text" id="str" name="str"> 
						<input type="submit" value="검색">

					</form>

				</div>
				<div class="row">
					<table class="table table-hover text-center">
						<tr>
							<th>글 번호</th>
							<th>제목</th>
							<th>조회수</th>
							<th>등록일</th>
							<c:if test="${loginId eq 'admin'}">
								<th>관리자</th>
							</c:if>
						</tr>
			
						<c:forEach items="${notices }" var="notice">

							<tr>
								<td>${notice.idx }</td>
								<td><a href="board?sign=mvboardview&idx=${notice.idx}">${notice.title }</a></td>
								<td>${notice.hits }</td>
								<td>${notice.date }</td>
								<c:if test="${loginId eq 'admin'}">
									<td><a href="board?sign=mvboardedit&idx=${notice.idx }">수정</a>
									<td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>

				<form>
					<c:if test="${loginId eq 'admin'}">
					<input type = "hidden" name = "sign" value ="mvboardwrite">
						<input type="submit" value="글쓰기">
					</c:if>
				</form>
			</div>
		</div>
	</section>
	
	
	
	<!-- ======= Services Section =======>

	<section class="section-services section-t8">
		<div id="notice-div">

			<div class="container">

				<div class="card">
					<div class="card-body">

						<div id="searchForm" method="post" class="sib-frm-search">

							<form>
								<h5 class="card-title">Notice</h5>

								<input type="text" id="searchNotice"> <input
									type="submit" value="검색">

								<c:if test="${loginId eq 'admin'}">
									<input type="submit" value="글쓰기">
								</c:if>

							</form>

						</div>



						<div class="accordion" id="accordionExample">
							<c:forEach items="${notices }" var="notice">
								<div class="accordion-item">
									<h2 class="accordion-header" id="headingOne">
										<button class="accordion-button" type="button"
											data-bs-toggle="collapse" data-bs-target="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">
											<a href="board?sign=mvboardview&idx=${notice.idx}">${notice.title }</a>
										</button>
									</h2>
									<div id="collapseOne" class="accordion-collapse collapse show"
										aria-labelledby="headingOne"
										data-bs-parent="#accordionExample">
										<div class="accordion-body">
											${notice.contents }<br /> <strong>${notice.date }</strong>
											<c:if test="${loginId eq 'admin'}">
												<td><a href="board?sign=mvboardedit&idx=${notice.idx }">수정</a>
												<td>
											</c:if>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section-->
	<!-- ///////////////// --> <!-- End Services Section --> <!-- End Contact Single-->
	<!-- End Services Section --> <!-- End Contact Single--> </main>
	<!-- End #main -->

	<%@ include file="/include/footer.jsp"%>
	<script src="assets/js/apt.js"></script>

</body>

</html>