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
                    <form:form id="inputForm" cssClass="form-horizontal" action="/app/save" method="post" modelAttribute="appInfo">
                        <form:hidden path="id"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="softwarename" class="col-sm-2 control-label">软件名称*</label>

                                <div class="col-sm-10">
                                    <form:input path="softwarename" cssClass="form-control required" placeholder="请输入软件名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apkname" class="col-sm-2 control-label">APK名称*</label>

                                <div class="col-sm-10">
                                    <form:password path="apkname" cssClass="form-control required" placeholder="请输入APK名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="supportrom" class="col-sm-2 control-label">支持ROM*</label>

                                <div class="col-sm-10">
                                    <form:input path="supportrom" cssClass="form-control required" placeholder="请输入支持的ROM"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="interfacelanguage" class="col-sm-2 control-label">界面语言*</label>

                                <div class="col-sm-10">
                                    <form:input path="interfacelanguage" cssClass="form-control required" placeholder="请输入界面语言"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="softwaresize" class="col-sm-2 control-label">软件大小*</label>

                                <div class="col-sm-10">
                                    <form:input path="softwaresize" cssClass="form-control required" placeholder="请输入软件大小"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">下载次数*</label>

                                <div class="col-sm-10">
                                    <form:input path="downloads" cssClass="form-control required" placeholder="请输入下载次数"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">所属平台*</label>

                                <div class="col-sm-10">
                                    <form:select path="floatformid" cssClass="form-control required">
                                        <for:option value="--请选择--"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">一级分类*</label>

                                <div class="col-sm-10">
                                    <form:select path="categorylevel1" cssClass="form-control required">
                                        <for:option value="--请选择--"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">二级分类*</label>

                                <div class="col-sm-10">
                                    <form:select path="categorylevel2" cssClass="form-control required">
                                        <for:option value="--请选择--"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">三级分类*</label>

                                <div class="col-sm-10">
                                    <form:select path="categorylevel3" cssClass="form-control required">
                                        <for:option value="--请选择--"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-sm-2 control-label">App状态*</label>

                                <div class="col-sm-10">
                                    <form:input path="status" cssClass="form-control required disabled" value="待审核"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="appinfo" class="col-sm-2 control-label">应用简介*</label>

                                <div class="col-sm-10">
                                    <form:input path="appinfo" cssClass="form-control required disabled" placeholder="请输入应用简介"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="logofile" class="col-sm-2 control-label">应用简介*</label>

                                <div class="col-sm-10">
                                    <input type="file" id="logofile"/>
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
</body>
</html>
