package com.aro.fileInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSizeInfo {
	protected static final int FAIL = -1;
	protected Path filePath = null;
	
	public FileSizeInfo(String file){
		filePath = Paths.get(file);
	}
	
	public void printSize(){
		System.out.print("File: "+filePath.getFileName()+
				", size: ");
		System.out.println(size());
	}
	
	public long size(){
		try{
			return Files.size(filePath);
		}
		catch(IOException exception){
			System.err.println("Problem with file: "+ exception);;
			return FAIL;
		}
	}
	
	
	
}
