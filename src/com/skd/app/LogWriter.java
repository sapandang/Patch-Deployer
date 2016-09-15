package com.skd.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

	String filename="";
	File file;
	FileWriter fw;
	BufferedWriter bw;
	
	public LogWriter(String name)
	{
		filename = name;
		file = new File(filename);
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//initialise the file writer
		try {
			this.initBW();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void initBW() throws IOException
	{
		fw = new FileWriter(file.getAbsolutePath());
		bw = new BufferedWriter(fw);
	}
	
	
	public void writeToFile(String data) throws IOException
	{
		bw.write(data);
		bw.newLine();
		
	}
	
	public void close() throws IOException
	{
		bw.close();
		fw.close();
	}
	
	
}
