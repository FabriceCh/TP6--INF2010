import java.util.List;
import java.util.ArrayList;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() { // A VOIR
		this.nodes = null;
		this.edges = null;
	}
	
	/*public List<Edge> getEdgesGoingFrom(Node source) {
		ArrayList<Edge> edgesFrom = new ArrayList<Edge>();
		
		for(Edge e : edges){ //On parcourt la liste des arcs du graphes
			if(e.getSource() == source){ //Si on trouve un match entre la source de l'arc et le noeud en param�tre
				edgesFrom.add(e); //Alors on ajoute le noeud � la liste que l'on va renvoy�e
			}
		}
		
		return edgesFrom;
		
	}
	
	public List<Edge> getEdgesGoingTo(Node dest) {
		ArrayList<Edge> edgesGoingTo = new ArrayList<Edge>();
		
		for(Edge e : edges){ 
			if(e.getDestination() == dest){ //Si on trouve un match entre la destination de l'arc et le noeud en param�tre
				edgesGoingTo.add(e);
			}
		}
		
		return edgesGoingTo; 
		
	}*/
	
	//NOUS UTILISONS UN GRAPHE NON ORIENTE, par cons�quent, les deux m�thodes ci-dessus, se r�sume en une seule.
	public List<Edge> getEdgesConnected(Node node) {
		ArrayList<Edge> edgesConnected = new ArrayList<Edge>();
		
		for(Edge e : edges){ 
			if(e.getDestination() == node || e.getSource() == node){ //Si on trouve un match entre la destination de l'arc et le noeud en param�tre
				edgesConnected.add(e);
			}
		}
		
		return edgesConnected; 
		
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
