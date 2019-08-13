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
                App管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">App审核</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-info box-info-search" style="display: none">
                        <form class="box-header" action="${ctx}/check_app/search" id="search_form">
                            <h3 class="box-title">高级搜索</h3>
                            <div class="box-body">
                                <div class="row form-horizontal">
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="softwarename" class="col-sm-4 control-label">软件名称</label>

                                            <div class="col-sm-8">
                                                <input id="softwarename" name="softwarename" class="form-control" placeholder="软件名称">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="floatformid" class="col-sm-4 control-label">所属平台</label>

                                            <div class="col-sm-8">
                                                <select id="floatformid" name="floatformid" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row form-horizontal">
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="categorylevel1" class="col-sm-4 control-label">一级分类</label>

                                            <div class="col-sm-8">
                                                <select id="categorylevel1" name="categorylevel1" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="categorylevel2"  class="col-sm-4 control-label">二级分类</label>

                                            <div class="col-sm-8">
                                                <select id="categorylevel2" name="categorylevel2" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="categorylevel3" class="col-sm-4 control-label">三级分类</label>

                                            <div class="col-sm-8">
                                                <select id="categorylevel3" name="categorylevel3" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button class="btn btn-info pull-right" type="submit">提交</button>
                            </div>
                        </form>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">App列表</h3>
                        </div>
                        <div class="box-body">
                            <button class="btn btn-primary btn-sm" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-download">搜索</i></button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>软件名称</th>
                                    <th>APK名称</th>
                                    <th>软件大小(单位:M)</th>
                                    <th>所属平台</th>
                                    <th>所属分类(一、二、三级分类)</th>
                                    <th>状态</th>
                                    <th>下载次数</th>
                                    <th>最新版本号</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach var="info" items="${page.result}" varStatus="i">
                                    <tr class="success">
                                        <td class="active">${info.softwarename}</td>
                                        <td class="active">${info.apkname}</td>
                                        <td class="active">${info.softwaresize}</td>
                                        <td class="active">${info.floatformid.valuename}</td>
                                        <td class="active">${info.categorylevel1.categoryname}
                                            ->${info.categorylevel2.categoryname}
                                                ->${info.categorylevel3.categoryname}</td>
                                        <td class="active">${info.status.valuename}</td>
                                        <td class="active">${info.downloads}</td>
                                        <td class="active">${info.appversion.versionno}</td>
                                        <td class="active">
                                            <a href="${ctx}/check_app/check/${info.id}"><button type="button" class="btn btn-danger">审核</button></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div id="page-info" style="width:1000px;height:80px;">
                                <ul class="pager ">
                                    <c:if test="${page.pageNum <= 1}">
                                        <li><a href="javascript:void(0);">« 上一页</a></li>
                                    </c:if>
                                    <c:if test="${page.pageNum > 1}">
                                        <li class="previous"><a href="${ctx}/check_app/list?pageNum=${page.pageNum-1}">« 上一页</a></li>
                                    </c:if>
                                    <c:forEach begin="1" end="${page.pages}" var="pn">
                                        <c:if test="${page.pageNum==pn}">
                                            <li class="active"><a href="javascript:void(0);">${pn}</a></li>
                                        </c:if>
                                        <c:if test="${page.pageNum!=pn}">
                                            <li ><a href="${ctx}/check_app/list?pageNum=${pn}">${pn}</a></li>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${page.pageNum>=page.pages}">
                                        <li><a href="javascript:void(0);">下一页 »</a></li>
                                    </c:if>
                                    <c:if test="${page.pageNum<page.pages}">
                                        <li><a href="${ctx}/check_app/list?pageNum=${page.pageNum+1}">下一页 »</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!-- /.box -->
                </div>
            </div>

        </section>
    </div>
</div>
<!-- /.content-wrapper -->
<jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>

<script>

    $(function () {
        //获取分类列表
        var category = JSON.parse(App.getCategory("level1",""));
        //遍历分类列表，加入到下拉框中
        $.each(category, function (index, data) {
            $("#categorylevel1").append('<option value="'+data.id+'">'+ data.categoryname +'</option>')
        });
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
        var floar = JSON.parse(App.getDictionary("${pageContext.request.contextPath}/app/floar"));
        $.each(floar, function (index, data) {
            $("#floatformid").append('<option value="'+data.id+'">'+ data.valuename +'</option>')
        });
    });

</script>
</body>
</html>
