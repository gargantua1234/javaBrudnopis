package com.aro.fileProcessing;

import java.nio.file.Path;

public interface FileProsessor {
	
	public void visitFileAction(Path filePath);
	public void visitDirectoryAction(Path pathToDirectory);
}