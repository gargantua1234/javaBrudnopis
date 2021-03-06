package com.aro.traverse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * Class responsible for directory traversing
 */
public class DirectoryTraverser {
	private Path pathToDirectory= null;
	private SimpleFileVisitor<Path> fileVisitAction = null;
	
	public DirectoryTraverser(String pathToDirectory, SimpleFileVisitor<Path> fileVisitAction){
		checkIfDirectoryExists(pathToDirectory);
		this.fileVisitAction = fileVisitAction;
		
	}
	private boolean checkIfDirectoryExists(String path){
		Path temporaryPath = Paths.get(path);
		if(Files.exists(temporaryPath)){
			pathToDirectory = temporaryPath;
			return true;
		}
		return false;
	}
	
	public void traverse(){
		System.out.format("Traversing directory: %s%n", pathToDirectory.getFileName());
		if(pathToDirectory != null)
			startTraverse();
		else
			System.out.println("Wrong directory path");
	}
	
	public void startTraverse(){
		try{
			Files.walkFileTree(pathToDirectory, fileVisitAction);
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		
	}

}

