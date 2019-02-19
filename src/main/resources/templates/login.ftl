<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="/static/css/reset.css">
    <link rel="stylesheet" href="/static/css/supersized.css">
    <link rel="stylesheet" href="/static/css/style2.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body >

<div class="page-container">
    <h1>Login</h1>
    <form id="formLogin">
        <input type="text" id="managerCode" name="managerCode" class="form-control" placeholder="用户名" required="">
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required="">

        <button type="button" id="btnLogin">登录</button>
        <div class="error"><span>+</span></div>
    </form>

</div>

<!-- Javascript -->
<script src="/static/js/jquery-1.12.4.js"></script>
<script src="/static/js/supersized.3.2.7.min.js"></script>
<script src="/static/js/supersized-init.js"></script>
<script src="/static/js/scripts.js"></script>
<script src="/static/js/formToJSON.js"></script>

</body>

</html>

<script>
    $(function () {
        //ajax提交表单
        $("#btnLogin").on("click",function () {
            //表单序列化为json
            var  jsonForm=$("#formLogin").getFormJSON();
            var  formLogin=JSON.stringify(jsonForm);
            $.ajax({
                type:"POST",
                url:"/manager/login.html",
                data:{"formLogin":formLogin},
                success:function (data) {
                    //成功
                    if (data.result=="success") {
                        alert(data.message);
                        location.href="/index.html";
                    }else {
                        alert(data.message);
                        $("#managerCode").val("");
                        $("#password").val("");
                    }
                },
                dataType:"json"
            });
        });
    })
</script>
