/*
Name: Ekim Karabey
NetId: 18ebk
Student Number: 20121769
Date: 19/01/2019
*/

public class Team {

	int num = -1;
	String name = "";
	int fSkillMin = -1;
	int fSkillMax = -1;
	int dSkillMin = -1;
	int dSkillMax = -1;
	int gSkillMin = -1;
	int gSkillMax = -1;
	Player[] forward = new Player[13];
	Player[] defense = new Player[8];
	Player[] goalie = new Player[4];
	int p = 0; /* P is the concept defined in the assignment, the sum of the skills of the offence and defense players. The assignment tells the programmer to calculate this at the beginning of every game, but since this stays constant, there is no point in calculating it more than once. */

	int played = 0;
	int wins = 0;
	int losses = 0;
	int overtimeLoss = 0;
	int points = 0;
	int goalsFor = 0;
	int goalsAgainst = 0;

	//Creating the leafs
	static Player brown = new Player('F', 5, 28);
	static Player ennis = new Player('F', 4, 63);
	static Player gaunthier = new Player('F', 5, 33);
	static Player hyman = new Player('F', 7, 11);
	static Player johnsson = new Player('F', 7, 18);
	static Player kadri = new Player('F', 7, 43);
	static Player kapanen = new Player('F', 8, 24);
	static Player lindholm = new Player('F', 8, 26);
	static Player marleau = new Player('F', 8, 12);
	static Player marner = new Player('F', 9, 16);
	static Player matthews = new Player('F', 9, 34);
	static Player nylander = new Player('F', 9, 29);
	static Player tavares = new Player('F', 10, 91);
	static Player[] leafsF = {brown, ennis, gaunthier, hyman, johnsson, kadri, kapanen, lindholm, marleau, marner, matthews, nylander, tavares};

	static Player dermott = new Player('D', 8, 23);
	static Player gardiner = new Player('D', 4, 51);
	static Player hainsey = new Player('D', 5, 2);
	static Player holl = new Player('D', 6, 3);
	static Player marincin = new Player('D', 4, 52);
	static Player ozhiganov = new Player('D', 6, 92);
	static Player rielly = new Player('D', 9, 44);
	static Player zaitsev = new Player('D', 8, 22);
	static Player[] leafsD = {dermott, gardiner, hainsey, holl, marincin, ozhiganov, rielly, zaitsev};

	static Player andersen = new Player('G', 10, 31);
	static Player hutchinson = new Player('G', 7, 30);
	static Player kaskisuo = new Player('G', 5, 50);
	static Player sparks = new Player('G', 6, 40);
	static Player[] leafsG = {andersen, hutchinson, kaskisuo, sparks};

	//Creating the leafs team using the special Constructor
	static Team leafs = new Team(16, "Toronto", leafsF, leafsD, leafsG);

	//Creating all the other teams, using their skill parameters
	static Team boston = new Team(1, "Boston", 				5, 9, 4, 9, 5, 7);
	static Team buffalo = new Team(2, "Buffalo", 			6, 9, 4, 7, 4, 7);
	static Team carolina = new Team(3, "Carolina", 			4, 8, 5, 7, 4, 9);
	static Team columbus = new Team(4, "Columbus", 			4, 9, 5, 8, 7, 10);
	static Team detroit = new Team(5, "Detroit", 			4, 7, 6, 8, 4, 6);
	static Team florida = new Team(6, "Florida", 			5, 7, 4, 8, 5, 9);
	static Team montreal = new Team(7, "Montreal", 			4, 7, 4, 7, 4, 9);
	static Team new_jersey = new Team(8, "New Jersey",	 	4, 7, 4, 7, 5, 6);
	static Team ny_islanders = new Team(9, "NY Islanders", 	6, 8, 5, 7, 6, 8);
	static Team ny_rangers = new Team(10, "NY Rangers", 	5, 7, 4, 6, 5, 7);
	static Team ottawa = new Team(11, "Ottawa",		 		4, 6, 4, 5, 4, 5);
	static Team philadelphia = new Team(12, "Philadelphia", 4, 6, 4, 6, 4, 7);
	static Team pittsburgh = new Team(13, "Pittsburgh", 	6, 10, 4, 7, 5, 7);
	static Team tampa_bay = new Team(14, "Tampa Bay", 		6, 10, 6, 10, 7, 9);
	static Team washington = new Team(15, "Washington", 	6, 10, 5, 8, 6, 8);

