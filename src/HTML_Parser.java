import java.util.Scanner;
import java.util.regex.Pattern;

public class HTML_Parser {
	
	private Scanner scan;
	
	//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html
	static Pattern PARAGRAPH = Pattern.compile("\n");
	static Pattern ITALIC = Pattern.compile("\\*");
	static Pattern BOLD = Pattern.compile("\\*\\*");
	static Pattern HEADING_1 = Pattern.compile("##");
	static Pattern HEADING_2 = Pattern.compile("##");
	static Pattern NUMBERED_LIST = Pattern.compile("[0-9]");
	static Pattern BULLETED_LIST = Pattern.compile("\\* ");
	static Pattern SEPERATOR = Pattern.compile("^---");
	static Pattern BLOCK_QUOTE = Pattern.compile("> $[A-Za-z][A-Za-z0-9]");
	
	
	
	
	public HTML_Parser(Scanner scan){
		this.scan = scan;
	}
	
	public void parseScanner(Scanner scan){
		while(scan.hasNext()){
			if(scan.hasNext(PARAGRAPH)){
				System.out.println("new line");
				scan.next();
			}
			else{
				System.out.print(scan.next());
			}
		}
	}
	
	public static void main(String [] args){
		
	}
	
}
