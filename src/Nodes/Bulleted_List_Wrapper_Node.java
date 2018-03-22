package Nodes;

public class Bulleted_List_Wrapper_Node extends AbstractNode {

	@Override
	public String getHTML() {
		return "<ul>" + super.getHTML() + "</ul>";
	}

}
