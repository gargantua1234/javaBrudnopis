package com.aro.fileProcessing;

import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class FileProsessor {
	protected List<String> fileNames = new LinkedList<>();
	
	public void visitFileAction(Path filePath){
	}
	public void visitDirectoryAction(Path pathToDirectory){
	}
	
	public  void listFiles(){
		for (String file: fileNames)
			System.out.println(file);
	}
	
	public void reverseSort(){
		Collections.reverse(fileNames);
	}
}