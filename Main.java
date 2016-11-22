import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		// Exerice 1: A completer : création du graphe
		
		//Création des noeuds
		Node nodeA = new Node(0,"A");
		Node nodeB = new Node(1,"B");
		Node nodeC = new Node(2,"C");
		Node nodeD = new Node(3,"D");
		Node nodeE = new Node(4,"E");
		Node nodeF = new Node(5,"F");
		Node nodeG = new Node(6,"G");
		
		//Création des arcs
		Edge edgeAB = new Edge(nodeA,nodeB,2);
		Edge edgeAC = new Edge(nodeA,nodeC,1);
		Edge edgeBE = new Edge(nodeB,nodeE,3);
		Edge edgeBC = new Edge(nodeB,nodeC,2);
		Edge edgeEC = new Edge(nodeE,nodeC,3);
		Edge edgeBD = new Edge(nodeB,nodeD,1);
		Edge edgeCD = new Edge(nodeC,nodeD,4);
		Edge edgeCF = new Edge(nodeC,nodeF,5);
		Edge edgeEF = new Edge(nodeE,nodeF,1);
		Edge edgeDF = new Edge(nodeD,nodeF,6);
		Edge edgeDG = new Edge(nodeD,nodeG,5);
		Edge edgeFG = new Edge(nodeF,nodeG,2);
		
		//Ajout des noeuds à la liste des noeuds du graphe
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);
		nodes.add(nodeE);
		nodes.add(nodeF);
		nodes.add(nodeG);
		
		g.setNodes(nodes);
		
		//Ajout des arcs à la liste des arcs du graphe
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(edgeAB);
		edges.add(edgeAC);
		edges.add(edgeBE);
		edges.add(edgeBC);
		edges.add(edgeEC);
		edges.add(edgeBD);
		edges.add(edgeCD);
		edges.add(edgeCF);
		edges.add(edgeEF);
		edges.add(edgeDF);
		edges.add(edgeDG);
		edges.add(edgeFG);
		
		g.setEdges(edges);
		
		
		// Exerice 2: A completer : création du graphe
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(/* SpÃ©cifiez les paramètres */);
		
		d.afficherTable();

		// Exercice 3
		System.out.println(d.afficherCourtChemin(/* Spécifiez les paramètres */));
	
	}
}
