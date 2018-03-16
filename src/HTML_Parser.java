import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HTML_Parser {

	private List<Node> nodes;

	// change to private final

	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html
	// static Pattern PARAGRAPH = Pattern.compile("\n");
	private static final Pattern PARAGRAPH = Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE);
	private static final Pattern ITALIC = Pattern.compile("\\*");
	private static final Pattern BOLD = Pattern.compile("\\*\\*");
	private static final Pattern HEADING_1 = Pattern.compile("##");
	private static final Pattern HEADING_2 = Pattern.compile("##");
	private static final Pattern NUMBERED_LIST = Pattern.compile("[0-9]");
	private static final Pattern BULLETED_LIST = Pattern.compile("\\* ");
	private static final Pattern SEPERATOR = Pattern.compile("^---");
	private static final Pattern BLOCK_QUOTE = Pattern.compile("> $[A-Za-z][A-Za-z0-9]");

	public HTML_Parser() {
		this.nodes = new ArrayList<>();
	}

	public void parseScanner(Scanner scan) {
		// https://codereview.stackexchange.com/questions/81852/empty-line-delimiter-single-line-output
		int i = 0;
		while (scan.hasNext()) {
			if (scan.hasNext(PARAGRAPH)) {
				i++;
				scan.next();
				if (i > 1) {
					System.out.print("PARAGRAPH");
				}
				continue;
			}
			System.out.print(scan.next());
		}

	}

	public String parseParagraphs(Scanner scan) {
		return null;
	}

	public static void main(String[] args) {

	}

}
