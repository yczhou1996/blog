var chou = new chou();

$(function () {
    $("#save-category-btn").click(function () {
        var id = $("#cid").val();
        var name = $("#cname").val();
        if (name && name != null) {
            $.ajax({
                type: "POST",
                url: "/admin/category/edit",
                data: {id: id, name: name},
                dataType: "JSON",
                async: false,
                success: function (result) {
                    if (result && result.success) {
                        chou.showOk("保存成功");
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000)
                    } else {
                        chou.showError(result.msg);
                    }
                }
            })
        }
    })

    $(".edit-category").click(function () {
        var id = $(this).attr("id");
        var name = $(this).attr("name");
        $("#cid").val(id);
        $("#cname").val(name);
        $(this).closest(".am-dropdown").dropdown('close')
    })

    $(".del-category").click(function () {
        var id = $(this).attr("id");
        $(this).closest(".am-dropdown").dropdown('close')
        chou.showConfirm("是否确认删除", function () {
            if (id && id != null) {
                $.ajax({
                    type: "POST",
                    url: "/admin/category/del",
                    data: {id: id},
                    dataType: "JSON",
                    async: false,
                    success: function (result) {
                        if (result && result.success) {
                            chou.showOk("删除成功");
                            setTimeout(function () {
                                window.location.reload();
                            }, 1000)
                        } else {
                            chou.showError(result.msg);
                        }
                    }
                })
            }
        })
    })
});