/*
Name: Ekim Karabey
NetId: 18ebk
Student Number: 20121769
*/

import java.util.*; // Used for the scanner class

public class NHLSimulator {
static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("NHL Simulator(Version 0.1). Author: Ekim Karabey");
		System.out.println("1 - Simulate NHL Season (Eastern Conference)");
		System.out.println("2 - View Team Skill Level Profile");
		System.out.println("3 - Display End of Regular Season Table");
		System.out.print("Select Option [1, 2 or 3](9 to Quit):");
		int in = s.nextInt();
		System.out.println("");

		boolean simulated = false;

		while(in != 9){
				if(in == 1){
					Game.simulateSeason();
					simulated = true;
					Team.printFirstandLast(Team.teams);
				} else if (in == 2){
					if(simulated){
						String teamIn = s.nextLine();
						teamIn = s.nextLine();
						Team found = Team.findTeam(teamIn);
						if(found != null){
							found.printRoster();
						}
					} else {
						System.out.println("Must run NHL Eastern Conference Simulation before accessing this option!");
					}
				} else if (in == 3){
					if(simulated){
						Team.printAllStats();
					} else {
						System.out.println("Must run NHL Eastern Conference Simulation before accessing this option!");
					}
				} else {
					System.out.println("Unknown command!");
				}
			System.out.println("");
			System.out.println("NHL Simulator(Version 0.1). Author: Ekim Karabey");
			System.out.println("1 - Simulate NHL Season (Eastern Conference)");
			System.out.println("2 - View Team Skill Level Profile");
			System.out.println("3 - Display End of Regular Season Table");
			System.out.print("Select Option [1, 2 or 3](9 to Quit):");
			in = s.nextInt();
			System.out.println("");
		}
	}
}
