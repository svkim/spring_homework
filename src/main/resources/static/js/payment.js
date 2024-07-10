$(function () {
    $(".pay_radio2").on("click", function () {
        $(".p2").css("display", "block");
        $(".p1").css("display", "none");
    });
    $(".pay_radio1").on("click", function () {
        $(".p2").css("display", "none");
        $(".p1").css("display", "block");
    });
});