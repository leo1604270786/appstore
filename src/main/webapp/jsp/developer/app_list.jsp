<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                App信息维护
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">App信息维护</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                            <div class="box-body">
                                <div class="row form-horizontal">
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="softwarename" class="col-sm-4 control-label">软件名称</label>

                                            <div class="col-sm-8">
                                                <input id="softwarename" class="form-control" placeholder="软件名称">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="status" class="col-sm-4 control-label">App状态</label>

                                            <div class="col-sm-8">
                                                <select id="status" class="form-control">
                                                    <option value="">请选择</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="floatformid" class="col-sm-4 control-label">所属平台</label>

                                            <div class="col-sm-8">
                                                <select id="floatformid" class="form-control">
                                                    <option value="">请选择</option>
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
                                                <select id="categorylevel1" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="categorylevel2" class="col-sm-4 control-label">二级分类</label>

                                            <div class="col-sm-8">
                                                <select id="categorylevel2" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <div class="form-group">
                                            <label for="categorylevel3" class="col-sm-4 control-label">三级分类</label>

                                            <div class="col-sm-8">
                                                <select id="categorylevel3" class="form-control">
                                                    <option value="">--请选择--</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button class="btn btn-info pull-right" onclick="search();">提交</button>
                            </div>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">App列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="${pageContext.request.contextPath}/app/form" type="button" class="btn btn-default btn-sm"><i class="fa fa-plus">新增</i></a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-default btn-sm" onclick="App.deleteMulti('/user/delete')"><i class="fa fa-trash">删除</i></button>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-download">导入</i></a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-upload">导出</i></a>&nbsp;&nbsp;&nbsp;
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
                                    <th>所属分类(一级、二级、三级分类)</th>
                                    <th>状态</th>
                                    <th>下载次数</th>
                                    <th>最新版本号</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>

                            </table>
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
    var dataTable;
    $(function () {
        //初始化DataTables
        var columns = [
            {"data": "softwarename"},
            {"data": "apkname"},
            {"data": "softwaresize"},
            {"data": "floatformid.valuename"},
            {"data": "categorylevel.categoryname"},
            {"data": "status.valuename"},
            {"data": "downloads"},
            {"data": "appversion.versionno"},
            {
                "data": function (row, type, val, meta) {
                    var detaleUrl = "/user/detail?id=" + row.id;
                    return '<button class="btn btn-default btn-sm" onclick="#"><i class="fa fa-search">查看</i></button>&nbsp;&nbsp;&nbsp;' +
                        '<a href="${pageContext.request.contextPath}/app/form?id=' + row.id + '" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit">编辑</i></a>&nbsp;&nbsp;&nbsp;' +
                        '<button class="btn btn-danger btn-sm" onclick="#"><i class="fa fa-trash-o">删除</i></button>';
                }
            }
        ];
        dataTable = App.initDataTables("/appstore"+"/app/page",columns);
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
            //加入第一个请选择
            $("#categorylevel2").append('<option value="">--请选择--</option>');
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
    });
    function search() {
        var softwarename = $("#softwarename").val();
        var status = $("#status").val();
        var floatformid = $("#floatformid").val();
        var categorylevel1 = $("#categorylevel1").val();
        var categorylevel2 = $("#categorylevel2").val();
        var categorylevel3 = $("#categorylevel3").val();
        //查询参数
        var param = {
            "softwarename":softwarename,
            "status.id":status,
            "floatformid.id":floatformid,
            "categorylevel1.id":categorylevel1,
            "categorylevel2.id":categorylevel2,
            "categorylevel3.id":categorylevel3
        };
        if (softwarename === ''){
            delete param.softwarename;
        }
        if (status === ''){
            delete param["status.id"];
        }
        if (floatformid === ''){
            delete param["floatformid.id"];
        }
        if (categorylevel1 === ''){
            delete param["categorylevel1.id"];
        }
        if (categorylevel2 === ''){
            delete param["categorylevel2.id"];
        }
        if (categorylevel3 === ''){
            delete param["categorylevel3.id"];
        }
        console.log(param);
        if (param !== {}){
            //设置参数，重新加载
            dataTable.settings()[0].ajax.data = param;
            dataTable.ajax.reload();
        }
    }
</script>
</body>
</html>
