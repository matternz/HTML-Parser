package Nodes;

public class Italic_Node extends AbstractNode {

	StringBuilder text;

	public Italic_Node() {
	}

	@Override
	public String getHTML() {
		return "<em>"+super.getHTML()+"</em>";
	}

	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}

}
