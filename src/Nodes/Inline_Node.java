package Nodes;

public class Inline_Node extends AbstractNode{
	
	@Override
	public String getHTML(){
		return "<code>"+super.getHTML()+"</code>";
	}
	
}
