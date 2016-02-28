import com.aro.fileProcessing.*;
import com.aro.traverse.DirectoryTraverser;

public class Zadanie4 {	
	private static String directoryPath = "C:\\Users\\Arek\\Desktop\\java work\\Brudnopis";
	
	public static void main(String[] args) {		
		/** list all files and subdirectories in specified directory */
//		DirectoryTraverser directory = new DirectoryTraverser(directoryPath, new FileVisitor(new FilePrints()));
//		directory.traverse();
		
		/** list all files which names contain specified word in name */
		DirectoryTraverser secondDirectory = new DirectoryTraverser(directoryPath, new FileVisitor(new FileAdds("git")));
		secondDirectory.traverse();
		FileAdds.listFileNamesContainingWord();
	}
}

