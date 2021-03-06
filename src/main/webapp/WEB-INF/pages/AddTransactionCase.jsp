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
    <title>自荐数据库</title>
    <meta name="Keywords" content="" />
    <meta name="Description" content="" />
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
    <meta content="no-cache" http-equiv="pragma" />
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
    <link href="../../resources/lib/jquery-dataTable/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div class="p-5">
        <form id="formData">
            <div class="form-tb">
                <table>
                    <tr>
                        <td class="fuild-width">成交时间</td>
                        <td>
                            <input type="text" name="Time" class="inpt laydate-icon" id="Time" required="true" />
                        </td>
                        <td class="fuild-width">城市</td>
                        <td>
                            <input type="text" name="City" class="inpt" id="City" required="true" />
                        </td>
                        <td class="fuild-width">行政区</td>
                        <td>
                            <input type="text" name="DistrictName" class="inpt" id="DistrictName" required="true" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">片区</td>
                        <td>
                            <input type="text" name="Area" class="inpt" id="Area" />
                        </td>
                        <td class="fuild-width">小区名称</td>
                        <td>
                            <input type="text" name="ResidentialAreaName" class="inpt" id="ResidentialAreaName" required="true" />
                        </td>
                        <td class="fuild-width">楼栋名称</td>
                        <td>
                            <input type="text" name="BuildingName" class="inpt" id="BuildingName" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">小区地址</td>
                        <td colspan="5">
                            <input type="text" name="ResidentialAddress" class="inpt" id="ResidentialAddress" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">户名称</td>
                        <td>
                            <input type="text" name="HouseNum" class="inpt" id="HouseNum" />
                        </td>
                        <td class="fuild-width">所在楼层</td>
                        <td>
                            <input type="text" name="Floor" class="inpt" id="Floor" />
                        </td>
                        <td class="fuild-width">总楼层</td>
                        <td>
                            <input type="text" name="MaxFloor" class="inpt" id="MaxFloor" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">朝向</td>
                        <td>
                            <input type="text" name="Toword" class="inpt" id="Toword" />
                        </td>
                        <td class="fuild-width">建成年代</td>
                        <td>
                            <input type="text" name="BuildedYear" class="inpt" id="BuildedYear" />
                        </td>
                        <td class="fuild-width">建筑面积</td>
                        <td>
                            <input type="text" name="BuildingArea" class="inpt" id="BuildingArea" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">户型</td>
                        <td>
                            <input type="text" name="FloorType" class="inpt" id="FloorType" />
                        </td>
                        <td class="fuild-width">单价(元)</td>
                        <td>
                            <input type="text" name="Price" class="inpt" id="Price" />
                        </td>
                        <td class="fuild-width">总价(万元)</td>
                        <td>
                            <input type="text" name="TotalPrice" class="inpt" id="TotalPrice" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">项目地址</td>
                        <td colspan="5">
                            <input type="text" name="ProjectAddress" class="inpt" id="ProjectAddress" />
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">备注</td>
                        <td colspan="5">
                            <textarea class="inpt" id="Remarks" name="Remarks"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="fuild-width">自定义字段</td>
                        <td colspan="5">
                            <textarea class="inpt" id="Others" name="Others"></textarea>
                        </td>
                    </tr>
                </table>
                <p class="f-im form-tb-info p-10">注意:上述字段未能满足实际使用情况时可使用自定义字段，格式为"{自定义字段名称:字段内容,自定义字段名称:字段内容}"。如："{绿化率:80%,周边公交站:123路,学校:xxx小学}"。需要使用多个自定义字段请按规定格式一并填写到"自定义字段"输入框中。</p>
                <div class="p-10 f-tc">

                    <button type="button" class="btn btn-save" id="uplodata">完成</button>
                </div>
        </form>
        </div>
    </div>
    <script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/lib/layer/layer.js"></script>
    <script type="text/javascript" src="../../resources/lib/laydate/laydate.js"></script>
    <script type="text/javascript" src="../../resources/lib/jquery-validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/lib/jquery-validation/validataboxextend.js"></script>
    <script type="text/javascript">
    var dialog;
    $(function() {
        intLaydate('#Time');
        $("#cancel").click(function() {
            parent.layer.closeAll();
        });
        $("#uplodata").click(function() {
            if (!$("#formData").valid()) {
                return false;
            }
        });
        $("#formData").validate({
            onkeyup: false,
            rules: {
                //询价时间
                Time: {
                    required: true
                },
                //城市
                City: {
                    required: true,
                    rightmessage: true
                },
                //行政区
                DistrictName: {
                    required: true,
                    rightmessage: true
                },
                //片区
                Area: {
                    rightmessage: true
                },
                //小区名称
                ResidentialAreaName: {
                    required: true
                },
                //所在楼层
                Floor: {
                    posint: true
                },
                //总楼层
                MaxFloor: {
                    posint: true,
                    larger: true
                },
                //建筑面积
                BuildingArea: {
                    posintdec: true
                },
                //单价
                Price: {
                    posint: true
                },
                //总价
                TotalPrice: {
                    posintdec: true
                }
            },
            messages: {
                Time: {
                    required: "请输入成交时间"
                },
                City: {
                    required: "请输入城市",
                    rightmessage: "请勿输入特殊字符和空格"
                },
                DistrictName: {
                    required: "请输入行政区",
                    rightmessage: "请勿输入特殊字符和空格"
                },
                Area: {
                    rightmessage: "请勿输入特殊字符和空格"
                },
                ResidentialAreaName: {
                    required: "请输入小区名称"
                },
                Floor: {
                    posint: "请输入所在楼层(正整数)"
                },
                MaxFloor: {
                    posint: "请输入总楼层(正整数)",
                    larger: "总楼层大于或等于所在楼层"
                },
                BuildingArea: {
                    posintdec: "请输入建筑面积(最多保留两位小数)"
                },
                Price: {
                    posint: "请输入单价(正整数)",
                },
                TotalPrice: {
                    posint: "请输入总价(最多保留两位小数)",
                }
            },
            errorPlacement: function(error, element) {
                if(error[0].innerHTML!=""){
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });
                    $("#" + element[0].id).addClass("error-border");
                }
            },
            success: function(label) {
                layer.close(dialog);
                $("#" + label[0].htmlFor).removeClass("error-border");
            }
        });
    });

    function intLaydate(elem) {
        laydate({
            elem: elem,
            event: 'click',
            choose: function(datas) {
                $("#formData").valid();
            }
        });
    }
    </script>
</body>

</html>
