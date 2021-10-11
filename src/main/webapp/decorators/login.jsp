<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Login Page - Ace Admin</title>

    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>


    <!-- Autho GOOGLE-->
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="<c:url value="/views/script.js"/>"></script>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/template/admin/login/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/fonts.googleapis.com.css"/>"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace.min.css"/>"/>

    <!--[if lte IE 9]>
			<link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-part2.min.css"/>" />

		<![endif]-->
    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-rtl.min.css"/>"/>

    <!--[if lte IE 9]>
		  <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-ie.min.css"/>" />

		<![endif]-->

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
		<script src="<c:url value="/template/admin/login/assets/js/html5shiv.min.js"/>"></script>

		<script src="<c:url value="/template/admin/login/assets/js/respond.min.js"/>"></script>
		<![endif]-->

</head>

<body class="login-layout">
<dec:body/>
</body>


<!-- basic scripts -->


<script src="<c:url value="/template/admin/login/assets/js/jquery-2.1.4.min.js"/>"></script>

<!-- <![endif]-->

<!--[if IE]>

		<script src="<c:url value="/template/admin/login/assets/js/jquery-1.11.3.min.js"/>"></script>
<![endif]-->
<script type="text/javascript">

    if ('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/template/admin/login/assets/js/jquery.mobile.custom.min.js"/>'>" + "<" + "/script>");
</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {
        $(document).on('click', '.toolbar a[data-target]', function (e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    });


    //you don't need this, just used for changing background
    jQuery(function ($) {
        $('#btn-login-dark').on('click', function (e) {
            $('body').attr('class', 'login-layout');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-light').on('click', function (e) {
            $('body').attr('class', 'login-layout light-login');
            $('#id-text2').attr('class', 'grey');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-blur').on('click', function (e) {
            $('body').attr('class', 'login-layout blur-login');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'light-blue');

            e.preventDefault();
        });

    });
</script>
</body>
</html>
