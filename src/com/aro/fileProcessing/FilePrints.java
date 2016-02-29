package com.aro.fileProcessing;

import java.nio.file.Path;

public class FilePrints implements FileProsessor {
	
	@Override
	public void visitFileAction(Path filePath){
		System.out.format("%-11s %s%n", "File:", filePath.toString());	
	}
	
	@Override
	public void visitDirectoryAction(Path directoryPath){
		System.out.format("%-11s %s%n", "Directory:", directoryPath.toString());
	}
}