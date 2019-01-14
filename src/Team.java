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
	Player[] defence = new Player[8];
	Player[] goalie = new Player[4];
	
	//Team Statistics
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
	
	//Creating the Leafs
	static Player brown = new Player('f', 5, 28);
	static Player ennis = new Player('f', 4, 63);
	static Player gaunthier = new Player('f', 5, 33);
	static Player hyman = new Player('f', 7, 11);
	static Player johnsson = new Player('f', 7, 18);
	static Player kadri = new Player('f', 7, 43);
	static Player kapanen = new Player('f', 8, 24);
	static Player lindholm = new Player('f', 8, 26);
	static Player marleau = new Player('f', 8, 12);
	static Player marner = new Player('f', 9, 16);
	static Player matthews = new Player('f', 9, 34);
	static Player nylander = new Player('f', 9, 29);
	static Player tavares = new Player('f', 10, 91);
	static Player[] leafsF = {brown, ennis, gaunthier, hyman, johnsson, kadri, kapanen, lindholm, marleau, marner, matthews, nylander, tavares};
	
	static Player dermott = new Player('d', 8, 23);
	static Player gardiner = new Player('d', 4, 51);
	static Player hainsey = new Player('d', 5, 2);
	static Player holl = new Player('d', 6, 3);
	static Player marincin = new Player('d', 4, 52);
	static Player ozhiganov = new Player('d', 6, 92);
	static Player rielly = new Player('d', 9, 44);
	static Player zaitsev = new Player('d', 8, 22);
	static Player[] leafsD = {dermott, gardiner, hainsey, holl, marincin, ozhiganov, rielly, zaitsev};
	
	static Player andersen = new Player('g', 10, 31);
	static Player hutchinson = new Player('g', 7, 30);
	static Player kaskisuo = new Player('g', 5, 50);
	static Player sparks = new Player('g', 6, 40);
	static Player[] leafsG = {andersen, hutchinson, kaskisuo, sparks};
	
	static Team leafs = new Team(16, "Toronto Maple Leaves", leafsF, leafsD, leafsG);
	
	//Constructor
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
		this.defence = this.initializeDefenders();
		this.goalie = this.initializeGoalies();
	}
	
	public Team(int num, String name, Player[] forward, Player[] defence, Player[] goalie) {
		this.num = num;
		this.name = name;
		this.forward = forward;
		this.defence = defence;
		this.goalie = goalie;
	}
	
	//Methods
	public Player[] initializeForwards() {
		Player[] forwards = new Player[13]; 
		for(int i = 0; i < 13; i++) {
			forwards[i] = new Player('f', this);
		}
		return forwards;
	}
	
	public Player[] initializeDefenders() {
		Player[] defenders = new Player[8]; 
		for(int i = 0; i < 8; i++) {
			defenders[i] = new Player('d', this);
		}
		return defenders;
	}
	
	public Player[] initializeGoalies() {
		Player[] goalies = new Player[4]; 
		for(int i = 0; i < 4; i++) {
			goalies[i] = new Player('g', this);
		}
		return goalies;
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
	
	//printTeam
	public void printTeam() {
		System.out.println("Team Name: " + this.getName());
		System.out.println("");
		System.out.println("Forwards");
		for(int i = 0; i < 13; i++) {
			System.out.println(this.forward[i]);
		}
		System.out.println("Defenders");
		for(int i = 0; i < 8; i++) {
			System.out.println(this.defence[i]);
		}
		System.out.println("Goalies");
		for(int i = 0; i < 4; i++) {
			System.out.println(this.goalie[i]);
		}
	}
	

}
