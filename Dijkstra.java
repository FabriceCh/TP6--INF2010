import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Arrays;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	
	public Dijkstra (Graph g) {
		this.graph = g;
	}

	@SuppressWarnings("unchecked")
	public void findPath (Node s, Node d) {

		//initialisation de la table
		dijkstraTable = new HashMap[graph.getNodes().size()];
		
		//initialisation de la premiere ligne (premiere iteration)
		dijkstraTable[0] = new HashMap<Node, Edge>();
		Edge edgeSS = new Edge(s,s,0);
		dijkstraTable[0].put(edgeSS.getDestination(), edgeSS);

		Node selectedNode = s;
		ArrayList<Node> selectedNodes = new ArrayList<Node>(); //Donne les noeuds choisis
		selectedNodes.add(selectedNode);
		
		//initialisation du stack pour se souvenir du parcours
		path = new Stack<Edge>();
		path.push(edgeSS);
		
		/*
		 * A chaque iteration, on copie l'Hashmap de la precedente et on lui enleve le
		 * noeud qui a ete choisi precedemment. Ensuite on ajoute tous les noeuds qui
		 * sont reliés au noeud choisi, à condition qu'ils ne sont pas parmi l'array
		 * SelectedNodes ou que leur chemin est plus long que le précédent.
		 */
		
		int i = 1; //iterateur pour parcourir la dijkstraTable et sortir du while
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
			
			path.push(dijkstraTable[i].get(selectedNode));
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
	
	/*
	 * La logique de cette méthode est expliquée dans l'énoncé. On dépile jusqu'à ce 
	 * que la destination de l'arc sur la pile est la source du noeud actuel.
	 */
	
	public String afficherCourtChemin(Node source, Node destination) {
		this.findPath(source,destination);
		StringBuilder chemin = new StringBuilder();
		Edge lastEdge = path.pop();
		int longeurDuChemin = lastEdge.getDistance();
		
		chemin.append(lastEdge.getDestination().getName() + " ");
		while (!path.empty()){
			if (!path.empty() && path.peek().getDestination() == lastEdge.getSource()){
				chemin.append(lastEdge.getSource().getName() + " ");
				lastEdge = path.pop();
			}
			else{
				path.pop();
			}
		}
		System.out.print("La longueur du plus court chemin est : ");
		System.out.println(longeurDuChemin);
		return "Le chemin le plus court est : " + chemin.reverse().toString();
		
	}

	/*
	 * On parcourt toutes les HashMap et on stock leur contenu dans un array double dont 
	 * on connait la taille. On compare toujours la node dans le HashMap avec la node associée
	 * à la colonne, si elle est égale, on ajoute l'arc et sa source dans le tableau, sinon
	 * on ajoute une tabulation.
	 */
	
	public void afficherTable () {
		ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
		String[][] table = new String[dijkstraTable.length][nodes.size()];
		for (int i = 0; i < nodes.size(); i++){
			table[0][i] = nodes.get(i).getName() + "\t";
		}
		System.out.println(Arrays.deepToString(table[0]));
		for (int i = 0; i < dijkstraTable.length; i++){
			for(int j = 0; j < nodes.size(); j++){
				if (dijkstraTable[i].containsKey(nodes.get(j))){
					table[i][j] = dijkstraTable[i].get(nodes.get(j)).getDistance() + dijkstraTable[i].get(nodes.get(j)).getSource().getName() + "\t";
				}
				else
					table[i][j] = "\t";
			}
		}
		for (int i = 0; i < dijkstraTable.length; i++)
			System.out.println(Arrays.deepToString(table[i]));
		
	}
	
	
}
