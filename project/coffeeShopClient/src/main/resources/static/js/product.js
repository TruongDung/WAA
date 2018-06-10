$(".delete-single-product").click(function(e) {
	debugger;
        e.preventDefault();
        var self = $(this);
        var productId = self.attr("productId");
        $.ajax({
            type: "DELETE",
            url: "/product/" + productId,
            contentType: "application/json; charset=utf-8",
            success: function() {
            	debugger;
                location.reload();
            }
        });
    });