
function onSignIn(googleUser) {
    var profile=googleUser.getBasicProfile();
    $(".g-signin2").css("display", "none");
    $(".data").css("display", "block");
    $("#pic").attr('src', profile.getImageUrl());
    $("#email").text(profile.getEmail());
    // put value
    $('#emailAPI').val(profile.getEmail());
    $('#ID').val(profile.getId());

    $('#formSubmit').submit();
    singOut();


    // console.log('ID: ' + profile.getId());
}

function singOut(){
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function(){
        // alert("you are logout success!");
         $(".g-signin2").css("display", "block");
        //location.reload();
         $(".data").css("display", "none");

    });
}