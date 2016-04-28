package com.zgljl2012.jupython;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.zgljl2012.jupython.impl.PythonExecutorImpl;
import com.zgljl2012.jupython.utils.StringUtil;

public class PythonExecutorTest {
	
	PythonExecutor executor;
	
	@Before
	public void before() {
		executor = new PythonExecutorImpl(); 
	}
	
	@Test
	@Ignore
	public void testExecfile() {
		String path = "E:/NetBean-Workspace/企业数据库爬虫/src/receiver.py";
        String sheng = "hunan";
        String keywords = "润融";
        PythonExecutor executor = new PythonExecutorImpl(); 
        String result = executor.execfile(StringUtil.blank(path, sheng, keywords), "gbk");
        System.out.println(result);
	}
	
	@Test
	public void testExec() {
		String result = executor.exec("print('Hello,World')\nprint('xyz')","utf-8");
        System.out.println(result);
	}
	
}
