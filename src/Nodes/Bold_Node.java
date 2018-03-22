package Nodes;

/**
 * 
 */

public class Bold_Node extends AbstractNode {

	StringBuilder text;

	@Override
	public String getHTML() {
		return "<strong>"+super.getHTML()+"</strong>";
	}

	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	} 

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
