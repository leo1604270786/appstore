<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html lang="en">
<head>
    <title>AppStore</title>

    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!--// Meta tag Keywords -->

    <!-- banner slider css -->
    <link href="${ctx}/static/css/minimal-slider.css" rel='stylesheet' type='text/css' />
    <!-- //banner slider css -->

    <!-- css files -->
    <link rel="stylesheet" href="${ctx}/static/css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
    <link href="${ctx}/static/css/style6.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${ctx}/static/css/style.css" type="text/css" media="all" /> <!-- Style-CSS -->
    <link rel="stylesheet" href="${ctx}/static/css/fontawesome-all.css"> <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->

    <!--web font-->
    <link href="http://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
    <!--//web font-->

</head>

<body>

<!-- header -->
<div class="header-top">
    <header>

        <div class="clearfix"></div>
        <nav class="">
            <div class="row">
                <div class="col-md-3">
                    <div class="logo">
                        <h1>
                            <a class="navbar-brand" href="index.html">
                                <i class="fab fa-cloudversify"></i>appstore</a>
                        </h1>
                    </div>
                </div>
                <div class="col-md-3"></div>
                <div class="col-md-6 top-head ml-lg-auto text-center">
                    <div class="row ">
                        <div class=" col-md-3">
                            <a href="${ctx}/jsp/developer/login.jsp" >
                                普通用户登录</a>
                        </div>
                        <div class="  col-md-3 ">
                            <a href="${ctx}/jsp/backend/login.jsp"  >
                                后台管理员登录</a>
                        </div>
                        <div class="  col-md-3">
                            <a href="${ctx}/jsp/register.jsp"  >
                                注册新账号</a>
                        </div>
                    </div>
                </div>
            </div>

        </nav>

    </header>
</div>
<!-- header -->

<!-- main image slider container -->
<section class="slide-window">
    <div class="slide-wrapper" style="width:300%;">
        <div class="slide">
            <div class="slide-caption text-center">
                <h3 class="text-uppercase">

                </h3>
            </div>
        </div>
        <div class="slide slide2">
            <div class="slide-caption text-center">
                <h3 class="text-uppercase">

                </h3>

            </div>
        </div>
        <div class="slide slide3">
            <div class="slide-caption text-center">
                <h3 class="text-uppercase">

                </h3>


            </div>
        </div>
    </div>
    <div class="slide-controller">
        <div class="slide-control-left">
            <div class="slide-control-line"></div>
            <div class="slide-control-line"></div>
        </div>
        <div class="slide-control-right">
            <div class="slide-control-line"></div>
            <div class="slide-control-line"></div>
        </div>
    </div>
</section>
<!-- //Vertically centered Modal -->

<!-- js -->
<script src="${ctx}/static/js/jquery-2.1.4.min.js"></script>
<script src="${ctx}/static/js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->

<!-- search overlay -->
<script src="${ctx}/static/js/modernizr-2.6.2.min.js"></script>
<!-- //search overlay -->

<!--search jQuery-->
<script src="${ctx}/static/js/classie-search.js"></script>
<script src="${ctx}/static/js/demo1-search.js"></script>
<!--//search jQuery-->

<!-- dropdown nav -->
<script>
    $(document).ready(function() {
        $(".dropdown").hover(
            function() {
                $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                $(this).toggleClass('open');
            },
            function() {
                $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                $(this).toggleClass('open');
            }
        );
    });
</script>
<!-- //dropdown nav -->

<!-- banner slider js -->
<script src="${ctx}/static/js/minimal-slider.js"></script>
<!-- //banner slider js -->

<!-- Stats-Number-Scroller-Animation-JavaScript -->
<script src="${ctx}/static/js/waypoints.min.js"></script>
<script src="${ctx}/static/js/counterup.min.js"></script>
<script>
    jQuery(document).ready(function( $ ) {
        $('.counter').counterUp({
            delay: 100,
            time: 1000
        });
    });
</script>
<!-- //Stats-Number-Scroller-Animation-JavaScript -->

<!-- start-smoth-scrolling -->
<script src="${ctx}/static/js/SmoothScroll.min.js"></script>
<script src="${ctx}/static/js/move-top.js"></script>
<script src="${ctx}/static/js/easing.js"></script>
<script>
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- here stars scrolling icon -->
<script>
    $(document).ready(function() {
        /*
            var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
            };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<!-- //here ends scrolling icon -->
<!-- start-smoth-scrolling -->

</body>
</html>
