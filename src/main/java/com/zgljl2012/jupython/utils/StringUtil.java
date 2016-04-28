package com.zgljl2012.jupython.utils;

public class StringUtil {
	
	public static String blank(String... args) {
    	String  s = "";
    	for(int i=0;i<args.length;i++) {
    		String arg = args[i];
    		s += arg;
    		
    		if(i < args.length) {
    			s += " ";
    		}
    	}
    	return s;
    }
}
