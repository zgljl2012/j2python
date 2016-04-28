package com.zgljl2012.jupython.impl;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.zgljl2012.jupython.PythonExecutor;
import com.zgljl2012.jupython.utils.FileUtil;
import com.zgljl2012.jupython.utils.NamedUtil;

public class PythonExecutorImpl implements PythonExecutor{
	
	/**
	 * 存储路径
	 */
	public static final String path = "python_file/";
	
	/**
	 * 调用Python脚本
	 */
	public String execfile(String command, String charset) {
		command = "python " + command;
    	Process process = null;
    	BufferedInputStream input = null;
    	try {
    		process = Runtime.getRuntime().exec(command);
    		input = new BufferedInputStream(process.getInputStream());
			final int buflen = 100;
			byte[] b = new byte[buflen];
			StringBuilder sb = new StringBuilder();
			while(input.read(b) != -1) {
				sb.append(new String(b, charset));
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return null;
	}

	/**
	 * 直接运行Python程序
	 * 将代码先保存为脚本然后调用execfile运行脚本得到结果返回，然后将脚本删除
	 */
	public String exec(String command, String charset) {
		String name = NamedUtil.named() + ".py";
		FileUtil.save(name, command, charset);
		String result = this.execfile(name, charset);
		FileUtil.delete(name);
		return result;
	}
	
}
