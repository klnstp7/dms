<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../../../resources/lib/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script src="../../../../resources/lib/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<div class="p-10 m-t-5 casetdst">
    <table class="f-cf casetdstTitle">
        <tr>
            <td>
                <label for="xunjia">
                    <input type="radio" name="type" id="xunjia" value="xunjia" data-typ="1" checked="checked" />询价案例</label>
            </td>
            <td>
                <label for="chengjiao">
                    <input type="radio" name="type" id="chengjiao" value="chengjiao" data-typ="1" />成交案例</label>
            </td>
            <td>
                <label for="baopan">
                    <input type="radio" name="type" id="baopan" value="baopan" data-typ="1" />报盘案例</label>
            </td>
            <td>
                <label for="baogao">
                    <input type="radio" name="type" id="baogao" value="baogao" data-typ="1" />报告案例</label>
            </td>
            <td>
                <label for="doc">
                    <input type="radio" name="type" id="doc" value="doc" data-typ="2" />报告文档</label>
            </td>
        </tr>
    </table>
    <div id="casetdstBody">
        <div class="caseUpload">
            <table class="attch">
                <tr>
                    <td>
                        <input type="file" name="file" id="attachUpload" />
                    </td>
                    <td>
                        <!--   <button type="button" class="btn"><i class="fa fa-cloud-upload"></i>导入文件</button> -->
                        <a href="javascript:void(0)" class="link">导入模版下载</a>
                        <a href="http://101.200.145.92:9199/bin/view/Main/%E6%93%8D%E4%BD%9C%E7%B1%BB%E9%97%AE%E9%A2%98/%E9%A2%84%E4%BC%B0%E5%8D%95%E8%87%AA%E5%AE%9A%E4%B9%89%E6%A8%A1%E7%89%88/" target="_blank" class="link">如何自定义模板</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="caseUpload">
            <table class="attch doc">
                <tr>
                    <td>
                        <input type="file" name="file" id="docUpload" /> </td>
                    <td>
                        <button type="button" class="btn btn-xs btn-check"><i class="fa fa-flag-checkered"></i>检测文件</button>
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
        <li class="noborder">
            <span class="total">33</span>
            <a href="javascript:void(0)" class="f-ib f-tc">新增</a>
        </li>
        <li class="noborder">
            <span class="total">33</span>
            <a href="javascript:void(0)" class="f-ib f-tc">更新</a>
        </li>
        <li class="">
            <span class="total">33</span>
            <a href="javascript:void(0)" class="f-ib f-tc">失败</a>
        </li>
    </ul>
    <div class="updataResultWrap">
        <div class="casetdst wrapstatue">
            <div class="result">
                <div class="f-fwb txt">
                    <p> 导入结果：</p>
                    <p>本次上传案例总数：900</p>
                    <p>成功新增案例总数：300</p>
                    <p>成功更新案例总数：300</p>
                    <p>上传失败案例总数：300</p>
                </div>
                <div>
                    <button type="button" id="" class="btn btn-xs btn-import">导出失败案例</button>
                    <button type="button" id="" class="btn btn-xs btn-reimport">重新上传失败案例</button>
                </div>
            </div>
        </div>
        <div class="wrapstatue">
            <table class="display" id="addresult" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>状态</th>
                        <th>案例编号</th>
                        <th>小区名称</th>
                        <th>小区地址</th>
                        <th>建成年代</th>
                        <th>单价</th>
                        <th>总价</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td><span class="fa fa-check-circle green"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                     <tr>
                        <td>1</td>
                        <td><span class="fa fa-check-circle green"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="wrapstatue">
            <table class="display" id="updataresult" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>状态</th>
                        <th>案例编号</th>
                        <th>小区名称</th>
                        <th>小区地址</th>
                        <th>建成年代</th>
                        <th>单价</th>
                        <th>总价</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td><span class="fa fa-compass green"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                      <tr>
                        <td>1</td>
                        <td><span class="fa fa-compass green"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="wrapstatue">
            <table class="display" id="errorresult" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>状态</th>
                        <th>案例编号</th>
                        <th>小区名称</th>
                        <th>小区地址</th>
                        <th>建成年代</th>
                        <th>单价</th>
                        <th>总价</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td><span class="fa fa-exclamation-circle red"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td><span class="fa fa-exclamation-circle red"></span></td>
                        <td>11111</td>
                        <td>五栋大楼</td>
                        <td>啊打算的啊飒飒的啊打算的</td>
                        <td>2000年</td>
                        <td>64200</td>
                        <td>302</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function() {
    $("#casetdstBody .caseUpload").eq(0).show();
    $("input[name=type]").change(function() {
        var i = $(this).attr("data-typ");
        dataType=i;
        $("#casetdstBody .caseUpload").hide();
        if (i == "1") {
            $("#casetdstBody .caseUpload").eq(0).show();
        } else {
            $("#casetdstBody .caseUpload").eq(1).show();
        }
    });

    $("#updataResult .wrapstatue").eq(0).show();
    $("#updataResult ul li").eq(0).addClass("current");
    $("#updataResult ul li").bind("click", function() {
        var i = $(this).index();
        $(this).siblings("li").removeClass("current");
         $(this).addClass("current");
        $("#updataResult .wrapstatue").hide();
        $("#updataResult .wrapstatue").eq(i).show();
        $("#updataResult .wrapstatue").eq(i).find(".display").css({
            "width": "100%"
        });
    });

    $('#addresult,#updataresult,#errorresult').DataTable({
        "language": {
            "url": "../../resources/lib/jquery-dataTable/js/Chinese.json"
        },
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "processing": true,
        "searching": false,
        "sPaginationType": "full_numbers",
        "ordering": false,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
    });
    intUpload();
});


