import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

	/**
	 * reads in file to be parsed
	 * @param file
	 */
	public static Scanner readFile(File file){
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			scan.close();
			return scan;
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		return null;
	}
	
	public static void parseFile(Scanner scan){
		if(scan == null){
			return;
		}
		
		HTML_Parser htmlParser;
		
	}
	
	
	
	public static void main(String [] args) {

	}

}
