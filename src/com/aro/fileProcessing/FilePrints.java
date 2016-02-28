package com.aro.fileProcessing;

import java.nio.file.Path;

public class FilePrints implements FileProsessor {
	
	public void visitFileAction(Path filePath){
		System.out.format("%-11s %s%n", "File:", filePath.toString());	
	}
	
	public void visitDirectoryAction(Path directoryPath){
		System.out.format("%-11s %s%n", "Directory:", directoryPath.toString());
	}
}