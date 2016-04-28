package com.zgljl2012.jupython;

public interface PythonExecutor {
	
	public String execfile(String command, String charset);
	
	public String exec(String command, String charset);
}
