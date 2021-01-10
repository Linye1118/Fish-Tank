
public class Fish {
	private int size;
	private int x;
	private int y;
	private int z;
	
	private String species;
	private int id;
	
	private int speed=1;
	private char symbol = 'f';
	
	private String dir;
	
	public Fish(int size, int x, int y, int z, String species, int id) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.z = z;
		this.species = species;
		this.id = id;
		
	}
	public Fish() {
		// TODO Auto-generated constructor stub
	}
	public void list() {
		System.out.println(id + " " + species + " "+symbol + " X: "+ x + " Y: "+ y + " Z: "+ z);
	}
	public void eat(FishTank t) {
		for (Fish s : t.getFishes()) {
			if (s.getX()==this.getX() && s.getY()==this.getY() && s.getZ()==this.getZ()) {
				if (s.getSize()<this.getSize()) {
					t.getFishes().remove(s); //unable to delete this fish?
					this.size=this.getSize()+1;
					System.out.println("a fish be eaten!");
					s.list();
				}
			}
		}
	}
	public String avoidBigFish(String nextDir, FishTank t) {
		String danger = null;
		int xTarget = x; int yTarget = y; int zTarget = z;
		if (nextDir.equals("Left")) {
			xTarget=x-speed*2;
		}else if(nextDir.equals("Right")) {
			xTarget=x+speed*2;
		}else if(nextDir.equals("Up")) {
			yTarget=y-speed*2;
		}else if (nextDir.equals("Down")) {
			yTarget=y+speed*2;
		}else if (nextDir.equals("Front")) {
			zTarget=z-speed*2;
		}else if(nextDir.equals("Back")) {
			zTarget=z+speed*2;
		}
		for (Fish b : t.getFishes()) {
			if(b.getX()==xTarget && b.getY()==yTarget && b.getZ()==zTarget) {
				if (b.getSize()>this.getSize()) {
					danger = nextDir; //2 steps forward has danger
				}
			}
		}
		return danger;
	}
	
	public void tick(FishTank t) {
		String nextDir = this.randomDir(dir);
		int nextP = this.move(nextDir, t);
		boolean moved = this.inBound(nextDir, t, nextP);
		String danger = this.avoidBigFish(nextDir, t);
		int i=0;
		while (i<5 && (moved==false || danger!=null)) { // if fish did not move try another time until 5.
			nextDir = this.randomDir(dir);
			nextP = this.move(nextDir, t);
			moved = this.inBound(nextDir, t, nextP);
			i++;
		}
		this.eat(t);
	}
	
	public int move(String nextDir, FishTank t) {
		//give the start value in case the argument not changed
		int nextX = x; int nextY = y; int nextZ = z; 
		int nextP = 0;
		if ("Front".equals(nextDir)) {
			nextP=nextZ=nextZ-speed;
		}else if ("Back".equals(nextDir)) {
			nextP=nextZ=nextZ+speed; return nextZ;
		}else if("Right".equals(nextDir)) {
			nextP=nextX=nextX+speed; return nextX;
		}else if ("Left".equals(nextDir)) {
			nextP=nextX=nextX-speed; return nextX;
		}else if ("Up".equals(nextDir)) {
			nextP=nextY=nextY-speed; return nextY;
		}else if  ("Down".equals(nextDir)) {
			nextP=nextY=nextY+speed; return nextY;
		}else {
			System.out.println("No nextDir...");//test
		}
		return nextP;
	}
	
	/*
	 * check boundary W32 H10 L10 and give new value to x, y, z, dir.
	 */		
	public boolean inBound(String nextDir, FishTank t, int nextP) {
		boolean inBound = false;
		if (nextDir.equals("Left") || nextDir.equals("Right")) {
			if (nextP>0 && nextP<t.getWidth()-1) {		
				x=nextP; dir=nextDir;
				inBound = true;
			}
		}else if (nextDir.equals("Up") || nextDir.equals("Down")) {
			if (nextP>0 && nextP<t.getHeight()-1) {			
				y=nextP; dir=nextDir;
				inBound = true;
			}
		}else if(nextDir.equals("Front")|| nextDir.equals("Back")) {
			if (nextP>0 && nextP<t.getLength()-1) {			
				z=nextP; dir=nextDir;
				inBound = true;
			}
		}
		return inBound;	
	}
	
	public String randomDir(String dir) {
		String nextDir = null;
		int d = (int)(Math.random()*5)+1;
		switch (d) {
		case 1:
			nextDir = "Front"; break;
		case 2:
			nextDir = "Back"; break;
		case 3:
			nextDir = "Right"; break;
		case 4:
			nextDir = "Left"; break;
		case 5:
			nextDir = "Up"; break;
		case 6:
			nextDir = "Down"; break;
		}
		//check if it's 1st move or backward
		if (dir == null) {
			return nextDir;
		}else if ((dir.equals("Front") && nextDir.equals("Back"))||(dir.equals("Back") && nextDir.equals("Front"))
			||(dir.equals("Right") && nextDir.equals("Left"))||(dir.equals("Left") && nextDir.equals("Right"))
			||(dir.equals("Up") && nextDir.equals("Down"))||(dir.equals("Down") && nextDir.equals("Up"))){
		this.randomDir(dir); //Recursion
		}
		return nextDir;
	}


	public String toString() {
		String s=null;
		// show fish info
		return s;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
}
