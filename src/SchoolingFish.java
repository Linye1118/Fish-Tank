
public class SchoolingFish extends Fish{
	
	protected char symbol = 's';
	protected int speed = 2;
	
	
	public SchoolingFish(int size, int x, int y, int z, String species, int id) {
		super(size, x, y, z, species, id);
		// TODO Auto-generated constructor stub
		
	}
	
	public void list() {
		System.out.println(super.getId() + " " + super.getSpecies() + " "+this.getSymbol() 
		+ " X: "+ super.getX() + " Y: "+ super.getY() + " Z: "+ super.getZ());
	}
	
	public String findNearbySchool(FishTank t) {
		int disMin = 0; String nearByDir = null;
		for (Fish s: t.getFishes()) {
			if(s.getSymbol()=='s') {
				int disX = Math.abs(s.getX()-this.getX());
				int disY = Math.abs(s.getY()-this.getY());
				int disZ = Math.abs(s.getZ()-this.getZ());
				int dis = (int) Math.sqrt(disX^2+disY^2+disZ^2); //distance between 2 fish
				if (disMin==0 || disMin>dis) {
					disMin=dis;
					nearByDir=s.getDir();
				}
			}
		}
		return nearByDir;
	}
	
	/*
	 * for schooling need to find the nearby same kind fish direction (the method still call random though)
	 */
	public String randomDir(String dir, FishTank t) {
		String nextDir = this.findNearbySchool(t);
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
