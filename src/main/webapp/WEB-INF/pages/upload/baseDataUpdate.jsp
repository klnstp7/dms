<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
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
    <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]>
    <link href="../../../resources/css/font-awesome-ie7.min.css" rel="stylesheet"  type="text/css" >
    <![endif]-->
    <link href="../../../resources/lib/jquery-dataTable/css/jquery.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../../resources/lib/jquery-dataTable-fixedColumns/fixedColumns.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../../resources/lib/jquery-dataTable-Select/css/select.dataTables.min.css"  rel="stylesheet" type="text/css" />
    <link href="../../../resources/lib/uploadify/uploadify.css" rel="stylesheet" type="text/css"/>
    <link href="../../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="p-10 m-t-5 casetdst">
    <table class="f-cf casetdstTitle">
        <tr>
            <td>
                <label for="community">
                    <input type="radio" name="type" id="community" value="community"
                           checked="checked"/>小区基础数据</label>
            </td>
            <td>
                <label for="building">
                    <input type="radio" name="type" id="building" value="building" />楼幢基础数据</label>
            </td>
            <td>
                <label for="unit">
                    <input type="radio" name="type" id="unit" value="unit" />单元基础数据</label>
            </td>
            <td>
                <label for="house">
                    <input type="radio" name="type" id="house" value="house"/>户基础数据</label>
            </td>
        </tr>
    </table>
    <div id="casetdstBody">
        <div class="caseUpload">
            <table class="attch">
                <tr>
                    <td>
                        <input type="file" name="file" id="attachUpload"/>
                    </td>
                    <td>
                        <!--   <button type="button" class="btn"><i class="fa fa-cloud-upload"></i>导入文件</button> -->
                        <a href="../../../resources/exceltemplate/小区基础数据-模版.xlsx" id="a_filedown" download="小区基础数据-模版.xlsx"
                           class="link">Excel模版下载</a>
                        <a href="http://101.200.145.92:9199/bin/view/Main/%E6%93%8D%E4%BD%9C%E7%B1%BB%E9%97%AE%E9%A2%98/%E9%A2%84%E4%BC%B0%E5%8D%95%E8%87%AA%E5%AE%9A%E4%B9%89%E6%A8%A1%E7%89%88/"
                           target="_blank" class="link">如何自定义模板</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="p-10 m-t-5 updataResult" id="updataResult">
    <ul class="f-cf">
        <li class="noborder">
            <a href="javascript:void(0)" class="f-ib">结果</a>
        </li>
        <li class="">
            <span class="total" id="title_total"></span>
            <a href="javascript:void(0)" class="f-ib f-tc">失败</a>
        </li>
        <li class="">
            <a href="javascript:void(0)" class="f-ib f-tc">导入提示</a>
        </li>
    </ul>
    <div class="updataResultWrap">
        <div class="casetdst wrapstatue">
            <div class="result">
                <div class="f-fwb txt">
                    <p> 导入结果：</p>
                    <p>本次上传数据总数：<span id="span_total"></span></p>
                    <p>成功新增数据总数：<span id="span_success"></span></p>
                    <p>成功更新数据总数：<span id="span_update"></span></p>
                    <p>上传失败数据总数：<span id="span_fail"></span></p>
                </div>
                <div>
                    <button type="button" id="btn_exporterror" class="btn btn-xs btn-import"
                            onclick="exportErrorData();" style="display: none">导出失败案例
                    </button>
                </div>
            </div>
        </div>
        <div class="wrapstatue">
            <table  id="errorresult" class="cell-border nowrap" cellspacing="0" width="100%">
            </table>
        </div>
        <div class="wrapstatue tips">
            <ul>
                <li>1、字段类型说明，如：建筑面积：数字类型（120.23），询价日期：时间类型（2017-01-01 12:00:00）</li>
                <li>2、同一个Excel文件不同sheet中的列头必须保证一致，以免导入失败；注意：不可修改模版中的列头，自定义字段除外</li>
                <li>3、需要使用扩展字段时，请首先在对应的案例中增加自定义字段</li>
                <li>4、导入报告文档时，需要将报告的所有文件压缩到一个压缩包中；文件名必须是报告编号，如：201700211212.rar或者201700211212.zip，且报告编号必须在系统中存在</li>
            </ul>
        </div>
    </div

