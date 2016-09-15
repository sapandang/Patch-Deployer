package com.skd.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Patch {
	List<File> listfiles;
	LogWriter logw;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			System.out.println("--- Appp Startted");
			Patch patchObj = new Patch();
			//initalise log writer
			 patchObj.logw = new LogWriter("logger.txt");
			
			
			
			Recursive obj = new Recursive();
			System.out.println(""+obj.factors(5));
			
			FileHelper fhoj = new FileHelper();
			patchObj.listfiles=fhoj.listf("C:\\Users\\sapan");
			
			
			//write to the files
			System.out.println("--- Writing Files");
			for(int i =0;i<=patchObj.listfiles.size();i++)
			{
				 System.out.println("--- Dump "+patchObj.listfiles.get(i).getPath());
				try {
					patchObj.logw.writeToFile(patchObj.listfiles.get(i).getAbsolutePath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
						
						
	}

}
