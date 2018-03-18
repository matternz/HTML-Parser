package Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Parser {

	/**
	 * reads in file to be parsed
	 * @param file
	 */
	public static Scanner readFile(File file){
		try {
			Scanner scan = new Scanner(file);
			//https://stackoverflow.com/questions/2188265/what-character-can-be-used-to-parse-for-paragraphs-with-java
			scan.useDelimiter("");
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
		
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(scan);
		
	}
	
	public static void selectFile(){
		JFileChooser chooser = new JFileChooser(".");// System.getProperty("user.dir"));
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
		
		}
		parseFile(readFile(chooser.getSelectedFile()));
	}
	
	public static void main(String [] args) {
		selectFile();
	}

}
