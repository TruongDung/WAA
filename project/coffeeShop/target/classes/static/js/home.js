$(function() {
    $(".add-to-cart-btn").click(function(e) {
        e.preventDefault();
        var self = $(this);
        $.ajax({
            url: "/addToCart",
            type: "POST",
            data: self.attr("productid"),
            contentType: "application/json; charset=utf-8",
            success: function() {
                //do nothing
            	console.log("added!");
            }
        });
    });
});