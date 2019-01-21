function login() {
    var deviceId = $('#deviceId').val();
    var password = $('#password').val();
    var baseUrl = '/shiro/login';
    if (deviceId != '' && password != '') {
        var postData = {deviceId: deviceId, password: password}
        $.ajax({
            type: "POST",
            url: baseUrl,
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(postData),
            success: function (response) {
                if (response.code == 200) {
                    window.location.href = '/modules/index.html'
                } else {
                    $('.error').text('账号或密码错误')
                }
            },
        });
    }
}
