
public class Edge {

	private Node source;
	private Node destination;
	private int distance;
	
	public Edge () {}
	
	/*public Edge(Node s, Node d) {
		this.source = s;
		this.destination = d;
		this.distance = Math.abs(s.getLongitude() - d.getLongitude()) + Math.abs(s.getAltitude() - d.getAltitude()); // adapted from http://stackoverflow.com/questions/8224470/calculating-manhattan-distance/8224516#8224516

	}*/
	
	public Edge(Node s, Node d, int poids) {
		this.source = s;
		this.destination = d;
		this.distance = poids;
	}
	
	public Node getSource() {
		return source;
	}
	public void setSource(Node source) {
		this.source = source;
	}
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	
	
}
