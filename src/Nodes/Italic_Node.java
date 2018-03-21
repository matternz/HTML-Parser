package Nodes;

public class Italic_Node extends AbstractNode {

	StringBuilder text;

	public Italic_Node(String text) {
		this.text = new StringBuilder();
		for(char c : text.toCharArray()) {
			if(c == '*') {
				continue;
			}
			this.text.append(c);
		}
	}

	@Override
	public String getHTML() {
		return "<em>"+super.getHTML()+"</em>";
	}

	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		return this.text.toString();
	}

}