	//Array of teams
	static Team[] teams = {boston, buffalo, carolina, columbus, detroit, florida, montreal, new_jersey, ny_islanders, ny_rangers, ottawa, philadelphia, pittsburgh, tampa_bay, leafs, washington};

	/*
	Constructor for a team where the players are unknown, but the skill ranges are known, so the players are created randomly accordingly.
	*/
	public Team(int num, String name, int fSkillMin, int fSkillMax, int dSkillMin, int dSkillMax, int gSkillMin, int gSkillMax) {
		this.num = num;
		this.name = name;
		this.fSkillMin = fSkillMin;
		this.fSkillMax = fSkillMax;
		this.dSkillMin = dSkillMin;
		this.dSkillMax = dSkillMax;
		this.gSkillMin = gSkillMin;
		this.gSkillMax = gSkillMax;
		this.forward = this.initializeForwards();
		this.defense = this.initializeDefenders();
		this.goalie = this.initializeGoalies();
		this.played = 0;
		this.wins = 0;
		this.losses = 0;
		this.p = this.calculateP();
	}

	/*
	Overloaded Constructor that, in this case, is used for the Toronto Maple Leafs. Instead of taking in skill ranges and generating players, this Constructor takes in the players.
	*/
	public Team(int num, String name, Player[] forward, Player[] defense, Player[] goalie) {
		this.num = num;
		this.name = name;
		this.forward = forward;
		this.defense = defense;
		this.goalie = goalie;
		this.played = 0;
		this.wins = 0;
		this.losses = 0;
		this.p = this.calculateP();
	}

	/*
	Goes through the array of teams, and returns the team with the name that is matching the parameter String.
	*/
	public static Team findTeam(String name){
		for(int i = 0; i < teams.length; i++){
			if(name.equals(teams[i].getName())){
				return teams[i];
			}
		}
		System.out.println("Team name not found!");
		return null;
	}

	/*
	Creates an array of Player objects, who are forwards, and have skill ratings that are within their Team's range.
	*/
	public Player[] initializeForwards() {
		Player[] forwards = new Player[13];
		for(int i = 0; i < 13; i++) {
			forwards[i] = new Player('F', this);
		}
		return forwards;
	}

	/*
	Creates an array of Player objects, who are defenders, and have skill ratings that are within their Team's range.
	*/
	public Player[] initializeDefenders() {
		Player[] defenders = new Player[8];
		for(int i = 0; i < 8; i++) {
			defenders[i] = new Player('D', this);
		}
		return defenders;
	}

	/*
	Creates an array of Player objects, who are goalies, and have skill ratings that are within their Team's range.
	*/
	public Player[] initializeGoalies() {
		Player[] goalies = new Player[4];
		for(int i = 0; i < 4; i++) {
			goalies[i] = new Player('G', this);
		}
		return goalies;
	}

	/*
	P is the sum of the skill ratings of the forwards and the defenders, which is constant one all the players are generated. This method is used in the Game class.
	*/
	public int calculateP(){
		int p = 0;
		for(int i = 0; i < 13; i++){
			p = p + forward[i].getSkill();
		}
		for(int i = 0; i < 8; i++){
			p = p + defense[i].getSkill();
		}
		return p;
	}

	/*
	Used for padding strings to the same length, so that the UI looks slick and aligned. Adds " " at the end until the
	desired length is met.
	*/
	public static String turnIntoLength(String x, char filler, int len){
		while(x.length() != len){
			x = x + filler;
		}
		return x;
	}

	/*
	Overloaded version of the previous method, used for ints. Instead of adding " " to the end, adds "0" to the beginning.
	*/
	public static String turnIntoLength(int x, char filler, int len){
		if(x >= 0){
			String toBeReturned = "" + x;
			while(toBeReturned.length() != len){
				toBeReturned = filler + toBeReturned;
			}
			return toBeReturned;
		} else {
			x = x * -1;
			String toBeReturned = (turnIntoLength(x, filler, len - 1));
			toBeReturned = "-" + toBeReturned;
			return toBeReturned;
		}
	}