function intUpload() {
    //附件上传
    $("#attachUpload").uploadify({
        'swf': '../../resources/lib/uploadify/uploadify.swf',
        //'uploader': '/Project/UploadAttachment?projectId=' + projectId,
        'uploader': '/upload/uploadAttach',
        'overrideEvents': ['onDialogClose', 'onSelectError'],
        'removeCompleted': true,
        'method':'get',
        'onSelect': function() {

        },
        'onSelectError': function(file, errorCode, errorMsg) {

        },
        'onUploadSuccess': function(file, data, response) {

        },
        'onUploadError': function(file, errorCode, errorMsg, errorString) {

        },
        'onUploadStart':function(file){
            var dataType=$("input[name='type']:checked").val();
            $("#attachUpload").uploadify("settings",'formData',{dataType:dataType});
        },
        'onQueueComplete': function(queueData) {},
        'height': 30,
        'width': 200,
        'fileTypeDesc': 'Excel',
        'fileTypeExts': '*.xls;*.xlsx',
        'fileSizeLimit': 1024 * 50,
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        'queueID': 'fileQueue',
        'buttonText': '选择上传excel案例文件',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true
    });

    //报告文档
    $("#docUpload").uploadify({
        'swf': '../../resources/lib/uploadify/uploadify.swf',
        'uploader': '/upload/uploadAttach',
        'overrideEvents': ['onDialogClose', 'onSelectError'],
        'removeCompleted': true,
        'onSelect': function() {},
        'onSelectError': function(file, errorCode, errorMsg) {

        },
        'onUploadStart':function(file){
            var dataType=$("input[name='type']:checked").val();
            $("#attachUpload").uploadify("settings",'formData',{dataType:dataType});
        },
        'onUploadSuccess': function(file, data, response) {},
        'onUploadError': function(file, errorCode, errorMsg, errorString) {},
        'onQueueComplete': function(queueData) {},
        'height': 30,
        'width': 200,
        'fileTypeDesc': '压缩包',
        'fileTypeExts': '*.rar;*.zip',
        'fileSizeLimit': 1024 * 50,
        //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
        'queueID': 'fileQueue',
        'buttonText': '选择压缩包上传',
        //选择文件后自动上传
        'auto': true,
        //设置为true将允许多文件上传
        'multi': true
    });
}
</script>
