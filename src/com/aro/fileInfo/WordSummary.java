package com.aro.fileInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordSummary extends WordCounter {
	protected Map<String, Integer> wordList;
	public static final int FIRSTAPPEAR = 1;
	
	public WordSummary(String fileName){
		super(fileName);
		wordList = new TreeMap<>();
	}
	
	public void makewordList(){
		try(Scanner file = new Scanner (new BufferedReader(
				new FileReader(filePath.toString())))){
			while(file.hasNext())
				addWordToList(prepareWord(file.next()));
				
		}
		catch (IOException exception){
			System.err.println("Problem with opening file "+ exception);
		}
		
	}
	
	public String prepareWord(String word){
		String preparedWord = word.toLowerCase().trim();
		preparedWord = preparedWord.replaceAll("\\p{Punct}", "");
		
		return preparedWord;
	}
	
	public void addWordToList(String word){
		if(wordList.containsKey(word)){
			int x = wordList.get(word);
			wordList.put(word, ++x);
		}
		else{
			wordList.put(word, FIRSTAPPEAR);
		}
	}
	
	public void printWordSummary(){
		System.out.println(filePath.getFileName()+" word summary:");
		printWordNumbers();
	}
	
	public void  printWordNumbers(){
		for(String word: wordList.keySet())
			System.out.println(word+" "+ wordList.get(word));
	}
}
