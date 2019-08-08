<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<header class="main-header">
    <!-- Logo -->
    <a href="../jsp/index.jsp" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>AppStore</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>AppStore</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <c:if test="${empty devUser}">
                <a  class="btn btn-default btn-flat" href="../jsp/login.jsp" style="color: black">[登录]</a>
                &nbsp;&nbsp;
                <a  class="btn btn-default btn-flat" href="../jsp/register.jsp" style="color: black">[注册]</a>
            </c:if>
            <c:if test="${not empty devUser}">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${pageContext.request.contextPath}/static/images/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${devUser.devcode}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${pageContext.request.contextPath}/static/images/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                        ${devUser.devcode}-开发者
                                    <small><fmt:formatDate value="${devUser.creationdate}" pattern="yyyy-MM-dd HH:mm:ss"/></small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="${ctx}/DevUserDetail" class="btn btn-default btn-flat">个人信息</a>
                                </div>
                                <div class="pull-right">
                                    <a href="${ctx}/logout" class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:if>

        </div>
    </nav>
</header>