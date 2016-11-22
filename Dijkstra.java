import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
		
		for(int i = 1; i < graph.getNodes().size(); i++){
			dijkstraTable[i] = new HashMap<Node, Edge>(dijkstraTable[i-1]);
			dijkstraTable[i].remove(selectedNode);
			
			for(Edge e : graph.getEdgesConnected(selectedNode)){
				Edge eCopie = new Edge(e.getSource(), e.getDestination(), e.getDistance()+ (dijkstraTable[i-1].get(selectedNode)).getDistance());
				if(dijkstraTable[i].get(eCopie.getDestination()) != null){
					if(eCopie.getDistance() < (dijkstraTable[i].get(eCopie.getDestination())).getDistance())
						dijkstraTable[i].replace(eCopie.getDestination(), eCopie);
				}
				else
					dijkstraTable[i].put(eCopie.getDestination(), eCopie);
			}
			
			selectedNode = getMinimum(dijkstraTable[i]);
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

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
	}

	public void afficherTable () {
		// A completer
		
	}
}
