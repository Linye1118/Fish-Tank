import java.util.ArrayList;
import java.util.List;

public class FishTank {
	protected int width=32;
	protected int height=10;
	protected int length=10;
	
	private static int count; //count only used for id generate but cannot be used for count objects
	
	private List<Fish> fishes= new ArrayList<>();
	private List<Plant> plants= new ArrayList<>();
	
	public FishTank() {
		loadDefault();
		drawTank();
	}
	
	public void drawTank() {
		Draw FB = new Draw(this);
	}
	
	public void updateTank() {
		for (Fish b : fishes) {
			b.tick(this);
		}
		this.drawTank();
	}

	public void addFish(Fish b) {
		//check boundary
		if (b.getX()<=0 || b.getX()>=width-1 
				|| b.getY()<=0||b.getY()>= height-1||b.getZ()<=0||b.getZ()>=length-1) {
			return;
		}
		count= count +1;
		fishes.add(b);
	}
	
	public void loadDefault() {
		count = count+1;
		for (int i = 0; i < 5; i++) { //5 small fishes
			int x = (int) (Math.random() * (width-2))+1;
			int y = (int) (Math.random() * (height-2))+1;
			int z = (int) (Math.random() * (length-2))+1;
			if (Math.random() < 0.5) {
				addFish(new NemoFish(5,  x, y, z, "nemo", count));
			} else {
				addFish(new Fish(10, x, y, z, "blue tang",count));
			}
		}
		
		for (int i = 0; i < 2; i++) { //2 big fishes
			int x = (int) (Math.random() * (width-2))+1;
			int y = (int) (Math.random() * (height-2))+1;
			int z = (int) (Math.random() * (length-2))+1;
			addFish(new BigFish(20, x, y, z, "eel",count));
		}
		
		for (int i = 0; i < 5; i++) { //5 plants
			int x = (int)(Math.random() * (width-2))+1;
			int z = (int)(Math.random() * (length-2))+1;
			int s = (int)(Math.random()*9)+1; //plant size (1-9)
			count = count+1;
			plants.add(new Plant("capnella", s, x, z, count));
		}
		
		for (int i=0; i<10; i++) { //10 schooling fish
			int x = (int) (Math.random() * (width-2))+1;
			int y = (int) (Math.random() * (height-2))+1;
			int z = (int) (Math.random() * (length-2))+1;
			addFish(new SchoolingFish(5, x, y, z, "school", count));
		}

	}
	
	public void report() {
		//can list all the items in the tank and their positions
		for (Plant p : plants) {
			p.list();
		}
		for (Fish f: fishes) {
			f.list();
		}
	}
	
	public void print(String l) {
		System.out.print(l);	//print without change a line
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		FishTank.count = count;
	}

	public List<Fish> getFishes() {
		return fishes;
	}

	public void setFishes(List<Fish> fishes) {
		this.fishes = fishes;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	
	
}
