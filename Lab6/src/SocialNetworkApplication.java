
public class SocialNetworkApplication {
	
	public static void main(String[] arqs) {
		Graph graph = new Graph();

        Node ruslan = new Node(1, "Ruslan");
        Node oleskandr = new Node(2, "Oleskandr");
        Node mykhailo = new Node(3, "Mykhailo");
        Node andrii = new Node(4, "Andrii");

        ruslan.addChild(oleskandr);
        ruslan.addChild(mykhailo);
        oleskandr.addChild(andrii);

        graph.getNodes().add(ruslan);
        graph.getNodes().add(oleskandr);
        graph.getNodes().add(mykhailo);
        graph.getNodes().add(andrii);

        System.out.println("Find Node by ID 1: " + graph.getById(1).getName()); 

        System.out.println("Child Nodes of Ruslan:");
        graph.getChildNodes(1).forEach(child -> System.out.println(child.getName()));

        System.out.println("Shortest Path from Ruslan to Andrii:");
        graph.findShortestPath("Ruslan", "Andrii").forEach(node -> System.out.println(node.getName())); 
	}
	
}
