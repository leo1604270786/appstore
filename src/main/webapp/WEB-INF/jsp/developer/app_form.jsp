<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AppStore | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/dropzone/basic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/dropzone/dropzone.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${appInfo.id == null ? "新增" : "编辑"}App基础信息
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">App基础信息管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="col-xs-12">
                <c:if test="${baseResult != null}">
                    <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            ${baseResult.message}
                    </div>
                </c:if>

                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">App基础信息</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form:form id="appInputForm" cssClass="form-horizontal" action="${pageContext.request.contextPath}/app/save" method="post" modelAttribute="appInfo">
                        <form:hidden path="id"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="softwarename" class="col-sm-2 control-label">软件名称*</label>

                                <div class="col-sm-10">
                                    <form:input path="softwarename" cssClass="form-control" placeholder="请输入软件名称" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apkname" class="col-sm-2 control-label">APK名称*</label>

                                <div class="col-sm-10">
                                    <form:input path="apkname" cssClass="form-control" placeholder="请输入APK名称" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="supportrom" class="col-sm-2 control-label">支持ROM*</label>

                                <div class="col-sm-10">
                                    <form:input path="supportrom" cssClass="form-control" placeholder="请输入支持的ROM" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="interfacelanguage" class="col-sm-2 control-label">界面语言*</label>

                                <div class="col-sm-10">
                                    <form:input path="interfacelanguage" cssClass="form-control" placeholder="请输入界面语言" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="softwaresize" class="col-sm-2 control-label">软件大小*</label>

                                <div class="col-sm-10">
                                    <form:input type="number" min="0.0" step="0.01" path="softwaresize" cssClass="form-control" placeholder="请输入软件大小,单位为MB" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">下载次数*</label>

                                <div class="col-sm-10">
                                    <form:input type="number" path="downloads" cssClass="form-control" placeholder="请输入下载次数" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="floatformid" class="col-sm-2 control-label">所属平台*</label>

                                <div class="col-sm-10">
                                    <select id="floatformid" name="floatformid.id" class="form-control" required="required">
                                        <option value="">--请选择--</option>
                                        <c:if test="${appInfo.floatformid != null}">
                                            <option value="${appInfo.floatformid.id}" selected>${appInfo.floatformid.valuename}</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categorylevel1" class="col-sm-2 control-label">一级分类*</label>

                                <div class="col-sm-10">
                                    <select id="categorylevel1" name="categorylevel1.id" class="form-control" required="required">
                                        <option value="">--请选择--</option>
                                        <c:if test="${appInfo.categorylevel1 != null}">
                                            <option value="${appInfo.categorylevel1.id}" selected>${appInfo.categorylevel1.categoryname}</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categorylevel2" class="col-sm-2 control-label">二级分类*</label>

                                <div class="col-sm-10">
                                    <select id="categorylevel2" name="categorylevel2.id" class="form-control" required="required">
                                        <option value="">--请选择--</option>
                                        <c:if test="${appInfo.categorylevel2 != null}">
                                            <option value="${appInfo.categorylevel2.id}" selected>${appInfo.categorylevel2.categoryname}</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categorylevel3" class="col-sm-2 control-label">三级分类*</label>

                                <div class="col-sm-10">
                                    <select id="categorylevel3" name="categorylevel3.id" class="form-control" required="required">
                                        <option value="">--请选择--</option>
                                        <c:if test="${appInfo.categorylevel3 != null}">
                                            <option value="${appInfo.categorylevel3.id}" selected>${appInfo.categorylevel3.categoryname}</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">App状态*</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${appInfo.status == null ? '待审核' : appInfo.status.valuename}" readonly="true">
                                    <form:hidden path="status.id" value="${appInfo.status == null ? '4' : appInfo.status.id}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="appinfo" class="col-sm-2 control-label">应用简介*</label>

                                <div class="col-sm-10">
                                    <form:textarea path="appinfo" cssClass="form-control" placeholder="请输入应用简介" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="logowebpath" class="col-sm-2 control-label">LOGO图片*</label>

                                <div class="col-sm-10">
                                    <form:input path="logowebpath" value="${appInfo.logowebpath == null ? '' : appInfo.logowebpath}" cssClass="form-control" placeholder="LOGO图片" required="required"/>

                                    <div id="dropz" class="dropzone"></div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">保存</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<!-- Dropzone -->
<script src="${pageContext.request.contextPath}/static/plugins/dropzone/min/dropzone.min.js"></script>
<script>
    $("#categorylevel1").on("click",(function () {
        this.empty();
        this.append('<option value="">--请选择--</option>');
        //获取分类列表
        var category = JSON.parse(App.getCategory("level1",""));
        //遍历分类列表，加入到下拉框中
        $.each(category, function (index, data) {
            $("#categorylevel1").append('<option value="'+data.id+'">'+ data.categoryname +'</option>')
        });

    }));
    //console.log(category);
    //为一级分类添加自动获取下级分类事件
    $("#categorylevel1").change(function(){
        //清空下拉框
        $("#categorylevel2").empty();
        $("#categorylevel3").empty();
        //加入第一个请选择
        $("#categorylevel2").append('<option value="">--请选择--</option>');
        $("#categorylevel3").append('<option value="">--请选择--</option>');
        var opt=$("#categorylevel1").val();
        if (opt !== '') {
            //获取分类列表
            var category = JSON.parse(App.getCategory("level2",opt));
            //遍历分类列表，加入到下拉框中
            $.each(category, function (index, data) {
                $("#categorylevel2").append('<option value="'+data.id+'">'+ data.categoryname +'</option>')
            });
        }
    });
    //为二级分类添加自动获取下级分类事件
    $("#categorylevel2").change(function(){
        //清空下拉框
        $("#categorylevel3").empty();
        //加入第一个请选择
        $("#categorylevel3").append('<option value="">--请选择--</option>');
        var opt=$("#categorylevel2").val();
        if (opt !== '') {
            //获取分类列表
            var category = JSON.parse(App.getCategory("level3",opt));
            //遍历分类列表，加入到下拉框中
            $.each(category, function (index, data) {
                $("#categorylevel3").append('<option value="'+data.id+'">'+ data.categoryname +'</option>')
            });
        }
    });
    $("#floatformid").on("click",function () {
        this.empty();
        this.append('<option value="">--请选择--</option>');
        //获取平台信息
        var floar = JSON.parse(App.getDictionary("${pageContext.request.contextPath}/app/floar"));
        $.each(floar, function (index, data) {
            $("#floatformid").append('<option value="'+data.id+'">'+ data.valuename +'</option>')
        });
    });
    //初始化Dropzone
    var dropz = App.initDropzone({
        id: "#dropz",
        url: "${pageContext.request.contextPath}/app/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#logowebpath").val(data.fileName);
            });
        }
    });
    if (${appInfo.logowebpath != null}) {
        console.log(dropz);
        var mockFile = { name: "${appInfo.logowebpath}" , accepted:true };
        dropz.emit("addedfile", mockFile);

        //request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        dropz.emit("thumbnail", mockFile,"${pageContext.request.scheme}" + "://" + "${pageContext.request.serverName}"+":"+
            "${pageContext.request.serverPort}" + "${pageContext.request.contextPath}" + "${appInfo.logowebpath}");
        dropz.emit("complete", mockFile);
        //dropz.createThumbnailFromUrl(file, imageUrl, callback, crossOrigin);
    }
</script>
</body>
</html>
