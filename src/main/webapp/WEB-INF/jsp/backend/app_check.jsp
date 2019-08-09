<%--
  Created by IntelliJ IDEA.
  User: Candy
  Date: 2019/8/7
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>AppStore | 控制面板</title>
        <jsp:include page="../includes/header.jsp"/>
        <style type="text/css">
            .mg-t-10{
                margin-top: 10px;
            }
            .sub-line{
                border-bottom: 1px solid #E6E6FA;
            }
            .l-h-28{
                line-height: 28px;
            }

            .table{
                border-collapse: separate;
                border-spacing:0 10px;  /*0表示表格左右边距 列与列 5表示上下边距 行与行*/
            }

            .table tr,.table tr td{
                border: none !important;
            }
            .table .title{
                width: 112px;
            }
            .table td .textarea-none{
                width: 100%;
                border: none;
                background:  #f5f5f5;/*@well-bg;*/
            }
            .table td .textarea{
                width: 100%;
                margin-left: -6px;
            }
            /*去掉textarea点击后的边框*/
            .table td textarea:focus{outline:none}

            /*添加cell的border*/
            .table .td-border-1{
                border: 1px solid #A9A9A9 !important;
            }
        </style>
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
                    App基础信息维护
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active">App基础信息维护</li>
                </ol>
            </section>

        <div class="content">
            <div class="container">
                <div class="col-sm-12 sub-line l-h-28">
                    <span>APP基础信息</span>
                </div>
                <div class="col-sm-12">
                    <div class="col-sm-offset-2">
                        <table class="table" id="info_table" style="table-layout:fixed;">
                            <tbody>
                            <tr>
                                <td class="title">软件名称 *</td>
                                <td class="well">你好啊</td>
                            </tr>
                            <tr>
                                <td class="title">APK名称 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">APK名称 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">支持ROM *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">界面语言 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">软件大小 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">下载次数 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">所属平台 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">APP状态 *</td>
                                <td class="well"></td>
                            </tr>
                            <tr>
                                <td class="title">应用简介 *</td>
                                <td class="well"><textarea rows="3" class="textarea-none" readonly placeholder="我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容我是内容"></textarea></td>
                            </tr>
                            <tr>
                                <td class="title">LOGO图片 *</td>
                                <td class="">
                                    <div>
                                        <img src="${pageContext.request.contextPath}/static/images/credit/qixi.jpg" width="112px;" height="112px;">
                                        <div class="mg-t-10">
                                            <input type="button" class="btn btn-info" name="" value="审核通过">
                                            <input type="button" class="btn btn-info" name="" value="审核不通过">
                                            <input type="button" class="btn btn-primary" name="" value="返回">
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <span class="col-sm-12 sub-line l-h-28">最新版本信息</span>
                </div>
                <div class="col-sm-12">
                    <div class="col-sm-offset-2">
                        <table class="table" id="table" style="table-layout:fixed;">
                            <tbody>
                            <tr>
                                <td class="title">版本号 *</td>
                                <td class="well">v1.1 1</td>
                            </tr>
                            <tr>
                                <td class="title">版本大小 *</td>
                                <td class="td-border-1"></td>
                            </tr>
                            <tr>
                                <td class="title">发布状态 *</td>
                                <td class="">待发布</td>
                            </tr>
                            <tr>
                                <td class="title">应用简介 *</td>
                                <td class=""><textarea rows="3" class="textarea" readonly placeholder="v1.1 1简介"></textarea></td>
                            </tr>
                            <tr>
                                <td class="title">apk文件 *</td>
                                <td class="">com.download.jjdisf.test.apk <a href="/下载路径">下载</a></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>>

</body>
</html>
