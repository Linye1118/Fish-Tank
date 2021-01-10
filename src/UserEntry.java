import java.util.Scanner;

public class UserEntry {
	private static Scanner sc = new Scanner(System.in);
	
	
	public UserEntry() {
		initialize();
	}
	
	public void tickAndDraw(FishTank t) {
		print("Tick times?");
		int nr = sc.nextInt();
		sc.nextLine(); //discard space line after scan int
		for (int i = 0; i < nr; i++) {
			t.updateTank();
		}
	}
	
	public void addFish() {
		print("Fish species?");
		String sp = sc.nextLine();
		print ("Position [x/y/z]?");
		String P = sc.nextLine();	
		
	}
	
	public void removeFish() {
		
	}
	
	public void initialize() {
		FishTank t = new FishTank();
		t.report();
		this.tickAndDraw(t);
	}
	
	public void print(String l) {
		System.out.println(l);	
	}
	public static void main(String[] args) {
		new UserEntry();
	}
}
