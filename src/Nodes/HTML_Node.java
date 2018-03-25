package Nodes;

public class HTML_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<html>" + super.getHTML() + "</html>";
	}

}
