$(function() {
    var startDate = new Date();
    var endDate = new Date();
    $('#my-startDate').text(format(new Date()));
    $('#my-endDate').text(format(new Date()));
    var $alert = $('#my-alert');
    $('#my-start').datepicker().
    on('changeDate.datepicker.amui', function(event) {
        if (event.date.valueOf() > endDate.valueOf()) {
            $alert.find('p').text('开始日期应小于结束日期！').end().show();
        } else {
            $alert.hide();
            startDate = new Date(event.date);
            $('#my-startDate').text($('#my-start').data('date'));
        }
        $(this).datepicker('close');
    });

    $('#my-end').datepicker().
    on('changeDate.datepicker.amui', function(event) {
        if (event.date.valueOf() < startDate.valueOf()) {
            $alert.find('p').text('结束日期应大于开始日期！').end().show();
        } else {
            $alert.hide();
            endDate = new Date(event.date);
            $('#my-endDate').text($('#my-end').data('date'));
        }
        $(this).datepicker('close');
    });
});

function format(date) {
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
}

function editPlan() {
    $.ajax({
        type: "POST",
        url: "/admin/plan/edit",
        data: $("#planForm").serialize(),
        dataType:"JSON",
        async:false,
        success:function (result) {
            if(result && result.success){
                window.location.reload();
            }else{

            }
        }
    })
}

function delPlans() {
    
}