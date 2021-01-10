
public class BigFish extends Fish{

	protected char symbol = 'F';
	protected int speed=3;
	
	public BigFish(int size, int x, int y, int z, String species, int id) {
		super(size, x, y, z, species, id);
		// TODO Auto-generated constructor stub
		
	}
	public void list() {
		System.out.println(super.getId() + " " + super.getSpecies() + " "+this.getSymbol() 
		+ " X: "+ super.getX() + " Y: "+ super.getY() + " Z: "+ super.getZ());
	}
	
	
	public int move(String nextDir, FishTank t) {
		//give the start value in case the argument not changed
		int nextX = super.getX(); int nextY = super.getY(); int nextZ = super.getZ(); 
		int nextP = 0;
		if ("Front".equals(nextDir)) {
			nextZ=nextZ-speed; return nextZ;
		}else if ("Back".equals(nextDir)) {
			nextZ=nextZ+speed; return nextZ;
		}else if("Right".equals(nextDir)) {
			nextX=nextX+speed; return nextX;
		}else if ("Left".equals(nextDir)) {
			nextX=nextX-speed; return nextX;
		}else if ("Up".equals(nextDir)) {
			nextY=nextY-speed; return nextY;
		}else if  ("Down".equals(nextDir)) {
			nextY=nextY+speed; return nextY;
		}else {
			System.out.println("No nextDir...");//test
			return nextP;
		}
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
