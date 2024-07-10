function count(type) {
    const resultElement =
        document.getElementById("result");
    const aa = document.getElementById("result1");
    let number = resultElement.innerText;
    const price = document.getElementById("item_price");
    var A = price.innerText;
    var a;
    if (type === "plus") {
        number = parseInt(number) + 1;
        a = A * number;
    } else if (type === "minus") {
        number = parseInt(number) - 1;
        a = A * number;
        if (number === 0) {
            number = 1;
            a = A;
        }
    }
    resultElement.innerText = number;
    aa.innerText = a;

};
$(function () {
    $(".box1").on("click", function(){
    $(".box1").css("background-color","white");
    $(".box2").css("background-color","#F7F7F7");
    $(".main2").css("display","none")
    $(".main1").css("display","block")
});
    $(".box2").on("click", function(){
    $(".box2").css("background-color","white");
    $(".box1").css("background-color","#F7F7F7");
    $(".main1").css("display","none")
    $(".main2").css("display","block")
    });
});
