import java.nio.file.Path;
import java.nio.file.Paths;

import com.aro.fileInfo.FileSizeInfo;
import com.aro.fileInfo.WordCounter;
import com.aro.fileInfo.WordSummary;

public class Zadanie4 {	
	private static String directoryPath = "C:\\Users\\Arek\\Desktop\\java work\\Brudnopis\\src";
	
	public static void main(String[] args) {		
		/** list all files and subdirectories in specified directory */
//		FilePrints filePrints = new FilePrints();
//		DirectoryTraverser directory = new DirectoryTraverser(directoryPath, 
//				new FileVisitor(filePrints));
//		directory.traverse();
//		filePrints.listFiles();
		
		/** list all files which names contain specified word in name */
//		FileAdds fileNames = new FileAdds(".txt");
//		DirectoryTraverser secondDirectory = new DirectoryTraverser(directoryPath, new FileVisitor(fileNames));
//		secondDirectory.traverse();
//		fileNames.listFiles();
		
		/** */
//		FileContentChecker fileContentChecker = new FileContentChecker("cie");
//		DirectoryTraverser secondDirectory = new DirectoryTraverser(directoryPath, 
//				new FileVisitor(fileContentChecker));
//		secondDirectory.traverse();
//		fileContentChecker.reverseSort();
//		fileContentChecker.listFiles();
		
		String fileName = "assets\\PanTadeusz.txt";
//		WordCounter wordCounter = new WordCounter(fileName);
//		wordCounter.printSize();
//		wordCounter.printWordAppearance("cie");
//		wordCounter.printWordAppearance("CIE");
		
		WordSummary ws = new WordSummary(fileName);
		ws.makewordList();
		ws.printWordSummary();
		
	}
}

