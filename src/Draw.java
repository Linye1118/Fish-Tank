import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Draw {
	private Set <DrawObject> objects = new HashSet<>();
	
	//constructor
	public Draw(FishTank t) {
		// TODO Auto-generated constructor stub
		loadDrawObjects(t);
		drawFrontBack(t);
	}

	public void loadDrawObjects(FishTank t) {
		for (Fish o : t.getFishes()) {
			DrawObject fish = new DrawObject(o.getSymbol(), o.getX(), o.getY(), o.getZ(), "fish", o.getSize());
			fish.backPosition(t); //create drawObj value for back
			objects.add(fish);
		
		}
		for (Plant d:t.getPlants()) {
			DrawObject plant = new DrawObject(d.getSize(),d.getX(),d.getY(),d.getZ(), "plant");
			plant.backPosition(t);//create drawObj value for back
			objects.add(plant);
		}
	}
	
	public void print(String l) {
		System.out.print(l);	//print without change a line
	}
	
	/*
	 * find out on the same x y spot find out the closest z object 
	 * (front case and back case are separated)
	 */
	public DrawObject findClosestObject(int i, int j, FishTank t) {
		List<DrawObject> found = new ArrayList<>();
		for (DrawObject o : objects) {
			if((o.getX()==j && o.getY()==i)||(o.getBackX()==j && o.getBackY()==i)) {
				found.add(o);
			}
		}
		
		DrawObject objFound = null;
		for (DrawObject f : found) {
			int zMin = 0;
			if (j<t.getWidth()-1) {
				if(zMin==0 || zMin>f.getZ()) { //find closet to front object
					zMin=f.getZ();
					objFound = f;
				}else if(zMin!=0 && zMin<f.getZ()) {
					//object in the middle do nothing
				}else if(zMin!=0 && zMin==f.getZ()) { //2 objects in the same position
					if (f.getType().equals(objFound.getType())) {
						if (f.getSize()>objFound.getSize()) {
							objFound = f;
						}else if (f.getType().equals("fish")&& (!objFound.getType().equals("fish"))) {
							objFound = f;//show fish over plant
						}
					}
				}
			}else if (j>t.getWidth()+5) {
				if(zMin==0 || zMin>f.getBackZ()) { //find closet to front object
					zMin=f.getBackZ();
					objFound = f;
				}else if(zMin!=0 && zMin<f.getBackZ()) {
					//object in the middle do nothing
				}else if(zMin!=0 && zMin==f.getBackZ()) { //2 objects in the same position
					if (f.getType().equals(objFound.getType())) {
						if (f.getSize()>objFound.getSize()) {
							objFound = f;
						}else if (f.getType().equals("fish")&& (!objFound.getType().equals("fish"))) {
							objFound = f;//show fish over plant
						}
					}
				}
			}
		}
		return objFound;
	}
	
	public void drawFrontBack(FishTank t) {
		int gap = 5;
		int H=t.getHeight(); int W=t.getWidth()*2+gap; 
		print("Front");
		for (int w = 5; w<38; w++) {
			if (w==37) {print("Back\n");}
			else {print(" ");}
		}	
		for (int i =0; i<H; i++) {
			for (int j =0; j<W; j++) {
				if (i==0 && j==0) { //left corner for front
					print("l");
				}else if (i==0 && j==W-1) { //left corner for back
					print("l\n");
				}else if ((i==0 && j==t.getWidth()-1)||(i==0 && j==t.getWidth()+5)) { //right corner for front
					print("r");
				}else if (i==0 && j==W-1) {//right corner for back change line
					print("r\n");
				}else if ((j==0||j==t.getWidth()-1||j==t.getWidth()+5) && i!=0){
					print("|"); //tank left side, Back tank right side
				}else if (j==W-1 && i!=0) {
					print("|\n");//tank right side and change line
				}else if ((i==0 && j>0 && j<t.getWidth()-1)||(i==0 && j>t.getWidth()+5 && j<W)){
					print("-");//tank top and bottom
				}else if ((i==H-1 && j>0 && j<t.getWidth()-1)||(i==H-1 && j>t.getWidth()+5 && j<W)){
					print("-");
				}else {
					DrawObject objFound = this.findClosestObject(i, j, t);
					if(objFound!=null) {
						if (objFound.getType().equals("fish")) {
							print(objFound.getSymbol()+"");
						}else if (objFound.getType().equals("plant")) {
							print(objFound.getSize()+"");
						}	
					}else {
						print(" ");
					}		
				}		
			}
		}
	}
}