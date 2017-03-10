<%@ page import="com.yunfang.dms.enums.SourceTableEmum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="toolbar p-10">
    <span class="f-fr toolbar-form">
        <input type="text" name="filter" id="filter" class="form-input f-fl" placeholder="请输入行政区/片区/小区名称/小区地址"/>
        <button type="button" class="f-fl form-button" onclick="search()"><i class="fa fa-search"></i>&nbsp;查询</button>
    </span>
    <span class="toolbar-btn-group">
           <!--  <a href="javascript:void(0);" id="addCase"><i class="fa fa-plus-circle"></i>&nbsp;新增案例</a> -->
        <a href="javascript:void(0);" id="allSelect" data-num="0"><i class="fa fa-navicon"></i>&nbsp;全选</a>
        <a href="javascript:void(0);" id="rowDown"><i class="fa fa-arrow-circle-down"></i>&nbsp;批量下载</a>
         <a href="javascript:void(0);" id="rowDele"><i class="fa fa-times-circle"></i>&nbsp;批量删除</a>
          <a href="javascript:void(0);" id="config"><i class="fa fa-cog"></i>&nbsp;自定义字段</a>
    </span>
</div>
<div class="f-cf autoprefixed md">
    <div class="autoprefixed-fl">
        <div class="autoprefixed-fl-wrap">
            <div class="panel">
                <div class="panel-title">
                    报告案例
                </div>
                <div class="panel-body">
                    <table id="reportCaseTable" class="cell-border nowrap" cellspacing="0" width="100%">
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="autoprefixed-fr">
        <div class="panel">
            <div class="panel-title">
                报告文件
            </div>
            <div class="panel-body">
                <table id="reportTable" class="display" cellspacing="0" width="100%">
                </table>
            </div>
        </div>
        <div class="panel m-t-5">
            <div class="panel-title">
                修改记录
            </div>
            <div class="panel-body">
                <table id="reportCaseHisTable" class="cell-border nowrap" cellspacing="0" width="100%">
                </table>
            </div>
        </div>
    </div>
</div>
<table id="tb" class="display">
</table>
<script type="text/javascript">
    var _idx, _dttable,_table,_reportTable;
    var sourceTable;
    <%
    out.print("sourceTable="+SourceTableEmum.ReportCase.ordinal()+";");
    %>
    $(function() {
        _initTable("#reportCaseTable","/reportCase/getPaging");
        $("input").placeholder();

        $("#rowDown").click(function() {
            if (_table.rows('.selected').data().length == 0) {
                layer.msg("请至少选中一行数据", {
                    time: 500
                });
            } else {
                var array=_table.rows('.selected').data();
                var ids=new Array();
                for(var k = 0; k < array.length; k++){
                    ids.push(array[k].id);
                }
                postcall("/reportCase/batchDownload", {ids: ids}, '_blank');
            }
        });
        $("#rowDele").click(function() {
            if (_table.rows('.selected').data().length == 0) {
                layer.msg("请至少选中一行数据", {
                    time: 500
                });
            } else {
                var array=_table.rows('.selected').data();
                var ids=new Array();
                for(var k = 0; k < array.length; k++){
                    ids.push(array[k].id);
                }
                batchDelete(ids);
            }
        });

        $('#reportCaseTable tbody').on('click', 'tr', function() {
            var _obj = _table.row($(this)).data();
            _initHis("#reportCaseHisTable","/reportCase/getHis",_obj.id);
            initReportTable(_obj.id);
        });

        $("#allSelect").click(function() {
            var that =this;
            SeletedAll(that);
        });

        $("#config").click(function() {
            Config('/extendConfig/index?sourceTable='+sourceTable);
        });
    });


    function search(){
        $('#reportCaseTable').DataTable().clear();
        $('#reportCaseTable').DataTable().destroy();
        _initTable("#reportCaseTable","/reportCase/getPaging");
    }

    function info(id, event) {
        stopBubble(event);
        ModifyView("查看报告案例", '/reportCase/add?action=view&id='+id,"720","567");
    }

    function edit(id, event) {
        stopBubble(event);
        ModifyView("修改报告案例", '/reportCase/add?action=edit&id='+id,"720","567");
    }

    function batchDelete(ids) {
        DeletedBatch('批量删除报告案例后将无法回复,您确定执行次操作？', '/reportCase/batchDelete',ids);
    }

    function deleted(id, event) {
        stopBubble(event);
        Deleted('报告案例删除后将无法回复,您确定执行次操作？','/reportCase/delete',id);
    }
    function initReportTable(id) {
        if (_reportTable) {
            _reportTable.table().destroy();
            _reportTable.table().clear();
        }
        _reportTable = $('#reportTable').DataTable({
            "language": {
                "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
            },
            "bServerSide":true,
            "destroy": true,
            "bDestroy": true,
            "dom": '<"toolbar">frtip',
            "bRetrieve": true,
            "scrollX": true,
            "processing": false,
            "bAutoWidth":false,
            "searching": false,
            "sPaginationType": "full_numbers",
            "ordering": false,
            "autoWidth": false,
            "iScrollLoadGap": 10,
            "aLengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "所有"]
            ],
            "serverSide":true,
            "ajax":  {
                url: "/reportCase/getReports",
                type: "GET",
                cache:false,
                data: {id: id}
            },
            "columns": [
                {data: "name",title:"文档名称"},
                {data: "operator",title:"上传者"},
                {'targets': 4,title:"操作",
                'render': function(data, type, full, meta) {
                    return '<a class="" href="javascript:void(0);" onclick=downloadReport(' + full.id + ')>下载</a>';
                }
            }]
        });
    }

    function downloadReport(id){
        postcall("/reportCase/downloadReport", {id: id}, '_blank');
    }

</script>
