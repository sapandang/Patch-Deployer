package com.skd.app;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.tree.FixedHeightLayoutCache;

import org.apache.commons.io.FileUtils;

public class CopyUtil extends FileUtils {

	String srcRoot ="";
	String destRoot="";
	String backupRoot ="E:\\Software\\Apache Common IO\\commons-io-2.4-bin";
	String backupdir="";
	String BacktimeStamp="";
	
	public CopyUtil(String src , String dest)
	{
		super();
		srcRoot = src;
		destRoot = dest;	
	}
	
	public CopyUtil()
	{
		super();
			
	}
	
	
	public void copyFiles()
	{
		docopyFiles(srcRoot);
	}
	
	// internal function called by copyfiles used as recursive function
	 void docopyFiles(String directoryName)
	{
		 
		 File sourceDirectory = new File(directoryName);
		 File destDirectory = new File(destRoot);
		 FileModel fmObj;
		 // get all the files from a directory
	        File[] fList = sourceDirectory.listFiles();
	        
	        // iterate over files
	        for(File file : fList)
	        {
	        	// if it is file
	        	if(file.isFile())
	        	{
	        		fmObj = checkFile(file);
	        	//	System.out.println(fmObj.isExists() + fmObj.getDestPath());	
	        		// copy file if not exist
	        		if(!fmObj.isExists)
	        		{
	        			try {
	        				System.out.println("-->File not Exist Copy file "+file.getAbsolutePath() + " to "+fmObj.getDestPath());
							copyFile(file, new File(fmObj.getDestPath()),true); //copy the file
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}else if(fmObj.isExists)
	        		{
	        			backupFile(fmObj);  // back up the file
	        			// now copy the new file
	        			try {
	        				System.out.println("---> File Exist Copy file "+file.getAbsolutePath() + " to "+fmObj.getDestPath());
							copyFile(file, new File(fmObj.getDestPath()),true); //copy the file
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}
	        		
	        	} else if (file.isDirectory()) {
	        		
	        		fmObj = checkFile(file);
	        		System.out.println("|===Directory exists "+fmObj.getDestPath());
	            	docopyFiles(file.getAbsolutePath()); //recurse function to get path
	            	
	            	//Create directory if not exist
	            	 if(!fmObj.isExists)
	            	 {
	            		 System.out.println("|==Directory Does not exist creating directory "+fmObj.getDestPath());
	            		 new File(fmObj.getDestPath()).mkdir();
	            	 }
	            	
	             }
	        }
	
		 
	}
	
	
	
	public FileModel checkFile(File srcfile)
	{
		FileModel m_filemodel=new FileModel();
		String destRelativePath  = srcfile.getAbsolutePath().replace(srcRoot,destRoot); 
		File src = new File(destRelativePath);
		m_filemodel.setDestPath(destRelativePath); // save the dedstination path
		
		// if not exists
		if(!src.exists()){
			m_filemodel.isExists =false;
		}
		// if directory
		if(srcfile.isDirectory())
		{
		//	System.out.println("copyUtil dump Directory -> "+src.getAbsolutePath());
			m_filemodel.setFiletype(FileModel.FILE_TYPE_DIRECTORY);			
		}
		// if file
		if(srcfile.isFile())
		{
		//	System.out.println("copyUtil dump File -> "+src.getAbsolutePath());
			m_filemodel.setFiletype(FileModel.FILE_TYPE_FILE);
		}
			
		
		
		return m_filemodel;
	}
	
	
	// back up the files according to mode
	public int backupFile(FileModel filename)
	{
	
		//backupFilesToDir(filename);
		backupFilesInDir(filename);
		
		return 0;
	}
	
	
	//back up files to different directory
	public int backupFilesToDir(FileModel filename)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//check if backup directory exist or not
		if(backupdir.equals(""))
		{
		backupdir=backupRoot+"\\Backup_"+timeStamp;
		boolean mkdir_backupdir = new File(backupdir).mkdir();
		}
		
		String backupfile = filename.getDestPath().replace(destRoot, backupdir);
		
		// Check the file type
		if(filename.getFiletype()==FileModel.FILE_TYPE_DIRECTORY)
			new File(backupfile).mkdir();
		System.out.println("Copy util backup "+backupfile);
		//check if it is file
		if(filename.getFiletype()==FileModel.FILE_TYPE_FILE)
			try {
				copyFile(new File(filename.getDestPath()),new File( backupfile),true);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return 0;
	}
	
	// backup files in the same dirs as dest
	public int backupFilesInDir(FileModel filename)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		if(BacktimeStamp.equals(""))
		{
			BacktimeStamp=timeStamp;
		}
		
		File fileobj = new File(filename.getDestPath());
		
		File bakdestfile = new File(filename.getDestPath()+"_bak_"+BacktimeStamp);
		fileobj.renameTo(bakdestfile);
		
		System.out.println("-->Backuped File "+filename.getDestPath()+" to "+bakdestfile.getAbsolutePath());
		
		
		return 0;
	}
	
	
	
}
