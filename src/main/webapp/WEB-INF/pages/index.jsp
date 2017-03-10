<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>自有数据</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta content="0" http-equiv="expires"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport"/>
    <meta content="no-cache,must-revalidate" http-equiv="Cache-Control"/>
    <meta content="telephone=no, address=no" name="format-detection"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <link href="../../resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link href="../../resources/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css">
    <![endif]-->
    <link href="../../resources/css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body class="f-oh">
<div class="nav f-cw f-cf f-oh">
    <p class="f-fr nav-user">
        <span class="f-cw"><i class="fa fa-map-marker"></i>&nbsp;&nbsp;<span id="cityName">北京市</span></span>
        <a href="javascript:void(0);" class="f-cw" id="changeCity"><i class="fa fa-chevron-circle-down"></i></a>
        <a href="javascript:void(0);" class="f-cw"><i class="fa fa-user"></i><span id="username"></span></a>
        <%--<a href="javascript:void(0);" class="f-cw" id="logout"><i class="fa fa-power-off"></i>退出</a>--%>
    <div class="f-pa nav-cityList" id="cityList" style="display:none; ">
        <a href="javascript:void(0);" onclick="selected('北京市',event)">北京市</a>
        <a href="javascript:void(0);" onclick="selected('上海市',event)">上海市</a>
        <a href="javascript:void(0);" onclick="selected('广州市',event)">广州市</a>
        <a href="javascript:void(0);" onclick="selected('深圳市',event)">深圳市</a>
    </div>
    </p>
    <div class="f-fl nav-logo">
        <p class="f-fl f-ib"><span class="f-ib ico"></span></p>
        <ul class="f-fl f-ib">
            <li class="f-fl f-ib current"><a data-link="/home/ownData" href="javascript:void(0)">案例数据</a></li>
            <li class="f-fl f-ib"><a data-link="/home/baseData" href="javascript:void(0)">基础数据</a></li>
            <li class="f-fl f-ib"><a data-link="/home/price" href="javascript:void(0)">价格数据</a></li>
        </ul>
    </div>
</div>
<iframe id="frame-container" class="frame-container wrap" src="/home/ownData"></iframe>
<script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        initHeight();
        $(".nav-logo ul li").click(function () {
            $(this).addClass("current").siblings("li").removeClass("current");
            $("#frame-container").attr("src", $(this).find("a").attr("data-link"));
        });
        $(window).resize(initHeight);
        $(document).click(function (event) {
            event.preventDefault();
            $("#cityList").hide();
        });

        $("#changeCity").click(function (event) {
            event.stopPropagation();
            $("#cityList").toggle();
        });
        $("#username").html(getCookie("DmsUserName"));
        $("#cityName").text(getCookie("CityName"));
    });
    function getCookie(name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        debugger;
        arr = document.cookie.match(reg)
        if (arr)
            return decodeURI(arr[2]);
        else
            return null;
    }
    function initHeight() {
        var _navbarHeight = $(".nav").height();
        $("#frame-container").height(parseInt($(window).height()) - _navbarHeight);
    }


    function selected(item, event) {
        stopBubble(event);
         $.ajax({
             url: '/home/changeCity',
             type: "post",
             cache: false,
             data: { cityName: item },
             success: function(result) {
                 $("#cityName").text(item);
                 $("#cityList").hide();
             }
         });
    }

    function stopBubble(e) {
        if (e && e.stopPropagation) {
            e.stopPropagation();
        } else {
            window.event.cancelBubble = true;
        }
    }
</script>
</body>

</html>
