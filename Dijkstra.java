import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	@SuppressWarnings("unchecked")
	public void findPath (Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		
		dijkstraTable[0] = new HashMap<Node, Edge>();
		
		Edge edgeSS = new Edge(s,s,0);
		
		dijkstraTable[0].put(edgeSS.getDestination(), edgeSS);
			
		Node selectedNode = s;
		ArrayList<Node> selectedNodes = new ArrayList<Node>(); //Donne les noeuds choisis et leur valeur minimale pour se rendre
		selectedNodes.add(selectedNode);
		
		Stack<Node> path = new Stack<Node>();
		path.push(selectedNode);
		
		int i = 1;
		while (selectedNode != d){
			dijkstraTable[i] = new HashMap<Node, Edge>(dijkstraTable[i-1]);
			dijkstraTable[i].remove(selectedNode);
			
			for(Edge e : graph.getEdgesConnected(selectedNode)){
				Edge connectedEdgePlus = new Edge(e.getSource(), e.getDestination(), e.getDistance() + (dijkstraTable[i-1].get(selectedNode)).getDistance());
				
				//Si le noeud a deja ete choisi, ou que la nouvelle valeur est superieure a celle deja dans la table de dijkstra, on ne fait rien
				if(selectedNodes.contains(connectedEdgePlus.getDestination()) || 
						(dijkstraTable[i].containsKey(connectedEdgePlus.getDestination()) && (connectedEdgePlus.getDistance() > dijkstraTable[i].get(connectedEdgePlus.getDestination()).getDistance()))){
				}
				//sinon, on lajoute dans la table
				else
					dijkstraTable[i].put(connectedEdgePlus.getDestination(), connectedEdgePlus);
			}
			
			selectedNode = getMinimum(dijkstraTable[i]);
			while(!path.empty() && path.peek() != dijkstraTable[i].get(selectedNode).getSource() ){
				path.pop();
			}
			
			path.push(selectedNode);
			selectedNodes.add(selectedNode);
			i++;
		}

	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	//private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
	//}
	
	//public String afficherCourtChemin (Node source, Node destination) {
		// A completer
	//}

	public void afficherTable () {
		// A completer
		
	}
}

/*
public void findPath (Node s, Node d) {

dijkstraTable = new HashMap[graph.getNodes().size()];

dijkstraTable[0] = new HashMap<Node, Edge>();

Stack<Node> path = new Stack<Node>();

Edge edgeSS = new Edge(s,s,0);

dijkstraTable[0].put(edgeSS.getDestination(), edgeSS);
	
Node selectedNode = s;
HashMap<Node,Edge> selectedNodes = new HashMap<Node,Edge>(); //Donne les noeuds choisis et leur valeur minimale pour se rendre
selectedNodes.put(s, edgeSS);

for(int i = 1; i < graph.getNodes().size(); i++){
	dijkstraTable[i] = new HashMap<Node, Edge>(dijkstraTable[i-1]);
	dijkstraTable[i].remove(selectedNode);
	
	for(Edge e : graph.getEdgesConnected(selectedNode)){
		Edge eCopie = new Edge(e.getSource(), e.getDestination(), e.getDistance() + (dijkstraTable[i-1].get(selectedNode)).getDistance());
		
		//Si le noeud a deja ete choisi, ou que la nouvelle valeur est superieure a celle deja dans la table de dijkstra, on ne fait rien
		if(selectedNodes.containsKey(eCopie.getDestination()) || 
				(dijkstraTable[i].containsKey(eCopie.getDestination()) && (eCopie.getDistance() > dijkstraTable[i].get(eCopie.getDestination()).getDistance()))){
		}
		//sinon, on lajoute dans la table
		else
			dijkstraTable[i].put(eCopie.getSource(), eCopie);
	}
	
	selectedNode = getMinimum(dijkstraTable[i]);
	path.push(selectedNode);
	selectedNodes.put(selectedNode, dijkstraTable[i].get(selectedNode));
}

}
*/