package Tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

import Nodes.*;

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
	public void paragraph_test_1() {
		Node paragraph = createParagraph();
	}
}
