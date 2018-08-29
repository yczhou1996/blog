var chou = new chou();
$(function () {
    fillUser();

    $(function () {
        $('#user-pic').on('change', function () {
            var path = $("#user-pic").val();
            var arr = path.split("\\");
            var fileName = '<span class="am-badge">' + arr[arr.length - 1] + '</span> ';
            $('#file-list').html(fileName);
        });
    });
});

/**
 * 填充个人信息
 */
function fillUser() {
    $.ajax({
        type: "POST",
        url: "/admin/user",
        data: {},
        dataType: "JSON",
        async: false,
        success: function (result) {
            $("#user-id").val(result.payload.id);
            $("#user-name").val(result.payload.fullname);
            $("#user-email").val(result.payload.email);
            $("#user-phone").val(result.payload.phone);
            $("#user-QQ").val(result.payload.qq);
            $("#user-weibo").val(result.payload.weibo);
            $("#user-intro").val(result.payload.intro);
        }
    })
}

/**
 * 修改个人资料
 */
function saveInfo() {
    $.ajax({
        type: "POST",
        url: "/admin/user/saveInfo",
        data: $("#userForm").serialize(),
        dataType: "JSON",
        async: false,
        success: function (result) {
            if (result && result.success) {
                chou.showOk("修改成功");
            } else {
                chou.showError(result.msg || "修改失败");
            }
        }
    })
}

/**
 * 修改头像
 */
function savePhoto() {
    $.ajax({
        type: "POST",
        url: "/admin/user/savePhoto",
        data: new FormData($('#fileForm')[0]),
        cache: false,
        processData: false,
        contentType: false,
        success: function (result) {
            //$("#imgHead").attr("src", result);
            window.location.reload();
        }
    })
}