package com.ming.vo;

public class HelloWorld
{

	public String sayHello(){
		return "hello arvin ming";
	}

	public static void main(String [] args){
		System.out.println(new HelloWorld().sayHello());
	}
}