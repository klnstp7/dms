<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.yunfang.dms.enums.SourceTableEmum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>自荐数据库</title>
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
    <link href="../../resources/lib/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="p-10">
<div class="toolbar p-5">
    <span class="f-fr toolbar-form">
        <input type="text" name="filter" id="filter" class="form-input f-fl"placeholder="请输入行政区/片区/小区名称/小区地址"  />
        <button type="button" class="f-fl form-button"  onclick="search()"><i class="fa fa-search"></i>&nbsp;查询</button>
    </span>
    <span class="toolbar-btn-group">
        <!--  <a href="javascript:void(0);" id="addCase"><i class="fa fa-plus-circle"></i>&nbsp;新增案例</a> -->
        <a href="javascript:void(0);" id="allSelect"  data-num="0" ><i class="fa fa-navicon"></i>&nbsp;全选</a>
        <a href="javascript:void(0);" id="rowDown"><i class="fa fa-arrow-circle-down"></i>&nbsp;批量下载</a>
        <a href="javascript:void(0);" id="rowDele"><i class="fa fa-times-circle"></i>&nbsp;批量删除</a>
        <a href="javascript:void(0);" id="config"><i class="fa fa-cog"></i>&nbsp;自定义字段</a>
        <input type="file" name="file" id="attachUpload" />
        <a href="javascript:void(0);" >导入模版下载</a>
        <a href="javascript:void(0);" >如何自定义模板？</a>
    </span>
</div>
<table id="priceDataTable" class="cell-border nowrap" cellspacing="0" width="100%">
</table>
    <div class="" style="margin-top: 20px">
        <div class="panel">
            <div class="panel-title">
                修改记录
            </div>
            <div class="panel-body">
                <table id="priceHisTable"  class="cell-border nowrap"  cellspacing="0" width="100%">
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/lib/layer/layer.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="../../resources/lib/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="../../resources/lib/help/help.js"></script>
<script type="text/javascript">
var _table, _idx,_dttable;
var sourceTable;
<%
out.print("sourceTable="+SourceTableEmum.UnitBaseData.ordinal()+";");
%>
$(function() {
    $.fn.dataTable.ext.errMode = 'none';
    _initTable("#priceDataTable","/buildingBaseData/getPaging");
    $("input").placeholder();

    $("#rowDown").click(function() {
        if (_table.rows('.selected').data().length == 0) {
            layer.msg("请至少选中一行数据", {
                time: 500
            });
        } else {

        }
    });
    $("#rowDele").click(function() {
        if (_table.rows('.selected').data().length == 0) {
            layer.msg("请至少选中一行数据", {
                time: 500
            });
        } else {

        }
    });

    $("#priceDataTable tbody").on('click', 'tr', function() {
        if (_dttable) {
            _dttable.table().destroy();
            _dttable.table().clear();
        }
        var _obj = _table.row($(this)).data();
        _initHis("#priceDataTable","/unitBaseData/getHis",_obj.id);
    });

    $("#allSelect").click(function () {
        var that =this;
        SeletedAll(that);
    });

    $("#attachUpload").uploadify({
        'swf': '../../resources/lib/uploadify/uploadify.swf',
        //'uploader': '/Project/UploadAttachment?projectId=' + projectId,
        'overrideEvents': ['onDialogClose', 'onSelectError'],
        'removeCompleted': true,
        'onSelect': function() {

        },
        'onSelectError': function(file, errorCode, errorMsg) {

        },
        'onUploadSuccess': function(file, data, response) {

        },
        'onUploadError': function(file, errorCode, errorMsg, errorString) {

        },
        'onQueueComplete': function(queueData) {},
        'height': 18,
        'width': 60,
        'fileTypeDesc': 'Excel',
        'fileTypeExts': '*.xlsx;*.xls',
        'fileSizeLimit': 1024 * 50,
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        'queueID': 'fileQueue',
        'buttonImageURL ':'../../resources/images/bg.png',
        'buttonText': '<span class="fs-md"><i class="fa fa-cloud-upload fs-md"></i></span>导入',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': false
    });

    $("#config").click(function() {
        Config('/extendConfig/index?sourceTable='+sourceTable);
    });
});


function search(){
    $('#priceDataTable').DataTable().clear();//清空数据
    $('#priceDataTable').DataTable().destroy();//销毁datatable
    _initTable("#priceDataTable","/buildingBaseData/getPaging");
}

function edit(id, event) {
    stopBubble(event);
    ModifyView('修改价格数据', '/home/AddPrice?action=edit&id=' + id, "720", "367");
}

function info(id, event) {
    stopBubble(event);
    ModifyView('查看价格数据', '/home/AddPrice?action=view&id='+id,"720","367");
}

function deleted(id, event) {
    stopBubble(event);
    console.log(id);
}

</script>
</body>
</html>