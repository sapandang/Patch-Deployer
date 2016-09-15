package com.skd.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;




public  class ConfigFile {

	
	String lineFeed = "";
	String srcRoot ="";
	String destRoot ="";
	String filename="";
	Properties prop ;
	String backuproot="";
	
	InputStream input = null;
	
	
	public ConfigFile()
	{
		
		
		
	}
	
	 public void init(String filename) throws IOException
	{
		this.filename=filename;
		prop = new Properties();
		
		input = new FileInputStream(filename);

		// load a properties file
		prop.load(input);		
	}

	public String getLineFeed() {
		return prop.getProperty("LINEFEED");
	}

	public void setLineFeed(String lineFeed) {
		this.lineFeed = lineFeed;
	}

	public String getSrcRoot() {
		return prop.getProperty("SRCROOT");
	}

	public void setSrcRoot(String srcRoot) {
		this.srcRoot = srcRoot;
	}

	public String getDestRoot() {
		return prop.getProperty("DESTROOT");
	}

	public void setDestRoot(String destRoot) {
		this.destRoot = destRoot;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
}


