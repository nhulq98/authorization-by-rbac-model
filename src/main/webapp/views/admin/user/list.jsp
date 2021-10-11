<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>--%>
<%--    <meta charset="utf-8"/>--%>
<%--    --%>

<%--    <meta name="description" content="overview &amp; stats"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>--%>
    <title>List News - Ace Admin</title>
</head>

<body class="no-skin">

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
            								<span class="input-icon">
            									<input type="text" placeholder="Search ..." class="nav-search-input"
                                                       id="nav-search-input" autocomplete="off"/>
            									<i class="ace-icon fa fa-search nav-search-icon"></i>
            								</span>
                    </form>
                </div><!-- /.nav-search -->
            </div>
            <table>
                <tr>
                    <th>User Name</th>
                    <th>status</th>
                    <th>Role</th>
                    <th>Created Date</th>
                    <th>Modified Date</th>
                    <th>Create By</th>
                    <th>Modified By</th>

                </tr>
                <c:forEach var="item" items="${model}">
                    <tr>
                        <td>${item.getUserName()}</td>
                        <td>${item.getStatus()}</td>
                        <td>${item.getRoleCode()}</td>
                        <td>${item.getCreatedDate()}</td>
                        <td>${item.getModifiedDate()}</td>
                        <td>${item.getCreatedBy()}</td>
                        <td>${item.getModifiedBy()}</td>

                        <td>
<%--                            <button onclick="window.location.href='#'" type="button" class="btn btn-success">add</button>--%>
<%--                            <button onclick="window.location.href='#'" class="btn"><a href="<c:url value="/admin-user?action=edit-user"/>" class="fa fa-edit"></a></button>--%>


                                <form action="<c:url value="/admin-user?action=edit-user"/>" method="POST">
                                    <input type="hidden" name="action" id="action" value="edit-user" />
                                    <input type="hidden" name="id" id="id" value="<c:url value="${item.getId()}"/>" />
                                    <button type="submit" class="btn"><a class="fa fa-edit"></a></button>
                                </form>
                                <form action="<c:url value="/admin-user?action=delete-user"/>" method="POST">
                                    <input type="hidden" name="action2" id="action2" value="delete-user" />
                                    <input type="hidden" name="id2" id="id2" value="<c:url value="${item.getId()}"/>" />
                                    <button type="submit" class="btn"><a class="fa fa-trash"></a></button>
                                </form>


                        </td>
                    </tr>
                </c:forEach>
            </table>
            <!--Show paging-->
            <div class="main-content">
                <form action="<c:url value="/admin-new"/>" id="formSubmit" method="get">
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page">
                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                </form>
            </div>
            <!--Show PAGING-->
<%--            <%@include file="/common/paging/paging.jsp" %>--%>

            <%--        <div class="page-content">--%>
            <%--                <div class="ace-settings-container" id="ace-settings-container">--%>
            <%--                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">--%>
            <%--                        <i class="ace-icon fa fa-cog bigger-130"></i>--%>
            <%--                    </div>--%>

            <%--                <!-- PAGE CONTENT ENDS -->--%>
        </div><!-- /.row -->
        <%--        </div><!-- /.page-content -->--%>
        <%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
    </div><!-- /.main-content -->


</div><!-- /.main-container -->

<%--<script type="text/javascript">--%>
<%--    var currentPage = ${model.page};--%>
<%--    var totalPages = ${model.totalPages};--%>
<%--    &lt;%&ndash;var visiblePages = ${model.maxPageItem};&ndash;%&gt;--%>
<%--    var limit = 2;--%>
<%--    $(function () {--%>
<%--        window.pagObj = $('#pagination').twbsPagination({--%>
<%--            totalPages: totalPages,--%>
<%--            visiblePages: 2,--%>
<%--            startPage: currentPage,--%>
<%--            onPageClick: function (event, page) {--%>
<%--                if (currentPage != page) {--%>
<%--                    $('#page').val(page);// set value for input form--%>
<%--                    $('#maxPageItem').val(limit);--%>
<%--                    $('#formSubmit').submit();--%>
<%--                }--%>
<%--                //console.info(page + ' (from options)');--%>
<%--            }--%>
<%--        }).on('page', function (event, page) {--%>
<%--            console.info(page + ' (from event listening)');--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

</body>

</html>
