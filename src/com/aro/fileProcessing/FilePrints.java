package com.aro.fileProcessing;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Class implementing action while traversing directory
 * 
 */
public class FilePrints extends SimpleFileVisitor<Path>{
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes ){
		System.out.format("%-10s %s%n","File:", file);
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path directory, IOException exception){
		System.out.format("%-10s %s%n", "Directory:", directory);
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exception){
		System.err.println(exception);
		return CONTINUE;
	}

}
