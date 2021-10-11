<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%--    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>--%>
    <%--    <meta charset="utf-8"/>--%>
    <%--    --%>

    <%--    <meta name="description" content="overview &amp; stats"/>--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>--%>
    <title>List News - Ace Admin</title>

    <%--        <script>--%>
    <%--            // get value select option--%>
    <%--            function myNewFunction(sel) {--%>
    <%--                alert(sel.options[sel.selectedIndex].text);--%>
    <%--                document.getElementById("inputdata").value = sel.options[sel.selectedIndex].text;--%>
    <%--            }--%>
    <%--        </script>--%>
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

            <h3>Edit User</h3>

            <form action="<c:url value='/admin-user'/> " method="POST">

                <!-- Hidden parameter-->
                <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input type="hidden" id="id" value="${model.getId()}" name="id"
                                   class="form-control"
                                   placeholder="roleCode"/>
<%--                            <i class="ace-icon fa fa-lock"></i>--%>
                        </span>
                </label>
                <!-- ====================================-->
                <!-- ================= FORM DATA ===================-->
                <fieldset>
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" value="${model.getUserName()}" id="name"
                                                                   name="userName"
                                                                   class="form-control"
                                                                   placeholder="Username"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" value="${model.getPassword()}"
                                                                   id="password" name="password"
                                                                   class="form-control"
                                                                   placeholder="Password"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>

                    </label>
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="hidden" id="oldrolecode" name="oldrolecode"
                                                                   value="${model.getRoleCode()}" class="form-control" />
															<i class="ace-icon fa fa-adjust"></i>
														</span>
                    </label>
                    <label for="box1">Current roles: </label>
                    <!-- load from db-->
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="listOldRoleCode" name="listOldRoleCode"
                                                                   value="${model.getRoleCode()}" class="form-control" disabled />
															<i class="ace-icon fa fa-adjust"></i>
														</span>
                    </label>

                    <label for="box1">Select roles:</label>
                    <select id="box1" onChange="myNewFunction(this);">
                        <option disabled selected value> -- select an option -- </option>
                        <option>see-posts</option>
                        <option>add-post</option>
                        <option>delete-post</option>
                        <option>edit-post</option>
                        <option>see-users</option>
                        <option>add-user</option>
                        <option>delete-user</option>
                        <option>edit-user</option>
                        <option>set-role</option>
                    </select>
<%--                    <label>roles server: </label><input name="demorole" id="demorole"> </input>--%>
                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input type="hidden" id="roleCode" name="roleCode"
                                   class="form-control"
                                   placeholder="roleCode"/>
<%--                            <i class="ace-icon fa fa-lock"></i>--%>
                        </span>
                    </label>
<%--                    <c:set var="roleStr" value="${model.getRoleCode()}"/>--%>
<%--                    <c:set var="listRole" value="${fn:split(roleStr, ',')}" />--%>
<%--                    <label>String role:  ${roleStr}</label>--%>
<%--                    <label>array role: ${listRole}</label>--%>


<%--                    <c:set var="roleCode" value="${param.roleCode}" />--%>
<%--                    <label>role code: ${roleCode}</label>--%>
<%--                    <c:set var="userName" value="${param.userName}" />--%>
<%--                    <label>user name: ${userName}</label>--%>
<%--                    <c:out value="le quang nhu" />--%>
<%--                    <h2>password: <c:out value="${param.password}"/></h2>--%>


                    <label for="actionSelect">Select Action:</label>
                    <select id="actionSelect" onChange="myNewFunction4(this);">
                        <option disabled selected value> -- select an option -- </option>
                        <option id="add">Add Role</option>
                        <option id="delete">Delete Role</option>
                    </select>
                    <input type="hidden" name="actionData" id="actionData"/>
                    <p><label for="box1">Current roles Updated: </label></p>

<%--                    <input style="width: 700px" type="text" id="roleUpdate" name="roleupdate" value="${model.getRoleCode()}" disabled/>--%>
                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="roleUpdate" name="roleUpdate"
                                                                   value="${model.getRoleCode()}" class="form-control" disabled />
															<i class="ace-icon fa fa-adjust"></i>
														</span>
                    </label>
                    <%--                    <input type="text" name="roleCode" id="rcode" disabled/>--%>
                    <div class="space"></div>
                    <div class="clearfix">
                        <label class="inline">
                            <input type="checkbox" class="ace"/>
                            <span class="lbl"> Remember Me</span>
                        </label>
                        <input type="hidden" value="update-user" name="action"/>

                        <button style="text-align: center" type="submit"
                                class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>

                            <span class="bigger-110">Update</span>
                        </button>

                    </div>
                    <div class="space-4"></div>
                </fieldset>
            </form>

            <%--            <!--FORM SEND data TO server-->--%>
            <%--            <form action="<c:url value='/admin-user'/>" method="get">--%>
            <%--                <input type="hidden" name="action" value="update-user" />--%>
            <%--                <div class="form-group">--%>
            <%--                    <input type="hidden" name="id" id="id2" value="${model.getId()}" disabled/>--%>
            <%--                    <p><label>User Name:</label></p>--%>
            <%--                    <input type="text" class="form-control" name="userName" id="username" value="${model.getUserName()}" disabled>--%>
            <%--                </div>--%>
            <%--                <div class="form-group">--%>
            <%--                    <label for="psw">Password:</label>--%>
            <%--                    <input type="password" class="form-control" name="password" id="psw" value="${model.getPassword()}">--%>
            <%--                </div>--%>

            <%--                <label for="box1">Current roles: </label>--%>
            <%--                <!-- load from db-->--%>

            <%--                <td><h4 style="color:blue">${model.getRoleCode()}</h4></td>--%>

            <%--                <div class="form-group">--%>
            <%--                    <label for="box1">Select roles:</label>--%>
            <%--                    <select id="box1" onChange="myNewFunction(this);">--%>
            <%--                        <option>add-post</option>--%>
            <%--                        <option>delete-post</option>--%>
            <%--                        <option>edit-post</option>--%>
            <%--                        <option>add-user</option>--%>
            <%--                        <option>delete-user</option>--%>
            <%--                        <option>edit-user</option>--%>
            <%--                        <option>set-role</option>--%>
            <%--                    </select>--%>
            <!-- show data checked-->
            <%--                    <input type="text" name="roleCode" id="rcode" disabled/>--%>
            <%--                </div>--%>
            <%--                <input type="text" name="role" value=""/>--%>
            <%--                <div class="checkbox">--%>
            <%--                    <label><input type="checkbox"> Remember me</label>--%>
            <%--                </div>--%>
            <%--&lt;%&ndash;                <c:url var="editURL" value="/admin-user">&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    <c:param name="type" value="edit"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    <c:param name="id" value="${model.id}"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                </c:url>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"&ndash;%&gt;--%>
            <%--&lt;%&ndash;                   title="cập nhật bài viết" href="${editURL}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>&ndash;%&gt;--%>

            <%--&lt;%&ndash;                </a>&ndash;%&gt;--%>

            <%--                <button type="submit" class="btn btn-default">Confirm</button>--%>

            <%--            </form>--%>

            <!--######################################-->
        </div><!-- /.row -->
        <%--        </div><!-- /.page-content -->--%>
        <%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
    </div><!-- /.main-content -->


</div><!-- /.main-container -->


</body>
<%--<script>--%>
<%--    // get value select option--%>
<%--    function myNewFunction(sel) {--%>
<%--        alert(sel.options[sel.selectedIndex].text);--%>
<%--        document.getElementById("inputdata").value = sel.options[sel.selectedIndex].text;--%>
<%--    }--%>
<%--</script>--%>
</html>