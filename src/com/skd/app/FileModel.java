package com.skd.app;

public class FileModel {

	static public final int FILE_TYPE_DIRECTORY =100;
	static public final int FILE_TYPE_FILE =200;
	
	
	public String FileName="";
	public String checksum="";
	public String path="";
	public String destPath="";
	public boolean isExists=true;
	public boolean isNewer=false;
	public int Filetype;
	
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isExists() {
		return isExists;
	}
	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}
	public boolean isNewer() {
		return isNewer;
	}
	public void setNewer(boolean isNewer) {
		this.isNewer = isNewer;
	}
	public int getFiletype() {
		return Filetype;
	}
	public void setFiletype(int filetype) {
		Filetype = filetype;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	
	
	
	
	
}
