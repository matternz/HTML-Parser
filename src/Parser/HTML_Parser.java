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
	private static final Pattern ITALIC = Pattern.compile("[*]{1}?[a-zA-Z0-9]+[*]{1}");
	// https://stackoverflow.com/questions/43932001/test-to-see-if-string-contains-2-letters-followed-by-7-numbers
	private static final Pattern BOLD = Pattern.compile("[*]{2}[a-zA-Z0-9]*[*]{2}");
	private static final Pattern HEADING1 = Pattern.compile("[#]{1}");
	private static final Pattern HEADING2 = Pattern.compile("[#]{2}");
	private static final Pattern NUMBERED_LIST = Pattern.compile("[1-9]{1}[\\.]{1}[ ]{1}[a-zA-Z0-9]*");
	private static final Pattern BULLETED_LIST = Pattern.compile("\\* ");
	private static final Pattern SEPERATOR = Pattern.compile("^---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile(">");

	public HTML_Parser() {
		this.htmlNode = new HTML_Node();
	}
	
	public HTML_Node getHtmlNode() {
		return htmlNode;
	}



	public void setHtmlNode(HTML_Node htmlNode) {
		this.htmlNode = htmlNode;
	}


	//TODO
	//fix this loop
	public void parseScanner(Scanner scan) {
		while (scan.hasNext()) {
			String line = scan.nextLine();
			Scanner sc = new Scanner(line);
			if (sc.hasNext(HEADING2)) {
				System.out.println("heading2");
				this.htmlNode.addNode(parseHeader2(sc));
			} else if (sc.hasNext(HEADING1)) {
				System.out.println("heading1");
				this.htmlNode.addNode(parseHeader1(sc));
			}
			else{
				sc.next();
			}
		}
		scan.close();
	}

	/**
	 * parses text and turns it into an <h1></h1> node
	 * @param scan
	 * @return
	 */
	private AbstractNode parseHeader1(Scanner scan) {
		System.out.println(scan.next());
		HeaderNode1 h1 = new HeaderNode1();
		while(scan.hasNext()){
			if(scan.hasNext(ITALIC)){
				h1.addNode(parseItalic(scan.next()));
			}
			else if(scan.hasNext(BOLD)){
				h1.addNode(parseBold(scan.next()));
			}
			//add check for startign with bold or italic
			else{
				h1.addNode( new TextNode(scan.next()));
				
			}
		}
		return h1;
	}

	/**
	 * parses text and turns it into an <h2></h2> node
	 * @param scan
	 * @return
	 */
	private AbstractNode parseHeader2(Scanner scan) {
		System.out.println(scan.next());
		HeaderNode2 h2 = new HeaderNode2();
		while(scan.hasNext()){
			if(scan.hasNext(ITALIC)){
				h2.addNode(parseItalic(scan.next()));
			}
			else if(scan.hasNext(BOLD)){
				h2.addNode(parseBold(scan.next()));
			}
			//add check for startign with bold or italic
			else{
				h2.addNode( new TextNode(scan.next()));
				
			}
		}
		return h2;
	}
	
	private AbstractNode parseBold(String string) {
		return new Bold_Node(string);
	}

	private AbstractNode parseItalic(String string) {
		return new Italic_Node(string);
	}



}
