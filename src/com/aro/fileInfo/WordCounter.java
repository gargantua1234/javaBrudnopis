package com.aro.fileInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter extends FileSizeInfo {
	protected int wordAppears;
	public WordCounter(String fileName){
		super(fileName);
	}
	
	public void printWordAppearance(String searchedWord){
		System.out.println("Word: "+searchedWord+
				" appears "+countAppears(searchedWord)+ " times");
	}
	
	public int countAppears(String word){
		try(Scanner fileScanner = new Scanner (new BufferedReader(
				new FileReader(filePath.toString())))){
			wordAppears=0;
			while(fileScanner.hasNext())
				checkWord(word.toLowerCase(), fileScanner.next());
			return wordAppears;
				
		}
		catch(IOException exception){
			System.err.println("Problem with file "+exception);
			return FAIL;
		}
	}
	
	
	public void checkWord(String searchedWord, String word){
		word = word.toLowerCase();
		if(Pattern.matches(searchedWord+"\\p{Punct}*", word))
			wordAppears++;
	}
	
	
	
}
