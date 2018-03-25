package Nodes;

public class Block_Quote_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<blockquote>" + super.getHTML() + "</blockquote>";
	}

}
