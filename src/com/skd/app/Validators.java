package com.skd.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Validators extends FileUtils {

	String srcRoot ="";
	String destRoot="";
	
	
	
		//validate the Patch Files in verbose mode
		public void validatePatchVerbose(String srcRoot,String scrDest)
		{
			
		}
		
		
		//internal method to used by validate Patch Files
		public void dovalidatePatchVerbose(String srcRoot,String destRoot)
		{
			 File sourceDirectory = new File(srcRoot);
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
		        		System.out.println(fmObj.isExists() + fmObj.getDestPath());	
		        		// copy file if not exist
		        		if(!fmObj.isExists)
		        		{
		        			try {
								copyFile(file, new File(fmObj.getDestPath()),true); //copy the file
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        		}else if(fmObj.isExists)
		        		{
		        			//backupFile(fmObj);  // back up the file
		        			// now copy the new file
		        			try {
								copyFile(file, new File(fmObj.getDestPath()),true); //copy the file
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        		}
		        		
		        	} else if (file.isDirectory()) {
		        		
		        		fmObj = checkFile(file);
		        		System.out.println(fmObj.isExists());
		            //	docopyFiles(file.getAbsolutePath()); //recurse function to get path
		            	
		            	//Create directory if not exist
		            	 if(!fmObj.isExists)
		            	 {
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
				System.out.println("copyUtil dump Directory -> "+src.getAbsolutePath());
				m_filemodel.setFiletype(FileModel.FILE_TYPE_DIRECTORY);			
			}
			// if file
			if(srcfile.isFile())
			{
				System.out.println("copyUtil dump File -> "+src.getAbsolutePath());
				m_filemodel.setFiletype(FileModel.FILE_TYPE_FILE);
			}
				
			
			
			return m_filemodel;
		}
	
}
