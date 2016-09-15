package com.skd.app;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class Main {

	static String m_scrRootl;
	static String m_destRootl;
	
	public static void main(String[] args) {
		
		System.out.println("--- Appp Startted");

		
		
		//open config file
		ConfigFile configObj = new ConfigFile();
		try {
			configObj.init("config.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Config Read Error");
			e1.printStackTrace();			
		
		}
		
		System.out.println("source root"+configObj.getSrcRoot());
		System.out.println("dest root"+configObj.getDestRoot());
		
		m_scrRootl = configObj.getSrcRoot();
		m_destRootl = configObj.getDestRoot();
		
		File f1 = new File(m_scrRootl);
		File f2 = new File(m_destRootl);
		
		
		
		//new CopyUtil
		CopyUtil copyutil = new CopyUtil();
		CopyUtil copyutil2 = new CopyUtil(f1.getAbsolutePath(),f2.getAbsolutePath());
		
		
		copyutil2.copyFiles();
		
		System.out.println("Patching Complete"+configObj.getSrcRoot());
		

	}

}
