package com.supermarket.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取当年年月日字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateStr() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	public static String formatCode(String code) {
		//订单号后4位+1
		int length = code.length();//14
		Integer num = Integer.parseInt(code.substring(length - 4, length)) + 1;//2
		String codeNum = num.toString();//String   "2"
		int codeLength = codeNum.length();//1
		for (int i = 4; i > codeLength; i--) {
			codeNum = "0" + codeNum;//0002
		}
		return codeNum;
	}
	
	public static Date formatString(String str,String format)throws Exception{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static String formatDate(Date date,String format)throws Exception{
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	public static String format(Date date) {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			result = df.format(date);
		}
		return result;
	}
}
