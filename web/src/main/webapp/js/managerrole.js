$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });

    $('.edit').click(function () {
        let id = $(this).children('button').val();
        $('.pro-id').val($('.product-ma-'+id).text().trim());
        $('.pro-name').val($('.product-ten-'+id).text().trim());
        $('.pro-img').val($('.product-img-'+id).children('img').attr('src').trim());
        $('.pro-price-1').val($('.product-gia-moi-'+id).text().trim());
        $('.pro-price-2').val($('.product-gia-cu-'+id).text().trim());
        $('.pro-des').val($('.product-mo-ta-'+id).text().trim());

    })
});


