var chou = new chou();
$(function () {
    init();
});

/**
 * 时间
 */
function init() {
    var startDate = new Date();
    var endDate = new Date();
    $('#my-startDate').text(format(new Date()));
    $('#my-endDate').text(format(new Date()));
    $("input[name='startTime']").val(format(new Date()));
    $("input[name='endTime']").val(format(new Date()));
    var $alert = $('#my-alert');
    $('#my-start').datepicker().on('changeDate.datepicker.amui', function (event) {
        if (event.date.valueOf() > endDate.valueOf()) {
            $alert.find('p').text('开始日期应小于结束日期！').end().show();
        } else {
            $alert.hide();
            startDate = new Date(event.date);
            $('#my-startDate').text($('#my-start').data('date'));
            $("input[name='startTime']").val($('#my-start').data('date'));
        }
        $(this).datepicker('close');
    });

    $('#my-end').datepicker().on('changeDate.datepicker.amui', function (event) {
        if (event.date.valueOf() < startDate.valueOf()) {
            $alert.find('p').text('结束日期应大于开始日期！').end().show();
        } else {
            $alert.hide();
            endDate = new Date(event.date);
            $('#my-endDate').text($('#my-end').data('date'));
            $("input[name='endTime']").val($('#my-end').data('date'));
        }
        $(this).datepicker('close');
    });
}

function format(date) {
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
}

/**
 * 修改plan
 */
function editPlan() {
    $.ajax({
        type: "POST",
        url: "/admin/plan/edit",
        data: $("#planForm").serialize(),
        dataType: "JSON",
        async: false,
        success: function (result) {
            if (result && result.success) {
                $("#addPlan").modal('close');
                chou.showOk("修改成功");
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            } else {
                chou.showError(result.msg || "修改失败");
            }
        }
    })
}

/**
 * 打开弹窗
 * @param id
 */
function modifyPlan(id) {
    form_rest();
    if (null != id) {
        $.ajax({
            type: "POST",
            url: "/admin/plan/findById",
            data: {id: id},
            dataType: "JSON",
            async: false,
            success: function (result) {
                //填充资料.
                if (result && result.success) {
                    $("#doc-vld-id-2").val(result.payload.id);
                    $("#doc-vld-name-2").val(result.payload.title);
                    $("#doc-vld-ta-2").val(result.payload.content);
                    $("#my-startDate").text(format(new Date(result.payload.startTime)));
                    $("#startTime").val(format(new Date(result.payload.startTime)));
                    $("#my-endDate").text(format(new Date(result.payload.endTime)));
                    $("#endTime").val(format(new Date(result.payload.endTime)));
                }
            }
        })
    }
    $("#addPlan").modal('open');
}

/**
 * 删除Plan
 */
function delPlans(id) {
    chou.showConfirm("确认要删除吗？",
        function () {
            $.ajax({
                type: "POST",
                url: "/admin/plan/delete",
                data: {id: id},
                dataType: "JSON",
                async: false,
                success: function (result) {
                    if (result && result.success) {
                        chou.showOk("删除成功");
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000);
                    } else {
                        chou.showError(result.msg || "删除失败");
                    }
                }
            })
        }
    )
}

/**
 * 清空弹窗
 */
function form_rest() {
    $("#doc-vld-id-2").val('');
    $("#doc-vld-name-2").val('');
    $("#doc-vld-ta-2").val('');
    $("#my-startDate").text(format(new Date()));
    $("#startTime").val(format(new Date()));
    $("#my-endDate").text(format(new Date()));
    $("#endTime").val(format(new Date()));
}