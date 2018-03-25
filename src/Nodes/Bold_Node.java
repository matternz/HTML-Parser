package Nodes;

public class Bold_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<strong>" + super.getHTML() + "</strong>";
	}

}
