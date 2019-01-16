public class Game{

  Team team1 = null;
  Team team2 = null;
  int p1 = 0;
  int p2 = 0;
  int g1 = 0;
  int g2 = 0;
  int t1 = 0;
  int t2 = 0;

  public Game(Team team1, Team team2){
    this.team1 = team1;
    this.team2 = team2;
    this.p1 = team1.getP();
    this.p2 = team2.getP();
    this.g1 = team1.goalie[(int)(Math.random() * 4)].getSkill();
    this.g2 = team2.goalie[(int)(Math.random() * 4)].getSkill();
    this.t1 = p1 + g1 + forwardsPlay() + defendersPlay() + goaliesPlay();
    this.t2 = p2 + g2 + forwardsPlay() + defendersPlay() + goaliesPlay();
  }

  public static int forwardsPlay(){
    int rand = (int)(Math.random() * 3);
    if(rand == 0){
      return 25;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -25;
    } else {
      return -10000;
    }
  }

  public static int defendersPlay(){
    int rand = (int)(Math.random() * 3);
    if(rand == 0){
      return 40;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -40;
    } else {
      return -10000;
    }
  }

  public static int goaliesPlay(){
    int rand = (int)(Math.random() * 3);
    if(rand == 0){
      return 60;
    } else if (rand == 1){
      return 0;
    } else if (rand == 2){
      return -60;
    } else {
      return -10000;
    }
  }

  public void printGame(){
    System.out.println("Game between " + team1.getName() + " and "  + team2.getName());
    System.out.println(this.p1 + this.g1);
    System.out.println(this.p2 + this.g2);
    System.out.println(this.t1);
    System.out.println(this.t2);
  }
}
