package com.aro.fileProcessing;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FileAdds implements FileProsessor{
	protected List<String> fileNames = new LinkedList<>();
	protected String keyWord;
	protected String fileName;
	
	public FileAdds(String keyWord){
		this.keyWord = keyWord;
	}
	
	
	@Override
	public void visitDirectoryAction(Path directoryPath){
	}
	
	@Override
	public void visitFileAction(Path filePath){
		addIfContainsWord(filePath);
	}
	
	protected void addIfContainsWord(Path pathToFile){
		fileName = pathToFile.toString();
		if (fileName.contains(keyWord))
			fileNames.add(fileName);
	}
	
	public  void listFileContainingWord(){
		for (String file: fileNames)
			System.out.println(file);
	}
	

}
