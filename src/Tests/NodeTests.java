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

	public static String createHTML(String text) {
		Scanner scan = new Scanner(text);
		HTML_Parser p = new HTML_Parser();
		p.parseScanner(scan);
		return p.getHtmlNode().getHTML();
	}

	/**
	 * tests if h1 type header works
	 */
	@Test
	public void h1_header_test() {
		String text = "# heading1";
		assertEquals("<html><h1>heading1</h1></html>", createHTML(text));
	}

	/**
	 * tests if h2 type header works
	 */
	@Test
	public void h2_header_test() {
		String text = "## heading2";
		assertEquals("<html><h2>heading2</h2></html>", createHTML(text));
	}

	/**
	 * tests if it returns h1 type header with italics
	 */
	@Test
	public void h1_header_italic_test() {
		String text = "# *heading1*";
		assertEquals("<html><h1><em>heading1</em></h1></html>", createHTML(text));
	}

	/**
	 * tests if it returns h2 type header with italics
	 */
	@Test
	public void h2_header_italic_test() {
		String text = "## *heading2*";
		assertEquals("<html><h2><em>heading2</em></h2></html>", createHTML(text));
	}

	/**
	 * tests if it returns h1 type header with bold
	 */
	@Test
	public void h1_header_bold_test() {
		String text = "# **heading1**";
		assertEquals("<html><h1><strong>heading1</strong></h1></html>", createHTML(text));
	}

	/**
	 * tests if it returns h2 type header with bold
	 */
	@Test
	public void h2_header_bold_test() {
		String text = "## **heading2**";
		assertEquals("<html><h2><strong>heading2</strong></h2></html>", createHTML(text));
	}

	/**
	 * tests simple italics
	 */
	@Test
	public void italic_test() {
		String text = "*italics*";
		assertEquals("<html><p><em>italics</em></p></html>", createHTML(text));
	}

	/**
	 * tests simple bold
	 */
	@Test
	public void bold_test() {
		String text = "**bold**";
		assertEquals("<html><p><strong>bold</strong></p></html>", createHTML(text));
	}

	/**
	 * tests empty string being parsed
	 */
	@Test
	public void html_test() {
		String text = "";
		assertEquals("<html></html>", createHTML(text));
	}

	/**
	 * complex h1 header
	 */
	@Test
	public void h1_header_complex_test() {
		String text = "# header with *italics*";
		assertEquals("<html><h1>header with <em>italics</em></h1></html>", createHTML(text));
	}

	/**
	 * complex h1 header
	 */
	@Test
	public void h2_header_complex_test() {
		String text = "## header with *italics*";
		assertEquals("<html><h2>header with <em>italics</em></h2></html>", createHTML(text));
	}

	/**
	 * single paragraph
	 */
	@Test
	public void paragraph_test() {
		String text = "Paragraph";
		assertEquals("<html><p>Paragraph</p></html>", createHTML(text));
	}

	/**
	 * 2 paragraphs separated by blank line
	 */
	@Test
	public void two_paragraph_test() {
		String text = "Paragraph1\n\nParagraph2";
		assertEquals("<html><p>Paragraph1</p><p>Paragraph2</p></html>", createHTML(text));
	}

	/*
	 * single line list
	 */
	@Test
	public void list_test_01() {
		String text = "1. list";
		assertEquals("<html><li>list</li></html>", createHTML(text));
	}

	/**
	 * multi-line list
	 */
	@Test
	public void list_test_02() {
		String text = "1. list\n1. list\n1. list";
		assertEquals("<html><ol><li>list</li><li>list</li><li>list</li></ol></html>", createHTML(text));
	}
	
	/**
	 * single bulleted list
	 */
	@Test
	public void bullet_test_01(){
		String text = "* bullet";
		assertEquals("<html><ul><li>bullet</li></ul></html>", createHTML(text));
	}
	
	/**
	 * multi line bulleted list with indent
	 */
	@Test
	public void bullet_test_02(){
		String text = "* bullet\n\t* bullet";
		assertEquals("<html><ul><li>bullet<ul><li>bullet</li></ul></li></ul></html>", createHTML(text));
	}
	
	/**
	 * tests line seperator
	 */
	@Test
	public void seperator_test(){
		String text = "---";
		assertEquals("<html><hr /></html>", createHTML(text));
	}
	
	/**
	 * single block quote
	 */
	@Test
	public void block_test(){
		String text = "> block";
		assertEquals("<html><blockquote><p>block</p></blockquote></html>", createHTML(text));
	}
	
	/**
	 * tests inline code
	 */
	@Test
	public void inline_code_test(){
		String text = "`inline`";
		assertEquals("<html><p>inline</p></html>", createHTML(text));
	}
	
	/**
	 * tests block code
	 */
	@Test
	public void block_code_test(){
		String text = "```\nblock\n```";
		assertEquals("<html><pre><code></code></pre></html>",createHTML(text));
	}
}
