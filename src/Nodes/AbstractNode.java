package Nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode extends MainNode {

	private List<Node> nodes;
	
	public AbstractNode() {
		this.nodes = new ArrayList<>();
	}
	
	public void addNode(Node n){
		this.nodes.add(n);
	}
	
	@Override
	public String getHTML(){
		StringBuilder str = new StringBuilder();
		for(Node n : this.nodes){
			str.append(n.toString());
		}
		return str.toString();
	}

}
