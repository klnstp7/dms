//通过配置获取列表列头
function getAllTitles(sourceTable, isHis, needOperate) {
    var cols = [];
    $.ajax({
        url: "/owndata/getAllTitles",
        data: {sourceTable: sourceTable, isHis: isHis},
        async: false,
        type: "Post",
        success: function (data) {
            $.each(data, function (name, value) {
                if (value == "community") {
                    cols.push({data: "" + name + "", title: "" + value + "", render: _render1, width: "120px"});
                } else if (value == "address") {
                    cols.push({data: "" + name + "", title: "" + value + "", render: _render2, width: "240px"});
                }
                else {
                    cols.push({data: "" + name + "", title: "" + value + "", width: "10%"});
                }
            });
        }
    });
    if (needOperate) {
        cols.push({targets: -1, title: "操作", render: _renderOperate})
    }
    return cols;
}

//上传获取列头
function _getGridCols(_datatype, _belongModel) {
    var cols = [];
    $.ajax({
        url: "/owndata/getGridCols",
        data: {dataType: _datatype, belongModel: _belongModel},
        async: false,
        type: "Post",
        success: function (data) {
            $.each(data, function (name, value) {
                if (value == "community") {
                    cols.push({data: "" + value + "", title: "" + name + "", render: _render1, width: "120px"});
                } else if (value == "address") {
                    cols.push({data: "" + value + "", title: "" + name + "", render: _render2, width: "240px"});
                }
                else {
                    cols.push({data: "" + value + "", title: "" + name + ""});
                }
            });
            $.ajax({
                url: "/owndata/getExtendCol",
                data: {dataType: _datatype, belongModel: _belongModel},
                async: false,
                type: "Post",
                success: function (data) {
                    data.forEach(function (item) {
                        cols.push({data: "" + item + "", title: "" + item + ""});
                    });
                }
            });
        }
    });
    if (_belongModel == "ownerData" || _belongModel == "baseData") {
        cols.push({data: "errorMsg", title: "错误原因"})
    }
    return cols;
}

//小区名称字符串
function _render1(data, type, full, meta) {
    return '<span class="text-over" style="max-width: 120px;">' + data + '</span>';
}

//小区地址字符串
function _render2(data, type, full, meta) {
    return '<span class="text-over" style="max-width: 240px;">' + data + '</span>';
}

//操作字符串
function _renderOperate(data, type, full, meta) {
    return '<a class="f-ib" href="javascript:void(0);" onclick=info(' + full.id + ',event)><i class="ico ico-info"></i></a>&nbsp;<a class="f-ib"  href="javascript:void(0);" onclick=edit(' + full.id + ',event)><i class="ico ico-edit"></i></a>&nbsp;<a class="f-ib" onclick=deleted(' + full.id + ',event) href="javascript:void(0);"><i class="ico ico-del"></i></a>';
}

//模拟Form提交导出数据
function postcall(url, params, target) {
    var tempform = document.createElement("form");
    tempform.action = url;
    tempform.method = "post";
    tempform.traditional = true;
    tempform.style.display = "none";
    if (target) {
        tempform.target = target;
    }

    for (var x in params) {
        var opt = document.createElement("input");
        opt.name = x;
        opt.value = params[x];
        tempform.appendChild(opt);
    }

    var optsubmit = document.createElement("input");
    optsubmit.type = "submit";
    tempform.appendChild(optsubmit);
    document.body.appendChild(tempform);
    tempform.submit();
    document.body.removeChild(tempform);
}

//防止事件冒泡
function stopBubble(e) {
    if (e && e.stopPropagation) {
        e.stopPropagation();
    } else {
        window.event.cancelBubble = true;
    }
}

//初始化列表
function _initTable(elem, url) {
    _table = $(elem).DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "bServerSide": true,
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "scrollX": true,
        "processing": true,
        "bAutoWidth": false,
        "select": {
            style: 'multi'
        },
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "autoWidth": false,
        "iScrollLoadGap": 10,
        "fixedColumns": {
            leftColumns: 0,
            rightColumns: 1
        },
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "serverSide": true,
        "ajax": {
            url: url,
            type: "GET",
            cache:false,
            data: {
                filter: $("#filter").val()
            }
        },
        "columns": getAllTitles(sourceTable, false, true)
    });
}

