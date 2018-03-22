package Nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode {

	public List<AbstractNode> nodes;
	
	public AbstractNode() {
		this.nodes = new ArrayList<>();
	}
	
	public void addNode(AbstractNode n){
		this.nodes.add(n);
	}
	
	public String toString(){
		return null;
	}
	
	public String getLatex(){
		return null;
	}
	
	public String getHTML(){
		StringBuilder str = new StringBuilder();
		for(AbstractNode n : this.nodes){
			str.append(n.getHTML());
		}
		return str.toString();
	}

}
