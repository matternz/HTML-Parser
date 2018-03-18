package Nodes;

public class Italic_Node implements Node {
	
	StringBuilder text;
	StringBuilder htmlText;
	StringBuilder latexText;

	public Italic_Node(String text) {
		this.text = new StringBuilder();
		this.htmlText = new StringBuilder();
		this.latexText = new StringBuilder();
		this.text.append(text);
	}

	@Override
	public String getHTML() {
		this.htmlText.append("<em>");
		this.htmlText.append(text);
		this.htmlText.append("</em>");
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
