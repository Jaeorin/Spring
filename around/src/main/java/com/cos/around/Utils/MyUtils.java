package com.cos.around.Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {

	public static Timestamp getCurrentTime() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);

		return ts;
	}
	
	public static List<String> extractHashTag(String str) {
		
		List<String> list = new ArrayList<String>();
	    Pattern p = Pattern.compile("\\#([0-9a-zA-Z가-힣]*)");
	    Matcher m = p.matcher(str);
	    String extractHashTag = null;
	 
	    while(m.find()) {
	    extractHashTag = string_replace(m.group());
	 
	    if(extractHashTag != null) {
	    	 list.add(extractHashTag);
	    }
	    	
	    }
	    return list;
	}
	 
	private static String string_replace(String str) {
	    str = str.replaceAll("[#]", "");
	 
	    if(str.length() < 1) {
	    return null;
	    }
	 
	    return str;
	}
	
}




