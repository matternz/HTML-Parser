package Parser;

import java.util.Scanner;
import java.util.regex.Pattern;
import Nodes.*;

public class HTML_Parser {

	private HTML_Node htmlNode;

	// change to private final

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html

	// private static final Pattern PARAGRAPH =
	// Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);

	// https://www.tutorialspoint.com/java/java_regular_expressions.htm
	private static final Pattern ITALIC = Pattern.compile("[*]{1}?[a-zA-Z0-9]+[*]{1}");
	// https://stackoverflow.com/questions/43932001/test-to-see-if-string-contains-2-letters-followed-by-7-numbers
	private static final Pattern BOLD = Pattern.compile("[*]{2}[a-zA-Z0-9]*[*]{2}");
	private static final Pattern HEADING1 = Pattern.compile("[#]{1}");
	private static final Pattern HEADING2 = Pattern.compile("[#]{2}");
	private static final Pattern NUMBERED_LIST = Pattern.compile("[1-9]{1}[\\.]{1}[ ]{1}[a-zA-Z0-9]*");
	private static final Pattern BULLETED_LIST = Pattern.compile("\\* ");
	private static final Pattern SEPERATOR = Pattern.compile("---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile(">");
	private static final Pattern BLOCK_CODE = Pattern.compile("```");

	public HTML_Parser() {
		this.htmlNode = new HTML_Node();
	}

	public HTML_Node getHtmlNode() {
		return htmlNode;
	}

	public void setHtmlNode(HTML_Node htmlNode) {
		this.htmlNode = htmlNode;
	}

	/**
	 * reads through scanner and turns it into html code;
	 * 
	 * @param scan
	 */
	public void parseScanner(Scanner scan) {
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner sc = new Scanner(line);
			while (sc.hasNext()) {
				if (sc.hasNext(HEADING2)) {
					this.htmlNode.addNode(parseHeader2(sc));
				} else if (sc.hasNext(HEADING1)) {
					this.htmlNode.addNode(parseHeader1(sc));
				} else if (sc.hasNext(ITALIC)) {
					// this.htmlNode.addNode(parseItalic(sc.next()));
					Paragraph_Node para = new Paragraph_Node();
					para.addNode(parseItalic(sc.next()));
					this.htmlNode.addNode(para);
				} else if (sc.hasNext(BOLD)) {
					// this.htmlNode.addNode(parseBold(sc.next()));
					Paragraph_Node para = new Paragraph_Node();
					para.addNode(parseBold(sc.next()));
					this.htmlNode.addNode(para);
				} else {
					Paragraph_Node para = new Paragraph_Node();
					para.addNode(new TextNode(sc.next()));
					this.htmlNode.addNode(para);
				}
			}
		}
		scan.close();
	}

	public void parse(Scanner scan) {
		while (scan.hasNextLine()) {
			if (scan.hasNext(BLOCK_QUOTE)) {
				// this.htmlNode.addNode(parseBlockQuote(new
				// Scanner(scan.nextLine())));
			} else if (scan.hasNext(HEADING1)) {
				this.htmlNode.addNode(parseHeader1(new Scanner(scan.nextLine())));
			} else if (scan.hasNext(HEADING2)) {
				this.htmlNode.addNode(parseHeader2(new Scanner(scan.nextLine())));
			} else if (scan.hasNext(NUMBERED_LIST)) {
				while (scan.hasNext(NUMBERED_LIST)) {
					// scan.nextLine();
				}
			} else if (scan.hasNext(BULLETED_LIST)) {
				while (scan.hasNext(BULLETED_LIST)) {
					// scan.nextLine();
				}
			} else if (scan.hasNext(SEPERATOR)) {
				// this.htmlNode.addNode(parseSeperator());
				// scan.nextLine();
			} else if (scan.hasNext(BLOCK_CODE)) {
				while (scan.hasNextLine()) {
					if (scan.hasNext(BLOCK_CODE)) {
						// break out of hasNextLine loop
					}
				}
			} else if (scan.hasNext(ITALIC)) {
				//which part of the line to you give to the other parsers?
				//
				//create new paragraph
				//add italic node to it
				//check if anything inside italic node
				//add to html node
			} else if (scan.hasNext(BOLD)) {
				//which part of the line to you give to the other parsers?
				//
				//create new paragraph
				//add bold node to it
				//check if anything inside bold node
				//add to html node
			} else {
				// check what the line starts with
				// create new method to check for paragraphs italic and bold
				// within?

			}
		}
	}

	/**
	 * parses text and turns it into an
	 * <h1></h1> node
	 * 
	 * @param scan
	 * @return
	 */
	private AbstractNode parseHeader1(Scanner scan) {
		scan.next();
		scan.useDelimiter("");
		scan.next();
		scan.reset();
		HeaderNode1 h1 = new HeaderNode1();
		while (scan.hasNext()) {
			if (scan.hasNext(ITALIC)) {
				h1.addNode(parseItalic(scan.next()));
			} else if (scan.hasNext(BOLD)) {
				h1.addNode(parseBold(scan.next()));
			}
			// add check for startign with bold or italic
			else {
				scan.useDelimiter("");
				h1.addNode(new TextNode(scan.next()));
				scan.reset();
			}
		}
		return h1;
	}

	/**
	 * parses text and turns it into an
	 * <h2></h2> node
	 * 
	 * @param scan
	 * @return
	 */
	private AbstractNode parseHeader2(Scanner scan) {
		scan.next();
		HeaderNode2 h2 = new HeaderNode2();
		while (scan.hasNext()) {
			if (scan.hasNext(ITALIC)) {
				h2.addNode(parseItalic(scan.next()));
			} else if (scan.hasNext(BOLD)) {
				h2.addNode(parseBold(scan.next()));
			}
			// add check for starting with bold or italic
			else {
				// scan.useDelimiter("");
				h2.addNode(new TextNode(scan.next()));
				// scan.reset();

			}
		}
		return h2;
	}

	/**
	 * creates new italic node and returns it
	 * 
	 * @param str
	 * @return
	 */
	private AbstractNode parseBold(String str) {
		StringBuilder text = new StringBuilder();
		Scanner scan = new Scanner(str);
		scan.useDelimiter("");
		while (scan.hasNext()) {
			if (scan.hasNext("\\*")) {
				scan.next();
			} else {
				text.append(scan.next());
			}
		}
		scan.close();
		Bold_Node bold = new Bold_Node();
		bold.addNode(new TextNode(text.toString()));
		return bold;
	}

	/**
	 * creates new italic node and returns it
	 * 
	 * @param str
	 * @return
	 */
	private AbstractNode parseItalic(String str) {
		StringBuilder text = new StringBuilder();
		Scanner scan = new Scanner(str);
		scan.useDelimiter("");
		while (scan.hasNext()) {
			if (scan.hasNext("\\*")) {
				scan.next();
			} else {
				text.append(scan.next());
			}
		}
		scan.close();
		Italic_Node italic = new Italic_Node();
		italic.addNode(new TextNode(text.toString()));
		return italic;
	}

}
