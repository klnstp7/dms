<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
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
        <input type="hidden" id="id" name="id" />
        <div class="form-tb">
            <table>
                <tr>
                    <td class="fuild-width">报盘时间</td>
                    <td>
                        <input type="text" name="offerTime" class="inpt laydate-icon" id="offerTime" required="true" />
                    </td>
                    <td class="fuild-width">案例来源</td>
                    <td>
                        <input type="text" name="dataSource" class="inpt" id="dataSource" required="true" />
                    </td>
                    <td class="fuild-width">城市</td>
                    <td>
                        <input type="text" name="cityName" class="inpt" id="cityName" required="true" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">行政区</td>
                    <td>
                        <input type="text" name="district" class="inpt" id="district" required="true" />
                    </td>
                    <td class="fuild-width">片区</td>
                    <td>
                        <input type="text" name="region" class="inpt" id="region" />
                    </td>
                    <td class="fuild-width">小区名称</td>
                    <td>
                        <input type="text" name="community" class="inpt" id="community" required="true" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">小区地址</td>
                    <td colspan="5">
                        <input type="text" name="address" class="inpt" id="address" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">户型</td>
                    <td>
                        <input type="text" name="roomLayout" class="inpt" id="roomLayout" />
                    </td>
                    <td class="fuild-width">所在楼层</td>
                    <td>
                        <input type="text" name="floor" class="inpt" id="floor" />
                    </td>
                    <td class="fuild-width">总楼层</td>
                    <td>
                        <input type="text" name="totalFloor" class="inpt" id="totalFloor" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">朝向</td>
                    <td>
                        <input type="text" name="toward" class="inpt" id="toward" />
                    </td>
                    <td class="fuild-width">建成年代</td>
                    <td>
                        <input type="text" name="buildYear" class="inpt" id="buildYear" />
                    </td>
                    <td class="fuild-width">建筑面积</td>
                    <td>
                        <input type="text" name="area" class="inpt" id="area" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">单价(元)</td>
                    <td>
                        <input type="text" name="price" class="inpt" id="price" />
                    </td>
                    <td class="fuild-width">总价(万元)</td>
                    <td>
                        <input type="text" name="totalPrice" class="inpt" id="totalPrice" />
                    </td>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td class="fuild-width">备注</td>
                    <td colspan="5">
                        <textarea class="inpt" id="remark" name="remark"></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">自定义字段</td>
                    <td colspan="5">
                        <textarea class="inpt" id="extendCol" name="extendCol"></textarea>
                    </td>
                </tr>
            </table>
            <p class="f-im form-tb-info p-10">注意:上述字段未能满足实际使用情况时可使用自定义字段，格式为"{自定义字段名称:字段内容,自定义字段名称:字段内容}"。如："{绿化率:80%,周边公交站:123路,学校:xxx小学}"。需要使用多个自定义字段请按规定格式一并填写到"自定义字段"输入框中。</p>
            <div class="p-10 f-tc">
                <button type="button" class="btn btn-save" id="uplodata">完成</button>
            </div>

        </div>
    </form>
</div>
<script type="text/javascript" src="../../resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/lib/layer/layer.js"></script>
<script type="text/javascript" src="../../resources/lib/laydate/laydate.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../resources/lib/jquery-validation/validataboxextend.js"></script>
<script type="text/javascript">
    var dialog;
    var action;
    var id=0;
    <% String action=request.getParameter("action");
    out.print("action='"+action+"';");
    if(action.equals("view")||action.equals("edit")){
        String id=request.getParameter("id");
        out.print("id="+id+";");
    }
    %>
    $(function() {
        if(id>0){
            initData();
        }
        if(action=="view"){
            $("#formData").find("input").attr("disabled", "disabled");
            $("#formData").find("textarea").attr("disabled", "disabled");
            $("#uplodata").remove();
        }
        intLaydate('#offerTime');
        $("#uplodata").click(function() {
            if (!$("#formData").valid()) {
                return false;
            }
            $.ajax({
                url: '/offerCase/update',
                type: "post",
                dataType: "json",
                data: $("#formData").serialize(),
                success: function (data) {
                    if(data){
                        layer.alert("修改成功", {
                            closeBtn: 0,
                            icon: 6,
                            shade: [0.3, '#000']
                        }, function() {
                            parent.search();
                            parent._initHis("#offerCaseHisTable","/offerCase/getHis",id);
                            parent.layer.closeAll();
                        });
                    }
                    else{
                        layer.alert("修改失败", {
                            closeBtn: 0,
                            icon: 2,
                            shade: [0.3, '#000']
                        });
                    }
                },
                error: function () {
                }
            });
        });
        $("#formData").validate({
            onkeyup: false,
            rules: {
                //询价时间
                offerTime: {
                    required: true
                },
                //询价来源
                dataSource: {
                    required: true,
                    rightmessage: true
                },
                //城市
                cityName: {
                    required: true,
                    rightmessage: true
                },
                //行政区
                district: {
                    required: true,
                    rightmessage: true
                },
                //片区
                region: {
                    rightmessage: true
                },
                //小区名称
                community: {
                    required: true
                },
                //所在楼层
                floor: {
                    posint: true
                },
                //总楼层
                totalFloor: {
                    posint: true,
                    larger: true
                },
                //建筑面积
                area: {
                    posintdec: true
                },
                //单价
                price: {
                    posint: true
                },
                //总价
                totalPrice: {
                    posintdec: true
                }
            },
            messages: {
                offerTime: {
                    required: "请输入询价时间"
                },
                dataSource: {
                    required: "请输入询价来源",
                    rightmessage: "请勿输入特殊字符和空格"
                },
                cityName: {
                    required: "请输入城市",
                    rightmessage: "请勿输入特殊字符和空格"
                },
                district: {
                    required: "请输入行政区",
                    rightmessage: "请勿输入特殊字符和空格"
                },
                region: {
                    rightmessage: "请勿输入特殊字符和空格"
                },
                community: {
                    required: "请输入小区名称"
                },
                floor: {
                    posint: "请输入正整数"
                },
                totalFloor: {
                    posint: "请输入正整数",
                    larger: "总楼层大于或等于所在楼层"
                },
                area: {
                    posintdec: "请输入建筑面积(最多保留两位小数)"
                },
                price: {
                    posint: "请输入单价(正整数)",
                },
                totalPrice: {
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
            event: 'focus',
            choose: function(datas) {
                $("#formData").valid();
            }
        });
    }
    function initData(){
        $.ajax({
            url: '/offerCase/get?id='+id,
            dataType: "json",
            cache:false,
            success: function (data) {
                <c:forEach items="${columns}" var="column">
                $("#${column}").val(data.${column});
                </c:forEach>
            },
            error: function () {
            }
        });
    }
</script>
</body>

</html>
