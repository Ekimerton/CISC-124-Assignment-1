import java.util.Collections;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
    int score1 = simulateRegulation(t1);
    int score2 = simulateRegulation(t2);
    if(score1 == score2){
      if (getOvertimeSkill(team1) < getOvertimeSkill(team2)){
        
      }
    }

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

  public static int simulateRegulation(int score){
    int points = 0;
    int rand = 0;
    while(score >= 50){
      rand = (int)(Math.random() * 3);
      if(rand == 0){
        points = points + 0;
      } else if (rand == 1){
        points = points + 1;
      } else if (rand == 2){
        points = points + 2;
      }
      score = score - 50;

    }
    if(score > 0){
      rand = (int)(Math.random() * 2);
      if(rand == 0){
        points = points + 0;
      } else if (rand == 1){
        points = points + 1;
      }
    }
    return points;
  }

  public int getOvertimeSkill(Team team){
    int totalSkill = 0;
    totalSkill = totalSkill + team.goalie[(int)(Math.random() * 4)].getSkill();
    int[] randomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
    shuffleArray(randomNumbers);
    for(int i = 0; i < 3; i++){
      int x = randomNumbers[i];
      if(x <= 13){
        totalSkill = totalSkill + team.forward[x].getSkill();
      } else {
        totalSkill = totalSkill + team.defense[x - 13].getSkill();
      }
    }
    return totalSkill;
  }

  // Implementing Fisher–Yates shuffle from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
  static void shuffleArray(int[] ar)
  {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
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
