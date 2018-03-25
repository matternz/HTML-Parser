package Nodes;

public class Paragraph_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<p>" + super.getHTML() + "</p>";
	}
}
