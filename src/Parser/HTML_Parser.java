package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Nodes.Italic_Node;
import Nodes.Node;

public class HTML_Parser {

	private List<Node> nodes;

	// change to private final

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html
<<<<<<< HEAD

	// private static final Pattern PARAGRAPH =
	// Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);

	// https://www.tutorialspoint.com/java/java_regular_expressions.htm
	private static final Pattern ITALIC = Pattern.compile("^[*][1]?[a-zA-Z0-9]+[*][1]?");
	private static final Pattern BOLD = Pattern.compile("^[*][2]?[a-zA-Z0-9]+[*][2]?");
	private static final Pattern HEADING = Pattern.compile("[#]+");
=======
	// static Pattern PARAGRAPH = Pattern.compile("\n");
	private static final Pattern PARAGRAPH = Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);
	private static final Pattern ITALIC = Pattern.compile("\\*");
	// private static final Pattern BOLD = Pattern.compile("**");
	private static final Pattern HEADING_1 = Pattern.compile("#");
	private static final Pattern HEADING_2 = Pattern.compile("##");
>>>>>>> 596b16027779cb7bcbf966f3013e902f3e06bec6
	private static final Pattern NUMBERED_LIST = Pattern.compile("[0-9]");
	// private static final Pattern BULLETED_LIST = Pattern.compile("* ");
	private static final Pattern SEPERATOR = Pattern.compile("^---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile(">");

	public HTML_Parser() {
		this.nodes = new ArrayList<>();
	}

	public void parseScanner(Scanner scan) {
<<<<<<< HEAD
		/*
		 * // https://codereview.stackexchange.com/questions/81852/empty-line-
		 * delimiter-single-line-output int i = 0; while (scan.hasNext()) { if
		 * (scan.hasNext(PARAGRAPH)) { i++; scan.next(); if (i > 1) {
		 * System.out.print("PARAGRAPH"); } continue; }
		 * System.out.print(scan.next()); }
		 */
=======
		String token = scan.next();

		switch (token) {
		case ("*"):
			parseItalics(scan);
		case ("**"):
			//parseBold
		case ("#"):
			//parseHeading1
		case ("##"):
			//parseHeading2
		case ("-"):
			//parseSeperator
		case (">"):
		default:
			break;
		}
	}

	public String parseParagraphs(Scanner scan) {
		// https://codereview.stackexchange.com/questions/81852/empty-line-delimiter-single-line-output
		int i = 0;
>>>>>>> 596b16027779cb7bcbf966f3013e902f3e06bec6
		while (scan.hasNext()) {
			
			if (scan.hasNext(ITALIC)) {
				System.out.println("ITALIC");
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
<<<<<<< HEAD

=======
		return null;
	}

	/**
	 *
	 * @param scan
	 * @return
	 */
	public String parseItalics(Scanner scan) {
		StringBuilder text = new StringBuilder();
		while (scan.hasNext()) {
			if (scan.hasNext(ITALIC)) {
				scan.next();
			} else {
				text.append(scan.next());
			}
		}
		Node Italic = new Italic_Node(text.toString());
		System.out.print(Italic.getHTML());
		return Italic.toString();
>>>>>>> 596b16027779cb7bcbf966f3013e902f3e06bec6
	}

}
