function chou() {
    
}

chou.prototype.showOk = function (msg) {
    swal({
        title: msg,
        text: "1秒后自动关闭",
        type: "success",
        timer: 1000,
        showConfirmButton: false,
    }).catch(swal.noop);
};

chou.prototype.showError = function (msg) {
    swal({
        title: msg,
        text: "1秒后自动关闭",
        type: "error",
        timer: 1000,
        showConfirmButton: false,
    }).catch(swal.noop);
};

chou.prototype.showConfirm = function (msg, then) {
    swal({
        title: msg,
        text: "",
        type: "question",
        timer: 99999,
        confirmButtonText: "确定",
        cancelButtonText:  '取消',
        showCancelButton: true,
    }).then( function (e) {
        then(e);
    }).catch(swal.noop);
};