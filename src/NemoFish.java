
public class NemoFish extends Fish{

	protected char symbol = 'n';
	protected int speed=2;
	
	public NemoFish(int size, int x, int y, int z, String species, int id) {
		// TODO Auto-generated constructor stub
		super(size, x, y, z, species, id);
	}

	
	
	public void list() {
		System.out.println(super.getId() + " " + super.getSpecies() + " "+this.getSymbol() 
		+ " X: "+ super.getX() + " Y: "+ super.getY() + " Z: "+ super.getZ());
	}
	
	/* 
	 * nemo fish will turn away when facing big fish
	 */
	public String randomDir(String dir, FishTank t) {
		String nextDir = null;
		String danger = null;
		if (dir==null) {
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
			danger = this.avoidBigFish(nextDir, t);
			
		}else if(dir!=null) {
			nextDir=dir; //no danger keep moving forward
			danger = this.avoidBigFish(nextDir, t);
		}
		int i = 2;
		while(danger!=null && i>0) {
			if (nextDir.equals("Front")) {
				nextDir="Back";
			}else if(nextDir.equals("Back")){
				nextDir="Front";
			}else if(nextDir.equals("Right")) {
				nextDir="Left";
			}else if(nextDir.equals("Left")) {
				nextDir="Right";
			}else if(nextDir.equals("Up")) {
				nextDir="Down";
			}else if(nextDir.equals("Down")) {
				nextDir="Up";
			}
			danger = this.avoidBigFish(nextDir, t);
			i--;
		}
		//check if it's 1st move or backward
		if (danger==null && nextDir!=null) {
			if((dir.equals("Front") && nextDir.equals("Back"))||(dir.equals("Back") && nextDir.equals("Front"))
				||(dir.equals("Right") && nextDir.equals("Left"))||(dir.equals("Left") && nextDir.equals("Right"))
				||(dir.equals("Up") && nextDir.equals("Down"))||(dir.equals("Down") && nextDir.equals("Up"))) {
				this.randomDir(dir); //Recursion
				return nextDir;
			}else { return nextDir;}
		}else if(danger!=null || nextDir==null) {
			super.randomDir(dir);
		}
		return nextDir;
	}
	
	public void tick(FishTank t) {
		String nextDir = this.randomDir(this.getDir());
		String danger = this.avoidBigFish(nextDir, t);
		while(danger!=null) {
			if (nextDir.equals("Front")) {
				nextDir="Back";
			}else if(nextDir.equals("Back")){
				nextDir="Front";
			}else if(nextDir.equals("Right")) {
				nextDir="Left";
			}else if(nextDir.equals("Left")) {
				nextDir="Right";
			}else if(nextDir.equals("Up")) {
				nextDir="Down";
			}else if(nextDir.equals("Down")) {
				nextDir="Up";
			}
			danger = this.avoidBigFish(nextDir, t);
		}
		
		int nextP = this.move(nextDir, t);
		boolean moved = this.inBound(nextDir, t, nextP);
		int i=0;
		while (i<5 && moved==false && danger!=null) { // if fish did not move try another time until 5.
			nextDir = this.randomDir(super.getDir());
			nextP = this.move(nextDir, t);
			moved = this.inBound(nextDir, t, nextP);
			i++;
		}
		this.eat(t);
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
