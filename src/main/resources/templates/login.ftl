<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>登录</title>


    <link href="/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=2.2.0" rel="stylesheet">

    <style>
        .logo-name {
            color: #e6e6e6;
            font-size: 80px;
            font-weight: 500;
            letter-spacing: -10px;
            margin-bottom: 0px;
        }
    </style>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h2 class="logo-name ">&nbsp;</h2>

        </div>
        <h3>欢迎使用 我有我优后台管理系统</h3>

        <form class="m-t"  id="formLogin">
            <div class="form-group">
                <input type="text" id="managerCode" name="managerCode" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <button type="button" class="btn btn-primary block full-width m-b" id="btnLogin">登 录</button>
        </form>
    </div>
</div>

<!-- Mainly scripts -->
<script src="/static/js/jquery-1.12.4.js"></script>
<script src="/static/js/bootstrap.min.js?v=3.4.0"></script>

<script src="../static/js/formToJSON.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->
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
