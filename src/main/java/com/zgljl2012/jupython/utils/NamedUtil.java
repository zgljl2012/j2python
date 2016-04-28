package com.zgljl2012.jupython.utils;

import java.util.Date;

public class NamedUtil {
	
	/**
	 * 用time生成唯一命名
	 * @return
	 */
	public synchronized static String named() {
		String name = Long.toString(new Date().getTime());
		return name;
	}
	
}
