<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="./include/head.jsp" %>
</head>

<body>
<%@ include file="./include/nav.jsp" %>


<main id="main"> <!-- ======= Services Section ======= -->

    <section class="section-services section-t8" style="margin: 100px;">
        <div id="notice-div">

            <div layout:fragment="content">
                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                    </section>

                    <!-- Main content -->
                    <section class="content container-fluid">


                        <div class="box box-primary">
                            <!-- form start -->
                            <form role="form" method="post">
                                <input type="hidden" name="code" value="${board.code}">
                                <div class="box-body" th:object="${board}">
                                    <div class="form-group">
                                        <label for="InputBoardTitle">Title</label> <textarea
                                            th:field=${board.title } type="text" class="form-control"
                                            id="InputBoardTitle"  name="title"
                                            rows="1">${board.title} </textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Content</label>
                                        <textarea th:th:field=${board.content } class="form-control" name="content"
                                                  rows="3">${board.content } </textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="InputBoardWriter">Writer</label> <input readonly
                                                                                            th:field=${board.writer } type="text"
                                                                                            class="form-control"
                                                                                            id="InputBoardWriter"
                                                                                            name="writer"
                                                                                            value=${board.writer }>
                                    </div>
                                </div>
                                <!-- /.box-body -->

                                <div class="box-footer" style="margin : 20px">
                                    <button type="submit" class="btn" style="background-color : #2eca6a">수정 </button>
                                    <button type="button" class="btn" style="background-color : gray" onclick="location.href='/board/delete/${board.code}'">삭제</button>
                                </div>

                            </form>
                            <%--							<form>--%>
                            <%--								<input type ="hidden" name ="sign" value = "boarddelete">--%>
                            <%--								<input type = "hidden" name = idx value = ${board.idx }>--%>
                            <%--								<button type = "submit" class="btn" style = "background-color : orange">삭제</button>--%>
                            <%--								</form>--%>
                        </div>
                        <!-- /.box -->

                    </section>
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->
            </div>

        </div>
    </section>
    <!-- End Services Section --> <!-- End Contact Single--> </main>
<!-- End #main -->

<%@ include file="./include/footer.jsp" %>
<script src="assets/js/apt.js"></script>

</body>

</html>