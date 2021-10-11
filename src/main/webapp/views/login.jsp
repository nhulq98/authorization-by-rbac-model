<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Login Page - Ace Admin</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <meta name="google-signin-client_id"
          content="689026199229-bb45lit1f3cn3t30cg6338td47c68ui5.apps.googleusercontent.com"/>

    <%--    <style>--%>
    <%--        .g-signin2{--%>
    <%--            margin-left:500px;--%>
    <%--            margin-top: 200px;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="ace-icon fa fa-leaf green"></i>
                            <span class="red">Ace</span>
                            <span class="white" id="id-text2">Application</span>
                        </h1>
                        <h4 class="blue" id="id-company-text">&copy; Company Name</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="ace-icon fa fa-coffee green"></i>
                                        Please Enter Your Information
                                    </h4>

                                    <div class="space-6"></div>
                                    <c:if test="${alert != null}">
                                        <div class="alert alert-${alert}">
                                            <strong>${message}</strong>
                                        </div>
                                    </c:if>
                                    <%--                                    <div class="alert alert-success">--%>
                                    <%--                                        <strong>Success!</strong> Indicates a successful or positive action.--%>
                                    <%--                                    </div>--%>
                                    <form action="<c:url value='/login?action=login'/> " method="POST">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="name" name="userName"
                                                                   class="form-control"
                                                                   placeholder="Username"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="password" name="password"
                                                                   class="form-control"
                                                                   placeholder="Password"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
                                            </label>
                                            <div class="space"></div>
                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace"/>
                                                    <span class="lbl"> Remember Me</span>
                                                </label>
                                                <input type="hidden" value="login" name="action"/>
                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="ace-icon fa fa-key"></i>

                                                    <span class="bigger-110">Login</span>
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">Or Login Using</span>
                                    </div>

                                    <div class="space-6"></div>

                                    <div class="social-login center">
                                        <%--                                        <a class="btn btn-primary">--%>
                                        <%--                                            <i class="ace-icon fa fa-facebook"></i>--%>
                                        <%--                                        </a>--%>

                                        <%--                                        <a class="btn btn-info">--%>
                                        <%--                                            <i class="ace-icon fa fa-twitter"></i>--%>
                                        <%--                                        </a>--%>
                                        <form id="formSubmit" action="<c:url value="/login?action=login&googleAPI=loginWithGoogle"></c:url>" method="post">

                                            <div class="g-signin2" style="display: block" align="center"
                                                 data-onsuccess="onSignIn" ></div>
                                            <input type="hidden" value="" id="emailAPI" name="userName">
                                            <input type="hidden" value="" id="ID" name="password">

<%--                                            <input type="hidden" value="" id="maxPageItem" name="maxPageItem">--%>
<%--                                            <input type="submit"></input>--%>

                                        </form>
                                        <%--                                        g-signin2--%>


                                        <div class="data" style="display: none">
                                            <%--                                            <p>ID</p>--%>
                                            <%--                                            <a class="btn btn-danger">--%>
                                            <%--                                                <i class="ace-icon fa fa-google-plus"></i>--%>
                                            <%--                                            </a>--%>
                                            <p>Profile Details</p>
                                            <img id="pic" class="img-circle" width="100" height="100"/>
                                            <p>Email Address</p>
                                            <p id="email" name="email" class="alert alert-danger"></p>
                                            <button  onclick="singOut()" class="btn btn-danger">SignOut</button>
                                        </div>
                                        <%--                                        <a class="btn btn-danger">--%>
                                        <%--                                            <i class="ace-icon fa fa-google-plus"></i>--%>
                                        <%--                                        </a>--%>
                                    </div>
                                </div><!-- /.widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" data-target="#forgot-box" class="forgot-password-link">
                                            <i class="ace-icon fa fa-arrow-left"></i>
                                            I forgot my password
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" data-target="#signup-box" class="user-signup-link">
                                            I want to register
                                            <i class="ace-icon fa fa-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="ace-icon fa fa-key"></i>
                                        Retrieve Password
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        Enter your email and to receive instructions
                                    </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control"
                                                                   placeholder="Email"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="ace-icon fa fa-lightbulb-o"></i>
                                                    <span class="bigger-110">Send Me!</span>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /.widget-main -->

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box" class="back-to-login-link">
                                        Back to login
                                        <i class="ace-icon fa fa-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="ace-icon fa fa-users blue"></i>
                                        New User Registration
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> Enter your details to begin: </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control"
                                                                   placeholder="Email"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control"
                                                                   placeholder="Username"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control"
                                                                   placeholder="Password"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control"
                                                                   placeholder="Repeat password"/>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
                                            </label>

                                            <label class="block">
                                                <input type="checkbox" class="ace"/>
                                                <span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="ace-icon fa fa-refresh"></i>
                                                    <span class="bigger-110">Reset</span>
                                                </button>

                                                <button type="button"
                                                        class="width-65 pull-right btn btn-sm btn-success">
                                                    <span class="bigger-110">Register</span>

                                                    <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box" class="back-to-login-link">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        Back to login
                                    </a>
                                </div>
                            </div><!-- /.widget-body -->
                        </div><!-- /.signup-box -->
                    </div><!-- /.position-relative -->

                    <div class="navbar-fixed-top align-right">
                        <br/>
                        &nbsp;
                        <a id="btn-login-dark" href="#">Dark</a>
                        &nbsp;
                        <span class="blue">/</span>
                        &nbsp;
                        <a id="btn-login-blur" href="#">Blur</a>
                        &nbsp;
                        <span class="blue">/</span>
                        &nbsp;
                        <a id="btn-login-light" href="#">Light</a>
                        &nbsp; &nbsp; &nbsp;
                    </div>
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.main-content -->
</div><!-- /.main-container -->
<script>

    function init() {
        gapi.load('auth2', function () {
            /* Ready. Make a call to gapi.auth2.init or some other API */
            gapi.auth2.init({
                client_id: '689026199229-bb45lit1f3cn3t30cg6338td47c68ui5.apps.googleusercontent.com'
                //client
                // apiKey: 'AIzaSyCrk7KOfwgox6lyA_R00ZLDQY4-vxowBvE',
                // discoveryDocs: ["https://people.googleapis.com/$discovery/rest?version=v1"],
                // scope: 'profile'
            });
        });
    }

    init();

    // }).then(function (response) {
    //     // Listen for sign-in state changes.
    //     gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);
    //
    //     // Handle the initial sign-in state.
    //     updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
    // },function(reason) {
    //     console.log('onerror');
    //     console.log(reason);
    //     // Listen for sign-in state changes.
    //     gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);
    //
    //     // Handle the initial sign-in state.
    //     updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
    //
    //
    // }
    // function onSignIn(googleUser) {
    //     var profile = googleUser.getBasicProfile();
    //     console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    //     console.log('Name: ' + profile.getName());
    //     console.log('Image URL: ' + profile.getImageUrl());
    //     console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    // }

</script>
</body>
</html>
