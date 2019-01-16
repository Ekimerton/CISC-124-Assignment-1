public class Player {
	char pos = 'X';
	int skill = -1;
	int num = -1;
	String id = "";
	Team team = null;

	public Player(char pos, Team team) {
		this.pos = pos;
		this.team = team;
		skill = createSkill(this);
		this.num = (int)(Math.random() * 99);
		this.id = pos + "" + num;

	}

	public Player(char pos, int skill, int num) {
		this.pos = pos;
		this.skill = skill;
		this.num = num;
		this.id = pos + "" + num;
		this.team = Team.leafs;
	}

	public static int createSkill(Player p) {
		char pos = p.getPos();
		Team team = p.getTeam();
		if (pos == 'F') {
			return team.getfSkillMin() + ((int) (Math.random() * (team.getfSkillMax() + 1 - team.getfSkillMin())));
		} else if (pos == 'D'){
			return team.getdSkillMin() + (int) (Math.random() * (team.getdSkillMax() + 1 - team.getdSkillMin()));
		} else if (pos == 'G') {
			return team.getgSkillMin() + (int) (Math.random() * (team.getgSkillMax() + 1 - team.getgSkillMin()));
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

	//toString
	public String toString() {
		String position = "";
		if(this.getPos() == 'F'){
			position = "forward";
		} else if (this.getPos() == 'D'){
			position = "defence";
		} else if(this.getPos() == 'G'){
			position = "goalie ";
		}

		if(this.getNum() < 10){
			return this.getNum() + "     " + this.getId() + "      " + position + "        " + this.getSkill();
		} else {
			return this.getNum() + "    " + this.getId() + "     " + position + "        " + this.getSkill();
		}
	}

}
