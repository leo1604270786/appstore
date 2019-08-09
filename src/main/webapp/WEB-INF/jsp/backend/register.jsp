<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>APPSTORE后台管理系统注册页面</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${ctx}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${ctx}/static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${ctx}/static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${ctx}/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${ctx}/static/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="${ctx}/jsp/index.jsp"><b>APPSTORE</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">后台管理系统管理员注册</p>
        <form action="${ctx}/register_backend" method="post" id="registerForm" >
            <span id="reg_span"></span>
            <div class="form-group has-feedback">
                <input id="usercode" name="usercode" type="text" class="form-control" placeholder="昵称" onblur="checkUserCode();">

                <span id="usercode_span"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="username" type="text" class="form-control" placeholder="全名">

                <span  id="username_span"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="userpassword" id="userpassword" type="password" class="form-control" placeholder="密码" onblur="checkPassword();">
                <span  id="password_span"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="reInputPassword" type="password" class="form-control" placeholder="重新输入密码" onblur="checkRePassword();">
                <span id="re_password_span"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="code" id="code" type="text" class="form-control" placeholder="验证码" onblur="checkCode()">
                <br/><span  id="code_span"></span>
            </div>
            <div>
                <IMG id="captchaImg" style="CURSOR: pointer"
                     onclick="changeCaptcha()"
                     title="看不清楚?请点击刷新验证码!"  src="${ctx}/captchaServlet"
                     height="18" width="55">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input id="protocol" type="checkbox" onclick="checkProtocol();"/> 我已同意 <a href="#">注册条款</a>
                            <br/>
                            <span id="protocol_span">

                            </span>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat" id ="to_register">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

       <%-- <div class="social-auth-links text-center">
            <p>- OR -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
                Facebook</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
                Google+</a>
        </div>--%>
        <a href="login.jsp" class="text-center">我已注册，前往登陆</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->
<!-- jQuery 3 -->
<script src="${ctx}/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctx}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${ctx}/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
    //提交注册信息
    $("#to_register").click (function(){
        if(!checkProtocol()){
            $("#protocol_span").text("请勾选\"注册条款协议\"！").css("color","red");
        }else{
            $("#protocol_span").text("");
        }

        if(checkUserCode()  &&  checkPassword() && checkRePassword()&& checkCode() && checkProtocol()){
            $("#registerForm").submit();
        }else {
            $("#reg_span").text("请将信息填写完整！").css("color","red");
        }

    });
    //再次密码离焦事件
    function checkRePassword() {
        var password = $("#userpassword").val();
        var reInputPassword = $("#reInputPassword").val();
        if(password == reInputPassword){
            $("#re_password_span").text("");
            $("#reg_span").text("");
            return true;

        }else {
            $("#re_password_span").text("两次输入的密码不一致").css("color","red");
            return false;
        }


    }
    //密码框离焦事件

    function checkPassword() {
        var password = $("#userpassword").val();
        password = password.replace(/^\s+|\s+$/g,"");
        if(password == ""){
            $("#password_span").text("请输入密码！").css("color","red");

            return false;
        }
        $("#password_span").text("");
        $("#reg_span").text("");
        return true;

    }
    //昵称校验

    var flag_user_code =false;
    function checkUserCode() {
        var user_code = $("#usercode").val();
            //验证该昵称是否已被使用
            $.ajax({
                type:'post',
                url:'/checkUserCode',
                data: {"usercode":user_code},
                dataType:'json',
                success:function(data) {
                    var val = data['message'];
                    if(val=="success"){
                        $("#usercode_span").text("");
                        $("#reg_span").text("");

                        flag_user_code  = true;

                    }else{

                        $("#usercode_span").text("该昵称已经被使用！");
                        flag_user_code =  false;
                    }
                }
            });

        return flag_user_code;
    }

    //验证码校验
    var flag_c = false;
    function checkCode() {
        var code = $("#code").val();
        code = code.replace(/^\s+|\s+$/g,"");
        if(code == ""){
            $("#code_span").text("请输入验证码！").css("color","red");
            flag_c = false;
        }else{
            $.ajax({
                type: 'post',
                url: '/checkCode',
                data: {"code": code},
                dataType: 'json',
                success: function (data) {
                    var val = data['message'];
                    if (val == "success") {

                        $("#reg_span").text("");
                        flag_c = true;
                    }else {
                        $("#code_span").text("验证码错误！").css("color","red");
                        flag_c = false;
                    }
                }
            });
        }
        return flag_c;
    }
    //更换验证码
    function changeCaptcha() {
        $("#captchaImg").attr('src', '${ctx}/captchaServlet?t=' + (new Date().getTime()));
    }
    //勾选用户协议校验
    function checkProtocol() {
        if($('#protocol').prop("checked"))
        {
            $("#reg_span").text("");
            return true;
        }
        else{
            return false;
        }
    }
</script>
</body>
</html>
