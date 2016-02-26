import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Zadanie4 {
	private static final String[] filesToSearch = {
			"KsiegaPierwsza.txt","PanTadeusz.txt", "KsiegaDruga.txt", 
			"KsiegaTrzecia.txt","KsiegaCzwarta.txt"
			};
	private static final String searchedWord = "cie";
	
	public static void main(String[] args) {
		FilePrintController controller = new FilePrintController(filesToSearch, searchedWord);
		controller.searchAction();		
	}
}

class FilePrinter {
	protected Path pathToSource;
	protected final Charset charset = Charset.forName("UTF-8");
	
	public FilePrinter(String fileName){
		this.pathToSource = Paths.get("src\\"+fileName);
	}
	
	public void printIfContains(String keyWord) {
		try(BufferedReader openedFile = Files.newBufferedReader(pathToSource, charset)){
			String readedLine = null;
			System.out.println(pathToSource.getFileName()+":");
			while((readedLine=openedFile.readLine())!= null){
				printLineContainingKeyWord(readedLine, keyWord);
			}
		}
		catch( IOException exception){
			exception.printStackTrace();
		}
	}
	
	private void printLineContainingKeyWord(String line, String keyWord){
		if(line.contains(keyWord))
			System.out.println(line);
	}
}

class FilePrinterAndAdder extends FilePrinter {
	protected static List<String> filesContainingKey;
	static{
		filesContainingKey = new LinkedList<>();
	}
	
	public FilePrinterAndAdder(String fileName){
		super(fileName);
	}
	
	public void addIfContains(String keyWord){
		try(BufferedReader openedFile = Files.newBufferedReader(pathToSource)){
			String readedLine = null;
			while((readedLine = openedFile.readLine()) != null){
				if(addFileIfContains(readedLine, keyWord))
					break;
			}
		}
		catch(IOException exception){
			System.err.println("Problem with opening file "+ pathToSource.getFileName());
		}
	}

	public boolean addFileIfContains(String line, String keyWord){
		if(line.contains(keyWord)){
			filesContainingKey.add(pathToSource.getFileName().toString());
			return true;
		}
		else
			return false;
	}
	
	public static List<String> listFilesContainingWord() {
		System.out.println("Files containing word: ");
		for(String file: filesContainingKey)
			System.out.println(file);
		return filesContainingKey;
	}
	
}

class FilePrintController {
	private List<String> files;
	private String searchedWord;
	private FilePrinterAndAdder processedFile;
	public FilePrintController(String[] filesToSelect, String searchedWord){
		this.files = Arrays.asList(filesToSelect);
		this.searchedWord = searchedWord;
	}
	
	public void searchAction(){
		for (String file : files) {
			processedFile = new FilePrinterAndAdder(file);
			processedFile.printIfContains(searchedWord);
			processedFile.addIfContains(searchedWord);
		}
		FilePrinterAndAdder.listFilesContainingWord();
	}
}