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
                <button type="button" class="btn btn-material btn-save" id="save">保存</button>
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
    $(function () {
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

            }
        });
    });
</script>
</body>

</html>
