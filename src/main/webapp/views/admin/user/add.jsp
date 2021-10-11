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
            <!--    WRITE CODE BELOW-->
            <form action="/action_page.php">
                <div class="form-group">
                    <label>User address:</label>
                    <input type="text" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd">
                </div>
                <div class="form-group">
                    <label for="sel1">Select roles:</label>
                    <select class="form-control" id="sel1">
                        <option>add-post</option>
                        <option>delete-post</option>
                        <option>edit-post</option>
                        <option>add-user</option>
                        <option>delete-user</option>
                        <option>edit-user</option>
                        <option>set-role</option>
                    </select>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>

            </form>

            <!--######################################-->
        </div><!-- /.row -->
        <%--        </div><!-- /.page-content -->--%>
        <%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
    </div><!-- /.main-content -->


</div><!-- /.main-container -->


</body>

</html>