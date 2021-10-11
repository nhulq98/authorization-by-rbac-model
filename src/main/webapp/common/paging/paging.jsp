<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <!-- Load library Paging -->
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">--%>
<%--    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>--%>
<%--    <script src="<c:url value="/template/paging/jquery.twbsPagination.js"/>" type="text/javascript"></script>--%>
    <!-- ///////////////////////////////////// -->

</head>
<body>

<!--Show paging-->
<div class="main-content">
<form action="<c:url value="/admin-new"/>" id="formSubmit" method="get">
    <ul class="pagination" id="pagination"></ul>
    <input type="hidden" value="" id="page" name="page">
    <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
</form>
</div>
<!-- Load JQuery Paging-->
<script type="text/javascript">
    var currentPage = ${model.page};
    var totalPages = ${model.totalPages};
    <%--var visiblePages = ${model.maxPageItem};--%>
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 2,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#page').val(page);// set value for input form
                    $('#maxPageItem').val(limit);
                    $('#formSubmit').submit();
                }
                //console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>

</body>
</html>
