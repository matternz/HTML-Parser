package Nodes;

public class Block_Code_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<pre>" + super.getHTML() + "</pre>";
	}

}
