package Nodes;

public class Italic_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<em>" + super.getHTML() + "</em>";
	}

}
