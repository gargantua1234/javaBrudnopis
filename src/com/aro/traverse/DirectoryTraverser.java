package com.aro.traverse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class responsible for directory traversing
 */
public class DirectoryTraverser {
	private Path pathToDirectory= null;
	private FilePrints filePrintMethod = null;
	
	public DirectoryTraverser(String pathToDirectory){
		checkIfDirectoryExists(pathToDirectory);
		
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
			System.out.println("Wrong path to directory");
	}
	
	public void startTraverse(){
		filePrintMethod = new FilePrints();
		try{
			Files.walkFileTree(pathToDirectory, filePrintMethod);
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		
	}

}

