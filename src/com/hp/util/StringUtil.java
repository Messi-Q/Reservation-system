package com.hp.util;

public class StringUtil {

	
	public static boolean notNullValue(String str){
		if(str==null) return false;
		if(str=="") return false;
		if(str.length()==0) return false;
		return true;
	}
	
	public static Integer parse(String str){
		if(!notNullValue(str)) return -1;
		try{
			return Integer.parseInt(str,10);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
