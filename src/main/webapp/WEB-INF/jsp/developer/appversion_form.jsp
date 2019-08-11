<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AppStore | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
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
                ${appVersion.id == null ? "新增" : "编辑"}App版本信息
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">App版本信息管理</li>
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
                        <h3 class="box-title">App版本信息</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form:form id="appInputForm" cssClass="form-horizontal" action="${pageContext.request.contextPath}/appversion/save" method="post" modelAttribute="appVersion" enctype="multipart/form-data">
                        <form:hidden path="id"/>
                        <form:hidden path="appid" value="${appVersion.appid}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="versionno" class="col-sm-2 control-label">版本号*</label>

                                <div class="col-sm-10">
                                    <form:input path="versionno" cssClass="form-control" readonly="${appVersion.id == null ? false : true}" placeholder="请输入版本号" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="versionsize" class="col-sm-2 control-label">版本大小*</label>

                                <div class="col-sm-10">
                                    <form:input type="number" min="0.0" step="0.01" path="versionsize" cssClass="form-control" placeholder="请输入版本大小" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">发布状态*</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${appVersion.publishstatus == null ? '预发布' : appVersion.publishstatus.valuename}" readonly="true">
                                    <form:hidden path="publishstatus.id" value="${appVersion.publishstatus == null ? '13' : appVersion.publishstatus.id}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="versioninfo" class="col-sm-2 control-label">版本简介*</label>

                                <div class="col-sm-10">
                                    <form:textarea path="versioninfo" rows="3" cssClass="form-control" placeholder="请输入版本简介" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apkfilename" class="col-sm-2 control-label">apk文件*</label>

                                <div class="col-sm-10">
                                    <c:if test="${appVersion.id == null}">
                                        <input type="file" id="apkfile" name="apkfile" class="form-control" required="required" onchange="setFileName()">
                                        <form:hidden path="apkfilename"/>
                                    </c:if>
                                    <c:if test="${appVersion.id != null}">
                                        <form:input path="apkfilename" cssClass="form-control" required="required" readonly="true" value="${appVersion.apkfilename}"/>
                                        <button type="button" class="btn btn-info" onclick="download('${appVersion.id}')" style="margin-top: 20px">下载</button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-info" onclick="" style="margin-top: 20px">删除</button>
                                    </c:if>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="button" class="btn btn-info pull-right" onclick="checkForm()">保存</button>
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
<script>
    function checkForm() {
        if ($("#versionno").val() === '' || $("#versionsize").val()===''
            || $("#versioninfo").val() === ''){
            alert("请完整填写");
            return;
        }
        if ($("#apkfilename").val() === ''){
            alert("请上传文件");
            return;
        }
        if (${appVersion.id == null}){
            var location = $("#apkfilename").val();
            var point = location.lastIndexOf(".");
            var type = location.substr(point);
            if (type !== ".apk") {
                alert("上传的文件必须是apk格式文件");
            } else {
                $("#appInputForm").submit();
            }
        } else {
            $("#appInputForm").submit();
        }
    }
    function setFileName() {
        var path = $("#apkfile").val();
        var point = path.lastIndexOf("\\");
        var fileName = path.substr(point+1);
        $("#apkfilename").val(fileName);
    }
    function download(versionId) {
        //构建表单请求下载
        var form = $("<form>");
        form.attr("style","display:none");
        form.attr("target","_blank");
        form.attr("method","post");
        form.attr("action","${pageContext.request.contextPath}/download?versionId="+versionId);
        $("body").append(form);
        form.submit();
        form.remove();
    }
</script>
</body>
</html>
