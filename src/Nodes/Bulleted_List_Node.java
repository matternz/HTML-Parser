package Nodes;

public class Bulleted_List_Node extends AbstractNode {

	@Override
	public String getHTML(){
		return "<li>"+super.getHTML()+"</li>";
	}
	
}
