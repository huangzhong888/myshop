
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的商城 | 登录</title>
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="static/assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="static/assets/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="static/assets/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#">我的商城</a>
    </div>
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">欢迎管理员登录</p>
            <form action="login" method="post">
                <div class="alert alert-danger alert-dismissible" ${message == null ?"style='display: none'" : ""}>
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${message}
                </div>
                <div class="input-group mb-3">
                    <input type="email" class="form-control" placeholder="邮箱" name="email" >
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="密码" name="password" >
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember" name="isRemember" >
                            <label for="remember">
                                记住我
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
            <!-- /.social-auth-links -->

            <p class="mb-1">
                <a href="#">忘记密码？</a>
            </p>

        </div>
    </div>
</div>
<!-- /.login-logo -->

<!-- jQuery -->
<script src="static/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="static/assets/js/adminlte.min.js"></script>
</body>
</html>


