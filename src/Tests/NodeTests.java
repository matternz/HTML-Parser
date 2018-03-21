package Tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.Test;

import Nodes.*;
import Parser.HTML_Parser;

public class NodeTests {

	public NodeTests() {
		// TODO Auto-generated constructor stub
	}

	public Node createParagraph() {
		// https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file

		Node paragraph = new Paragraph_Node(readLineByLineJava8("src/Tests/Paragraph.txt"));
		return paragraph;
	}

	/**
	 * https://howtodoinjava.com/core-java/io/java-read-file-to-string-examples/
	 *
	 * @param filePath
	 * @return
	 */
	public String readLineByLineJava8(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();

	}

	@Test
	public void bold_test_01() {
		//Node paragraph = createParagraph();
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(new Scanner(readLineByLineJava8("src/Tests/Bold.txt")));
		//assertEquals("bold",(htmlParser.getNodes().get(0).toString()));
		//assertEquals("<em>bold</em>",(htmlParser.getNodes().get(0).getHTML()));

	}

	@Test
	public void heading1_test_01() {
		//Node paragraph = createParagraph();
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(new Scanner(readLineByLineJava8("src/Tests/Heading1.txt")));
		assertEquals("heading1",(htmlParser.getNodes().get(0).toString()));
		assertEquals("<h2>heading1</h2>",(htmlParser.getNodes().get(0).getHTML()));
	}

	@Test
	public void heading2_test_01() {
		//Node paragraph = createParagraph();
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(new Scanner(readLineByLineJava8("src/Tests/Heading2.txt")));
		assertEquals("heading2",(htmlParser.getNodes().get(0).toString()));
		assertEquals("<h3>heading2</h3>",(htmlParser.getNodes().get(0).getHTML()));
	}

	@Test
	public void italic_test_01() {
		//Node paragraph = createParagraph();
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(new Scanner(readLineByLineJava8("src/Tests/Italic.txt")));
		assertEquals("italic",(htmlParser.getNodes().get(0).toString()));
		assertEquals("<em>italic</em>",(htmlParser.getNodes().get(0).getHTML()));
	}

	@Test
	public void paragraph_test_01() {
		//Node paragraph = createParagraph();
		HTML_Parser htmlParser = new HTML_Parser();
		htmlParser.parseScanner(new Scanner(readLineByLineJava8("src/Tests/Paragraph.txt")));
		htmlParser.getNodes().get(0).toString();
	}



}
