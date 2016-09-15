package com.skd.app;

public class Recursive {

	
	
	public int factors(int num)
	{
		
		 int result;
System.out.println("Printed "+num);
		 if(num==1)
	         return 1;

	       result = factors(num-1) * num;
	       System.out.println("Revoked  "+num);
	       return result;
		
	}
}
