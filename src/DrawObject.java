
public class DrawObject {
	private String type;
	private int size;
	private char symbol;
	private int x;
	private int y;
	private int z;
	
	private int backX;
	private int backY;
	private int backZ;
	
	private int leftX;
	private int leftY;
	private int leftZ;
	
	private int rightX;
	private int rightY;
	private int rightZ;
	
	public DrawObject(char symbol, int x, int y, int z, String type, int size) { // for fishes
		super();
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
		this.size = size;
	}
	public DrawObject(int size, int x, int y, int z, String type) { //for plants
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
		this.size = size;
		this.symbol = 'p';
	}
	
	
	
	public void backPosition(FishTank o) {
		int h=o.getHeight(); int w=o.getWidth(); int l=o.getLength();
		int xBack=0; int gap=5;
		for (int i =0; i<h-1; i++) {
			for (int j =0; j<w-1; j++) {
				if (type.equals("fish")) {
					for (Fish f : o.getFishes()) {
						if(f.getX()==j && f.getY()==i) {
							xBack=w*2+gap-1-f.getX(); //x position show on back board
							this.setBackX(xBack);
							this.setBackY(f.getY()); //y keep the same
							this.setBackZ(l-1-f.getZ()); //z close to back to show	
						}
					}
				}else if(type.equals("plant")) {
					for (Plant p : o.getPlants()) {
						if(p.getX()==j && p.getY()==i) {
							xBack=w*2+gap-1-p.getX(); //x position show on back board
							this.setBackX(xBack);
							this.setBackY(p.getY()); //y keep the same
							this.setBackZ(l-1-p.getZ()); //z mirror position	
						}
					}
				}	
			}
		}
	}
	
	
	public int getBackZ() {
		return backZ;
	}

	public void setBackZ(int backZ) {
		this.backZ = backZ;
	}

	public int getLeftZ() {
		return leftZ;
	}

	public void setLeftZ(int leftZ) {
		this.leftZ = leftZ;
	}

	public int getRightZ() {
		return rightZ;
	}

	public void setRightZ(int rightZ) {
		this.rightZ = rightZ;
	}

	public char getSymbol() {
		return symbol;
	}


	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}


	public int getBackX() {
		return backX;
	}


	public void setBackX(int backX) {
		this.backX = backX;
	}


	public int getBackY() {
		return backY;
	}


	public void setBackY(int backY) {
		this.backY = backY;
	}


	public int getLeftX() {
		return leftX;
	}


	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}


	public int getLeftY() {
		return leftY;
	}


	public void setLeftY(int leftY) {
		this.leftY = leftY;
	}


	public int getRightX() {
		return rightX;
	}


	public void setRightX(int rightX) {
		this.rightX = rightX;
	}


	public int getRightY() {
		return rightY;
	}


	public void setRightY(int rightY) {
		this.rightY = rightY;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
