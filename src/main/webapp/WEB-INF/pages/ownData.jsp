<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>自建数据</title>
    <meta name="Keywords" content="" />
    <meta name="Description" content="" />
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta content="0" http-equiv="expires" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <meta content="no-cache,must-revalidate" http-equiv="Cache-Control" />
    <meta content="telephone=no, address=no" name="format-detection" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <link href="../../resources/css/base.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]>
    <link href="../../resources/css/font-awesome-ie7.min.css" rel="stylesheet"  type="text/css" >
    <![endif]-->
    <link href="../../resources/lib/jquery-dataTable/css/jquery.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../resources/lib/jquery-dataTable-fixedColumns/fixedColumns.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../resources/lib/jquery-dataTable-Select/css/select.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="p-10">
    <ul class="f-cf nav-tab " id="nav-tab">
        <li class="f-fl first current" data-links="/inquiryData/index">
            <div class="wrap">
                <p class="f-cf nav-tab-wrap">
                        <span class="f-fr">
                        <span class="num">2000</span>
                        <br/>
                        <span>询价案例</span>
                        </span>
                    <i class="ico"></i>
                </p>
            </div>
        </li>
        <li class="f-fl second" data-links="/transactionCase/index">
            <div class="wrap">
                <p class="f-cf nav-tab-wrap">
                        <span class="f-fr">
                        <span class="num">1888</span>
                        <br/>
                        <span>成交案例</span>
                        </span>
                    <i class="ico"></i>
                </p>
            </div>
        </li>
        <li class="f-fl three" data-links="/offerCase/index">
            <div class="wrap">
                <p class="f-cf nav-tab-wrap">
                        <span class="f-fr">
                        <span class="num">1999</span>
                        <br/>
                        <span>报盘案例</span>
                        </span>
                    <i class="ico"></i>
                </p>
            </div>
        </li>
        <li class="f-fl four" data-links="/reportCase/index">
            <div class="wrap">
                <p class="f-cf nav-tab-wrap">
                        <span class="f-fr">
                        <span class="num">1777</span>
                        <br/>
                        <span>报告案例</span>
                        </span>
                    <i class="ico"></i>
                </p>
            </div>
        </li>
        <li class="f-fl five" data-links="/owndata/ownDataUpdate">
            <div class="wrap">
                <p class="f-cf nav-tab-wrap">
                        <span class="f-fr">
                        <span class="special">上传案例</span>
                        </span>
                    <i class="ico"></i>
                </p>
            </div>
        </li>
    </ul>
    <div id="mainWrap">

    </div>
    <iframe id="mainWrapFrame" style="display: none;width: 100%"  src="/owndata/ownDataUpdate"></iframe>
</div>
<script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/lib/layer/layer.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="../../resources/lib/help/help.js"></script>
<script type="text/javascript">
    var _loading,_table;
    $(function () {
        $.fn.dataTable.ext.errMode = 'none';
        loadingHtml('/inquiryData/index',function(_result){
            $("#mainWrap").html("").html(_result);
        });
        $("#nav-tab li").click(function () {
            $(this).addClass("current").siblings("li").removeClass("current");
            var _url = $(this).attr("data-links");
            if($(this).index()==4){
                $("#mainWrap").html("");
                $("#mainWrapFrame").css({"height":$(window).height()-$("#nav-tab").height()-30}).show();
            }else{
                loadingHtml(_url,function(_result){
                    $("#mainWrap").html("").html(_result);
                    $("#mainWrapFrame").hide();
                });
            }
        });
    });

    function loadingHtml(url,fn) {
        _loading = layer.load(2);
        $.ajax({
            url: url,
            type: 'GET',
            beforesend: _loading,
            data: {},
            success: function(result) {
                fn&&fn(result);
                layer.close(_loading);
            },
            error: function() {
                layer.close(_loading);
                layer.open({
                    content: '网络异常,请稍后再试!'
                });
            }
        });
    }
</script>
</body>

</html>
