
public class Grass extends Plant{
	
	protected char symbol = 'g';
	
	public Grass(String species, int size, int x, int z, int id) {
		super(species, size, x, z, id);
		// TODO Auto-generated constructor stub
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	
}
