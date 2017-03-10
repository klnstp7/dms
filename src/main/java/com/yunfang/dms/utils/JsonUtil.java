package com.yunfang.dms.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yunfang.dms.dto.PageVo;

import java.lang.reflect.Type;
import java.net.URLDecoder;

/**
 * json格式工具类
 * 
 * @author Ivan
 * 
 */
public class JsonUtil {

	// {{json字符串转换为bean对象公共方法
	/**
	 * json转换为bean对象公共方法
	 * 
	 * @param data
	 * @param typeOfT
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObj(String data, Type typeOfT) {
		// 把json字符串转换为bean对象
		T t = null;
		try {
			if(!StringUtil.isNullOrEmpty(data)){
				data = URLDecoder.decode(data, "UTF-8");// 转码
				Gson gson = new Gson();
				t = (T) gson.fromJson(data, typeOfT);
			}
			return t;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// }}
	
	
	//{{json字符串转为json对象
	/**
	 * json字符串转为json对象
	 * @param data
	 * @return
	 */
	public static JsonObject getJson(String data){
		JsonObject jsonObj = null;
		JsonParser parser = new JsonParser();
		JsonElement el =parser.parse(data);
		if(el.isJsonObject()){
			jsonObj = el.getAsJsonObject();  
		}
		return jsonObj;
	}
	
	//}}


	//{{带有Extend字段的obj对象转为字符串
	/**
	 * 带有Extend字段的obj对象转为字符串
	 * @param obj
	 * @return String
	 */
	public static String getExtendJsonString(Object obj){
		Gson gson=new Gson();
		String str=gson.toJson(obj);
		str=str.replace("\"extendCol\":\"{\\\"","\"").replace("\\\"}\"","\"").replace("\\\"","\"");
		return str;
	}

	// }}
}
