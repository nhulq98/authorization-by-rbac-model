<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<head>
    <!---->
    <meta name="google-signin-client_id"
          content="689026199229-bb45lit1f3cn3t30cg6338td47c68ui5.apps.googleusercontent.com"/>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="<c:url value="/views/script.js"/>"></script>
</head>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">News super hot</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <!--TH1: -->
                <c:if test="${USERMODEL != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Wellcome, ${USERMODEL.userName}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout?action=logout"/>">Thoát</a>
                    </li>
                </c:if>

                <c:if test="${USERMODEL == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login?action=login"/>">Đăng nhập</a>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
<script>
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function(){
        alert("you are logout success!");
        $(".g-signin2").css("display", "block");
        //location.reload();
        $(".data").css("display", "none");

    });
</script>