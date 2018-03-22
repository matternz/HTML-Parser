package Nodes;

public class Numbered_List_Wrapper_Node extends AbstractNode {
	@Override
	public String getHTML() {
		return "<ol>" + super.getHTML() + "</ol>";
	}
}
