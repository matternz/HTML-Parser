package Nodes;
public interface Node{
	
	/**
	 * returns the string encoded with html
	 * @return
	 */
	public String getHTML();
	
	/**
	 * returns the string encoded with latex
	 * @return
	 */
	public String getLatex();
	
	/**
	 * returns the string stored with out any encoding
	 * @return
	 */
	public String toString();
}