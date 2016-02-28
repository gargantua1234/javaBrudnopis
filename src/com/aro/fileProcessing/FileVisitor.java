package com.aro.fileProcessing;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitor extends SimpleFileVisitor<Path> {
	private FileProsessor processingMethod = null;
	
	public FileVisitor(FileProsessor processingMethod) {
		this.processingMethod = processingMethod;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes ){
		processingMethod.visitFileAction(file);
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes){
		processingMethod.visitDirectoryAction(directory);
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exception){
		System.err.println(exception);
		return CONTINUE;
	}
}
