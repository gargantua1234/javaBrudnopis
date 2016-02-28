package com.aro.fileProcessing;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class FileAdds extends SimpleFileVisitor<Path>{
	private static List<String> fileNames = new LinkedList<>();
	private String keyWord;
	private String fileName;
	
	public FileAdds(String keyWord){
		this.keyWord = keyWord;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes ){
		addIfContainsWord(file);
		return CONTINUE;
	}
	
	private void addIfContainsWord(Path pathToFile){
		fileName = pathToFile.toString();
		if (fileName.contains(keyWord))
			fileNames.add(fileName);
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path directory, IOException exception){
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exception){
		System.err.println(exception);
		return CONTINUE;
	}
	
	public static void listFileNamesContainingWord(){
		for (String file: fileNames)
			System.out.println(file);
	}
	

}
