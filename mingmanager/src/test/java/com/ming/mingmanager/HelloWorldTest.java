package com.ming.mingmanager;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest{
	
	@Test
	public void testSayHello(){
		
		HelloWorld hw = new HelloWorld();
		
		String result = hw.sayHello("arvin");
		
		assertEquals("Hello Mavenarvin",result);
	}
}