	//Setters and getters

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getfSkillMin() {
		return fSkillMin;
	}

	public void setfSkillMin(int fSkillMin) {
		this.fSkillMin = fSkillMin;
	}

	public int getfSkillMax() {
		return fSkillMax;
	}

	public void setfSkillMax(int fSkillMax) {
		this.fSkillMax = fSkillMax;
	}

	public int getdSkillMin() {
		return dSkillMin;
	}

	public void setdSkillMin(int dSkillMin) {
		this.dSkillMin = dSkillMin;
	}

	public int getdSkillMax() {
		return dSkillMax;
	}

	public void setdSkillMax(int dSkillMax) {
		this.dSkillMax = dSkillMax;
	}

	public int getgSkillMin() {
		return gSkillMin;
	}

	public void setgSkillMin(int gSkillMin) {
		this.gSkillMin = gSkillMin;
	}

	public int getgSkillMax() {
		return gSkillMax;
	}

	public void setgSkillMax(int gSkillMax) {
		this.gSkillMax = gSkillMax;
	}

	public int getP(){
		return this.p;
	}

	/*
	Goes through an array that contains Teams, and prints the lowests and highest point teams.
	*/
	public static void printFirstandLast(Team[] teamList){
		int max = teamList[0].points;
		Team maxT = teamList[0];
		int min = teamList[0].points;
		Team minT = teamList[0];
		for(int i = 0; i < teamList.length; i++){
			if(teamList[i].points > max){
				max = teamList[i].points;
				maxT = teamList[i];
			}
			if(teamList[i].points < min){
				min = teamList[i].points;
				minT = teamList[i];
			}
		}
		System.out.println("First Team: " + maxT.name + "    " + "Points: " + maxT.points);
		System.out.println("Last Team: " + minT.name + "    " + "Points: " + minT.points);
	}

	/*
	Prints all the players of a team class, along with some fancu additions for formatting.
	*/
	public void printRoster() {
		System.out.println("");
		System.out.println("No" + "     " + "Name" + "     " +"Position" + "     "  + "Skill Level");
		System.out.println("**" + "     " + "****" + "     " +"********" + "     "  + "***********");
		for(int i = 0; i < 13; i++) {
			System.out.println(this.forward[i]);
		}
		for(int i = 0; i < 8; i++) {
			System.out.println(this.defense[i]);
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(this.goalie[i]);
		}
	}

	/*
	Prints all the teams' stats, going through the team array, and calling the printTeamStats method on each team.
	*/
	public static void printAllStats(){
		System.out.println("Team Name   " + "     " + "GP" + "    " + "W " + "    " + "L " + "    " + "OTL" + "    " + "Pts" + "    " + "GF" + "    " + "GA" + "    " + "Diff");
		System.out.println("*********   " + "     " + "**" + "    " + "**" + "    " + "**" + "    " + "***" + "    " + "***" + "    " + "**" + "    " + "**" + "    " + "****");
		for(int i = 0; i < teams.length; i++){
			teams[i].printTeamStats();
		}
	}

	/*
	This could have been fine without having a method all to itself, but for the sake of readability, I decided to make the formatting into a seperate method instead of makign the printAllStats method look like spaghetti code.
	*/
	public void printTeamStats(){
		String name = turnIntoLength(this.name, ' ', 13);
		String gp = turnIntoLength(this.played, '0', 2);
		String w = turnIntoLength(this.wins, '0', 2);
		String l = turnIntoLength(this.losses, '0', 2);
		String otl = turnIntoLength(this.overtimeLoss, '0', 3);
		String pts = turnIntoLength(this.points, '0', 3);
		String gf = turnIntoLength(this.goalsFor, '0', 2);
		String ga = turnIntoLength(this.goalsAgainst, '0', 2);
		String diff = turnIntoLength((this.goalsFor - this.goalsAgainst), '0', 4);
		System.out.println(name + "    " + gp + "    " + w + "    " + l + "    " + otl + "    " + pts + "    " + gf + "    " + ga + "    " + diff);
	}

}
