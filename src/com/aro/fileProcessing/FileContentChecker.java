package com.aro.fileProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileContentChecker extends FileAdds {
	
	protected String readedLine = null;
	
	public FileContentChecker(String keyWord){
		super(keyWord);
	}
	
	@Override
	protected void addIfContainsWord(Path pathToFile){
		try(BufferedReader file = Files.newBufferedReader(pathToFile)){
			if(contentHasKeyWord(file))
				fileNames.add(pathToFile.toString());
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
	}
	
	protected boolean contentHasKeyWord(BufferedReader file)throws IOException{
		while((readedLine=file.readLine())!= null){
			if(readedLine.contains(keyWord))
				return true;
		}
		return false;
	}
}
