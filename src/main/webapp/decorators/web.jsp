<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>News Home</title>
    <!---->
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="<c:url value="/views/script.js"/>"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/template/web/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/template/web/css/shop-homepage.css"/>" rel="stylesheet">

</head>

<body>
<!--INCLUDE HEADER-->
<%@include file="/common/web/Navigation.jsp" %>

<!-- Page Content -->
<%--<div class="container">--%>

<%--    <div class="row">--%>

<%--        <div class="col-lg-3">--%>

<%--            <h1 class="my-4">NEWS HOT</h1>--%>
<%--            <div class="list-group">--%>
<%--                <!--  Load Category -->--%>

<%--                <c:forEach var="i" begin="0" end="3">--%>
<%--                    <a href="#" class="list-group-item">${categoryModels.get(i).getName()}</a>--%>
<%--                </c:forEach>--%>
<%--                &lt;%&ndash;                <c:forEach var = "i" begin = "0" end = "3">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="#" class="list-group-item">${newsModels.get(i).getTitle()}</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </c:forEach>&ndash;%&gt;--%>



<%--                <!-- <a href="#" class="list-group-item">thời sự</a>--%>
<%--                <a href="#" class="list-group-item">Category 2</a>--%>
<%--                <a href="#" class="list-group-item">Category 3</a> -->--%>
<%--            </div>--%>

<%--        </div>--%>
<%--        <!-- /.col-lg-3 -->--%>
<%--        <ul class="pagination" id="pagination"></ul>--%>

<%--        <div class="col-lg-9">--%>

<%--            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">--%>
<%--                <ol class="carousel-indicators">--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>--%>
<%--                </ol>--%>
<%--                <div class="carousel-inner" role="listbox">--%>
<%--                    <div class="carousel-item active">--%>
<%--                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">--%>
<%--                    </div>--%>
<%--                    <div class="carousel-item">--%>
<%--                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">--%>
<%--                    </div>--%>
<%--                    <div class="carousel-item">--%>
<%--                        <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">--%>
<%--                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--                    <span class="sr-only">Previous</span>--%>
<%--                </a>--%>
<%--                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">--%>
<%--                    <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--                    <span class="sr-only">Next</span>--%>
<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="row">--%>
<%--                <c:forEach var="i" begin="0" end="1">--%>
<%--                    <div class="col-lg-4 col-md-6 mb-4">--%>
<%--                        <div class="card h-100">--%>
<%--                            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>--%>
<%--                            <div class="card-body">--%>
<%--                                <h4 class="card-title">--%>
<%--                                    <a href="#">${newModels.get(i).getTitle()}</a>--%>
<%--                                </h4>--%>
<%--                                <h5>$24.99</h5>--%>
<%--                                <p class="card-text">${newModels.get(i).getShortDescription()}</p>--%>
<%--                            </div>--%>
<%--                            <div class="card-footer">--%>
<%--                                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>

<%--                --%>

<%--            </div>--%>
<%--            <!-- /.row -->--%>

<%--        </div>--%>
<%--        <!-- /.col-lg-9 -->--%>

<%--    </div>--%>
<%--    <!-- /.row -->--%>

<%--</div>--%>
<%--<!-- /.container -->--%>
<div class="container">
    <dec:body/>
</div>

<!--INCLUDE FOOTER-->
<%@include file="/common/web/footer.jsp" %>
<!-- Bootstrap core JavaScript -->

<script src="<c:url value="/template/web/jquery/jquery.min.js"/>"></script>

<script src="<c:url value="/template/web/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>

</body>

</html>
