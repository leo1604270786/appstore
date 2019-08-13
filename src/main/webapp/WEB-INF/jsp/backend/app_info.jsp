<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>AppStore | 控制面板</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu2.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                审核页面
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">审核APP</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="col-xs-12">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">审核</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form id="appInputForm" class="form-horizontal" action="#" method="post">
                        <div class="box-body">
                            <input type="hidden" name="id" id="id" value="${appInfo.id}"/>
                            <div class="form-group">
                                <label for="softwarename" class="col-sm-2 control-label">软件名称*</label>

                                <div class="col-sm-10">
                                    <input id="softwarename" value="${appInfo.softwarename}" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="apkname" class="col-sm-2 control-label">APK名称*</label>

                                <div class="col-sm-10">
                                    <input id="apkname" value="${appInfo.apkname}" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="supportrom" class="col-sm-2 control-label">支持ROM*</label>

                                <div class="col-sm-10">
                                    <input id="supportrom" value="${appInfo.supportrom}" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="interfacelanguage" class="col-sm-2 control-label">界面语言*</label>

                                <div class="col-sm-10">
                                    <input id="interfacelanguage" value="${appInfo.interfacelanguage}" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="softwaresize" class="col-sm-2 control-label">软件大小*</label>

                                <div class="col-sm-10">
                                    <input type="number" value="${appInfo.softwaresize}" id="softwaresize" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="downloads" class="col-sm-2 control-label">下载次数*</label>

                                <div class="col-sm-10">
                                    <input type="number" id="downloads" value="${appInfo.downloads}" class="form-control" readonly="true" required="required"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="floatformid" class="col-sm-2 control-label">所属平台*</label>

                                <div class="col-sm-10">
                                    <input id="floatformid" value="${appInfo.floatformid.valuename}" class="form-control" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categorylevel" class="col-sm-2 control-label">所属分类*</label>

                                <div class="col-sm-10">
                                    <input id="categorylevel" name="categorylevel" value="${appInfo.categorylevel.categoryname}" class="form-control" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">App状态*</label>

                                <div class="col-sm-10">
                                    <input id="status" name="status" class="form-control" value="${appInfo.status.valuename}" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="appinfo" class="col-sm-2 control-label">应用简介*</label>

                                <div class="col-sm-10">
                                    <textarea id="appinfo" name="appinfo" rows="3" class="form-control" required="required" readonly="true">${appInfo.appinfo}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">LOGO图片*</label>

                                <div class="col-sm-10">
                                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}${appInfo.logowebpath}"
                                         alt="logo" width="200">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="padding-left: 200px">
                            <button class="btn btn-info" style="background-color: red" ><a href="${ctx}/check_app/pass/${appInfo.id}">通过</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="btn btn-info" style="background-color: red" ><a href="${ctx}/check_app/reject/${appInfo.id}">不通过</a></button>
                        </div>
                    </form>
                </div>
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">历史版本列表</h3>
                    </div>
                    <div class="box-body">

                    </div>
                    <div class="box-body">
                        <table id="versionTable" class="table table-hover">
                            <thead>
                            <tr>
                                <th>软件名称</th>
                                <th>版本号</th>
                                <th>软件大小(单位:M)</th>
                                <th>发布状态</th>
                                <th>APK文件下载</th>
                                <th>最近更新时间</th>

                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${versionList}" var="version">
                                    <tr>
                                        <td>${appInfo.softwarename}</td>
                                        <td>${version.versionno}</td>
                                        <td>${version.versionsize}</td>
                                        <td>${version.publishstatus.valuename}</td>
                                        <td><a href="${pageContext.request.contextPath}/download?versionId=${version.id}">${appInfo.apkname}</a></td>
                                        <td><fmt:formatDate value="${version.modifydate}" pattern="yyyy-MM-dd"/></td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="box-footer">
                            <button type="button" class="btn btn-info" onclick="history.go(-1)">返回</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script>

</script>
</body>
</html>
