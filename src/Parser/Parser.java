package Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Nodes.HTML_Node;
import Tests.TestRunner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Parser {

	/**
	 * reads in file to be parsed
	 * 
	 * @param file
	 */
	public static Scanner readFile(File file) {
		try {
			Scanner scan = new Scanner(file);
			// https://stackoverflow.com/questions/2188265/what-character-can-be-used-to-parse-for-paragraphs-with-java
			scan.useDelimiter("");
			return scan;
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		return null;
	}

	/**
	 * https://stackoverflow.com/questions/15754523/how-to-write-text-file-java
	 * 
	 * @param FileName
	 */
	public static void writeFile(String fileName, HTML_Node htmlNode) {
		BufferedWriter writer = null;
		try {
			// create a temporary file
			File logFile = new File(fileName);

			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write(htmlNode.getHTML());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 
	 * @param scan
	 */
	public static void parseToHTML(Scanner scan) {
		if (scan == null) {
			return;
		}
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(scan);
		writeFile("out.html", htmlParser.getHtmlNode());

	}

	/**
	 * 
	 */
	public static void selectFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("markdown", "md"));
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			return;
		}
		parseToHTML(readFile(chooser.getSelectedFile()));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> argsList = Arrays.asList(args);
		if (argsList.contains("--test")) {
			TestRunner.run();
		} else {
			selectFile();
		}
	}

}
