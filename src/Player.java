/*
Name: Ekim Karabey
NetId: 18ebk
Student Number: 20121769
Date: 19/01/2019
*/

public class Player {

	/*
	A player object has a char position ('f' or 'd' or 'g'), an int skill (1-10), a jersey number, a name, which in this case is pos + number, and a Team object that it belongs to.
	*/
	char pos = 'X';
	int skill = -1;
	int num = -1;
	String id = "";
	Team team = null;

	/*
	This constuctor is used for generating new players, for teams that are not the leafs. Since a number and skill aren't known, they are randomly generated. Their number is a randomly generated int between 0 and 99. Their skill is generated based on their position and team, using the method createSkill().
	*/
	public Player(char pos, Team team) {
		this.pos = pos;
		this.team = team;
		skill = createSkill(this);
		this.num = NHLSimulator.generator.nextInt(99);
		this.id = pos + "" + Team.turnIntoLength(num, '0', 2);
	}

	/*
	This constuctor is used for "importing" leafs plays, whos skill ratings don't have to be generated, and their numbers are known. The team is always set to leafs, and their Id is set up as normal.
	*/
	public Player(char pos, int skill, int num) {
		this.pos = pos;
		this.skill = skill;
		this.num = num;
		this.id = pos + "" + Team.turnIntoLength(num, '0', 2);
		this.team = Team.leafs;
	}

	/*
	Each team has a determined skill range for each of the positions, so this method first determines which position the player is. For example, if they are a forward, the 'F' if statement is entered, and a random number is generated, that is in range of the teams forward skill range. (Vice versa for all the other positions.)
	*/
	public static int createSkill(Player p) {
		char pos = p.getPos();
		Team team = p.getTeam();
		if (pos == 'F') {
			return team.getfSkillMin() + (NHLSimulator.generator.nextInt(team.getfSkillMax() + 1 - team.getfSkillMin()));
		} else if (pos == 'D'){
			return team.getdSkillMin() + (NHLSimulator.generator.nextInt(team.getdSkillMax() + 1 - team.getdSkillMin()));
		} else if (pos == 'G') {
			return team.getgSkillMin() + (NHLSimulator.generator.nextInt(team.getgSkillMax() + 1 - team.getgSkillMin()));
		} else {
			return -1;
		}
	}


	//Setters and Getters
	public char getPos() {
		return pos;
	}

	public void setPos(char pos) {
		this.pos = pos;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	/*
	Pretty self explanitory, just prints the players various attributes, along with some fancy formatting.
	*/
	public String toString() {
		String position = "";
		if(this.getPos() == 'F'){
			position = "forward";
		} else if (this.getPos() == 'D'){
			position = "defense";
		} else if(this.getPos() == 'G'){
			position = "goalie ";
		}
		return Team.turnIntoLength(this.getNum(), '0', 2) + "     " + this.getId() + "      " + position + "          " + Team.turnIntoLength(this.getSkill(), '0', 2);
	}

}
