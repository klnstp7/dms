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
    <link href="../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="p-10">
    <form id="formData">
        <div class="form-tb">
            <table>
                <tr>
                    <td class="fuild-width">字段名</td>
                    <td>
                        <input type="text" name="FieldName" class="inpt"  id="FieldName"/>
                    </td>
                </tr>
            </table>
            <p class="f-tc p-10">
                <button type="button" class="btn btn-material btn-save" id="save">添加</button>
            </p>
        </div>
    </form>
    <table class="configList">
        <thead>
        <th class="col-width">字段名</th>
        <th>操作</th>
        </thead>
    </table>
    <div id="configList">
    </div>
</div>
<script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/lib/layer/layer.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-validation/validataboxextend.js"></script>
<script type="text/javascript">
    var dialog;
    var _idx;
    var sourceTable;
    <% String sourceTable=request.getParameter("sourceTable");
    out.print("sourceTable="+sourceTable+";");
    %>
    $(function () {
        listInit();
        $("#formData").validate({
            onkeyup: false,
            rules: {
                //字段名
                FieldName: {
                    required: true,
                    maxlength:10,
                    rightmessage: true
                }
            },
            messages: {
                FieldName: {
                    required: "请输入字段名",
                    maxlength:jQuery.validator.format("请输入一个长度最多是 {0} 的字段"),
                    rightmessage: "请勿输入特殊字符和空格"
                }
            },
            errorPlacement: function(error, element) {
                if(error[0].innerHTML!=""){
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });
                }
                $("#" + element[0].id).addClass("error-border");
            },
            success: function(label) {
                layer.closeAll('tips');
                $("#" + label[0].htmlFor).removeClass("error-border");
            }
        });

        $("#save").click(function(){
            if (!$("#formData").valid()) {
                return false;
            }else{
                insert($("#FieldName").val())
            }
        });
    });

    function initDraw(data) {
        var str = ""
        if (data.length == 0) {
            $("#configList").html(str);
        } else {
            $.each(data, function(i, v) {
                if (i % 2 == 0) {
                    str += "<tr><td class='col-width '>" + v.columnName + "</td><td><a href='javascript:void(0)' onclick='del(" + v.id + ")'>删除</a></td></tr>";
                } else {
                    str += "<tr class='odd'><td class='col-width'>" + v.columnName + "</td><td><a href='javascript:void(0)' onclick='del(" + v.id + ")'>删除</a></td></tr>";
                }
            })
            $("#configList").html("<div class='scroll'><table><tbody>" + str + "</tbody></table></div>");
        }
    }

    function listInit(){
        $.ajax({
            url: '/extendConfig/getExtendConfigList',
            data:{sourceTable:sourceTable},
            dataType: "json",
            success: function (data) {
                initDraw(data);
            },
            error: function () {
            }
        });
    }

    function insert(columnName){
        $.ajax({
            url: '/extendConfig/insertExtendConfig',
            type: "post",
            data:{sourceTable:sourceTable,columnName:columnName},
            dataType: "json",
            success: function (result) {
                if(result.success){
                    layer.msg("新增成功", { time: 600, icon: 1, shade: [0.3, '#000'] });
                    $("#FieldName").val("");
                    initDraw(result.data);
                }else {
                    layer.alert(result.msg, { icon: 2 , shade: [0.3, '#000'] });
                }
            },
            error: function () {
            }
        });
    }

    function del(id) {
        _idx = layer.confirm('该字段删除后将无法恢复,您确定执行次操作？', {
            btn: ['确认', '取消'],
            icon: 2,
            shade: 0
        }, function() {
            $.ajax({
                url: '/extendConfig/deleteExtendConfig',
                type: "post",
                data:{sourceTable:sourceTable,id:id},
                dataType: "json",
                success: function (result) {
                    layer.close(_idx);
                    if(result.success){
                        layer.msg("删除成功", { time: 600, icon: 1, shade: [0.3, '#000'] });
                        initDraw(result.data);
                    }else {
                        layer.alert(result.msg, { icon: 2 , shade: [0.3, '#000'] });
                    }
                },
                error: function () {
                }
            });
        });
    }
</script>
</body>

</html>
