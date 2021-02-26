$(function () {
    $("#TANGRAM__PSP_4__password").focus(function () {
        if (!$(this).hasClass("input-focus")) {
            $(this).addClass("input-focus");
            $.get("http://localhost:8080/getpublickey", function (data) {
                $("#publicKey").val(data.respMap.publicKey);
                $("#RSAKey").val(data.respMap.RSAKey);
            });
        }
    });
    $("#TANGRAM__PSP_4__password").blur(function () {
        $(this).removeClass("input-focus");
    });
});