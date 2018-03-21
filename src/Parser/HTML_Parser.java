package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.print.DocFlavor.CHAR_ARRAY;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import Nodes.*;

public class HTML_Parser {

	private HTML_Node htmlNode;

	// change to private final

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html

	// private static final Pattern PARAGRAPH =
	// Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);

	// https://www.tutorialspoint.com/java/java_regular_expressions.htm
	private static final Pattern ITALIC = Pattern.compile("^[*][1]?[a-zA-Z0-9]+[*][1]?");
	// https://stackoverflow.com/questions/43932001/test-to-see-if-string-contains-2-letters-followed-by-7-numbers
	private static final Pattern BOLD = Pattern.compile("[*]{2}[a-zA-Z0-9]*[*]{2}");
	private static final Pattern HEADING1 = Pattern.compile("[#]+");
	private static final Pattern HEADING2 = Pattern.compile("[##]+");
	private static final Pattern NUMBERED_LIST = Pattern.compile("[1-9]{1}[\\.]{1}[ ]{1}[a-zA-Z0-9]*");
	private static final Pattern BULLETED_LIST = Pattern.compile("\\* ");
	private static final Pattern SEPERATOR = Pattern.compile("^---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile(">");

	public HTML_Parser() {
		this.htmlNode = new HTML_Node();
	}

	public void parseScanner(Scanner scan) {
		/*
		 * // https://codereview.stackexchange.com/questions/81852/empty-line-
		 * delimiter-single-line-output int i = 0; while (scan.hasNext()) { if
		 * (scan.hasNext(PARAGRAPH)) { i++; scan.next(); if (i > 1) {
		 * System.out.print("PARAGRAPH"); } continue; }
		 * System.out.print(scan.next()); }
		 */

		// -------------------
		/*
		 * split everything into lines loop through each line list of lists list
		 * of each line with each line having a list of nodes....
		 */
		// -------------------
		while (scan.hasNext()) {
			StringBuilder text = new StringBuilder();
			if (scan.hasNext(HEADING2)) {
				String line = scan.nextLine();
				Scanner sc = new Scanner(line);
				this.htmlNode.addNode(parseHeader2(sc));
			} else if (scan.hasNext(HEADING1)) {
				String line = scan.nextLine();
				Scanner sc = new Scanner(line);
				this.htmlNode.addNode(parseHeader1(sc));
			}
			scan.close();
		}
	}

	private Node parseHeader1(Scanner scan) {
		scan.next();
		scan.next();
		HeaderNode1 h1 = new HeaderNode1();
		StringBuilder str = new StringBuilder();
		while(scan.hasNext()){
			if(scan.hasNext(ITALIC)){
				h1.addNode(parseItalic(scan.next()));
			}
			else if(scan.hasNext(BOLD)){
				h1.addNode(parseBold(scan.next()));
			}
			//add check for startign with bold or italic
			else{
				h1.addNode((Node) new TextNode(scan.next()));
			}
		}
		return (Node) h1;
	}

	private Node parseBold(String string) {
		string.
	}

	private Node parseItalic(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private Node parseHeader2(Scanner scan) {
		// TODO Auto-generated method stub
		return null;
	}

}
