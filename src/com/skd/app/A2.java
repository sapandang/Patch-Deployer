package com.skd.app;

public class A2 extends A1 {

	public static void main(String[] args) {
		
		System.out.println("Started");
		A2 obj = new A2();
		System.out.println(obj.m1());
		
	}
	
	@Override
	public String m4()
	{
		return "--<This is manipulated>--"+m5();
	}

}