//获取修改记录
function _initHis(elem, url, id) {
    if (_dttable) {
        _dttable.destroy();
        _dttable.clear();
    }
    _dttable = $(elem).DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "bServerSide": true,
        "destroy": true,
        "bDestroy": true,
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "scrollX": true,
        "processing": false,
        "bAutoWidth": false,
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "autoWidth": false,
        "iScrollLoadGap": 10,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "serverSide": true,
        "ajax": {
            url: url,
            type: "GET",
            cache:false,
            data: {
                id: id
            }
        },
        "columns": getAllTitles(sourceTable, true)
    });

}

//上传文件初始化列表
function _initDataTable($data, $cols) {
    if (typeof (_dataTable) !== "undefined") {
        _dataTable.clear().destroy();
        //$("#errorresult thead").html("");
        $("#errorresult").empty();
    }
    $("#updataResult li").eq(1).click();
    _dataTable = $('#errorresult').DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "destroy": true,
        "bDestroy": true,
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "scrollX": true,
        "processing": false,
        "bAutoWidth": false,
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "autoWidth": false,
        "iScrollLoadGap": 10,
        "data": $data,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "columns": $cols
    });
    _dataTable.draw(true);
}

//配置项
function Config(url) {
    layer.open({
        type: 2,
        title: '自定义字段',
        shadeClose: false,
        shade: 0.8,
        closeBtn: 1,
        area: ['480px', '460px'],
        content: url
    });
}

//查看详细 修改信息
function ModifyView(title, url, width, height) {
    layer.open({
        type: 2,
        title: title,
        shadeClose: false,
        shade: 0.8,
        closeBtn: 1,
        area: [width + 'px', height + 'px'],
        content: url
    });
}

//删除 单个
function Deleted(_title, _url, _id) {
    _idx = layer.confirm(_title, {
        btn: ['确认', '取消'],
        icon: 2,
        shade: 0
    }, function () {
        layer.close(_idx);
        $.ajax({
            url: _url,
            type: "post",
            dataType: "json",
            data: {id: _id},
            success: function (data) {
                if (data) {
                    layer.alert("删除成功", {
                        closeBtn: 0,
                        icon: 6,
                        shade: [0.3, '#000']
                    }, function () {
                        layer.closeAll();
                        search();
                    });
                }
                else {
                    layer.alert("删除失败", {
                        closeBtn: 0,
                        icon: 2,
                        shade: [0.3, '#000']
                    }, function () {
                        layer.closeAll();
                        search();
                    });
                }
            },
            error: function () {
            }
        });
    });
}

//删除 批量
function DeletedBatch(_title, _url, _ids) {
    _idx = layer.confirm(_title, {
        btn: ['确认', '取消'],
        icon: 2,
        shade: 0
    }, function () {
        layer.close(_idx);
        $.ajax({
            url: _url,
            type: "post",
            traditional: true,
            dataType: "json",
            data: {ids: _ids},
            success: function (data) {
                if (data) {
                    layer.alert("删除成功", {
                        closeBtn: 0,
                        icon: 6,
                        shade: [0.3, '#000']
                    }, function () {
                        layer.closeAll();
                        search();
                    });
                }
                else {
                    layer.alert("删除失败", {
                        closeBtn: 0,
                        icon: 2,
                        shade: [0.3, '#000']
                    }, function () {
                        layer.closeAll();
                        search();
                    });
                }
            },
            error: function () {
            }
        });
    });
}

//全选和反选
function SeletedAll(_that) {
    var _num = parseInt($(_that).attr("data-num"));
    _num++;
    $(_that).attr("data-num", _num);
    if (_num % 2 == 1) {
        _table.rows().select();
    } else {
        _table.rows().deselect();
    }
}
