
import java.util.*;

public class Graph {
	private List<Node> nodes;
	
	public Graph() {
		this.nodes = new ArrayList();
	}
	
	public List<Node> getNodes(){return this.nodes;}
	
	public Node getById(int id) {
		if (this.nodes.isEmpty())
			return null;
		
		return this.nodes.stream()
						 .filter(node -> node.getId() == id)
						 .findFirst()
						 .orElse(null);
	}
	
	public Node getByName(String name) {
		if (this.nodes.isEmpty())
			return null;
		
		return this.nodes.stream()
						 .filter(node -> node.getName() == name)
						 .findFirst()
						 .orElse(null);
	}
	
	public List<Node> getChildNodes(int id){
		if (this.nodes.isEmpty())
			return null;
		
		Node node = getById(id);
		
		return node != null ? node.getChildrens() : null;
	}
	
	public List<Node> findShortestPath(String firstName, String secondName){
		Node start = getByName(firstName);
        Node end = getByName(secondName);
        if (start == null || end == null) return null;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> prevNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == end) {
                List<Node> path = new ArrayList<>();
                Node node = end;
                while (node != null) {
                    path.add(node);
                    node = prevNodes.get(node);
                }
                Collections.reverse(path);
                return path;
            }

            visited.add(current);
            for (Node neighbor : current.getChildrens()) {
                if (!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    prevNodes.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return null;
	}
}
