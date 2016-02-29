package com.aro.fileProcessing;

import java.nio.file.Path;

public class FilePrints extends FileProsessor {
	
	@Override
	public void visitFileAction(Path filePath){
		fileNames.add(String.format("%-11s %s", "File:", 
				filePath.toString()));	
	}
	
	@Override
	public void visitDirectoryAction(Path directoryPath){
		fileNames.add(String.format("%-11s %s", "Directory:", 
				directoryPath.toString()));
	}
}