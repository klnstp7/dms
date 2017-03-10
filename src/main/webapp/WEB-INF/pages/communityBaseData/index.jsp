<%@ page import="com.yunfang.dms.enums.SourceTableEmum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="toolbar p-5">
    <span class="f-fr toolbar-form">
        <input type="text" name="filter" id="filter" class="form-input f-fl" placeholder="请输入行政区/片区/小区名称/小区地址" 　/>
        <button type="button" class="f-fl form-button" onclick="search()"><i class="fa fa-search"></i>&nbsp;查询</button>
    </span>
    <span class="toolbar-btn-group">
      <!--  <a href="javascript:void(0);" id="addCase"><i class="fa fa-plus-circle"></i>&nbsp;新增案例</a> -->
        <a href="javascript:void(0);" id="allSelect"  data-num="0"><i class="fa fa-navicon"></i>&nbsp;全选</a>
        <a href="javascript:void(0);" id="rowDown"><i class="fa fa-arrow-circle-down"></i>&nbsp;批量下载</a>
        <a href="javascript:void(0);" id="rowDele"><i class="fa fa-times-circle"></i>&nbsp;批量删除</a>
        <a href="javascript:void(0);" id="config"><i class="fa fa-cog"></i>&nbsp;自定义字段</a>
    </span>
</div>
<table id="communityBaseDataTable" class="cell-border nowrap" cellspacing="0" width="100%">
</table>
<div class="" style="margin-top: 20px">
    <div class="panel">
        <div class="panel-title">
            修改记录
        </div>
        <div class="panel-body">
            <table id="communityBaseDataHisTable" class="cell-border nowrap" cellspacing="0" width="100%">
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    var _idx, _dttable,_table;
    var sourceTable;
    <%
    out.print("sourceTable="+SourceTableEmum.CommunityBaseData.ordinal()+";");
    %>
    $(function() {
        _initTable("#communityBaseDataTable","/communityBaseData/getPaging");
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
                postcall("/communityBaseData/batchDownload", {ids: ids}, '_blank');
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

        $('#communityBaseDataTable tbody').on('click', 'tr', function() {
            var _obj = _table.row($(this)).data();
            _initHis("#communityBaseDataHisTable","/communityBaseData/getHis",_obj.id)
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
        $('#communityBaseDataTable').DataTable().clear();
        $('#communityBaseDataTable').DataTable().destroy();
        _initTable("#communityBaseDataTable","/communityBaseData/getPaging");
    }

    function info(id, event) {
        stopBubble(event);
        ModifyView( '查看小区','/communityBaseData/add?action=view&id='+id,"720","567");
    }

    function edit(id, event) {
        stopBubble(event);
        ModifyView( '修改小区','/communityBaseData/add?action=edit&id='+id,"720","567");
    }

    function batchDelete(ids) {
        DeletedBatch('批量删除小区信息后将无法回复,您确定执行次操作？','/communityBaseData/batchDelete',ids);
    }

    function deleted(id, event) {
        stopBubble(event);
        Deleted('小区信息删除后将无法回复,您确定执行次操作？', '/communityBaseData/delete',id);
    }
</script>
