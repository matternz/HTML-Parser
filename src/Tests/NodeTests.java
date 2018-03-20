package Tests;

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

	String PARAGRAPH_1 = "src/Tests/Paragraph.txt";
	String ITALIC_1 = "src/Tests/Italic.txt";

	public NodeTests() {
		// TODO Auto-generated constructor stub
	}

	public Node createParagraph(String filePath) {
		// https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file

		Node paragraph = new Paragraph_Node(readLineByLineJava8(filePath));
		return paragraph;
	}

	public Node createItalic(String filePath) {
		Node italic = new Italic_Node(readLineByLineJava8(filePath));
		return italic;
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
	public void paragraph_test_1() {
<<<<<<< HEAD
		//Node paragraph = createParagraph();
		new HTML_Parser().parseScanner(new Scanner(readLineByLineJava8("src/Tests/Italic.txt")));;
=======
		Node paragraph = createParagraph(PARAGRAPH_1);
	}

	@Test
	public void italic_test_1() {
		Node italic = createItalic(ITALIC_1);
>>>>>>> 596b16027779cb7bcbf966f3013e902f3e06bec6
	}
}
