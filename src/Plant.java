
public class Plant {
	
	private String species;
	private int id;
	private int size;
	private int x;
	private int y = 8;
	private int z;
	
	public Plant(String species, int size, int x, int z, int id) {
		super();
		this.species = species;
		this.size = size;
		this.x = x;
		this.z = z;
		this.id = id;
		
	}
	public void list() {
		System.out.println(id + " " + species + " Size: "+size + " X: "+ x + " Y: "+ this.getY() + " Z: "+ z);
	}

	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}
	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}

	
}
