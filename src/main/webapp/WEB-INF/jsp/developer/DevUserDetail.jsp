<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | User Profile</title>
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
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${ctx}/static/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <jsp:include page="../includes/header.jsp"/>
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <style>
    .narrower{
      width: 400px!important;
    }
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <jsp:include page="../includes/nav.jsp"/>
  <jsp:include page="../includes/menu.jsp"/>
      <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        User Profile
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">User profile</li>
      </ol>
      </section>

      <!-- Main content -->
      <section class="content">
        <form class="form-horizontal" action="${ctx}/alterDevUserInfo">
          <div class="form-group">
            <label for="devcode" class="col-sm-2 control-label">昵称</label>

            <div class="col-sm-10">
              <input type="email" class="form-control narrower" id="devcode" placeholder="${devUser.devcode}" name="devcode">
            </div>
          </div>
          <div class="form-group">
            <label for="devemail" class="col-sm-2 control-label">邮箱</label>

            <div class="col-sm-10">
              <input type="email" class="form-control narrower" id="devemail" placeholder="${devUser.devemail}" name="devemail">
            </div>
          </div>
          <div class="form-group">
            <label for="devname" class="col-sm-2 control-label">姓名</label>

            <div class="col-sm-10">
              <input type="text" class="form-control narrower" id="devname" placeholder="${devUser.devname}" name="devname">
            </div>
          </div>
          <div class="form-group">
            <label for="devpassword" class="col-sm-2 control-label">密码</label>

            <div class="col-sm-10">
              <input type="text" class="form-control narrower" id="devpassword" placeholder="${devUser.devpassword}" name="devpassword">
            </div>
          </div>
          <div class="form-group">
            <label for="devinfo" class="col-sm-2 control-label">个人介绍</label>

            <div class="col-sm-10">
              <textarea class="form-control narrower" id="devinfo" placeholder="${devUser.devinfo}" name="devinfo"></textarea>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="button" class="btn btn-danger" onclick="alterInfo()">提交</button>
            </div>
          </div>
        </form>
      </section>
      <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- jQuery 3 -->
<script src="${ctx}/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctx}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${ctx}/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${ctx}/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${ctx}/static/dist/js/demo.js"></script>
<script>
  function alterInfo() {
    var devcode = $("#devcode").val();
    var devname = $("#devname").val();
    var devemail = $("#devemail").val();
    var devinfo = $("#devinfo").val();
    var devpassword = $("#devpassword").val();
      $.ajax({
        type: 'post',
        url: '/alterDevUserInfo',
        data: {"devcode": devcode,"devname":devname,"devemail":devemail,"devinfo":devinfo,"devpassword":devpassword},
        dataType: 'json',
        success: function (data) {
          var val = data['message'];
          if (val == "ok") {
              alert("修改成功");
          }else {
              alert("修改失败，请稍后重试");
          }
        }
      });
  }
</script>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>