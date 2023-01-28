package artificialSweetener;
import java.util.Scanner;

public class ArtificialSweeener {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double killMouse, mouse, man, canKillMan;
		double percentage = 0.001;
		int gramOfCan = 30;
		
		killMouse = scanner.nextDouble();
		mouse = scanner.nextDouble();
		man = scanner.nextDouble();
		
		canKillMan = (((killMouse/mouse)*man)/percentage)/gramOfCan;
		
		System.out.printf("%.1f", canKillMan);
		

	}

}
