package com.aro.fileProcessing;

import java.nio.file.Path;

public class FileAdds extends FileProsessor{
	protected String keyWord;
	protected String fileName;
	
	public FileAdds(String keyWord){
		this.keyWord = keyWord;
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
	
	public  void listFiles(){
		for (String file: fileNames)
			System.out.println(file);
	}
	
}
