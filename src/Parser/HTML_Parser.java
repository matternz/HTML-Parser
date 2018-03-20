package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Nodes.Node;

public class HTML_Parser {

	private List<Node> nodes;

	// change to private final

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html

	// private static final Pattern PARAGRAPH =
	// Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);

	// https://www.tutorialspoint.com/java/java_regular_expressions.htm
	private static final Pattern ITALIC = Pattern.compile("^[*][1]?[a-zA-Z0-9]+[*][1]?");
	private static final Pattern BOLD = Pattern.compile("^[*][2]?[a-zA-Z0-9]+[*][2]?");
	private static final Pattern HEADING = Pattern.compile("[#]+");
	private static final Pattern NUMBERED_LIST = Pattern.compile("[0-9]");
	private static final Pattern BULLETED_LIST = Pattern.compile("\\* ");
	private static final Pattern SEPERATOR = Pattern.compile("^---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile(">");

	public HTML_Parser() {
		this.nodes = new ArrayList<>();
	}

	public void parseScanner(Scanner scan) {
		/*
		 * // https://codereview.stackexchange.com/questions/81852/empty-line-
		 * delimiter-single-line-output int i = 0; while (scan.hasNext()) { if
		 * (scan.hasNext(PARAGRAPH)) { i++; scan.next(); if (i > 1) {
		 * System.out.print("PARAGRAPH"); } continue; }
		 * System.out.print(scan.next()); }
		 */

		//-------------------
		/*
		 * split everything into lines
		 * loop through each line
		 * list of lists
		 * list of each line with each line having a list of nodes....
		 */
		//-------------------
		while(scan.hasNextLine()) {
			parseLine(scan.nextLine());
		}
	}

	public void parseLine(String line) {
		Scanner scan = new Scanner(line);
		while (scan.hasNext()) {
			StringBuilder text = new StringBuilder();
			if (scan.hasNext(ITALIC)) {
				System.out.println("ITALIC");
				//loop through until you get to the next italic by calling scan.next
				//once finished create new node and then add it to the list
			} else if (scan.hasNext(BOLD)) {
				System.out.println("BOLD");
			} else if (scan.hasNext(HEADING)) {
				System.out.println("HEADING");
			} else if (scan.hasNext(NUMBERED_LIST)) {
				System.out.println("NUMBER_LIST");
			} else if (scan.hasNext(BULLETED_LIST)) {
				System.out.println("BULLETED_LIST");
			} else if (scan.hasNext(SEPERATOR)) {
				System.out.println("SEPERATOR");
			} else if (scan.hasNext(BLOCK_QUOTE)) {
			}
			else{
				System.out.println("Hello there");
			}

			System.out.println(scan.next());
		}
		scan.close();

	}

}
