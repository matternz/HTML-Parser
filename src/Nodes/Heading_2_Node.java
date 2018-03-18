package Nodes;

public class Heading_2_Node implements Node {

	StringBuilder text;
	StringBuilder htmlText;
	StringBuilder latexText;
	
	public Heading_2_Node(String text) {
		this.text = new StringBuilder();
		this.htmlText = new StringBuilder();
		this.latexText = new StringBuilder();
		this.text.append(text);
	}

	@Override
	public String getHTML() {
		this.htmlText.append("<h2>");
		this.htmlText.append(this.text);
		this.htmlText.append("</h2>");
		return this.htmlText.toString();
	}

	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		return this.text.toString();
	}

}
