package com.yunfang.dms.utils;

import com.yunfang.dms.dto.TempLateConfigDto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * /*
 * 通过Java反射机制，动态给对象属性赋值
 * Created by Administrator on 2017/2/15.
 */
public class ClassRefUtil {
    /**
     * set属性的值到Bean，并验证数据类型
     *
     * @param bean
     * @param valMap
     */
    public static void setFieldValue(Object bean, Map<String, String> valMap) {
        Class<?> cls = bean.getClass();
        // 取出bean里的所有方法
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        boolean dataValid = true;
        for (Field field : fields) {
            try {
                String fieldSetName = parSetName(field.getName());
                if (!checkSetMet(methods, fieldSetName)) {
                    continue;
                }
                Method fieldSetMet = cls.getMethod(fieldSetName, field.getType());
                String value = valMap.get(field.getName());
                //判断为空情况，读取配置文件
                if ((null != value && !"".equals(value))) {
                    String fieldType = field.getType().getSimpleName();
                    if ("String".equals(fieldType)) {
                        fieldSetMet.invoke(bean, StringUtil.isNumeric(value) ? StringUtil.subZeroAndDot(value) : value);
                    } else if ("Date".equals(fieldType)) {
                        Date temp = StringUtil.parseDate(value);
                        fieldSetMet.invoke(bean, temp);
                    } else if ("Integer".equals(fieldType) || "int".equals(fieldType)) {
                        Integer intval = (int) Double.parseDouble(value);
                        fieldSetMet.invoke(bean, intval);
                    } else if ("Long".equalsIgnoreCase(fieldType)) {
                        Long temp = Long.parseLong(value);
                        fieldSetMet.invoke(bean, temp);
                    } else if ("Double".equalsIgnoreCase(fieldType)) {
                        Double temp = Double.parseDouble(value);
                        fieldSetMet.invoke(bean, temp);
                    } else if ("Boolean".equalsIgnoreCase(fieldType)) {
                        Boolean temp = Boolean.parseBoolean(value);
                        fieldSetMet.invoke(bean, temp);
                    } else if ("BigDecimal".equalsIgnoreCase(fieldType)) {
                        BigDecimal bd = new BigDecimal(value);
                        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        fieldSetMet.invoke(bean, bd);
                    } else {
                        System.out.println("not supper type" + fieldType);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    /*
    * 给类里面的指定字段赋值
    * */
    public static void setFieldValue(Object bean, String fieldName, String fieldValue) {
        Class<?> cls = bean.getClass();
        // 取出bean里的所有方法
        Method[] methods = cls.getDeclaredMethods();
        String fieldSetName = parSetName(fieldName);
        if (!checkSetMet(methods, fieldSetName)) {
            return;
        }
        try {
            Field field = cls.getDeclaredField(fieldName);
            Method fieldSetMet = cls.getMethod(fieldSetName, field.getType());
            fieldSetMet.invoke(bean, StringUtil.isNumeric(fieldValue) ? StringUtil.subZeroAndDot(fieldValue) : fieldValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    /**
     * 日期转化为String
     *
     * @param date
     * @return date string
     */
    private static String fmtDate(Date date) {
        if (null == date) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断是否存在某属性的 set方法
     *
     * @param methods
     * @param fieldSetMet
     * @return boolean
     */
    private static boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否存在某属性的 get方法
     *
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    private static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }

    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }
}


