package com.yunfang.dms.utils;

import java.io.IOException;

/**
 * 判断字符串工具类
 * @author Ivan
 *
 */
public class StringUtil {
	
	//{{判断字符串是否为空
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		boolean result = false;
		
		if ((str == null) || ((str.trim().isEmpty()))) {
			result = true;
		}
		return result;
	}
	//}}
	
	//{{中文编码
		/**
		 * 字符串中文编码
		 * @param result
		 * @return
		 * @throws IOException
		 */
		public static String encoding(String result) throws IOException {
			result = new String(result.getBytes("iso8859-1"),"GBK");
			return result;
		}
		//}}
		
		/**
		 * 判断字符串是否为空
		 * @param str
		 * @return
		 */
		public static String checkEmpty(String str){
			if ((str != null) && (!(str.trim().isEmpty()))) {
				return str;
			}
			return "";
		}

	/**
	 * 从头开始截取
	 *
	 * @param str 字符串
	 * @param end 结束位置
	 * @return
	 */
	public static String subStrStart(String str, int end){
		return subStr(str, 0, end);
	}

	/**
	 * 从尾开始截取
	 *
	 * @param str 字符串
	 * @param start 开始位置
	 * @return
	 */
	public static String subStrEnd(String str, int start){
		return subStr(str, str.length()-start, str.length());
	}

	/**
	 * 截取字符串 （支持正向、反向截取）<br/>
	 *
	 * @param str 待截取的字符串
	 * @param length 长度 ，>=0时，从头开始向后截取length长度的字符串；<0时，从尾开始向前截取length长度的字符串
	 * @return 返回截取的字符串
	 * @throws RuntimeException
	 */
	public static String subStr(String str, int length) throws RuntimeException{
		if(str==null){
			throw new NullPointerException("字符串为null");
		}
		int len = str.length();
		if(len<Math.abs(length)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(length)));
		}
		if(length>=0){
			return  subStr(str, 0,length);
		}else{
			return subStr(str, len-Math.abs(length), len);
		}
	}


	/**
	 * 截取字符串 （支持正向、反向选择）<br/>
	 *
	 * @param str  待截取的字符串
	 * @param start 起始索引 ，>=0时，从start开始截取；<0时，从length-|start|开始截取
	 * @param end 结束索引 ，>=0时，从end结束截取；<0时，从length-|end|结束截取
	 * @return 返回截取的字符串
	 * @throws RuntimeException
	 */
	public static String subStr(String str, int start, int end) throws RuntimeException{
		if(str==null){
			throw new NullPointerException("");
		}
		int len = str.length();
		int s = 0;//记录起始索引
		int e = 0;//记录结尾索引
		if(len<Math.abs(start)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(start)));
		}else if(start<0){
			s = len - Math.abs(start);
		}else if(start<0){
			s=0;
		}else{//>=0
			s = start;
		}
		if(len<Math.abs(end)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(end)));
		}else if (end <0){
			e = len - Math.abs(end);
		}else if (end==0){
			e = len;
		}else{//>=0
			e = end;
		}
		if(e<s){
			throw new StringIndexOutOfBoundsException("截至索引小于起始索引:"+(e-s));
		}

		return str.substring(s, e);
	}
}
