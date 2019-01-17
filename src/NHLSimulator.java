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
				if(in == 1){
					Game testGame = new Game(Team.leafs, Team.boston);
					Game.simulateSeason();
				} else if (in == 2){
					String teamIn = s.nextLine();
					teamIn = s.nextLine();
					Team found = Team.findTeam(teamIn);
					found.printRoster();
				} else if (in == 3){
					Team.printAllStats();
				} else {
					System.out.println("Unknown command!");
				}
			System.out.print("Select Option [1, 2 or 3](9 to Quit):");
			in = s.nextInt();
		}
	}
}
