import java.util.*;

public class NHLSimulator {
static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("NHL Simulator(Version 0.1). Author: Ekim Karabey");
		System.out.println("1 - Simulate NHL Season (Eastern Conference)");
		System.out.println("2 - View Team Skill Level Profile");
		System.out.println("3 - Display End of Regular Season Table");
		System.out.print("Select Option [1, 2 or 3](9 to Quit):");
		int in = s.nextInt();

		while(in != 9){




			System.out.print("Select Option [1, 2 or 3](9 to Quit):");
			in = s.nextInt();
		}
		Game testGame = new Game(Team.leafs, Team.philadelphia);
		testGame.printGame();
	}
}
