/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: CN
 */
jQuery.extend(jQuery.validator.messages, {
    required: "该字段不能为空",
    remote: "请修正该字段",
    email: "请输入正确格式的电子邮件",
    url: "请输入合法的网址",
    date: "请输入合法的日期",
    dateISO: "请输入合法的日期 (ISO).",
    number: "请输入合法的数字",
    digits: "只能输入整数",
    creditcard: "请输入合法的信用卡号",
    equalTo: "请再次输入相同的值",
    accept: "请输入拥有合法后缀名的字符串",
    maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
    minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
    rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
    range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
    max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
    min: jQuery.validator.format("请输入一个最小为 {0} 的值"),

    notnull: "不能为空"
});
/*****************************************************************
                  jQuery Validate扩展验证方法  (linjq)       
*****************************************************************/
$(function() {

    //禁止特殊字符
    jQuery.validator.addMethod("rightmessage", function(value, element) {
        var flag =false;
        if(value==""){
            flag=true;
        }else{
           flag = /^[^@$#~&\s]+$/.test(value);
        }
        return flag;
    }, "禁止特殊字符");

    // 只能输入[0-9]数字
    jQuery.validator.addMethod("isDigits", function(value, element) {
        var flag= false;
        if(value==""){
            flag = true;
        }else{
            flag =  /^\d+$/.test(value);
        }
        return flag;
    }, "只能输入0-9数字");

    // 只能输入1-9正整数
    jQuery.validator.addMethod("posint", function(value, element) {
        var flag= false;
        if(value==""){
            flag = true;
        }else{
            flag = /^[1-9]\d*$/.test(value);
        }
        return flag;
    }, "只能输入1-9正整数");

    // 保留至多两位小数
    jQuery.validator.addMethod("posintdec", function(value, element) {
        var flag= false;
        if(value==""){
            flag = true;
        }else{
            flag =/^(?!0+(?:\.0+)?$)(?:[1-9]\d*|0)(?:\.\d{1,2})?$/.test(value);
        }
        return flag;
    }, "保留至多两位小数");

    //总楼层大于或等于所在楼层
    jQuery.validator.addMethod("larger", function(value, element) {
        var sumreward = $("#Floor").val();
        var flag = false;
        if (sumreward == null || sumreward == "" || value == null || value == "") {
            flag = true;
        } else {
            if (parseInt(value) >= parseInt(sumreward)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }, $.validator.format("总楼层大于或等于所在楼层!"));
});
