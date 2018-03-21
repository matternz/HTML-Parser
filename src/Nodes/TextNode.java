package Nodes;

public class TextNode extends AbstractNode{

	private String text;
	
	public TextNode(String text){
		 this.text = text;
	}
	
	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return this.text;
	}

	@Override
	public String getHTML() {
		return this.text;		
	}
	
}
