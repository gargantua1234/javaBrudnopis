import com.aro.fileProcessing.*;
import com.aro.traverse.DirectoryTraverser;

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
		FileContentChecker fileContentChecker = new FileContentChecker("cie");
		DirectoryTraverser secondDirectory = new DirectoryTraverser(directoryPath, 
				new FileVisitor(fileContentChecker));
		secondDirectory.traverse();
		fileContentChecker.reverseSort();
		fileContentChecker.listFiles();
		
	}
}

