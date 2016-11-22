
public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		// Exerice 1: A completer : création du graphe
		
		
		// Exerice 2: A completer : création du graphe
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(/* Spécifiez les paramètres */);
		
		d.afficherTable();

		// Exercice 3
		System.out.println(d.afficherCourtChemin(/* Spécifiez les paramètres */));
	
	}
}