</div>
<script type="text/javascript" src="../../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/lib/layer/layer.js"></script>
<script type="text/javascript" src="../../../resources/lib/jquery-dataTable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../../resources/lib/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="../../../resources/lib/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="../../../resources/lib/uploadify/jquery.uploadify.min.js" ></script>
<script type="text/javascript" src="../../../resources/lib/help/help.js"></script>
<script type="text/javascript">
    var tips;
    var _dataTable;
    var cols = [];
    var errorData = [];
    var successCount = 0;//成功新增数据的条数
    var updateCount=0;//成功更新数据的条数
    var fileQueens = [];//队列中的文件名
    $(function () {
        $.fn.dataTable.ext.errMode = 'none';
        $("#casetdstBody .caseUpload").eq(0).show();
        $("input[name=type]").change(function () {
            var datatype = $(this).val();
            errorData = [];
            successCount = 0;
            if (datatype == "community") {
                $("#a_filedown").attr("href", "../../../resources/exceltemplate/小区基础数据-模版.xlsx");
                $("#a_filedown").attr("download", "小区基础数据-模版.xlsx");
            }
            if (datatype == "building") {
                $("#a_filedown").attr("href", "../../../resources/exceltemplate/楼幢基础数据-模版.xlsx");
                $("#a_filedown").attr("download", "楼幢基础数据-模版.xlsx");
            }
            if (datatype == "unit") {
                $("#a_filedown").attr("href", "../../../resources/exceltemplate/单元基础数据-模版.xlsx");
                $("#a_filedown").attr("download", "单元基础数据-模版.xlsx");
            }
            if (datatype == "house") {
                $("#a_filedown").attr("href", "../../../resources/exceltemplate/户基础数据-模版.xlsx");
                $("#a_filedown").attr("download", "户基础数据-模版.xlsx");
            }
//            $("#span_total").html("");
//            $("#span_success").html("");
//            $("#span_update").html("");
//            $("#span_fail").html("");
//            $("#title_total").html("");
        });

        $("#updataResult .wrapstatue").eq(0).show();
        $("#updataResult ul li").eq(0).addClass("current");
        $("#updataResult ul li").bind("click", function () {
            var i = $(this).index();
            $(this).siblings("li").removeClass("current");
            $(this).addClass("current");
            $("#updataResult .wrapstatue").hide();
            $("#updataResult .wrapstatue").eq(i).show();
            $("#updataResult .wrapstatue").eq(i).find(".display").css({
                "width": "100%"
            });
        });
        intUpload();
    });

    //案例数据导入文件
    function intUpload() {
        var fileTypeDesc = "Excel";
        var fileTypeExts = "*.xls;*.xlsx";
        var buttonText = "选择上传Excel数据文件";
        //附件上传
        $("#attachUpload").uploadify({
            'swf': '/../../../resources/lib/uploadify/uploadify.swf',
            //'uploader': '/Project/UploadAttachment?projectId=' + projectId,
            'uploader': '/upload/uploadAttach',
            'overrideEvents': ['onDialogClose', 'onSelectError'],
            'removeCompleted': true,
            'method': 'get',
            'onSelect': function () {
                errorData = [];
                successCount = 0;
                updateCount=0;
            },
            'onSelectError': function (file, errorCode, errorMsg) {

            },
            'onUploadSuccess': function (file, data, response) {
                var retundata = JSON.parse(data);
                if (retundata.success) {
                    retundata.data.data.aaData.forEach(function (item) {
                        errorData.push(item);
                    });
                    successCount += retundata.data.successCount;
                    updateCount+=retundata.data.updateCount;
                }
                else {
                    layer.alert(retundata.msg, {icon: 2});
                }
            },
            'onUploadError': function (file, errorCode, errorMsg, errorString) {

            },
            'onUploadStart': function (file) {
                tips = layer.load(1, {
                    shade: [0.1, '#fff'] //0.1透明度的白色背景
                });
                var dataType = $("input[name='type']:checked").val();
                $("#attachUpload").uploadify("settings", 'formData', {dataType: dataType});
            },
            'onQueueComplete': function (queueData) {
                layer.close(tips);
                //返回结果，并绑定列表
                $("#span_total").html(successCount +updateCount+ errorData.length);
                $("#span_success").html(successCount);
                $("#span_update").html(updateCount);
                $("#span_fail").html(errorData.length);
                $("#title_total").html(errorData.length);
                _initDataTable(errorData, _getGridCols($("input[name='type']:checked").val(),"baseData"));
                $("#attachUpload").uploadify("cancel","*");
                if(errorData.length>0){
                    $("#btn_exporterror").show();
                }
            },
            'height': 30,
            'width': 200,
            'fileTypeDesc': fileTypeDesc,
            'fileTypeExts': fileTypeExts,
            'fileSizeLimit': 1024 * 50,
            //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
            'queueID': 'fileQueue',
            'buttonText': buttonText,
            //选择文件后自动上传
            'auto': true,
            //设置为true将允许多文件上传
            'multi': true
        });
    }

    //导出错误数据
    function exportErrorData() {
        //window.open()
        var dataType = $("input[name='type']:checked").val();
        var jsonStr = JSON.stringify(errorData);
        postcall("/upload/exportError", {dataType: dataType, jsonStr: jsonStr}, '_blank');
    }
</script>
</body>
</html>