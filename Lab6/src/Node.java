
import java.util.ArrayList;
import java.util.List;

public class Node {
	private int id;
	private String name;
	private List<Node> childrens;
	
	public Node(int id, String name) {
		this.id = id;
		this.name = name;
		this.childrens = new ArrayList();
	}
	
	public int getId() {return this.id;}
	
	public String getName() {return this.name;}
	
	public List<Node> getChildrens(){return this.childrens;}
	
	public void addChild(Node node) {
		this.childrens.add(node);
	}
}
