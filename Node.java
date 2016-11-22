
public class Node {

	private int id;
	private String name;
	private int longitude;
	private int altitude;
	
	/*public Node(int id, String n, int longitude, int altitude) {
		this.id = id;
		this.name = n;
		this.longitude = longitude;
		this.altitude = altitude;
	}*/
	
	public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.longitude = 0; //Suite aux modifications apport�es par le charg� de lab durant la s�ance
		this.altitude = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	public int hashCode() {
		return id;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setLaltitude(int laltitude) {
		this.altitude = laltitude;
	}
}
