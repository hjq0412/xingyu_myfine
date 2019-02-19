$(function () {
    //查看详细订单信息
    var obj;
    $(".lookDetail").click(function () {
        obj = $(this);
        var id = obj.attr("orderId");
        $.ajax({
            type: "POST",
            url: "/orderdetail/getOrderDetail.html",
            data: {"id": id},
            success: function (data) {
                $("#orderNo").html(data.orderNo);
                $("#userNickName").html(data.userNickName);
                $("#phone").html(data.phone);
                $("#consignee").html(data.consignee);
                $("#productName").html(data.productName);
                $("#productNum").html(data.productNum);
                $("#integralVariation").html(data.integralVariation);
                $("#count").html(data.count);
                $("#total").html(data.total);
                $("#address").html(data.address);
            },
            dataType: "json"
        });
    });
});