package Nodes;

public class HeaderNode2 extends AbstractNode {

	@Override
	public String getHTML() {
		return "<h2>" + super.getHTML() + "</h2>";
	}

}
