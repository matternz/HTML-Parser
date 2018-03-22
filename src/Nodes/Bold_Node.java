package Nodes;

/**
 * 
 */

public class Bold_Node extends AbstractNode {

	StringBuilder text;

	public Bold_Node(String text) {
		this.text = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (c == '#') {
				continue;
			}
			this.text.append(c);
		}
	}

	@Override
	public String getHTML() {
		return "<strong>"+super.getHTML()+"</strong>";
	}

	@Override
	public String getLatex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return this.text.toString();
	}

}
