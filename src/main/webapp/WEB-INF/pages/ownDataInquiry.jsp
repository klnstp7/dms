<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="toolbar p-5">
    <span class="f-fr toolbar-form">
        <input type="text" name="" id="" class="form-input f-fl" />
        <button type="button" class="f-fl form-button"><i class="fa fa-search"></i>&nbsp;查询</button>
    </span>
    <span class="toolbar-btn-group">
      <!--  <a href="javascript:void(0);" id="addCase"><i class="fa fa-plus-circle"></i>&nbsp;新增案例</a> -->
        <a href="javascript:void(0);" id="allSelect"><i class="fa fa-navicon"></i>&nbsp;全选</a>
        <a href="javascript:void(0);" id="rowDown"><i class="fa fa-arrow-circle-down"></i>&nbsp;批量下载</a>
         <a href="javascript:void(0);" id="rowDele"><i class="fa fa-times-circle"></i>&nbsp;批量删除</a>
    </span>
</div>
<table id="example" class="display compact" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>询价时间</th>
            <th>询价来源</th>
            <th>城市</th>
            <th>行政区</th>
            <th>片区</th>
            <th>小区名称</th>
            <th>小区地址</th>
            <th>建成年代</th>
            <th>建筑面积(㎡)</th>
            <th>询价价格(万)</th>
            <th>价格时点</th>
            <th>操作</th>
        </tr>
    </thead>
</table>
<div class="" style="margin-top: 20px">
    <div class="panel">
        <div class="panel-title">
            修改记录
        </div>
        <div class="panel-body">
            <table id="tb" class="display">
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" >
var dataSet = [{
    "id": "1",
    "InquiryTime": "2017-12-12",
    "ProjectSource": "电话",
    "city": "北京",
    "region": "西城区",
    "district": "车公庄",
    "residentialAreaName": "五栋大楼",
    "residentialAreaAddress": "五栋大楼",
    "builtYear": "2010",
    "area": "90",
    "price": "45000",
    "priceTime": "2010-12-21",
}, {
    "id": "2",
    "InquiryTime": "2017-12-12",
    "ProjectSource": "电话",
    "city": "北京",
    "region": "西城区",
    "district": "车公庄",
    "residentialAreaName": "五栋大楼",
    "residentialAreaAddress": "五栋大楼",
    "builtYear": "2010",
    "area": "90",
    "price": "45000",
    "priceTime": "2010-12-21",
}];
var _idx, _dttable;
$(function() {

    _table = $('#example').DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "processing": true,
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "iScrollLoadGap": 10,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "data": dataSet,
        "fnInitComplete": function(oSettings, json) {
            var _obj = oSettings.aoData[0]._aData;
            editList(_obj);
        },
        "columns": [{
            data: "InquiryTime"
        }, {
            data: "ProjectSource"
        }, {
            data: "city"
        }, {
            data: "region"
        }, {
            data: "district"
        }, {
            data: "residentialAreaName"
        }, {
            data: "residentialAreaAddress"
        }, {
            data: "builtYear"
        }, {
            data: "area"
        }, {
            data: "price"
        }, {
            data: "priceTime"
        }, {
            'targets': 12,
            'render': function(data, type, full, meta) {
                return '<a class="f-ib" href="javascript:void(0);" onclick=info(' + full.id + ',event)><i class="ico ico-info"></i></a>&nbsp;<a class="f-ib"  href="javascript:void(0);" onclick=edit(' + full.id + ',event)><i class="ico ico-edit"></i></a>&nbsp;<a class="f-ib" onclick=deleted(' + full.id + ',event) href="javascript:void(0);"><i class="ico ico-del"></i></a>';
            }
        }]
    });

    $("#addCase").click(function() {
        layer.open({
            type: 2,
            title: '新增询价案例',
            shadeClose: false,
            closeBtn: 0,
            shade: 0.8,
            area: ['720px', '567px'],
            content: '/home/AddInquiryCase'
        });
    });

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

    $('#example tbody').on('click', 'tr', function() {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        } else {
            $(this).addClass('selected');
        }
        if (_dttable) {
            _dttable.table().destroy();
        }
        var _obj = _table.row($(this)).data();
        editList(_obj);
    });

    $("#allSelect").click(function() {
        if ($('#example tbody tr').length > 0) {
            $('#example tbody tr').toggleClass('selected');
        }
    });
});


function editList(obj) {
    _dttable = $('#tb').DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "processing": true,
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "iScrollLoadGap": 10,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "data": dataSet,
        "columns": [{
            title: "询价时间",
            data: "InquiryTime"
        }, {
            title: "询价时间",
            data: "ProjectSource"
        }, {
            title: "询价时间",
            data: "city"
        }, {
            title: "询价时间",
            data: "region"
        }, {
            title: "询价时间",
            data: "district"
        }, {
            title: "询价时间",
            data: "residentialAreaName"
        }, {
            title: "询价时间",
            data: "residentialAreaAddress"
        }, {
            title: "询价时间",
            data: "builtYear"
        }, {
            title: "询价时间",
            data: "area"
        }, {
            title: "询价时间",
            data: "price"
        }, {
            title: "询价时间",
            data: "priceTime"
        }]
    });
}

function info(id, event) {
    stopBubble(event);
}

function edit(id, event) {
    stopBubble(event);
    layer.open({
        type: 2,
        title: '修改询价案例',
        shadeClose: false,
        shade: 0.8,
        closeBtn: 0,
        area: ['720px', '567px'],
        content: '/home/AddInquiryCase'
    });
}

function deleted(id, event) {
    stopBubble(event);
    _idx = layer.confirm('案例删除后将无法回复,您确定执行次操作？', {
        btn: ['确认', '取消'],
        icon: 2,
        shade: 0
    }, function() {
        layer.close(_idx);
    });
}
</script>
