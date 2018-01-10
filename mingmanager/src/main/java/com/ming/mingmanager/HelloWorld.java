package com.ming.mingmanager;

public class HelloWorld{
	
	public HelloWorld(){
		
	}
	
	public String sayHello(String name){
		return "Hello Maven" + name;
	}
	
	public static void main(String [] args){
		System.out.println(new HelloWorld().sayHello("arvin"));
	}
}